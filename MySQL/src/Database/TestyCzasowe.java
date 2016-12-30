package Database;

import java.util.Arrays;
import java.util.Random;

public class TestyCzasowe {
    public static void main (String[] args){
    long[] test = new long[10000];
        Random rand = new Random();
        String query = "Insert into testy (DATA) values ";
        for(int i = 0; i < test.length; i++){
            if (i != 0)
                query = query +", ";
            test[i]= rand.nextLong();
            query = query+ "("+ test[i]+ ")";
        }
        Database.executeUpdate(query);
        
        long czasPrzed = System.currentTimeMillis();
        Arrays.sort(test);
        long czasPo = System.currentTimeMillis();
        System.out.println("Czas sortowania przez Javę: "+ (czasPo-czasPrzed)+ " ms");
        
        czasPrzed = System.currentTimeMillis();
        Database.executeQuery("Select * from testy order by data asc");
        czasPo = System.currentTimeMillis();
        System.out.println("Czas sortowania przez SQL: "+ (czasPo-czasPrzed)+ " ms");
    }
}
