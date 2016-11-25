package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Ability;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public Ability update(Ability Ability) {
        return em.merge(Ability);
    }

    @Override
    public void delete(Ability Ability) {
        em.remove(Ability);
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
