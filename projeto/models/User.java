package models;

import java.util.List;
import java.util.Objects;

public class User {
    public int id;
    public String email;
    public String password;
    public String name;


    public User(int id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getId() {
        return Integer.toString(id);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public static User createUser(int size) {
        System.out.println("Cadastrar novo usuário");
        System.out.println("Digite o nome do usuário: ");
        String name = System.console().readLine();
        System.out.println("Digite o email do usuário: ");
        String email = System.console().readLine();
        System.out.println("Digite a senha do usuário: ");
        String password = System.console().readLine();

        return new User(size + 1, email, password, name);
    }

    public static void listUsers(List<User> users) {
        System.out.println("Listar usuários");
        final StringBuffer sb = new StringBuffer("Users \n");
        for (User currentUser : users) {
            sb.append("{id='").append(currentUser.getId()).append("'")
                    .append(", name='").append(currentUser.getName()).append("'")
                    .append("} \n");
        }
        System.out.println(sb.toString());
    }

    public static List<User> editUser(List<User> users, String id) {
        System.out.println("Editar usuário");
        for (User user : users) {
            if (Objects.equals(user.getId(), id)) {
                System.out.println("Digite o nome do usuário: ");
                String name = System.console().readLine();
                System.out.println("Digite o email do usuário: ");
                String email = System.console().readLine();
                System.out.println("Digite a senha do usuário: ");
                String password = System.console().readLine();
                user.name = name;
                user.email = email;
                user.password = password;
            } else {
                System.out.println("Usuário não encontrado");
            }
            return users;
        }
        return users;
    }

    public static User login(List<User> users) {
        System.out.println("Login");
        System.out.println("Digite o email do usuário: ");
        String login_email = System.console().readLine();
        System.out.println("Digite a senha do usuário: ");
        String login_password = System.console().readLine();
        for (User currentUser : users) {
            if (Objects.equals(login_email, currentUser.getEmail()) && Objects.equals(login_password, currentUser.getPassword())) {
                return currentUser;
            }
        }
        return null;
    }
}
