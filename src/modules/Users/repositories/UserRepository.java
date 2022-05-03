package modules.Users.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modules.Users.entities.User;
import database.Database;
import exceptions.ErrorMessage;

public final class UserRepository extends User {
    public void create(User user){
        Database database = new Database();
        database.openConnection();
        
        try {
            Statement stmt = database.getConnection().createStatement();
            stmt.executeUpdate("INSERT INTO "+ this.table +" (name, age, email) VALUES ('"+user.getName()+"', "+user.getAge()+", '"+user.getEmail()+"')");
            database.closeConnection(); 
        } catch (SQLException e) {
            database.closeConnection();  
            throw new ErrorMessage("Ocorreu um erro ao realizar query.\n"+e.getMessage());
        }

    }

    public ArrayList<User> getAll() {
        Database database = new Database();
        database.openConnection();
        
        try {
            Statement stmt = database.getConnection().createStatement();
            ResultSet resultQueryUsers = stmt.executeQuery("select * from " + this.table);
            
            ArrayList<User> users = new ArrayList<User>();
            
            while(resultQueryUsers.next()){
                User userObject = new User(
                	resultQueryUsers.getInt("id"),
                	resultQueryUsers.getString("name"),
                	resultQueryUsers.getInt("age"),
                	resultQueryUsers.getString("email")
                );
                
                users.add(userObject);
            }
            
            database.closeConnection(); 
            return users;
            
        } catch (SQLException e) {
            database.closeConnection();
            throw new ErrorMessage("Ocorreu um erro ao realizar query.\n"+e.getMessage());
        }
    }

    public User getUserById(Integer user_id){
        Database database = new Database();
        database.openConnection();

        try {
            Statement stmt = database.getConnection().createStatement();
            ResultSet resultQueryUser = stmt.executeQuery("SELECT * FROM "+ this.table +" WHERE id = '"+user_id+"'");

            if(!resultQueryUser.next()) 
            	return null;
            
            User user = new User(
        		resultQueryUser.getInt("id"),
        		resultQueryUser.getString("name"),
        		resultQueryUser.getInt("age"),
        		resultQueryUser.getString("email")
            );           

            database.closeConnection(); 
            return user;

        } catch (SQLException e) {
            database.closeConnection();
            throw new ErrorMessage("Ocorreu um erro ao realizar query.\n"+e.getMessage());
        }
    }

    public User getUserByEmail(String email){
        Database database = new Database();
        database.openConnection();

        try {
            Statement stmt = database.getConnection().createStatement();
            ResultSet resultQueryUser = stmt.executeQuery("SELECT * FROM "+ this.table +" WHERE email = '"+email+"'");

            if(!resultQueryUser.next()) return null;
            
            User user = new User(
        		resultQueryUser.getInt("id"),
        		resultQueryUser.getString("name"),
        		resultQueryUser.getInt("age"),
        		resultQueryUser.getString("email")
            );   

            database.closeConnection(); 
            return user;

        } catch (SQLException e) {
        	database.closeConnection();  
            throw new ErrorMessage("Ocorreu um erro ao realizar query.\n"+e.getMessage());
        }
    }

    public void removeUser(Integer user_id){
        Database database = new Database();
        database.openConnection();

        try {
            Statement stmt = database.getConnection().createStatement();
            stmt.executeUpdate("DELETE FROM "+ this.table +" WHERE id = '"+user_id+"'");
            database.closeConnection(); 
        } catch (SQLException e) {
        	database.closeConnection();  
            throw new ErrorMessage("Ocorreu um erro ao realizar query.\n"+e.getMessage());
        }
    }
}
