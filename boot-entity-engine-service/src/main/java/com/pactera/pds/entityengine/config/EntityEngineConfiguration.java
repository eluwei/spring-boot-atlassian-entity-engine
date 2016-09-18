package com.pactera.pds.entityengine.config;

import org.ofbiz.core.entity.GenericDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Foy Lian
 * Date: 2016-09-18
 * Time: 17:57
 */
@Configuration
public class EntityEngineConfiguration {
    @Bean(name="defaultDS")
    public GenericDAO getProjectDao() {
        return new GenericDAO("defaultDS");
    }
}
