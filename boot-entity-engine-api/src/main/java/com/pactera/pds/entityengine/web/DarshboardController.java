package com.pactera.pds.entityengine.web;

import org.ofbiz.core.entity.DelegatorInterface;
import org.ofbiz.core.entity.GenericEntityException;
import org.ofbiz.core.entity.GenericValue;
import org.ofbiz.core.entity.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        try{
            TransactionUtil.begin();
            Map obj1=new HashMap<>();
            obj1.put("id",22);
            obj1.put("key","22");
            obj1.put("counter", 22);
            delegator.create("Project", obj1);
            int a =0;
            int b =1/a;
            Map obj2=new HashMap<>();
            obj2.put("id",22);
            obj2.put("key","22");
            obj2.put("counter", 22);
            delegator.create("Project", obj2);
            TransactionUtil.commit();
        }catch (Exception e){
            TransactionUtil.rollback();

        }

        return "aa";
    }

}
