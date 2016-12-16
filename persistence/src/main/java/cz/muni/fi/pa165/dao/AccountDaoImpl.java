package cz.muni.fi.pa165.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.muni.fi.pa165.entity.Account;

/**
 * @author Jirka Kruml
 */
@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Account create(Account account) {
        em.persist(account);
        return account;
    }

    @Override
    public Account update(Account account) {
        em.merge(account);
        return account;
    }

    @Override
    public void delete(Long id) {
        em.remove(getById(id));
    }

    @Override
    public void delete(Account account) {
        delete(account.getId());
    }

    @Override
    public Account getById(Long id) {
        return em.find(Account.class, id);
    }

    @Override
    public Account getByName(String username) {
        return em.createQuery("select a from Account a where name = :username", Account.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public List<Account> getAll() {
        return em.createQuery("select a from Account a", Account.class).getResultList();
    }
}
