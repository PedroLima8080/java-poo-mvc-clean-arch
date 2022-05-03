package modules.Users.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modules.Users.entities.User;
import database.Database;

public class UserRepository extends User {
    public void create(User user){
        Database database = new Database();
        database.openConnection();
        
        try {
            Statement stmt = database.getConnection().createStatement();
            stmt.executeUpdate("INSERT INTO "+ this.table +" (name, age, email) VALUES ('"+user.name+"', "+user.age+", '"+user.email+"')");

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao realizar query.\n"+e.getMessage());
            System.exit(0);
        }

        database.closeConnection();  
    }

    public ArrayList<User> getAll() {
        Database database = new Database();
        database.openConnection();
        
        try {
            Statement stmt = database.getConnection().createStatement();
            ResultSet resultQueryUsers = stmt.executeQuery("select * from " + this.table);
            
            ArrayList<User> users = new ArrayList<User>();
            
            while(resultQueryUsers.next()){
                User userObject = new User();
                userObject.id = resultQueryUsers.getInt("id");
                userObject.name = resultQueryUsers.getString("name");
                userObject.age = resultQueryUsers.getInt("age");
                userObject.email = resultQueryUsers.getString("email");
                users.add(userObject);
            }
            
            database.closeConnection(); 

            return users;
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao realizar query.\n"+e.getMessage());
            database.closeConnection();

            return new ArrayList<User>();
        }
    }

    public User getUserById(Integer user_id){
        Database database = new Database();
        User user = new User();
        database.openConnection();

        try {
            Statement stmt = database.getConnection().createStatement();
            ResultSet resultQueryUser = stmt.executeQuery("SELECT * FROM "+ this.table +" WHERE id = '"+user_id+"'");

            if(!resultQueryUser.next()) 
            	return null;
            
            user.id = resultQueryUser.getInt("id");
            user.name = resultQueryUser.getString("name");
            user.age = resultQueryUser.getInt("age");
            user.email = resultQueryUser.getString("email");            

            return user;

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao realizar query.\n"+e.getMessage());
            database.closeConnection();
            return user;
        }
    }

    public User getUserByEmail(String email){
        Database database = new Database();
        User user = new User();
        database.openConnection();

        try {
            Statement stmt = database.getConnection().createStatement();
            ResultSet resultQueryUser = stmt.executeQuery("SELECT * FROM "+ this.table +" WHERE email = '"+email+"'");

            if(!resultQueryUser.next()) return null;
            
            user.id = resultQueryUser.getInt("id");
            user.name = resultQueryUser.getString("name");
            user.age = resultQueryUser.getInt("age");
            user.email = resultQueryUser.getString("email");

            return user;

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao realizar query.\n"+e.getMessage());
            database.closeConnection();
            return user;
        }
    }

    public void removeUser(Integer user_id){
        Database database = new Database();
        database.openConnection();

        try {
            Statement stmt = database.getConnection().createStatement();
            stmt.executeUpdate("DELETE FROM "+ this.table +" WHERE id = '"+user_id+"'");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao realizar query.\n"+e.getMessage());
            database.closeConnection();
        }
    }
}
