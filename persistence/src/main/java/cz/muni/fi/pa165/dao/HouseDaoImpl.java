package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.House;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public List<House> getByName(String name) {
        return em.createQuery("select House from House house where House.name = :name")
                .getResultList();
    }

    @Override
    public List<House> getByAddress(String address) {
        return em.createQuery("select House from House house where House.address = :address")
                .setParameter("address", address)
                .getResultList();
    }

    @Override
    public List<House> getAll() {
        return em.createQuery("select house from House house", House.class).getResultList();
    }
}
