package models;

public class FriendsSolicitation {
    private String id;
    private String userId;
    private Friend friend;
    private boolean status;

    public FriendsSolicitation(String id, String userId, Friend friend, boolean status) {
        this.id = id;
        this.friend = friend;
        this.userId = userId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Friend getFriend() {
        return friend;
    }

    public boolean getStatus() {
        return status;
    }
}
