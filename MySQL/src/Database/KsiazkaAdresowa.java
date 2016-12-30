package Database;


import java.sql.ResultSet;
import java.sql.SQLException;

public class KsiazkaAdresowa {

    public static void main(String[] args) throws SQLException{
        Database.executeUpdate("Insert into ksiazkaadresowa (imie,nazwisko,miasto,ulica,numer,kodpocztowy) values ('Janusz','Dworak','Grunwald','17-stycznia',505432223,'43-321')");
         try(ResultSet r = Database.executeQuery("Select * from ksiazkaadresowa")){
             while(r.next()){
                 System.out.println(r.getString(2));
             }
         }
         catch(SQLException e){
             System.out.println("Błąd SQL: " + e.getMessage());
         }
        
        
    }
}

