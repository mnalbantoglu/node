package com.app.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
       /* (name = "Node")*//*

@NamedNativeQueries({@NamedNativeQuery(
        name = "Node.getAdjacencyMatrix",
        resultSetMapping = "AdjacencyMatrixMapping",
        query = "select n1.id as n1Id, n1.node_number as startNodeNumber, nr.start_node_id as startNodeId,  nr.end_node_id as endNodeId, n2.id as n2Id, n2.node_number as endNodeNumber from node n1 " +
                        "full join node_relation nr on n1.id=nr.start_node_id " +
                        "full join node n2 on nr.end_node_id = n2.id ")})*/
public class Node implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_node_generator")
    private Long id;
    @Column(name="node_number")
    private Integer nodeNumber;

    @OneToMany(mappedBy = "relationStart")
    Set<NodeRelation> relationStart;

    @OneToMany(mappedBy = "relationEnd")
    Set<NodeRelation> relationEnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(Integer nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public Set<NodeRelation> getRelationStart() {
        return relationStart;
    }

    public void setRelationStart(Set<NodeRelation> relationStart) {
        this.relationStart = relationStart;
    }

    public Set<NodeRelation> getRelationEnd() {
        return relationEnd;
    }

    public void setRelationEnd(Set<NodeRelation> relationEnd) {
        this.relationEnd = relationEnd;
    }
}
