package cz.muni.fi.pa165.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.muni.fi.pa165.entity.House;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jirka Kruml
 */
@Repository
@Transactional
public class HouseDaoImpl implements HouseDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(House house) {
        em.persist(house);
    }

    @Override
    public House update(House house) {
        return em.merge(house);
    }

    @Override
    public void delete(House house) {
        em.remove(house);
    }

    @Override
    public House getById(long id) {
        return em.find(House.class, id);
    }

    @Override
    public House getByName(String name) {
        return (House) em.createQuery("select House from House house where House.name = :name")
                .setMaxResults(1)
                .getResultList();
    }

    @Override
    public House getByAddress(String address) {
        return (House) em.createQuery("select House from House house where House.address = :address")
                .setParameter("address", address)
                .setMaxResults(1)
                .getResultList();
    }

    @Override
    public List<House> getAll() {
        return em.createQuery("select house from House house").getResultList();
    }
}
