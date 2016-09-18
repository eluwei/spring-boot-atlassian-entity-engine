package com.pactera.pds.entityengine.config;

import org.ofbiz.core.entity.GenericDAO;
import org.ofbiz.core.entity.GenericDelegator;
import org.ofbiz.core.entity.GenericEntityException;
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
    @Bean(name = "defaultDAO")
    public GenericDAO getProjectDao() {
        return new GenericDAO("defaultDS");
    }

    @Bean(name = "defaultDelegator")
    public GenericDelegator getDefaultDelegator() throws GenericEntityException {
        return GenericDelegator.getGenericDelegator("default");
    }
}
