package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Haunting;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
}
