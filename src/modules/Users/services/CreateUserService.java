package modules.Users.services;

import modules.Users.entities.User;
import modules.Users.repositories.UserRepository;
import utils.MyScanner;

public class CreateUserService {
	private UserRepository userRepository = new UserRepository();

    public void execute(){
        User user = new User();
        System.out.print("Enter name: ");
        user.name = MyScanner.prompt().nextLine();

        System.out.print("Enter age: ");
        user.age = MyScanner.myNextInt();

        while(user.email == null){
            System.out.print("Enter email: ");
            user.email = MyScanner.prompt().nextLine();

            User userExists = userRepository.getUserByEmail(user.email);
            if(userExists != null) {
                user.email = null;
                System.out.println("Email já está em uso!");
            }
        }

        userRepository.create(user);
    }
}
