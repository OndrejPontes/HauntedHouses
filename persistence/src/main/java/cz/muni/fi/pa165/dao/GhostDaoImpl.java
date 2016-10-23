package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Ghost;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Ondrej Ponteš
 */
public class GhostDaoImpl implements GhostDao {

    @PersistenceContext
    private EntityManager em;

    public Ghost create(Ghost ghost) {
        em.persist(ghost);
        return getById(ghost.getId());
    }

    public Ghost update(Ghost ghost) {
        return em.merge(ghost);
    }

    public boolean delete(Ghost ghost) {
        em.remove(ghost);
        return !em.contains(ghost);
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
