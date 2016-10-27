/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.HauntingDao;
import cz.muni.fi.pa165.entity.Haunting;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author xmociar
 */
public class Main {
    
    public static void main(String[] args) {
		
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(PersistenceApplicationContext.class);
        HauntingDao hauntingDao = applicationContext.getBean(HauntingDao.class);
        Haunting hauting = new Haunting();
        hauting.setNumberOfPeoplePresent(9);
        hauntingDao.create(hauting);
        
	}
    
}
