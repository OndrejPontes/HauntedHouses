package cz.muni.fi.pa165.services;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.muni.fi.pa165.dao.HauntingDao;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.exception.ServiceImplDAOException;

/**
 * @author MonikaMociarikova
 *
 * Implementation of the (@link HauntingService)
 */
@Service
@Transactional
public class HauntingServiceImpl implements HauntingService {

    @Inject
    private HauntingDao hauntingDao;

    @Override
    public Haunting create(Haunting haunting) {
        try {
            hauntingDao.create(haunting);
            return haunting;
        }catch (Exception ex) {
            throw new ServiceImplDAOException("Cannot create haunting ", ex);
        }
    }

    @Override
    public void remove(Haunting haunting) {
        try {
            hauntingDao.delete(haunting);
        }catch (Exception ex) {
            throw new ServiceImplDAOException("Cannot remove haunting ", ex);
        }
    }

    @Override
    public void addGhost(Haunting haunting, Ghost ghost) {
        if (haunting.getGhosts().contains(ghost)) {
            throw new ServiceImplDAOException("Ghost is already in a collection. ");
        }
        try {
            haunting.addGhost(ghost);
        }catch (Exception ex) {
            throw new ServiceImplDAOException("Cannot add ghost ", ex);
        }
    }

    @Override
    public void removeGhost(Haunting haunting, Ghost ghost) {
        try {
            haunting.removeGhost(ghost);
        }catch (Exception ex) {
            throw new ServiceImplDAOException("Cannot remove ghost ", ex);
        }
    }

    @Override
    public Haunting update(Haunting haunting) {
        try {
            return hauntingDao.update(haunting);
        }catch (Exception ex) {
            throw new ServiceImplDAOException("Cannot update haunting ", ex);
        }
    }

    @Override
    public Haunting getById(Long id) {
        try {
            return hauntingDao.getById(id);
        }catch (Exception ex) {
            throw new ServiceImplDAOException("Cannot find haunting by id ", ex);
        }
    }

    @Override
    public List<Haunting> getByDate(Date date) {
        try {
            return hauntingDao.getByDate(date);
        }catch (Exception ex) {
            throw new ServiceImplDAOException("Cannot find haunting by date ", ex);
        }
    }

    @Override
    public List<Haunting> getAll() {
        try {
            return hauntingDao.getAll();
        }catch (Exception ex) {
            throw new ServiceImplDAOException("Cannot find all hauntings ", ex);
        }
    }
}
