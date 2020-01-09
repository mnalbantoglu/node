package com.app.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="node_relation")
public class NodeRelation implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_node_relation_generator")
    private Long id;

    @Column(name="start_node_id")
    private Long startNodeId;

    @Column(name="end_node_id")
    private Long endNodeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStartNodeId() {
        return startNodeId;
    }

    public void setStartNodeId(Long startNodeId) {
        this.startNodeId = startNodeId;
    }

    public Long getEndNodeId() {
        return endNodeId;
    }

    public void setEndNodeId(Long endNodeId) {
        this.endNodeId = endNodeId;
    }


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "start_node_id", insertable = false, updatable = false)
    private Node relationStart;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "end_node_id" , insertable = false, updatable = false)
    private Node relationEnd;

    public Node getRelationStart() {
        return relationStart;
    }

    public void setRelationStart(Node relationStart) {
        this.relationStart = relationStart;
    }

    public Node getRelationEnd() {
        return relationEnd;
    }

    public void setRelationEnd(Node relationEnd) {
        this.relationEnd = relationEnd;
    }


}
