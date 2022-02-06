package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validation {
    public static void main(String[] args) {
    }

    //static Scanner sc = new Scanner(System.in);


    public static boolean isNotEmptyValidation(String input) {
        return input.isEmpty();
    }

    public static boolean isNotNullValidation(String input) {
        return input.isBlank();
    }


    public static boolean isValidPostalCodeNumber(String pCode) {
        Pattern postalCode = Pattern.compile("^[0-9]{2}+-[0-9]{3}$");
        Matcher m = postalCode.matcher(pCode);
        return m.find();
    }

    public static boolean isValidUUIDNumber(String id) {
        Pattern uUID = Pattern.compile("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})");
        Matcher m = uUID.matcher(id);
        return m.find();
    }

    public static boolean isThatAString(String aString) {
        Pattern isString = Pattern.compile("(^[a-zA-Z])");
        Matcher m = isString.matcher(aString);
        return m.find();

    }
//    public static boolean isThatProperSize(String size){
//        return false;
//    }
}

