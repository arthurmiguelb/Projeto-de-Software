import java.util.ArrayList;

import Users.Menu;
import Users.UserDo;


public class Main{

    public static void main(String[] args){
        ArrayList<UserDo> users = new ArrayList<>();
        users.add(new UserDo("admin", "adm", "admin", "none", "none"));
        Menu menu = new Menu();
        menu.runMenu(users);
    }
}