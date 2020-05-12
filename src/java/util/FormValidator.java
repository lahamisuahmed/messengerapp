package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.json.JsonObjectBuilder;

/**
 * validate form input submitted by client ends
 *
 * @author ajitata & lawal
 */
public class FormValidator {

    /* check for a valid email address */
    public boolean isValidEmail(String emailStr) {
        if (isBlank(emailStr)) {
            return false;
        }
        Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(emailStr);
        return matcher.find();
    }

    public boolean isValidWebsite(String website) {
        if (isBlank(website)) {
            return false;
        }
        Matcher matcher = Pattern.compile("^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$", Pattern.CASE_INSENSITIVE).matcher(website);
        return matcher.find();
    }

    /* check if a given value is not empty or just space(s) */
    public boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    /* check if a given day is valid as day of month */
    public boolean isValidMonthDay(String day) {
        if (isBlank(day)) {
            return false;
        }
        if (!isNumeric(day)) {
            return false;
        }
        int d = Integer.parseInt(day);
        return d > 0 && d <= 31;
    }

    /* check if a given input is a number/digit */
    public boolean isNumeric(String str) {
        if (str == null) {
            return false;
        } else if (str.contains(".")) {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException ne) {
                return false;
            }
        } else {
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }
    }

    public void addError(boolean isFaulty, String key, String value, JsonObjectBuilder o) {
        if (isFaulty) {
            o.add(key, value);
        }
    }

    public boolean pinOK(String pin) {
        if (isBlank(pin)) {
            return false;
        } else if (!isNumeric(pin)) {
            return false;
        } else {
            return pin.length() == 4;
        }
    }

}
