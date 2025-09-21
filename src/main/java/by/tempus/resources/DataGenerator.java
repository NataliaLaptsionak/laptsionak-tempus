package by.tempus.resources;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class DataGenerator {

    private static final Random random = new Random();

    public static String generateValidEmail() {
        return "test" + System.currentTimeMillis() + "@example.com";
    }

    public static String generateInvalidEmail() {
        return "invalid-email";
    }

    public static String generateValidBelarusianPhoneNumber() {
        String operatorCode = String.format("%02d", random.nextInt(3) == 0 ? 29 : (random.nextInt(2) == 0 ? 33 : 44));
        String subscriberNumber = RandomStringUtils.randomNumeric(7);
        return "+375" + operatorCode + subscriberNumber;
    }

    public static String generateInvalidBelarusianPhoneNumber() {
        return "123";
    }

    public static String generateValidFullName() {
        return "Тест Тестович Тестовый";
    }

    public static String generateValidPassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public static String generateInvalidPassword() {
        return "123";
    }

    public static String generateValidRepeatPassword() {
        return "Password-1";
    }

    public static String generateInvalidRepeatPassword() {
        return "Password-2";
    }
}
