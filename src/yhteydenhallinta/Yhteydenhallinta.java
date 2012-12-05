/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yhteydenhallinta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author s1000789
 */
public class Yhteydenhallinta {

    private static Connection yhteys=null;
    
    public static Connection avaaYhteys(String ajuri, String url, String kayttaja, String salasana){
        try{
            Class.forName(ajuri).newInstance();
            yhteys=DriverManager.getConnection(url, kayttaja, salasana);
        }
        catch(SQLException sqle){
            System.out.println("sql virhe");
            sqle.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Yhteys ei auennut");
        }
        return yhteys;
    }
    
    public static void suljeYhteys(){
        try{
            if(yhteys!=null){
                yhteys.close();
            }
        }
        catch(Exception e){
            
        }
    }
}

