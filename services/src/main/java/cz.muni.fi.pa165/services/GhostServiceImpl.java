package cz.muni.fi.pa165.services;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.muni.fi.pa165.dao.GhostDao;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.exception.ServiceImplDAOException;

/**
 * @author Ondrej Ponteš
 */
@Service
@Transactional
public class GhostServiceImpl implements GhostService {
    @Autowired
    private GhostDao ghostDao;

    @Override
    public Ghost create(Ghost ghost) {
        try {
            return ghostDao.create(ghost);
        } catch (IllegalArgumentException | PersistenceException | ConstraintViolationException e) {
            throw new ServiceImplDAOException("cannot create ghost", e);
        }
    }

    @Override
    public Ghost update(Ghost ghost) {
        try {
            return ghostDao.update(ghost);
        } catch (ConstraintViolationException e) {
            throw new ServiceImplDAOException("cannot update ghost", e);
        }
    }

    @Override
    public void delete(Ghost ghost) {
        try {
            ghostDao.delete(ghost);
        } catch (ConstraintViolationException e) {
            throw new ServiceImplDAOException("cannot delete ghost", e);
        }
    }

    @Override
    public Ghost getById(long id) {
        try {
            return ghostDao.getById(id);
        } catch (ConstraintViolationException e) {
            throw new ServiceImplDAOException("cannot find ghost by id", e);
        }
    }

    @Override
    public Ghost getByName(String name) {
        try {
            return ghostDao.getByName(name);
        } catch (ConstraintViolationException e) {
            throw new ServiceImplDAOException("cannot find ghost by name", e);
        }
    }

    @Override
    public List<Ghost> getAll() {
        try {
            return ghostDao.getAll();
        } catch (ConstraintViolationException e) {
            throw new ServiceImplDAOException("cannot find all ghosts", e);
        }
    }

    @Override
    public List<Ghost> getByAbility(Ability aiblity) {
        try {
            return ghostDao.getByAbility(aiblity);
        } catch (ConstraintViolationException e) {
            throw new ServiceImplDAOException("cannot find ghosts by ability", e);
        }
    }

    @Override
    public List<Ghost> getGhostsOfHouse(House house) {
        try {
            return ghostDao.getGhostsOfHouse(house);
        } catch (ConstraintViolationException e) {
            throw new ServiceImplDAOException("cannot find ghosts by house", e);
        }
    }
}
