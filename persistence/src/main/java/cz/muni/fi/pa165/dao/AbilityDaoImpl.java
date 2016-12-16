package cz.muni.fi.pa165.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.muni.fi.pa165.entity.Ability;

/**
 * @author Vojta David
 */
@Repository
@Transactional
public class AbilityDaoImpl implements AbilityDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Ability create(Ability ability) {
        em.persist(ability);
        return ability;
    }

    @Override
    public Ability update(Ability ability) {
        return em.merge(ability);
    }

    @Override
    public void delete(Ability ability) {
        em.remove(ability);
    }

    @Override
    public void delete(long id) {
        em.remove(getById(id));
    }

    @Override
    public Ability getById(long id) {
        return em.find(Ability.class, id);
    }

    @Override
    public Ability getByName(String name) {
        if(name == null)
            throw new IllegalArgumentException("name cannot be null");

        try {
            return em
                    .createQuery("select a from Ability a where name = :name",
                            Ability.class).setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    @Override
    public List<Ability> getAll() {
        return em.createQuery("select a from Ability a", Ability.class)
                .getResultList();
    }
}
