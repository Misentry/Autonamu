/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.Component; 
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;

/**
 *
 * @author s1000779
 */
      
public class Hakuikkuna extends JFrame{

    public Hakuikkuna() {
        JLabel label = new JLabel("Hakutermi");;
        JTextField hakuKentta = new JTextField();
        JCheckBox julkaisijaCheckBox = new JCheckBox("Julkaisija");
        JCheckBox genreCheckBox = new JCheckBox("Genre");
        JCheckBox alustaCheckBox = new JCheckBox("Alusta");
        JCheckBox arvosanaCheckBox = new JCheckBox("Arvosana");
        JButton hakuNappi = new JButton("Haku");
        JButton peruutaNappi = new JButton("Peruuta");
 
        ButtonGroup hakuTermit = new ButtonGroup();
        hakuTermit.add(julkaisijaCheckBox);
        hakuTermit.add(genreCheckBox);
        hakuTermit.add(alustaCheckBox);
        hakuTermit.add(arvosanaCheckBox);
        // remove redundant default border of check boxes - they would hinder
        // correct spacing and aligning (maybe not needed on some look and feels)
        julkaisijaCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        genreCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        alustaCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        arvosanaCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
 
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
 
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addComponent(label)
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(hakuKentta)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(julkaisijaCheckBox)
                        .addComponent(alustaCheckBox))
                    .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(genreCheckBox)
                        .addComponent(arvosanaCheckBox))))
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(hakuNappi)
                .addComponent(peruutaNappi))
        );
        
        layout.linkSize(SwingConstants.HORIZONTAL, hakuNappi, peruutaNappi);
 
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(label)
                .addComponent(hakuKentta)
                .addComponent(hakuNappi))
            .addGroup(layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(julkaisijaCheckBox)
                        .addComponent(genreCheckBox))
                    .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(alustaCheckBox)
                        .addComponent(arvosanaCheckBox)))
                .addComponent(peruutaNappi)) 
        );
        
        setTitle("Haku");
        pack();
        this.setLocation(100,100);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       }
     
 
}