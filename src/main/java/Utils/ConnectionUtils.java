package Utils;

import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import javax.security.auth.login.LoginException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConnectionUtils {
    private String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{10,}$";
    private Pattern pattern = Pattern.compile(this.passwordRegex);

    public boolean isRegexPasswordValid(String password) throws LoginException {
        Matcher match = this.pattern.matcher(password);
        if (match.matches()) {
            System.out.println("Password is valid");
        } else {
            throw new LoginException("Le mot de passe doit contenir au moins une minuscule, " +
                    "une majuscule et un caractère spécial et doit faire au moins 10 caractères.");
        }
        return match.matches();
    }

    public static String hashPassword(String password) {
//        PBEKeySpec spec = new PBEKeySpec(password.toCharArray())
        return new String();
    }
}
