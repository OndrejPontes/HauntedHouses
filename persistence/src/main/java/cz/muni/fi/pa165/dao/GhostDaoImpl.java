package cz.muni.fi.pa165.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.muni.fi.pa165.entity.Ghost;

/**
 * @author Ondrej Ponteš
 */
@Repository
@Transactional
public class GhostDaoImpl implements GhostDao {

    @PersistenceContext
    private EntityManager em;

    public Ghost create(Ghost ghost) {
        em.persist(ghost);
        return ghost;
    }

    public Ghost update(Ghost ghost) {
        return em.merge(ghost);
    }

    public void delete(Ghost ghost) {
        em.remove(em.contains(ghost) ? ghost : em.merge(ghost));
    }

    public Ghost getById(long id) {
        return em.find(Ghost.class, id);
    }

    public Ghost getByName(String name) {
        if(name == null)
            throw new IllegalArgumentException("name cannot be null");
        try {
            return em.createQuery("select ghost from Ghost ghost where ghost.name = :name", Ghost.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Ghost> getAll() {
        return em.createQuery("select ghost from Ghost ghost", Ghost.class)
                .getResultList();
    }

    @Override
    public List<Ghost> getByAbility(Ability ability) {
        TypedQuery<Ghost> query = em.createQuery(
                "Select g from Ghost g where :ability member of g.abilities",
                Ghost.class);
        query.setParameter("ability", ability);
        return query.getResultList();
    }

    @Override
    public List<Ghost> getGhostsOfHouse(House house) {
        TypedQuery<Ghost> query = em.createQuery(
                "Select g from Ghost g where :house = g.hauntedHouse",
                Ghost.class);
        query.setParameter("house", house);
        return query.getResultList();
    }
}
