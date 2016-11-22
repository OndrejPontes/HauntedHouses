package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.UserAuthenticateDTO;
import cz.muni.fi.pa165.dto.UserDTO;

import java.util.Collection;

/**
 * @author Ondrej Ponteš
 */
public interface UserFacade {
    UserDTO findUserById(Long userId);

    UserDTO findUserByEmail(String email);

    /**
     * Register the given user with the given unencrypted password.
     */
    void registerUser(UserDTO u, String unencryptedPassword);

    /**
     * Get all registered users
     */
    Collection<UserDTO> getAllUsers();

    /**
     * Try to authenticate a user. Return true only if the hashed password matches the records.
     */
    boolean authenticate(UserAuthenticateDTO u);

    /**
     * Check if the given user is admin.
     */
    boolean isAdmin(UserDTO u);
}
