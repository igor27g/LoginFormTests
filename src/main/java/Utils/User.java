package Utils;

import java.util.Properties;

public class User {

    private final String email;
    private final String password;
    private final String wrongPassword;
    private final String myAccountUrl;

    public User(Properties properties) {
        email = properties.getProperty("user.email");
        password = properties.getProperty("user.password");
        wrongPassword = properties.getProperty("user.wrongPassword");
        myAccountUrl = properties.getProperty("user.myAccountUrl");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getWrongPassword() {
        return wrongPassword;
    }

    public String getMyAccountUrl() {
        return myAccountUrl;
    }



}