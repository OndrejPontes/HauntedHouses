package cz.muni.fi.pa165;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import cz.muni.fi.pa165.facade.HouseFacade;
import cz.muni.fi.pa165.facade.HouseFacadeImpl;

/**
 * @author opontes
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cz.muni.fi.pa165.controller", "cz.muni.fi.pa165.facade", "cz.muni.fi.pa165.services", "cz.muni.fi.pa165.dao"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
