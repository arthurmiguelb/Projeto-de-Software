import models.Friend;
import models.FriendsSolicitation;
import models.User;

import java.util.ArrayList;
import java.util.List;

import static models.Friend.fromUser;
import static models.Friend.listFriends;
import static models.User.*;

public class Main {

    static List<User> users = new ArrayList<>();

    static List<FriendsSolicitation> friendsSolicitation = new ArrayList<>();

    static List<Friend> friends = new ArrayList<>();

    static User loggedUser;

    public static void main(String[] args) {
        rootMenu();
    }


    private static void loggedMenu() {
        do {
            System.out.println("1 - Listar usuários");
            System.out.println("2 - Editar usuário");
            System.out.println("3 - Listar amigos");
            System.out.println("4 - Solicitar amizade");
            System.out.println("5 - Listar solicitações de amizade");
            System.out.println("6 - Sair");
            System.out.println("Digite a opção desejada: ");
            int opcao = Integer.parseInt(System.console().readLine());
            switch (opcao) {
                case 1:
                    clearScreen();
                    listUsers(users);
                    break;
                case 2:
                    clearScreen();
                    editUser(users, loggedUser.getId());
                    break;
                case 3:
                    clearScreen();
                    listFriends(friends, loggedUser.getId(), users);
                    break;
                case 4:
                    clearScreen();
                    solicitFriend();
                    clearScreen();
                    break;
                    case 5:
                    clearScreen();
                    listSolicitations();
                    break;
                case 6:
                    clearScreen();
                    rootMenu();
                    break;
            }
        } while (true);
    }

    private static void rootMenu() {
        do {
            System.out.println("Bem vindo ao IFace!");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar novo usuário");
            System.out.println("3 - Listar usuários");
            System.out.println("4 - Sair");
            System.out.println("Digite a opção desejada: ");
            int opcao = Integer.parseInt(System.console().readLine());
            switch (opcao) {
                case 1:
                    clearScreen();
                    loggedUser = login(users);

                    if (loggedUser == null) {
                        System.out.println("Usuário não encontrado");
                    } else {
                        clearScreen();
                        System.out.println("Bem vindo " + loggedUser.getName());
                        loggedMenu();
                    }
                    break;
                case 2:
                    clearScreen();
                    User createdUser = createUser(users.size());
                    users.add(createdUser);
                    clearScreen();
                    break;
                case 3:
                    clearScreen();
                    listUsers(users);
                    break;

            }
        } while (true);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void solicitFriend() {
        String loggedUserId = loggedUser.getId();
        System.out.println("Digite o id do usuário que deseja solicitar amizade: ");
        int friendId = Integer.parseInt(System.console().readLine());

        User friend = findUserById(Integer.toString(friendId));

        if (friend == null) {
            System.out.println("Usuário não encontrado");
        } else {
            Friend friendRequest = fromUser(loggedUser, Integer.toString(friendId));
            FriendsSolicitation solicitation = new FriendsSolicitation(Integer.toString(friendsSolicitation.size() + 1) ,Integer.toString(friendId), friendRequest, false);
            friendsSolicitation.add(solicitation);
        }
    }

    public static void listSolicitations() {

        System.out.println("Listar Solicitações de amizade");
        final StringBuffer sb = new StringBuffer("Users \n");
        List<FriendsSolicitation> solicitationsToRemove = new ArrayList<>();
        for (FriendsSolicitation solicitation : friendsSolicitation) {
            if (solicitation.getUserId().equals(loggedUser.getId())) {
                    Friend friend = solicitation.getFriend();
                    sb.append("{id='").append(friend.getId()).append("'")
                            .append(", name='").append(friend.getName()).append("'")
                            .append("} \n");
                    System.out.println(sb.toString());

                    System.out.println("Deseja aceitar a solicitação de amizade? (s/n/sair)");
                    String opcao = System.console().readLine();
                    if (opcao.equals("s")) {
                        friends.add(friend);
                        solicitationsToRemove.add(solicitation);
                    }

                    if (opcao.equals("sair")) {
                        break;
                    }
            }
        }
        friendsSolicitation.removeAll(solicitationsToRemove);
    }

    public static User findUserById(String friendId) {
        User user = null;
        for (User currentUser : users) {
            if (currentUser.getId().equals(friendId)) {
                user = currentUser;
            }
        }

        return user;
    }
}
