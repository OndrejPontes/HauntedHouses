package cz.muni.fi.pa165.exception;

import org.springframework.dao.DataAccessException;

/**
 * @author opontes
 */
public class GhostDataAccessException extends DataAccessException {
    public GhostDataAccessException(String msg) {
        super(msg);
    }

    public GhostDataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
