package modules.Users.services;

import java.util.ArrayList;

import modules.Users.entities.User;
import modules.Users.repositories.UserRepository;


public class GetUsersService {
    public ArrayList<User> execute(){
        ArrayList<User> users = (new UserRepository()).getAll();

        return users;
    }
}
