package main.control.classes;

public class message {
    String room;
    String username;
    String message;

    public void setMessage(String message) {
        this.message = message;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public String getRoom() {
        return room;
    }
    public String getMessage() {
        return message;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String uname) {
        this.username = uname;
    }
    public void newMessage(String uname, String rm, String ms) {
        this.username = uname;
        this.room = rm;
        this.message = ms;
    }
}
