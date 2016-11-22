package cz.muni.fi.pa165.dto;

/**
 * @author Ondrej Ponteš
 */
public class UserAuthenticateDTO {
    private String nickname;
    private String password;

    public String getNickname() {
        return nickname;
    }

    public UserAuthenticateDTO setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAuthenticateDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
