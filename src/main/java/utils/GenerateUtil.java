package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class GenerateUtil {
    GenerateUtil() {
        throw new IllegalStateException("This is utility class.");
    }

    public static String generateRandomName() {
        return String.format("Name_%s", RandomStringUtils.random(7, true, false));
    }

    public static String generateRandomFirstName() {
        return String.format("FirstName_%s", RandomStringUtils.random(7, true, false));
    }

    public static String generateLastName() {
        return String.format("LastName_%s", RandomStringUtils.random(7, true, false));
    }

    public static int generateRandomId() {
        return new Random().nextInt(50);
    }

    public static String generateRandomCategory() {
        return String.format("Category_%s", RandomStringUtils.random(7, true, false));
    }

    public static String generateRandomEmail() {
        return String.format("%s@gmail.com", RandomStringUtils.random(15, true, true));
    }

    public static String generateRandomPassword() {
        return String.format("pass_%s", RandomStringUtils.random(15, true, true));
    }

    public static String generateRandomPhoneNumber() {
        return String.format("+380%s", RandomStringUtils.random(9, false, true));
    }
}
