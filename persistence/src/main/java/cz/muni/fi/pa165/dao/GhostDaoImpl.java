package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Ghost;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author opontes
 */
public class GhostDaoImpl implements GhostDao {

    @PersistenceContext
    private EntityManager em;

    public void create(Ghost ghost) {
        em.persist(ghost);
    }

    public void update(Ghost ghost) {
        em.merge(ghost);
    }

    public void delete(Ghost ghost) {
        em.remove(ghost);
    }

    public Ghost getById(long id) {
        return em.find(Ghost.class, id);
    }

    public List<Ghost> getByName(String name) {
        return em.createQuery("select ghost from Ghost ghost where ghost.name = :name")
                .setParameter("name", name)
                .getResultList();
    }

    public List<Ghost> getAll() {
        return em.createQuery("select ghost from Ghost ghost", Ghost.class)
                .getResultList();
    }
}
