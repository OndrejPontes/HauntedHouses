package cz.muni.fi.pa165.exception;

import org.springframework.dao.DataAccessException;

/**
 * @author Vojta David, vojtadavid
 */
public class ServiceImplDAOException extends DataAccessException {
    public ServiceImplDAOException(String msg) {
        super(msg);
    }

    public ServiceImplDAOException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
