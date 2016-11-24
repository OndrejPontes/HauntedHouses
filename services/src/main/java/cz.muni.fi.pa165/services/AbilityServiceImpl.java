package cz.muni.fi.pa165.services;

import cz.muni.fi.pa165.dao.AbilityDao;
import cz.muni.fi.pa165.entity.Ability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Vojta David, vojtadavid
 */
@Service
@Transactional
public class AbilityServiceImpl implements AbilityService {
    @Autowired
    private AbilityDao abilityDao;


    @Override
    public void create(Ability ability) {
        abilityDao.create(ability);
    }

    @Override
    public Ability update(Ability ability) {
        return abilityDao.update(ability);
    }

    @Override
    public void delete(Ability ability) {
        abilityDao.delete(ability);
    }

    @Override
    public Ability getById(long id) {
        return abilityDao.getById(id);
    };

    @Override
    public Ability getByName(String name) {
        return abilityDao.getByName(name);
    }

    @Override
    public List<Ability> getAll() {
        return abilityDao.getAll();
    }
}
