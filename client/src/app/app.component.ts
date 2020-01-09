import {ChangeDetectorRef, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {NodeService} from "../services/node.service";
import {NodeDomain} from "../domain/NodeDomain";

import {NodeRelationDomain} from "../domain/NodeRelationDomain";
import {NodeRelationService} from "../services/nodeRelation.service";

import * as dracula from 'graphdracula';
import cytoscape from 'cytoscape';
import edgehandles from 'cytoscape-edgehandles';
import { Network, DataSet } from 'vis';
import {finalize} from "rxjs/operators";
import {colors} from "@angular/cli/utilities/color";
import * as vis from 'vis';


cytoscape.use( edgehandles );

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  numberOfNode : number;

  nodeList: NodeDomain[] = [];
  createdNodeList: NodeDomain[] = [];

  minNodeRelationCount: number = 2;
  maxNodeRelationCount: number = 0;
  createNodeRelationList: NodeRelationDomain[] = [];

  nodeRelationList: NodeRelationDomain[] = [];

  nodeNumber: number[]=[];
  dbList:any;





  constructor(private nodeService: NodeService, private nodeRelationService: NodeRelationService, private ref: ChangeDetectorRef) {}
  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.nodeList = [];
    this.nodeService.getNodes().subscribe(nodes => {
      this.nodeList = nodes; this.ref.markForCheck();
        this.grafikCiz();
        this.adjacencyMatrix();
    });
  }



  nodeCreate() {
    if(this.numberOfNode !== undefined){
      this.createdNodeList = [];
      for(let i=0; i<this.numberOfNode; i++) {
        const newNode = new NodeDomain();
        newNode.nodeNumber = Math.floor(Math.random() * (400 - 1 + 1)) + 1;
        this.createdNodeList.push(newNode);
      }
      this.nodeService.save(this.createdNodeList).subscribe (
        res => {
          this.maxNodeRelationCount = Math.floor(this.numberOfNode/2);
          this.createNodeRelationList = [];

          this.nodeService.getNodes().subscribe(nodes => {

            for (let j=0; j<this.maxNodeRelationCount; j++){
              const relation = new NodeRelationDomain();
              let randomNodeStart = nodes[Math.floor(Math.random()*nodes.length)];
              relation.startNodeId = randomNodeStart.id;

              let randomNodeEnd = nodes[Math.floor(Math.random()*nodes.length)];
              relation.endNodeId = randomNodeEnd.id;

              this.createNodeRelationList.push(relation);
            }
            this.nodeRelationService.save(this.createNodeRelationList).subscribe (
              res => {
                this.loadData();
                this.grafikCiz();
/*
                this.adjacencyMatrix();
*/
              },
              err => {
                console.log('error: ' + JSON.stringify(err));
              }
            );
          });
        },
        err => {
          console.log('error: ' + JSON.stringify(err));
        });
    }else{
      console.log('nodeNumber is null');
    }

  }

  grafikCiz() {
    var container = document.getElementById('graph_container');
    const nodes = new DataSet<any>([

    ]);

    for(let i of this.nodeList){
      nodes.add({id: i.id, label: i.nodeNumber.toString(), color: {background: '#5bc0de'}});
    }

    const edges = new DataSet<any>([
    ]);



    this.nodeRelationService.getNodeRelations().pipe(finalize(() => {
      setTimeout(() => {
        const data = { nodes, edges };
        const a = new Network(container, data, {height: '500px'});
      }, 0);
    })).subscribe(value => {
      console.log('value :' + JSON.stringify(value));
      for(let i of value){
        edges.add({from: i.startNodeId, to: i.endNodeId, color:{color:'green'}});
      }
    });




  }

  adjacencyMatrix(){
    this.nodeService.getAdjacencyMatrix().subscribe(value => {
      //console.log("===="+JSON.stringify(value))
      this.nodeNumber = [];
      for(let i=0; i<value.length; i++){
        if(!this.contains(this.nodeNumber, value[i][0])){
          this.nodeNumber.push(value[i][0])
        }
        this.dbList = value;
      }
      //console.log("===="+this.nodeNumber);
    })
  }

  contains(dizi, item){
    var exist = false;
    for(let k=0; k<dizi.length; k++){
      if(dizi[k]===item){
        exist=true
      }
    }
    return exist;
  }

  findRelation(start,end){
    let val = 0;
    for(let i=0; i<this.dbList.length; i++){
      if((this.dbList[i][0]===start && this.dbList[i][1]===end) || (this.dbList[i][0]===end && this.dbList[i][1]===start)){
        val = 1
      }
    }
    return val;
  }


}


