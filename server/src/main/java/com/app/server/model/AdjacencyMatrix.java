package com.app.server.model;

import javax.persistence.*;
import java.io.Serializable;

public class AdjacencyMatrix implements Serializable {

    private Number n1Id;
    private Number startNodeNumber;
    private Number startNodeId;
    private Number endNodeId;
    private Number n2Id;
    private Number endNodeNumber;

    public Number getN1Id() {
        return n1Id;
    }

    public void setN1Id(Number n1Id) {
        this.n1Id = n1Id;
    }

    public Number getStartNodeNumber() {
        return startNodeNumber;
    }

    public void setStartNodeNumber(Number startNodeNumber) {
        this.startNodeNumber = startNodeNumber;
    }

    public Number getStartNodeId() {
        return startNodeId;
    }

    public void setStartNodeId(Number startNodeId) {
        this.startNodeId = startNodeId;
    }

    public Number getEndNodeId() {
        return endNodeId;
    }

    public void setEndNodeId(Number endNodeId) {
        this.endNodeId = endNodeId;
    }

    public Number getN2Id() {
        return n2Id;
    }

    public void setN2Id(Number n2Id) {
        this.n2Id = n2Id;
    }

    public Number getEndNodeNumber() {
        return endNodeNumber;
    }

    public void setEndNodeNumber(Number endNodeNumber) {
        this.endNodeNumber = endNodeNumber;
    }

    public AdjacencyMatrix(Number n1Id, Number startNodeNumber, Number startNodeId, Number endNodeId, Number n2Id, Number endNodeNumber) {
        this.n1Id = n1Id;
        this.startNodeNumber = startNodeNumber;
        this.startNodeId = startNodeId;
        this.endNodeId = endNodeId;
        this.n2Id = n2Id;
        this.endNodeNumber = endNodeNumber;
    }

    public AdjacencyMatrix() {
    }
}
