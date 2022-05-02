import java.util.ArrayList;

import Users.Menu;
import Users.Users;

public class Main{

    public static void main(String[] args){
        ArrayList<Users> users = new ArrayList<>();
        users.add(new Users("admin", "adm", "admin", "none", "none"));
        Menu menu = new Menu();
        menu.runMenu(users);
    }
}