package cz.muni.fi.pa165.config;

import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.facade.GhostFacade;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author opontes
 */
@Configuration
@ComponentScan(basePackageClasses = {GhostFacade.class})
public class ServiceConfig {

    @Bean
    public Mapper dozer(){
        DozerBeanMapper dozer = new DozerBeanMapper();
        dozer.addMapping(new DozerGhostConfig());
        return dozer;
    }

    private class DozerGhostConfig extends BeanMappingBuilder {
        @Override
        protected void configure() {
            mapping(Ghost.class, GhostDTO.class);
        }
    }
}
