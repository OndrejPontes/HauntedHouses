package cz.muni.fi.pa165;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author opontes
 */
@SpringBootApplication
@ComponentScan(
        basePackages = {"cz.muni.fi.pa165.controller", "cz.muni.fi.pa165.facade", "cz.muni.fi.pa165.services", "cz.muni.fi.pa165.dao"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
