package service;

import domain.model.User;

import java.util.Objects;

public class UserServiceTest {

    private static UserService userService;
    private static final String TEST_EMAIL = "ahmmedjubayer2015@gmail.com";

    public static void main(String[] args) {

        userService = new UserService();

        testUserEmailFormat();

        testRegisterUser();

        testGetUserByEmail();

        testGetUserByEmailNotFound();

    }

    private static void testUserEmailFormat() {

        String message = isValidEmailFormat(TEST_EMAIL)
                ? "testEmailFormat PASSED: Email format is valid"
                : "testEmailFormat FAILED: Email format is invalid for " + TEST_EMAIL;

        System.out.println(message);
    }

    public static void testRegisterUser() {

        User user = userService.registerUser(TEST_EMAIL);

        String message = isUserEmailValid(user)
                ? "testRegisterUser PASSED"
                : "testRegisterUser FAILED: User should not be null and email should be " + TEST_EMAIL;

        System.out.println(message);
    }

    public static void testGetUserByEmail() {

        userService.registerUser(TEST_EMAIL);
        User user = userService.getUserInformation(TEST_EMAIL);

        String message = isUserEmailValid(user)
                ? "testGetUserByEmail PASSED"
                : "testGetUserByEmail FAILED: User should not be null and email should be " + TEST_EMAIL;

        System.out.println(message);

    }

    public static void testGetUserByEmailNotFound() {

        User user = userService.getUserInformation("ahmmedjubayer@example.com");

        String message = Objects.isNull(user)
                ? "testGetUserByEmailNotFound PASSED"
                : "testGetUserByEmailNotFound FAILED: User should be null for non-existent email";

        System.out.println(message);

    }

    private static boolean isUserEmailValid(User user) {
        return Objects.nonNull(user) && TEST_EMAIL.equals(user.getEmail());
    }

    private static boolean isValidEmailFormat(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && email.matches(emailRegex);
    }
}



