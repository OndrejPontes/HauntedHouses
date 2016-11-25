package cz.muni.fi.pa165.services;

import java.util.Collection;

import cz.muni.fi.pa165.exception.ServiceImplDAOException;
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
        try {
            return houseDao.getAll();
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot getAll house",e);
        }
    }

    @Override
    public House getByName(String name) {

        try {
            return houseDao.getByName(name);
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot getByName house",e);
        }
    }

    @Override
    public House getByAddress(String address) {
        try {
            return houseDao.getByAddress(address);
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot getByAdress house",e);
        }
    }

    @Override
    public House getById(Long id) {

        try {
            return houseDao.getById(id);
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot getById house",e);
        }
    }

    @Override
    public House create(House house) {
        try {
            houseDao.create(house);
            return house;
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot create house",e);
        }
    }

    @Override
    public House update(House house) {

        try {
            return houseDao.update(house);
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot update house",e);
        }
    }

    @Override
    public void delete(Long id) {

        try {
            houseDao.delete(id);
        } catch (Exception e) {
            throw new ServiceImplDAOException("cannot delete house",e);
        }
    }
}
