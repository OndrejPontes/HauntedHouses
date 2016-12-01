package cz.muni.fi.pa165.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.muni.fi.pa165.dao.AbilityDao;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.exception.ServiceImplDAOException;

/**
 * @author Vojta David, vojtadavid
 */
@Service
@Transactional
public class AbilityServiceImpl implements AbilityService {
    @Autowired
    private AbilityDao abilityDao;

    @Override
    public Ability create(Ability ability) {
        try {
            abilityDao.create(ability);
            return ability;
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot create ability",e);
        }
    }

    @Override
    public Ability update(Ability ability) {
        try {
            return abilityDao.update(ability);
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot update ability",e);
        }
    }

    @Override
    public void delete(Ability ability) {
        try {
            abilityDao.delete(ability);
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot delete ability",e);
        }
    }

    @Override
    public Ability getById(Long id) {
        try {
            return abilityDao.getById(id);
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot getById ability",e);
        }
    };

    @Override
    public Ability getByName(String name) {
        try {
            return abilityDao.getByName(name);
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot getByName ability",e);
        }
    }

    @Override
    public List<Ability> getAll() {
        try {
            return abilityDao.getAll();
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot getAll ability",e);
        }
    }
}
