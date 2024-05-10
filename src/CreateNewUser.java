import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public record CreateNewUser(String login, String password, String confirmPassword) {

    public static void checkLogin(CreateNewUser login) throws WrongLoginException {
        if (!login.login().matches("\\w{1,20}")) {
            throw new WrongLoginException();
        } else {
            System.out.println("Логин успешно сохранен");
        }
    }

    public static void checkPassword(CreateNewUser password) throws WrongPasswordException {
        if (!password.password().matches("\\w{1,20}")) {
            throw new WrongPasswordException();
        }
    }

    public static void checkConfirmPassword(CreateNewUser password) throws WrongPasswordException {
        if (!password.confirmPassword().equals(password.password())) {
            throw new WrongPasswordException();
        } else {
            System.out.println("Пароль успешно сохранен");
        }
    }

}
