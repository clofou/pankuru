package org.odk.g1.pankuru.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilService {

    public static boolean isValidEmail(String email) {
        final String EMAIL_PATTERN =
                "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhone(String phone) {
        final String PHONE_PATTERN = "^[+]?[0-9]{10,13}$";
        final Pattern pattern = Pattern.compile(PHONE_PATTERN);
        if (phone == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean isValidPassportNumber(String passportNumber) {
        final String PASSPORT_PATTERN = "^[A-Z]{1,2}[0-9]{6}$";
        final Pattern pattern = Pattern.compile(PASSPORT_PATTERN);
        if (passportNumber == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(passportNumber);
        return matcher.matches();
    }

    
    public static boolean isValidVisaNumber(String visaNumber) {
        final String VISA_PATTERN = "^[A-Z]{1,2}[0-9]{6}$";
        final Pattern pattern = Pattern.compile(VISA_PATTERN);
        if (visaNumber == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(visaNumber);
        return matcher.matches();
    }

    
    public static boolean isValidCarteBancaireNumber(String carteBancaireNumber) {
        final String CARTE_BANCAIRE_PATTERN = "^[0-9]{16}$";
        final Pattern pattern = Pattern.compile(CARTE_BANCAIRE_PATTERN);
        if (carteBancaireNumber == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(carteBancaireNumber);
        return matcher.matches();
    }


    public static boolean isValidPassword(String password) {
        return password != null && password.length() > 6;
    }

    
}
