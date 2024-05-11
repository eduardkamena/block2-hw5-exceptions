package service;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class CheckCreateNewUser {

    private static final Pattern CHECK_LOGIN_PATTERN = Pattern.compile("\\w{1,20}");
    private static final Pattern CHECK_PASSWORD_PATTERN = Pattern.compile("\\w{1,20}");

    private static void checkLogin(CreateNewUser createNewUser) {
        if (!CHECK_LOGIN_PATTERN.matcher(createNewUser.login()).matches()) {
            throw new WrongLoginException("Логин должен содержать " +
                    "только латинские буквы, цифры и знак подчеркивания " +
                    "и быть не более 20 знаков");
        }
    }

    private static void checkPassword(CreateNewUser createNewUser) {
        if (!CHECK_PASSWORD_PATTERN.matcher(createNewUser.password()).matches()) {
            throw new WrongPasswordException("Пароль должен содержать " +
                    "только латинские буквы, цифры и знак подчеркивания " +
                    "и быть не более 20 знаков");
        }
    }

    private static void checkConfirmPassword(CreateNewUser createNewUser) {
        if (!createNewUser.password().equals(createNewUser.confirmPassword())) {
            throw new WrongPasswordException("Пароли не совпадают");
        } else {
            System.out.println("Логин и Пароль пользователя \"" + createNewUser.login() + "\" успешно сохранены");
        }
    }

    public static void checkUser(CreateNewUser createNewUser) throws WrongLoginException, WrongPasswordException {
        try {
            checkLogin(createNewUser);
            checkPassword(createNewUser);
            checkConfirmPassword(createNewUser);
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        }
    }

}
