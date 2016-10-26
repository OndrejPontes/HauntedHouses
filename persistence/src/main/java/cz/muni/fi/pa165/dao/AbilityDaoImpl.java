package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Ability;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by vojta on 10/25/16.
 */
public class AbilityDaoImpl implements AbilityDao {

    @PersistenceContext
    private EntityManager em;

    public Ability findById(Long id) {
        return null;
    }

    public void create(Ability a) {
        em.persist(a);
    }

    public void delete(Ability a) {

    }

    public void update(Ability a) {
        em.merge(a);
    }

    public List<Ability> findAll() {
        return null;
    }

    public Ability findByName(String name) {
        return null;
    }
}
