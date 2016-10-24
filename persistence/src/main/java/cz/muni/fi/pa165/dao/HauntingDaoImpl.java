package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Haunting;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Monika Mociarikova
 */
@Repository
public class HauntingDaoImpl implements HauntingDao {

    @PersistenceContext
    private EntityManager em;

    public void create(Haunting haunting) {
        em.persist(haunting);
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

    public List<Haunting> getByDate(LocalDate date) {
        TypedQuery<Haunting> query = em.createQuery("select h from Haunting h where h.date between :startDate and :endDate", Haunting.class);
        query.setParameter("startDate", date);
        query.setParameter("endDate", date.atTime(23,59,59));
        return query.getResultList();
    }

    public List<Haunting> getAll() {
        return em.createQuery("select h from Haunting h", Haunting.class)
                .getResultList();
    }
}
