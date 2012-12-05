/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Date;

public class Peli {
    private int peliID;
    private String peliNimi;
    private int genreID;
    private String genre_nimi;

    public Peli(int peliID, String peliNimi, String genre_nimi, String julkaisija_nimi, String alusta_nimi, int julkaisuvuosi, int arvosana, String kuvaus, Date lisaysaika) {
        this.peliID = peliID;
        this.peliNimi = peliNimi;
        this.genre_nimi = genre_nimi;
        this.julkaisija_nimi = julkaisija_nimi;
        this.alusta_nimi = alusta_nimi;
        this.julkaisuvuosi = julkaisuvuosi;
        this.arvosana = arvosana;
        this.kuvaus = kuvaus;
        this.lisaysaika = lisaysaika;
    }
    private String julkaisija_nimi;
    private String alusta_nimi;
    private int julkaisijaID;
    private int alustaID;
    private int julkaisuvuosi;
    private int arvosana;
    private String kuvaus;
    private Date lisaysaika;

    public Peli(int peliID, String peliNimi, int genreID, int julkaisijaID, int alustaID, int julkaisuvuosi, int arvosana, String kuvaus, Date lisaysaika) {
        this.peliID = peliID;
        this.peliNimi = peliNimi;
        this.genreID = genreID;
        this.julkaisijaID = julkaisijaID;
        this.alustaID = alustaID;
        this.julkaisuvuosi = julkaisuvuosi;
        this.arvosana = arvosana;
        this.kuvaus = kuvaus;
        this.lisaysaika = lisaysaika;
    }

    public int getAlustaID() {
        return alustaID;
    }

    public int getArvosana() {
        return arvosana;
    }

    public int getGenreID() {
        return genreID;
    }

    public int getJulkaisijaID() {
        return julkaisijaID;
    }

    public int getJulkaisuvuosi() {
        return julkaisuvuosi;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public Date getLisaysaika() {
        return lisaysaika;
    }

    public int getPeliID() {
        return peliID;
    }

    public String getPeliNimi() {
        return peliNimi;
    }

    @Override
    public String toString() {
        return "Peli{" + "peliID=" + peliID + ", peliNimi=" + peliNimi + ", genreID=" + genreID + ", julkaisijaID=" + julkaisijaID + ", alustaID=" + alustaID + ", julkaisuvuosi=" + julkaisuvuosi + ", arvosana=" + arvosana + ", kuvaus=" + kuvaus + ", lisaysaika=" + lisaysaika + '}';
    }

    public Peli(String peliNimi, int genreID, int julkaisijaID, int alustaID, int julkaisuvuosi, int arvosana, String kuvaus) {
        this.peliNimi = peliNimi;
        this.genreID = genreID;
        this.julkaisijaID = julkaisijaID;
        this.alustaID = alustaID;
        this.julkaisuvuosi = julkaisuvuosi;
        this.arvosana = arvosana;
        this.kuvaus = kuvaus;
    }


}

