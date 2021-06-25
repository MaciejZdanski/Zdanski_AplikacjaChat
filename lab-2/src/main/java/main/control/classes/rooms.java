package main.control.classes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class rooms {
    ArrayList<String> rooms = new ArrayList<String>();
    ArrayList<String> roomsUsers = new ArrayList<String>();
    ArrayList<String> message = new ArrayList<String>();

    public ArrayList<String> getMessage() {
        return message;
    }
    public ArrayList<String> getRooms() {
        return rooms;
    }
    public ArrayList<String> getRoomsUsers() {
        return roomsUsers;
    }
    public void setRooms(ArrayList<String> rooms) {
        this.rooms = rooms;
    }
    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }
    public void newRoom (String room) {
        this.rooms.add(room);
    }

    public void newRoomUser (String room, String username) {
        String concat = room + ";" + username;
        this.roomsUsers.add(concat);
    }

    public void newRoomMessage (String room, String username, String message){
        Date date = new Date();
        String concat = room + ";" + username + ";" + message + ";" + date.toString();
        this.message.add(concat);
    }

    public void setRoomsUsers(ArrayList<String> roomsUsers) {
        this.roomsUsers = roomsUsers;
    }

    public boolean check_if_exist (String room, String name){
        for (int i = 0; i<this.rooms.size(); i++) {
            if (this.rooms.get(i).equals(room)) {
                return false;
            }
        }
        newRoom(room);
        newRoomUser(room, name);
        return true;
    }
    public boolean add_users_to_room (String room, String name) {
        for (int i = 0; i<this.roomsUsers.size(); i++) {
            if (this.roomsUsers.get(i).equals(room + ";" + name)) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<String> get_room_message (String room) {
        ArrayList<String> answer = new ArrayList<String>();
        for (int i = this.message.size()-1; i > -1; i--) {
            String temp = this.message.get(i);
            List<String> items = Arrays.asList(temp.split(";"));
            if (items.get(0).equals(room)){
                answer.add(this.message.get(i));

            }
        }
        return answer;
    }
}
