
package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    

 class Database {
    private static Database dbInstance;
    private static Connection con;

    public static Database getInstance(){
        if(dbInstance == null){
            dbInstance = new Database();
        }
    return dbInstance;
    }
    public static Connection getConnection(){
        if(con == null){
            try{
                String driver = "com.mysql.jdbc.Driver";
                String host = "jdbc:mysql://localhost:3306/njpo";
                String login = "root";
                String pass = "1234kokos";
                Class.forName(driver);
                con = DriverManager.getConnection(host, login, pass);
            }
            catch (SQLException ex){
                System.out.println("Błąd SQLa "+ ex.getMessage());
            }
            catch (ClassNotFoundException e){
                System.out.println("Bląd sterownika JDBC: " + e.getMessage());
            }
        }
        return con;
    }
    public static ResultSet executeQuery(String query){
        try{
            con = Database.getConnection();
            PreparedStatement p = con.prepareStatement(query);
            return p.executeQuery();
        }
        catch(SQLException e){
            System.out.println("Błąd w składni: " + e.getMessage());
        }
      return null;
    }
    public static int executeUpdate(String update){
       try{
           con = Database.getConnection();
           try(PreparedStatement p = con.prepareStatement(update)){
               return p.executeUpdate();
           }
        }
        catch(SQLException e){
            System.out.println("Błąd w składni: " + e.getMessage());
        }
       return -1;
    }
}
