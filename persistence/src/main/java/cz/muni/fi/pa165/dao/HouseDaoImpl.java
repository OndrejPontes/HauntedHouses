package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.House;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    public House getByName(String name) {
        try {
            return em
                    .createQuery("select a from House a where name = :name",
                            House.class).setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    @Override
    public House getByAddress(String address) {
        try {
            return em
                    .createQuery("select a from House a where address = :address",
                            House.class).setParameter("address", address)
                    .getSingleResult();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    @Override
    public List<House> getAll() {
        return em.createQuery("select house from House house", House.class).getResultList();
    }
}
