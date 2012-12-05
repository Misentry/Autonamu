/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Data.Tietovarasto;
import Data.Peli;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 *
 * @author s1000789
 */
public class LisaysIkkuna extends JFrame{
    
    private JPanel pohjapaneeli=new JPanel(new BorderLayout());
    private JPanel ylapaneeli=new JPanel(new GridLayout());
    private JPanel keskipaneeli=new JPanel(new GridLayout());
    private JPanel alapaneeli=new JPanel(new GridLayout());
    
    private JLabel nimiKentta=new JLabel("Nimi", JLabel.CENTER);
    private JLabel genreKentta=new JLabel("Genre", JLabel.CENTER);
    private JLabel julkaisijaKentta=new JLabel("Julkaisija", JLabel.CENTER);
    private JLabel alustaKentta=new JLabel("Alusta", JLabel.CENTER);
    private JLabel arvosanaKentta=new JLabel("Arvosana", JLabel.CENTER);
    private JLabel vuosiKentta=new JLabel("Julkaisuvuosi", JLabel.CENTER);
    private JLabel kuvausKentta=new JLabel("Kuvaus", JLabel.CENTER);
        
    private JComboBox genreLista=new JComboBox(new String[]{" ","eka valinta","tokavalinta"});    
    private JComboBox julkaisijaLista=new JComboBox(new String[]{" ","eka valinta","tokavalinta"});
    private JComboBox alustaLista=new JComboBox(new String[]{" ","eka valinta","tokavalinta"});
    private JComboBox arvosanaLista=new JComboBox(new String[]{" ","1","2","3","4","5"});
    
    private JTextArea nimiSyote=new JTextArea("");
    private JTextArea vuosiSyote=new JTextArea("");
    private JTextArea kuvausSyote=new JTextArea("");

    private JTextArea testi = new JTextArea("");
    
    private JButton tallennaNappi=new JButton("Tallenna");
    private JButton peruutaNappi=new JButton("Peruuta");
    
    private String kelloNyt;
    
    private Tietovarasto varasto=new Tietovarasto();
    
    public LisaysIkkuna(){
        ylapaneeli.add(nimiKentta);
        ylapaneeli.add(genreKentta);
        ylapaneeli.add(julkaisijaKentta);
        ylapaneeli.add(alustaKentta);
        ylapaneeli.add(vuosiKentta);
        ylapaneeli.add(arvosanaKentta);
        ylapaneeli.add(kuvausKentta);
        
        keskipaneeli.add(nimiSyote);
        keskipaneeli.add(genreLista);
        keskipaneeli.add(julkaisijaLista);
        keskipaneeli.add(alustaLista);
        keskipaneeli.add(vuosiSyote);
        keskipaneeli.add(arvosanaLista);
        keskipaneeli.add(kuvausSyote);
  
        
        alapaneeli.add(tallennaNappi);
        alapaneeli.add(peruutaNappi);
        
        pohjapaneeli.add(ylapaneeli, BorderLayout.PAGE_START);
        pohjapaneeli.add(keskipaneeli, BorderLayout.CENTER);
        pohjapaneeli.add(alapaneeli, BorderLayout.PAGE_END);
        
        this.add(pohjapaneeli);
       
        this.setTitle("Pelikokoelma");
        this.setLocation(100,100);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
              
      peruutaNappi.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         palaaValikkoon();
      }
    });
    }
    private void palaaValikkoon() {
    this.dispose();
  }
    
    private void kelloNyt() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
    
    private void Talleta() {
        genreLista.setSelectedItem(null);
   
        try {
            String nimi= nimiSyote.getText();
            int genre = genreLista.getSelectedIndex();
            int julkaisija = genreLista.getSelectedIndex();
            int alusta = alustaLista.getSelectedIndex();
            int julkaisuvuosi = Integer.parseInt(vuosiSyote.getText());
            int arvio = arvosanaLista.getSelectedIndex();
            String kuvaus = kuvausSyote.getText();
           
            varasto.lisaaPeli(new Peli(nimi, genre, julkaisija, alusta, julkaisuvuosi, arvio, kuvaus));
        }
         catch(Exception e){   
//             JOptionPane.showMessageDialog(rootPane, date);
        }
        
    }
    
    }
    

