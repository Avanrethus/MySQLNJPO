package Database;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class KsiazkaAdresowa {

    public static void main(String[] args){
        List<Osoba> osoby = new ArrayList<Osoba>();
        osoby.add(new Osoba("Przemek","Jarosz","Lwowska","Olkusz",505678908,"34-678"));
        osoby.add(new Osoba("Justyna","Czekan","Al.Jerozolimskie","Warszawa",785632778,"32-305"));
        osoby.add(new Osoba("Darek","Izuma","Karpacka","Zakopane",305554302,"65-862"));
        osoby.add(new Osoba("Anna","Kubaz","Kocia","Jaworzno",532678332,"99-998"));
        osoby.add(new Osoba("Demira","Wazer","Leśna","Białystok",791305643,"12-780"));
        
        for(Osoba o : osoby){
            System.out.println(o);
        }
        Connection con = Database.getInstance().getConnection();
    }
}

