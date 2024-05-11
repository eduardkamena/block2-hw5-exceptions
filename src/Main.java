import service.CreateNewUser;
import service.CheckCreateNewUser;

public class Main {
    public static void main(String[] args) {

        CreateNewUser user = new CreateNewUser("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        CreateNewUser user1 = new CreateNewUser("Test2", "123g588_2", "123g588_2");

        CheckCreateNewUser.checkUser(user);
        CheckCreateNewUser.checkUser(user1);

    }

}
