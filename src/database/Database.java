package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    protected Connection conn;

    public Connection getConnection(){
        return this.conn;
    }
    
    public Database openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); /* here registry */
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo","root","root"); 
        }catch(SQLException e){ 
            System.out.println("Ocorreu um erro ao realizar a conexão.\n"+e.getMessage());
            System.exit(0);
        }catch(ClassNotFoundException a){
            System.out.println("Driver não encontrado.\n"+a.getMessage());
            System.exit(0);
        }

        return this;
    }

    public void closeConnection(){
        try{
            this.conn.close();
        }catch(SQLException e){ 
            System.out.println("Ocorreu um erro ao fechar a conexão.\n"+e.getMessage());
            System.exit(0);
        }
    }
}
