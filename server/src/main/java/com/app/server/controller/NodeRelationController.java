package com.app.server.controller;


import com.app.server.dao.NodeRelationDao;
import com.app.server.model.Node;
import com.app.server.model.NodeRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/nodeRelation")
@CrossOrigin(origins = "*")
public class NodeRelationController {
    @Autowired
    private NodeRelationDao nodeRelationDao;

    @GetMapping("/list")
    public List<NodeRelation> list() {
        return nodeRelationDao.findAll();
    }

    @PostMapping("/save")
    public List<NodeRelation> save(@RequestBody List<NodeRelation> n) {
        List<NodeRelation> returnList = new ArrayList<NodeRelation>();
        nodeRelationDao.deleteAll();
        for(int i=0; i<n.size(); i++)
            returnList.add(nodeRelationDao.save(n.get(i)));
       return returnList;
    }

    @DeleteMapping("/delete")
    public void delete(Long id) {
        nodeRelationDao.deleteById(id);
    }

}
