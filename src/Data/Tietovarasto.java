/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import yhteydenhallinta.Yhteydenhallinta;

/**
 *
 * @author s1000789
 */
public class Tietovarasto {

    private String lisaaPeliSQL="insert into app.pelitaulu(pelin_nimi, genre_id, julkaisija_id, alusta_id, julkaisuvuosi, arvosana, kuvaus)"
                                + " values(?,?,?,?,?,?,?)";
    private String haeNimenMukaanSQL="select * from pelitaulu where pelin_nimi=?";
    private String haeGenrenMukaanSQL="select * from pelitaulu where genre_id=?";
    private String haeJulkaisijanMukaanSQL="select * from pelitaulu where julkaisija_id=?";
    private String haeAlustanMukaanSQL="select * from pelitaulu where alusta_id=?";
    private String haeArvosananMukaanSQL="select * from pelitaulu where arvosana=?";
    private String pelinPoistoSQL="delete from app.pelitaulu where peli_id=?";
    private String haeKaikkiSQL="select peli_id, pelin_nimi, genre_nimi, julkaisija_nimi, alusta_nimi, julkaisuvuosi, arvosana, kuvaus, lisaysaika from app.pelitaulu, app.genretaulu, app.julkaisijataulu, app.alustataulu where app.genretaulu.GENRETAULUID=app.pelitaulu.GENRE_ID and app.julkaisijataulu.JULKAISIJATAULUID=app.pelitaulu.JULKAISIJA_ID and app.alustataulu.ALUSTATAULUID=app.pelitaulu.ALUSTA_ID";
            
            
    private String ajuri="org.apache.derby.jdbc.EmbeddedDriver";
    private String url="jdbc:derby:pelikanta";
    private String kayttaja="Saku";
    private String salasana="salainen";
    private Connection yhteys=null;

    public void poistaPeli (int peli_id){
        try{            
            yhteys=Yhteydenhallinta.avaaYhteys(ajuri, url, kayttaja, salasana);    
            if(yhteys!=null){
            PreparedStatement poistaPeli=yhteys.prepareStatement(pelinPoistoSQL);
            poistaPeli.setInt(1, peli_id);
            poistaPeli.executeUpdate();
      
              }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            Yhteydenhallinta.suljeYhteys();
        }
    } 
    
     public List<Peli> haeKaikkiPelit() {
    List<Peli> apuLista=new ArrayList<Peli>();
        try{
            yhteys=Yhteydenhallinta.avaaYhteys(ajuri, url, kayttaja, salasana);
            if(yhteys!=null){
                PreparedStatement haeKaikkiLause=yhteys.prepareStatement(haeKaikkiSQL);
                ResultSet tulosjoukko=haeKaikkiLause.executeQuery();
                while(tulosjoukko.next()){
                    apuLista.add(new Peli(tulosjoukko.getInt(1), tulosjoukko.getString(2), tulosjoukko.getString(3), tulosjoukko.getString(4), tulosjoukko.getString(5), tulosjoukko.getInt(6), tulosjoukko.getInt(7), tulosjoukko.getString(8), tulosjoukko.getDate(9)));
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            Yhteydenhallinta.suljeYhteys();
        }
        return apuLista;
    }
     
      public void lisaaPeli(Peli uusiPeli) {
          try {
                yhteys=Yhteydenhallinta.avaaYhteys(ajuri, url, kayttaja, salasana);  
                if(yhteys!=null) {
                    PreparedStatement lissaaPeli = yhteys.prepareStatement(lisaaPeliSQL);
                    lissaaPeli.setString(1, uusiPeli.getPeliNimi());
                    lissaaPeli.setInt(2, uusiPeli.getGenreID());
                    lissaaPeli.setInt(3, uusiPeli.getJulkaisijaID());
                    lissaaPeli.setInt(4, uusiPeli.getAlustaID());
                    lissaaPeli.setInt(5, uusiPeli.getJulkaisuvuosi());
                    lissaaPeli.setInt(6, uusiPeli.getArvosana());
                    lissaaPeli.setString(7, uusiPeli.getKuvaus());
                    lissaaPeli.executeUpdate();
          }                
      }
      catch(Exception e){
            e.printStackTrace();
      }
        finally{
            Yhteydenhallinta.suljeYhteys();
        }  
    }
}
