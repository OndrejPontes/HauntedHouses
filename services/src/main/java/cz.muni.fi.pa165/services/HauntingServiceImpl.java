package cz.muni.fi.pa165.services;

import cz.muni.fi.pa165.dao.HauntingDao;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import cz.muni.fi.pa165.exception.HauntingDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            throw new HauntingDataAccessException("Cannot create haunting ", ex);
        }
    }

    @Override
    public void remove(Haunting haunting) {
        try {
            hauntingDao.delete(haunting);
        }catch (Exception ex) {
            throw new HauntingDataAccessException("Cannot remove haunting ", ex);
        }
    }

    @Override
    public void addGhost(Haunting haunting, Ghost ghost) {
        if (haunting.getGhosts().contains(ghost)) {
            throw new HauntingDataAccessException("Ghost is already in a collection. ");
        }
        try {
            haunting.addGhost(ghost);
        }catch (Exception ex) {
            throw new HauntingDataAccessException("Cannot add ghost ", ex);
        }
    }

    @Override
    public void removeGhost(Haunting haunting, Ghost ghost) {
        try {
            haunting.removeGhost(ghost);
        }catch (Exception ex) {
            throw new HauntingDataAccessException("Cannot remove ghost ", ex);
        }
    }

    @Override
    public Haunting update(Haunting haunting) {
        try {
            return hauntingDao.update(haunting);
        }catch (Exception ex) {
            throw new HauntingDataAccessException("Cannot update haunting ", ex);
        }
    }

    @Override
    public Haunting getById(Long id) {
        try {
            return hauntingDao.getById(id);
        }catch (Exception ex) {
            throw new HauntingDataAccessException("Cannot find haunting by id ", ex);
        }
    }

    @Override
    public List<Haunting> getByDate(Calendar date) {
        try {
            return hauntingDao.getByDate(date);
        }catch (Exception ex) {
            throw new HauntingDataAccessException("Cannot find haunting by date ", ex);
        }
    }

    @Override
    public List<Haunting> getAll() {
        try {
            return hauntingDao.getAll();
        }catch (Exception ex) {
            throw new HauntingDataAccessException("Cannot find all hauntings ", ex);
        }
    }
}
