package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for parameters validation
 */
public class Validator {
    public static boolean isValidPassword(String pass) {
        if (pass == null || pass.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[а-яА-Я\\wіІїЇ@#$%^&+=]{6,64}$");
        Matcher matcher = pattern.matcher(pass);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    /**
     * Method for first name and last name validation
     * @param name
     * @return
     */
    public static boolean isValidName(String name){
        if (name == null || name.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{3,20}|[А-ЯІЇ][а-я]{3,20}$");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }
}
