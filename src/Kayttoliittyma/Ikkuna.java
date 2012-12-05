/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Data.Tietovarasto;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.GroupLayout.Alignment.*;
import javax.swing.*;
/**
 *
 * @author s1000789
 */
public class Ikkuna extends JFrame{
    private JPanel pohjapaneeli=new JPanel(new BorderLayout());
    private JPanel nappipaneeli=new JPanel(new BorderLayout());
    private JPanel ylapaneeli=new JPanel(new GridLayout());
    private JPanel keskipaneeli=new JPanel(new GridLayout());
    private JPanel alapaneeli=new JPanel(new GridLayout());
    
    private JButton haeNappi=new JButton("Hae");
    private JButton lisaaNappi=new JButton("Lisää");
    private JButton poistaNappi=new JButton("Poista");
    private JButton suljeNappi=new JButton("Sulje");
    
    private JButton nimiNappi=new JButton("Nimi");
    private JButton genreNappi=new JButton("Genre");
    private JButton julkaisijaNappi=new JButton("Julkaisija");
    private JButton alustaNappi=new JButton("Alusta");
    private JButton arvosanaNappi=new JButton("Arvosana");
    
    private JLabel nimiKentta=new JLabel("Nimi", JLabel.CENTER);
    private JLabel genreKentta=new JLabel("Genre", JLabel.CENTER);
    private JLabel julkaisijaKentta=new JLabel("Julkaisija", JLabel.CENTER);
    private JLabel alustaKentta=new JLabel("Alusta", JLabel.CENTER);
    private JLabel arvosanaKentta=new JLabel("Arvosana", JLabel.CENTER);
    
    JCheckBox valinta=new JCheckBox();
   
    private Tietovarasto varasto=new Tietovarasto();
    
    public Ikkuna(){
        
        ylapaneeli.add(nimiNappi);
        ylapaneeli.add(genreNappi);
        ylapaneeli.add(julkaisijaNappi);
        ylapaneeli.add(alustaNappi);
        ylapaneeli.add(arvosanaNappi);
        
        keskipaneeli.add(nimiKentta);
        keskipaneeli.add(genreKentta);
        keskipaneeli.add(julkaisijaKentta);
        keskipaneeli.add(alustaKentta);
        keskipaneeli.add(arvosanaKentta);
        
        alapaneeli.add(haeNappi);
        alapaneeli.add(lisaaNappi);
        alapaneeli.add(poistaNappi);
        alapaneeli.add(suljeNappi);
        
        nappipaneeli.add(ylapaneeli, BorderLayout.PAGE_START);
        nappipaneeli.add(keskipaneeli, BorderLayout.CENTER);
        nappipaneeli.add(alapaneeli, BorderLayout.PAGE_END);
        
        pohjapaneeli.add(valinta, BorderLayout.LINE_START);
        pohjapaneeli.add(nappipaneeli, BorderLayout.CENTER);
        
        
        this.add(pohjapaneeli);
       
        this.setTitle("Pelikokoelma");
        this.setLocation(100,100);
        this.pack();
        //this.setSize(400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        haeNappi.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                Hakuikkuna hakuRuutu = new Hakuikkuna();
            }
        });
        
        lisaaNappi.addActionListener(new ActionListener() {

        @Override
            public void actionPerformed(ActionEvent e) {
                LisaysIkkuna lisaysRuutu=new LisaysIkkuna();
            }
        });
        
      suljeNappi.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         suljeOhjelma();
      }
    });
    }
    private void suljeOhjelma() {
    System.exit(0);
  }
      
    public static void main(String[] args) {
        Ikkuna ikkuna=new Ikkuna();
            SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Ikkuna().setVisible(true); 
      }
    });
  }    
}
    
