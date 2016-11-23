package cz.muni.fi.pa165.exception;

import org.springframework.dao.DataAccessException;

/**
 * @author opontes
 */
public class ScaryDataAccessException extends DataAccessException {
    public ScaryDataAccessException(String msg) {
        super(msg);
    }

    public ScaryDataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
