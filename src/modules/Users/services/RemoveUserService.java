package modules.Users.services;


import exceptions.ErrorMessage;
import modules.Users.entities.User;
import modules.Users.repositories.UserRepository;

public class RemoveUserService {
	private UserRepository userRepository = new UserRepository();
	
    public void execute(Integer user_id){
        User user = userRepository.getUserById(user_id);
        
        if(user == null) throw new ErrorMessage("Usuário não encontrado!");
        	
        userRepository.removeUser(user.id);
    }
}
