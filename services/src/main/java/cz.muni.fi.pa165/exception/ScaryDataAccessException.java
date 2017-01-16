package cz.muni.fi.pa165.exception;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.google.gson.Gson;

/**
 * @author opontes
 */
public class ScaryDataAccessException extends DataAccessException {
    public ScaryDataAccessException(String msg) {
        super(msg);
    }

    public ScaryDataAccessException(List<String> errors) {
        super(new Gson().toJson(errors));
    }

    public ScaryDataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
