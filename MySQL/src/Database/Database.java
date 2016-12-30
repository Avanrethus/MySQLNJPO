
package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


 class Database {
    private static Database dbInstance;
    private static Connection con;
    private static Statement st;
    
    private Database(){
        
    }
    
    public static Database getInstance(){
        if(dbInstance == null){
            dbInstance = new Database();
        }
    return dbInstance;
    }
    public Connection getConnection(){
        if(con == null){
            try{
                String host = " ";
                String login = " ";
                String pass = " ";
                con = DriverManager.getConnection(host, login, pass);
            }
            catch (SQLException ex){
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
}
