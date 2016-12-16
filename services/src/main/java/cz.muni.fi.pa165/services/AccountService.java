package cz.muni.fi.pa165.services;

import cz.muni.fi.pa165.entity.Account;

/**
 * @author Jirka Kruml
 */
public interface AccountService {

    Account create(Account account);

    Account update(Account account);

    void delete(Long id);

    void delete(Account account);

    Account getById(Long id);

    Account getByName(String username);
}
