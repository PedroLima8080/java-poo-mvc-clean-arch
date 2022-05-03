import exceptions.ErrorMessage;
import modules.Users.controllers.UserController;
import utils.MyScanner;

class Main{
	
    public static void main(String[] args){
    	UserController userController = new UserController();

        while(true){
        	try {
	            System.out.println("\n-----MENU-----");
	            System.out.println("1-) Cadastrar Usuário");
	            System.out.println("2-) Listar Usuários");
	            System.out.println("3-) Remover Usuários");
	            System.out.print("Resposta (digite '0' para encerrar): ");
	            Integer choosedAlternative = MyScanner.myNextInt();

                switch (choosedAlternative) {
                    case 0:
                        System.exit(1);
                    case 1:
                    	userController.createMany();
                        break;
                    case 2:
                    	userController.listAll();
                        break;
                    case 3:
                    	userController.removeUser();
                        break;
                    default:
                        System.out.println("Opção invalida!");
                        break;
                }
            } catch (ErrorMessage e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
            	MyScanner.prompt().next();
            	System.out.println("Ocorreu um erro inesperado.");
            }

        }
    }
}