package cz.muni.fi.pa165.services;

import cz.muni.fi.pa165.dao.HauntingDao;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MonikaMociarikova
 *
 * Implementation of the (@link HauntingService)
 */
public class HauntingServiceImpl implements HauntingService {

    @Inject
    private HauntingDao hauntingDao;

    @Override
    public Haunting create(Haunting haunting) {

        hauntingDao.create(haunting);
        return haunting;
    }

    @Override
    public void remove(Haunting haunting) {
        hauntingDao.delete(haunting);
    }

    @Override
    public void addGhost(Haunting haunting, Ghost ghost) {

    }

    @Override
    public void removeGhost(Ghost ghost) {

    }

    @Override
    public Haunting update(Haunting haunting) {
        return hauntingDao.update(haunting);
    }

    @Override
    public Haunting findById(Long id) {
        return hauntingDao.getById(id);
    }

    @Override
    public List<Haunting> findByDate(Date date) {
        return hauntingDao.getByDate(date);
    }

    @Override
    public List<Haunting> findAll() {
        return hauntingDao.getAll();
    }
}
