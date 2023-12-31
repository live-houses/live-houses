package livehouses;

import java.util.regex.Pattern;

public class BaseUser {
    private String username;
    private String email;
    private String password;
    private UserRole role;

    public BaseUser(String username, String email, String password, UserRole role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public class EmailValidation {
        private static final String EMAIL_REGEX = (
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
        );

        public static boolean isValidEmail(String email) {
            return Pattern.matches(EMAIL_REGEX, email);
        }
    }

    public class PasswordValidation {
        private static final String PASSWORD_REGEX = ("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

        public static boolean isValidPassword(String password) {
            return Pattern.matches(PASSWORD_REGEX, password);
        }
    }

    public class UsernameValidation {
        private static final String USERNAME_REGEX = "^[a-z0-9_-]{3,15}$";

        public static boolean isValidUsername(String username) {
            return Pattern.matches(USERNAME_REGEX, username);
        }
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public UserRole getRole() { return role; }
    public String getPassword() { return password; }
}
