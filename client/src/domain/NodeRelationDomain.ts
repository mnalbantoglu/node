import {NodeDomain} from "./NodeDomain";

export class NodeRelationDomain{
  id: number;
  startNodeId: number;
  endNodeId: number;
  relationStart: NodeDomain;
  relationEnd: NodeDomain;
}

