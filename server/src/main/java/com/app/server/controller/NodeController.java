package com.app.server.controller;

import com.app.server.dao.NodeDao;
import com.app.server.dao.NodeDaoCustom;
import com.app.server.dao.NodeRelationDao;
import com.app.server.model.AdjacencyMatrix;
import com.app.server.model.Node;
import com.app.server.model.NodeRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/node")
@CrossOrigin(origins = "*")
public class NodeController {
    @Autowired
    private NodeDao nodeDao;
    @Autowired
    private NodeRelationDao nodeRelationDao;
    @Autowired
    private NodeDaoCustom nodeDaoCustom;

    @GetMapping("/list")
    public List<Node> list() {
        return nodeDao.findAll();
    }

    @PostMapping("/save")
    public List<Node> save(@RequestBody List<Node> n) {
        List<Node> returnList = new ArrayList<Node>();
        nodeRelationDao.deleteAll();
        nodeDao.deleteAll();
        for(int i=0; i<n.size(); i++)
            returnList.add(nodeDao.save(n.get(i)));
        return returnList;
    }

    @DeleteMapping("/delete")
    public void delete(Long id) {
        nodeDao.deleteById(id);
    }

    @GetMapping("/adj")
    public List<AdjacencyMatrix> adjacencyMatrixList() {
        return nodeDaoCustom.getAdjacencyMatrix();
    }

}
