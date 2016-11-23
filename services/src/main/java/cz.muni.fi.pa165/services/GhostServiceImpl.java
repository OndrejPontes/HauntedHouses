package cz.muni.fi.pa165.services;

import cz.muni.fi.pa165.dao.GhostDao;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.exception.ScaryDataAccessException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @author Ondrej Ponteš
 */
public class GhostServiceImpl implements GhostService {
    @Autowired
    private GhostDao ghostDao;

    @Override
    public Long create(Ghost ghost) {
        try {
            return ghostDao.create(ghost);
        } catch (IllegalArgumentException | PersistenceException | ConstraintViolationException e) {
            throw new ScaryDataAccessException("cannot create ghost", e);
        }
    }

    @Override
    public Ghost update(Ghost ghost) {
        try {
            return ghostDao.update(ghost);
        } catch (ConstraintViolationException e) {
            throw new ScaryDataAccessException("cannot update ghost", e);
        }
    }

    @Override
    public void delete(Ghost ghost) {
        try {
            ghostDao.delete(ghost);
        } catch (ConstraintViolationException e) {
            throw new ScaryDataAccessException("cannot delete ghost", e);
        }
    }

    @Override
    public Ghost getById(long id) {
        try {
            return ghostDao.getById(id);
        } catch (ConstraintViolationException e) {
            throw new ScaryDataAccessException("cannot find ghost by id", e);
        }
    }

    @Override
    public List<Ghost> getByName(String name) {
        try {
            return ghostDao.getByName(name);
        } catch (ConstraintViolationException e) {
            throw new ScaryDataAccessException("cannot find ghost by name", e);
        }
    }

    @Override
    public List<Ghost> getAll() {
        try {
            return ghostDao.getAll();
        } catch (ConstraintViolationException e) {
            throw new ScaryDataAccessException("cannot find all ghosts", e);
        }
    }
}
