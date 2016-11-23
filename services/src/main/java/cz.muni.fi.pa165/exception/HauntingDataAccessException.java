package cz.muni.fi.pa165.exception;

import org.springframework.dao.DataAccessException;

/**
 * @author MonikaMociarikova
 */
public class HauntingDataAccessException extends DataAccessException{

    public HauntingDataAccessException(String msg) {
        super(msg);
    }

    public HauntingDataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
