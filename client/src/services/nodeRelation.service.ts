import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NodeDomain} from "../domain/NodeDomain";
import {Observable, throwError} from "rxjs";
import {catchError, map} from "rxjs/operators";
import {NodeRelationDomain} from "../domain/NodeRelationDomain";
import {environment} from "../environments/environment";

@Injectable({
  providedIn: 'root',
})
export class NodeRelationService {

  constructor(private http: HttpClient) { }

  getNodeRelations() {
    return this.http.get<NodeRelationDomain[]>(environment.serverUrl+'/nodeRelation/list');
  }

  save(data): Observable<NodeRelationDomain[]>{
    console.log(data);
    return this.http.post<NodeRelationDomain[]>(environment.serverUrl+'/nodeRelation/save', data);
  }




}
