package Users;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Users {
    ArrayList<Users> friends;
    ArrayList<String> menssage;
    ArrayList<Users> request;
    ArrayList<Users> requestcommunity;
   private String name;
   private String login;
   private String password;
   private String email;
   private String number;



   public Users(String name, String login, String password, String email, String number){
       this.name = name;
       this.login = login;
       this.password = password;
       this.email = email;
       this.number = number;
       this.friends = new ArrayList<Users>();
       this.request = new ArrayList<Users>();
       this.requestcommunity = new ArrayList<Users>();
       this.menssage = new ArrayList<String>();
   }
    public String getName(){
        return name;
    }
    public void setName(String name){
         this.name = name;
    }
    public String getlogin(){
        return login;
    }
    public void setlogin(String login){
         this.login = login;
    }
    public String getpassword(){
        return password;
    }
    public void setpassword(String password){
         this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return number;
    }

    // public String printUsersInfo(){
    //     return "Name: " + this.name +
    //            "\nlogin: " + this.login +
    //            "\nemail: " + this.email + 
    //            "\nnumber: " + this.number+
    //            "\npassword: " + this.password;
    // }
    // public String printUsersInfo(Users user){
    //     return "Name: " + this.name +
    //            "\nlogin: " + this.login +
    //            "\npassword: " + this.password +
    //            "\nemail: " + this.email + 
    //            "\nnumber: " + this.number+
    //            "\n----------------------------" +
    //            "\nName: " + user.name +
    //            "\nlogin: " + user.login +
    //            "\npassword: " + user.password+
    //            "\nemail: " + user.email + 
    //            "\nnumber: " + user.number;
    // }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\nName: " + this.name +
               "\nlogin: " + this.login +
               "\nemail: " + this.email + 
               "\nnumber: " + this.number +
               "\npassword: " + this.password+
               "\n";
    }    

    public void register(String nickname, String username, String password, ArrayList<UserDo> users){
        users.add(new UserDo(nickname, username, password, email, number));
        //  printlist(users);
    }
}
