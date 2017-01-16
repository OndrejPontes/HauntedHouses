package cz.muni.fi.pa165.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.House;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.muni.fi.pa165.entity.Haunting;

/**
 * @author Monika Mociarikova
 */
@Repository
@Transactional
public class HauntingDaoImpl implements HauntingDao {

    @PersistenceContext
    private EntityManager em;

    public Haunting create(Haunting haunting) {
        em.persist(haunting);
        return haunting;
    }

    public Haunting update(Haunting haunting) {
        return em.merge(haunting);
    }

    public void delete(Haunting haunting) {
        em.remove(haunting);
    }

    public Haunting getById(Long id) {
        return em.find(Haunting.class, id);
    }

    public List<Haunting> getByDate(Date date) {
        if(date == null)
            throw new IllegalArgumentException("date cannot be null");

        TypedQuery<Haunting> query = em.createQuery("select h from Haunting h where h.date = :date", Haunting.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    public List<Haunting> getAll() {
        return em.createQuery("select h from Haunting h", Haunting.class)
                .getResultList();
    }

    @Override
    public List<Haunting> getHauntingsOfGhost(Ghost ghost) {
        if(ghost == null)
            throw new IllegalArgumentException("ghost cannot be null");
        TypedQuery<Haunting> query = em.createQuery("select h from Haunting h where :ghost member of h.ghosts", Haunting.class);
        query.setParameter("ghost", ghost);
        return query.getResultList();
    }

    @Override
    public List<Haunting> getHauntingsOfHouse(House house) {
        if(house == null)
            throw new IllegalArgumentException("house cannot be null");
        TypedQuery<Haunting> query = em.createQuery("select h from Haunting h where :house = h.hauntedHouse", Haunting.class);
        query.setParameter("house", house);
        return query.getResultList();
    }


}
