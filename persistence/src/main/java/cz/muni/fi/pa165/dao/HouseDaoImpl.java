package cz.muni.fi.pa165.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.muni.fi.pa165.entity.House;

/**
 * @author Jirka Kruml
 */
public class HouseDaoImpl implements HouseDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(House house) {
        em.persist(house);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public House update(House house) {
        return em.merge(house);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean delete(House house) {
        em.remove(house);
        return !em.contains(house);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public House getById(long id) {
        return em.find(House.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public House getByName(String name) {
        return (House) em.createQuery("select House from House house where House.name = :name")
                .setMaxResults(1)
                .getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public House getByAddress(String address) {
        return (House) em.createQuery("select House from House house where House.address = :address")
                .setParameter("address", address)
                .setMaxResults(1)
                .getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<House> getAll() {
        return em.createQuery("select house from House house").getResultList();
    }
}
