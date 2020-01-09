package com.app.server.dao;

import com.app.server.model.Node;
import com.app.server.model.NodeRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NodeRelationDao extends JpaRepository<NodeRelation, Long> {

}
