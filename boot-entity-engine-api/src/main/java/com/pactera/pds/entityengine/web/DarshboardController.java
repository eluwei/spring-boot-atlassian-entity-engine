package com.pactera.pds.entityengine.web;

import org.ofbiz.core.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
