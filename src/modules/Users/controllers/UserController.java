package modules.Users.controllers;

import java.util.ArrayList;

import modules.Users.entities.User;
import modules.Users.services.CreateUserService;
import modules.Users.services.GetUsersService;
import modules.Users.services.RemoveUserService;
import utils.MyScanner;

public class UserController {
	private CreateUserService createUserService = new CreateUserService();
	private GetUsersService getUsersService = new GetUsersService();
	private RemoveUserService removeUserService = new RemoveUserService();
	
    public void createMany(){
        System.out.println("\n---CADASTRO DE USUÁRIO---");
        String continueRegistration = "sim";

        while(continueRegistration.equals("sim")){
            this.createUserService.execute();

            System.out.print("Deseja cadastrar mais um? (sim/nao): ");
            continueRegistration = MyScanner.prompt().nextLine();
        }
    }

    public void listAll(){
        System.out.println("\n---USUARIOS---");

        ArrayList<User> users = this.getUsersService.execute();

        if(users.size() == 0) System.out.println("sem registros");

        for(User user : users){
            System.out.println(String.format("ID: %s, Nome: %s, Age: %s, Email: %s", user.getId(), user.getName(), user.getAge(), user.getEmail()));
        }
    }

    public void removeUser(){
        System.out.println("\n---REMOVER USUARIO---");
        System.out.print("Digite o ID do usuário que deseja remover: ");
        Integer userId = MyScanner.myNextInt();

        this.removeUserService.execute(userId);
        System.out.println("Usuário removido com sucesso!");
    }
}
