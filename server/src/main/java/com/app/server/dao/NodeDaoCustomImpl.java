package com.app.server.dao;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
public class NodeDaoCustomImpl implements NodeDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List getAdjacencyMatrix() {
        Query q = em.createNativeQuery("select n1.node_number as startNodeNumber, n2.node_number as endNodeNumber from node n1 full join node_relation nr on n1.id=nr.start_node_id full join node n2 on nr.end_node_id = n2.id");

        return q.getResultList();




    }
}
