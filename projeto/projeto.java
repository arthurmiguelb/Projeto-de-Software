
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class User{
    public String login;
    public String senha;

    public User(String login, int senha) {
        this.login = login;
        this.senha = senha;
    }
}
public class projeto {
    public static void main(final String[] args) {
        int number1;
        System.out.print("escolha uma opção: [1] Login  [2]Criar conta\n");
        Scanner ler = new Scanner(System.in);
        number1 = ler.nextInt();
        if (number1 == 1) {
            entra();
        } else if (number1 == 2) {
            cria_conta();
        }
    }

    public static void entra() {
        String login, senha;
        
        System.out.print("digite seu usuário:\n");
        Scanner ler = new Scanner(System.in);
        login = ler.nextLine();
        System.out.print("digite sua senha:\n");
        Scanner ler2 = new Scanner(System.in);
        senha = ler2.nextLine();
        
    }
    public static void cria_conta(){
        String login, senha;
        System.out.print("digite seu usuário:\n");
        Scanner ler = new Scanner(System.in);
        login = ler.nextLine();
        System.out.print("digite sua senha:\n");
        Scanner ler2 = new Scanner(System.in);
        senha = ler2.nextLine();
        System.out.print("digite novamente sua senha:\n");
        Scanner ler3 = new Scanner(System.in);
        senha = ler3.nextLine();
        if(ler2 != ler3)
        {
            System.out.print("as senhas são diferentes!\n");
            return;
        }
        else{
            ArrayList<String> users = new ArrayList<>();

        }
        


    }

  }



