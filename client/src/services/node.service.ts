import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NodeDomain} from "../domain/NodeDomain";
import {Observable, throwError} from "rxjs";
import {catchError, map} from "rxjs/operators";
import {environment} from "../environments/environment";

@Injectable({
  providedIn: 'root',
})
export class NodeService {

  constructor(private http: HttpClient) { }

  getNodes() {
    return this.http.get<NodeDomain[]>(environment.serverUrl+'/node/list');
  }

  save(data): Observable<NodeDomain[]>{
    return this.http.post<NodeDomain[]>(environment.serverUrl+'/node/save', data);
  }

  getAdjacencyMatrix() {
    return this.http.get<any>(environment.serverUrl+'/node/adj');
  }




}
