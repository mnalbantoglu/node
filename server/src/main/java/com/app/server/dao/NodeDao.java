package com.app.server.dao;

import com.app.server.model.AdjacencyMatrix;
import com.app.server.model.Node;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface NodeDao extends JpaRepository<Node, Long> {
//    @Query(value = "select n1.id as n1Id, n1.node_number as startNodeNumber, nr.start_node_id as startNodeId,  nr.end_node_id as endNodeId, n2.id as n2Id, n2.node_number as endNodeNumber from node n1 " +
//            "full join node_relation nr on n1.id=nr.start_node_id " +
//            "full join node n2 on nr.end_node_id = n2.id ", nativeQuery = true)
//    List<AdjacencyMatrix> getAdjacencyMatrix();
    /*@Query(value="select n1.id as n1Id, n1.node_number as startNodeNumber, nr.start_node_id as startNodeId,  nr.end_node_id as endNodeId, n2.id as n2Id, n2.node_number as endNodeNumber from node n1 " +
                "full join node_relation nr on n1.id=nr.start_node_id " +
                "full join node n2 on nr.end_node_id = n2.id ", nativeQuery = true)*/


   /* @Query(value="select new com.app.server.model.AdjacencyMatrix(n1.id, n1.nodeNumber, nr.startNodeId, nr.endNodeId, n2.id, n2.nodeNumber) from  Node n1 " +
            "full join NodeRelation nr on n1.id=nr.startNodeId " +
            "full join Node n2 on nr.endNodeId = n2.id ", nativeQuery = true)*/

//    List<AdjacencyMatrix> getAdjacencyMatrix();

}
