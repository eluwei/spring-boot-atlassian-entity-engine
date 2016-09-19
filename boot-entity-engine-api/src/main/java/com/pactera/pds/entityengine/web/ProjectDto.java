package com.pactera.pds.entityengine.web;

import lombok.Data;
import org.ofbiz.core.entity.GenericEntity;
import org.ofbiz.core.entity.GenericValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Foy Lian
 * Date: 2016-09-18
 * Time: 18:25
 */
@Data
public class ProjectDto {
    String id;
    String key;
    String counter;

    public static ProjectDto transform(GenericEntity entity) {
        ProjectDto rs = new ProjectDto();
        rs.id =  entity.get("id") +"";
        rs.key = (String) entity.get("key");
        rs.counter = entity.get("counter")+"";
        return rs;
    }

    public static List<ProjectDto> transform(List<GenericValue> list) {
        List<ProjectDto> rs = new ArrayList<ProjectDto>();
        for (GenericValue v : list) {
            rs.add(transform(v));
        }
        return rs;
    }
}
