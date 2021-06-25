package main.control;
import main.control.classes.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/")
public class MainController {
        public MainController() {
        }
        rooms rooms = new rooms();

        @RequestMapping(value = "/join-room", method = RequestMethod.POST)
        public users joinRoom(@RequestBody users userData){
                users user = new users();
                boolean check = rooms.check_if_exist(userData.getRoom(),userData.getName());
                if (check) {
                        return userData;
                }
                boolean check2 = rooms.add_users_to_room(userData.getRoom(), userData.getName());
                if (check2) {
                        return userData;
                }
                return user;
        }
        @RequestMapping(value = "/sent-message", method = RequestMethod.POST)
        public boolean messageSent (@RequestBody message ms){
                if (ms.getMessage().equals("") || ms.getUsername().equals(null) || ms.getRoom().equals(null)) {
                        return false;
                }
                rooms.newRoomMessage(ms.getRoom(), ms.getUsername(), ms.getMessage());
                return true;
        }
        @RequestMapping(value = "/get-room-data", method = RequestMethod.POST)
        public ArrayList<String> messageGet (@RequestBody message ms){
                ArrayList<String> answers = new ArrayList<String>();
                answers = rooms.get_room_message(ms.getRoom());
                return answers;
        }
}
