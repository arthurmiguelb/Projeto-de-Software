package models;

import java.util.List;

public class Friend extends User {
    private final String userId;

    public Friend(String userId, String id, String name, String email) {
        super(Integer.parseInt(id), email, null, name);

        this.userId = userId;
    }

    public String getId() {
        return Integer.toString(id);
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static Friend fromUser(User user, String friendId) {
        return new Friend(user.getId(), friendId, user.getName(), user.getEmail());
    }

    public static void listFriends(List<Friend> friends, String userId, List<User> users) {
        System.out.println("Listar amigos");
        final StringBuffer sb = new StringBuffer("Users \n");
        for (Friend friend : friends) {
            if (friend.getUserId().equals(userId)) {
                sb.append("{id='").append(friend.getId()).append("'")
                        .append(", name='").append(friend.getName()).append("'")
                        .append("} \n");
            }

            if (friend.getId().equals(userId)) {
                for (User user : users) {
                    if (user.getId().equals(friend.getUserId())) {
                        sb.append("{id='").append(user.getId()).append("'")
                                .append(", name='").append(user.getName()).append("'")
                                .append("} \n");
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
