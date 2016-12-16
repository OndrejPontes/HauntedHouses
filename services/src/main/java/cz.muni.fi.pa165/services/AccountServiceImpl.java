package cz.muni.fi.pa165.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.muni.fi.pa165.dao.AccountDao;
import cz.muni.fi.pa165.entity.Account;
import cz.muni.fi.pa165.exception.ScaryDataAccessException;

/**
 * @author Jirka Kruml
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account create(Account account) {
        return accountDao.create(account);
    }

    @Override
    public Account update(Account account) {
        if(account == null) {
            throw new ScaryDataAccessException("name is null");
        }
        return accountDao.update(account);
    }

    @Override
    public void delete(Long id) {
        if(id == null) {
            throw new ScaryDataAccessException("id is null");
        }
        accountDao.delete(id);
    }

    @Override
    public void delete(Account account) {
        if(account == null) {
            throw new ScaryDataAccessException("name is null");
        }
        accountDao.delete(account);
    }

    @Override
    public Account getById(Long id) {
        if(id == null) {
            throw new ScaryDataAccessException("id is null");
        }
        return accountDao.getById(id);
    }

    @Override
    public Account getByName(String username) {
        if(username == null) {
            throw new ScaryDataAccessException("username is null");
        }
        return accountDao.getByName(username);
    }
}
