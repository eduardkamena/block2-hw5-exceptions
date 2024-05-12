import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {

        checkUser("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");

    }

    public static void checkUser(String login, String password, String confirmPassword) {
        CreateNewUser user = new CreateNewUser(login, password, confirmPassword);
        try {
            CreateNewUser.checkLogin(user);
            CreateNewUser.checkPassword(user);
            CreateNewUser.checkConfirmPassword(user);
        } catch (WrongLoginException e) {
            System.out.println("Логин содержит недопустимые символы");
        } catch (WrongPasswordException e) {
            System.out.println("Пароли не совпадают или содержат недопустимые символы");
        } finally {
            System.out.println();
            System.out.println("\"Логин\" и \"Пароль\" должны:" +
                    "\n1. Содержать в себе только латинские буквы, цифры и знак подчеркивания" +
                    "\n2. Не превышать 20 знаков");
        }

    }

}
