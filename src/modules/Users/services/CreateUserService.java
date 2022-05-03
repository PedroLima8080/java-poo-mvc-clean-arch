package modules.Users.services;

import modules.Users.entities.User;
import modules.Users.repositories.UserRepository;
import utils.MyScanner;

public final class CreateUserService {
	private UserRepository userRepository = new UserRepository();

    public void execute(){
        System.out.print("Enter name: ");
        String name = MyScanner.prompt().nextLine();

        System.out.print("Enter age: ");
        Integer age = MyScanner.myNextInt();
        
        String email = null;

        while(email == null){
            System.out.print("Enter email: ");
            email = MyScanner.prompt().nextLine();

            User userExists = userRepository.getUserByEmail(email);
            if(userExists != null) {
                email = null;
                System.out.println("Email já está em uso!");
            }
        }

        User user = new User(name, age, email);
        userRepository.create(user);
    }
}
