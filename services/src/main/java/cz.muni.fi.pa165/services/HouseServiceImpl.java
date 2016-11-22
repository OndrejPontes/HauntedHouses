package cz.muni.fi.pa165.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.muni.fi.pa165.dao.HouseDao;
import cz.muni.fi.pa165.entity.House;

/**
 * @author Jirka Kruml
 */
@Service
@Transactional
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseDao houseDao;

    @Override
    public Collection<House> getAll() {
        return houseDao.getAll();
    }

    @Override
    public House getByName(String name) {
        return houseDao.getByName(name);
    }

    @Override
    public House getByAddress(String address) {
        return houseDao.getByAddress(address);
    }

    @Override
    public House getById(Long id) {
        return houseDao.getById(id);
    }

    @Override
    public House create(House house) {
        houseDao.create(house);
        return house;
    }

    @Override
    public void update(House house) {
        houseDao.update(house);
    }

    @Override
    public void delete(Long id) {
        houseDao.delete(id);
    }
}
