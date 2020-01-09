package com.app.server.dao;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface NodeDaoCustom {
    List getAdjacencyMatrix();
}
