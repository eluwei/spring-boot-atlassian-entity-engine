package com.pactera.pds.entityengine.web;

import org.ofbiz.core.entity.DelegatorInterface;
import org.ofbiz.core.entity.GenericEntityException;
import org.ofbiz.core.entity.GenericValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Foy Lian
 * Date: 2016-09-18
 * Time: 18:23
 */
@RestController
public class DarshboardController {
    @Autowired
    DelegatorInterface delegator;

    @RequestMapping("/projects")
    public Object Projects() throws GenericEntityException {

        List<GenericValue> projects = delegator.findAll("Project");
        return ProjectDto.transform(projects);
    }
    //test roll back!
    @RequestMapping("/trans")
    public Object Trans() throws GenericEntityException {
        Map obj=new HashMap<>();
        obj.put("id",1);
        obj.put("cardId","card_id_001");
        obj.put("balance", 100);
        GenericValue g = delegator.makeValue("Card", obj);

        Map obj1=new HashMap<>();
        obj1.put("id",22);
        obj1.put("key","11");
        obj1.put("counter", 11);
        GenericValue g1 = delegator.makeValue("Project", obj1);
        Map obj2=new HashMap<>();//obj1 and obj2 are duplicate key.
        obj2.put("id",22);
        obj2.put("key","22");
        obj2.put("counter", 22);
        GenericValue g2 = delegator.makeValue("Project", obj2);
        List<GenericValue> savePoint = new ArrayList<>();
        savePoint.add(g);
        savePoint.add(g1);
        savePoint.add(g2);

        delegator.storeAll(savePoint);//duplicate key, will auto rollback..
        return "aa";
    }

}
