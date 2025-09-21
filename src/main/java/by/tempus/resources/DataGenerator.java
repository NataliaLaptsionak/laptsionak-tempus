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
        // Генерирует случайный двухзначный операторский код (29, 33, 44)
        String operatorCode = String.format("%02d", random.nextInt(3) == 0 ? 29 : (random.nextInt(2) == 0 ? 33 : 44));
        // Генерирует случайный семизначный абонентский номер
        String subscriberNumber = RandomStringUtils.randomNumeric(7);
        return "+375" + operatorCode + subscriberNumber;
    }

    public static String generateInvalidBelarusianPhoneNumber() {
        return "123"; // Too short
    }

    public static String generateValidFullName() {
        return "Тест Тестович Тестовый";
    }

    public static String generateValidPassword() {
        return RandomStringUtils.randomAlphanumeric(10); // Min 6 chars
    }

    public static String generateInvalidPassword() {
        return "123"; // Too short
    }

    public static String generateRepeatPassword(String password) {
        return password;
    }

    public static String generateInvalidRepeatPassword() {
        return "Password-2";
    }
}