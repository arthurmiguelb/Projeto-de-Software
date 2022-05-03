package Users;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class MenuLogin{
    boolean exit;
    
    public void runMenuLogin(Users user, ArrayList<UserDo> users){

        exit = false;
        while(!exit){
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            printMenuLogin(user);
            int choice = getInputMenu1();
            perfomAction(choice, user, users);
        }
     }

     private void printMenuLogin(Users user){
         
            System.out.println("\n+------------------------------+");
            System.out.println("|                              |");
            System.out.println("|           Welcome "+user.getName()+"          |");
            System.out.println("|                              |");
            System.out.println("+------------------------------+");
            System.out.println("\n1) profile");
            System.out.println("2) news feed");
            System.out.println("3) friends");
            System.out.println("4) community");
            System.out.println("5) delete profile");
            System.out.println("0) exit");

     }
     private int getInputMenu1(){
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while(choice < 0 || choice > 5){
            try{
                System.out.println("\nEnter your choice: ");
                choice =  Integer.parseInt(kb.nextLine());

            }
            catch(NumberFormatException e){
                System.out.println("Invalid selection, Please try again.");

            }
        }
        return choice;
    }
    

    private void perfomAction(int choice, Users user, ArrayList<UserDo> users){
        // Scanner b = new Scanner(System.in);
        // int choice3 = b.nextInt();
        switch(choice){
            case 0:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            exit = true;
            System.out.println("\nThank you for using our application.");
            break;

            case 1:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            profileMenu(user, users);
            break;
        
            case 2:
            break;

            case 3:
            FriendMenu(user, users);
            break;

            case 4:
            break;

            case 5:
            String option;
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("do you want to remove your profile?\n");
            System.out.println("y/n?");
            Scanner a = new Scanner(System.in);
            option = a.next();
            if(option.equals("y")){
                exit = true;
                delete_profile(user, users);
                System.out.println("your profile has been removed!");
                
                break;
            }
            else if(option.equals("n")){
            break;
            }

            default:
        }
    }

    private void profileMenu(Users user, ArrayList<UserDo> users){
        
        while(true){
            
            System.out.println("\n1) show my profile");
            System.out.println("2) edit my profile");
            System.out.println("0) exit");
            Scanner b = new Scanner(System.in);
            int choice = b.nextInt();
            switch(choice){
                case 0:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("\nThank you for using our application.");
                return;

                case 1:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println(user);
                break;
            
                case 2:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                profileEdit(user, users);
                break;

                default:
            }
        }

    }

    private void profileEdit(Users user, ArrayList<UserDo> users){
        System.out.println("\n1) change nickname");
        System.out.println("2) change username");
        System.out.println("3) change password");
        System.out.println("4) add or change email");
        System.out.println("5) add or change number");
        System.out.println("0) exit");
        Scanner a = new Scanner(System.in);
        int choice2 = a.nextInt();
        
        if(choice2 == 1){
            System.out.println("\nenter your new nickname:");
            Scanner q = new Scanner(System.in);
            String newNickname = q.next();
                for(Users User : users){
                    if(user.getName().equals(newNickname)){
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                    System.out.println("\nnickname already exists. ");
                    return;
                    }
                }
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                user.setName(newNickname);
                System.out.println("\nSuccess!");
                System.out.println("\n your new nickname is "+ user.getName());
        }
        if(choice2 == 2){
                System.out.println("\nenter your new name:");
                Scanner w = new Scanner(System.in);
                String newUsername = w.next();
                for(Users User : users){
                    if(user.getlogin().equals(newUsername)){
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                    System.out.println("\nname already exists. ");
                    return;
                    }
                }
                user.setlogin(newUsername);
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("\nSuccess!");
                System.out.println("\n your new username is "+ user.getlogin());
        }

        if(choice2 == 3){
                System.out.println("\nEnter your new password: ");
                Scanner c = new Scanner(System.in);
                String password = c.next();
                if(password.equals(user.getpassword())){
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println("\nyour password cannot be the same as the previous!");
                    return;
                }
                System.out.println("\nRepeat your password: ");
                Scanner c2 = new Scanner(System.in);
                String password2 = c2.next();
            
            if(password.equals(password2)){
                user.setpassword(password); 
            }
            else{
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("\nPasswords are not the same ");
                return;
            }
            System.out.print("\033[H\033[2J");  
            System.out.flush();
                System.out.println("\nSuccess!");
                System.out.println("\n your new password is "+ user.getpassword());
        }

        if(choice2 == 4){
            System.out.println("\nenter your new email:");
            Scanner e = new Scanner(System.in);
            String newEmail = e.next();
            for(Users User : users){
                if(user.getEmail().equals(newEmail)){
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println("\nemail already exists. ");
                    return;
                }
            }
            user.setEmail(newEmail);
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("\nSuccess!");
            System.out.println("\n your new Email is "+ user.getEmail());
        }
        if(choice2 == 5){
            System.out.println("\nenter your new number:");
            Scanner r = new Scanner(System.in);
            String newNumber = r.next();
            for(Users User : users){
                if(user.getNumber().equals(newNumber)){
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                 System.out.println("\nnumber already exists. ");
                    return;
                }
            }
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            user.setNumber(newNumber); 
            System.out.println("\nSuccess!");
            System.out.println("\n your new number is "+ user.getNumber());

        }
    }

    private void delete_profile(Users user, ArrayList<UserDo> users){
        users.remove(user);
    }

    public void FriendMenu(Users user, ArrayList<UserDo> users){
        
        boolean exit = false;
        System.out.println("\n1) friend requests");
        System.out.println("2) add friend");
        System.out.println("3) remove friend");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
            if(choice == 1){
                printListFriend(user ,user.request);
            }
             if(choice == 2){
                 Boolean it = false;
                System.out.println("\nenter the username of the user:");
                Scanner a = new Scanner(System.in);
                String nick = a.next();
                    for(Users User : users){
                        if(nick.equals(user.getName())){
                            System.out.println("\ndo you want to send request to " + user.getName()+"?");
                            System.out.println("y/n");
                            Scanner b = new Scanner(System.in);
                            String option = b.next();
                                if(option.equals("y")){
                                    user.request.add(user);  
                                    return;
                                }
                                it = true;
                        }
                        else if(!nick.equals(user.getName())){
                            it = false;
                        }
                    }
                    if(it){
                        System.out.println("User does not exist!");
                        return;
                    }

            }
        
        

        }

        public void printListFriend(Users user, ArrayList<Users> request){
            System.out.println("ENTOUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
    
                for(Users users : request){
                    
                        System.out.println("\nrequests:");
                        System.out.println("\n"+user.request);
                
                }
        }



}

