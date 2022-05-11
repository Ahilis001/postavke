/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jf;

import controler.MetodePostavki;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Postavke;

/**
 *
 * @author ahilis001
 */
public class jfObrazacPostavki extends JFrame{
    
    public jfObrazacPostavki() {
    }
    
    /**
     * generira obrazac postavki
     */
    public static void generirajObrazac(){
        
        MetodePostavki.ucitajPostavke(MetodePostavki.getStrPutanjaPostavki());
        //inicijalizacija jFramea postavki
        JFrame jfObrazacPostavki = new jfObrazacPostavki();
        
        //postavljanje poravnanja i layouta jFramea
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;

        //postavljanje layuta
        jfObrazacPostavki.setLayout(new GridBagLayout());
        
        JPanel jpPomocni = new JPanel(new GridBagLayout());
        jpPomocni.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dostupne postavke", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        
        
        //dodavanje jlabela za kljuc i odredivanje 
        //odstojaja izmedu sljedeceg jlabela
        c.ipadx = 10;
        c.gridx = 0;
        c.gridy = 0;
        jpPomocni.add(new JLabel("Ključ"), c);
        
        //dodavanje jlabela za vrijednost i micanje
        //odstojanja od kraja jpanela
        c.ipadx = 0;
        c.gridx = 1;
        c.gridy = 0;
        jpPomocni.add(new JLabel("Vrijednost"), c);
        
        c.gridy++;
        
        //dodavanje jtexffielda na obrazac
        for (Postavke postavke : Postavke.getAlListaPostavki()) {
            c.ipadx = 10;
            c.gridx = 0;
            postavke.getJtbKey().setEnabled(false);
            jpPomocni.add(postavke.getJtbKey(), c);
            
            c.ipadx = 0;
            c.gridx = 1;
            
            if (postavke.getJtbValue().getText().equals("true") || postavke.getJtbValue().getText().equals("false")) {
                jpPomocni.add(postavke.getJcbValue(), c);
            }
            
            else{
                jpPomocni.add(postavke.getJtbValue(), c);
            }
            
            c.gridy++;
        }
        
        //dodavanje jButtona za spremanje i zatvaranje
        JButton jbSpremiSveIZatvori = new JButton("Spremi i zatvori");
        jbSpremiSveIZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSpremiSveIZatvorictionPerformed(jfObrazacPostavki, evt);
            }
        });
        
        //dodavanje jpanela na jframe
        c.gridx = 0;
        c.gridy = 0;
        jfObrazacPostavki.add(jpPomocni, c);
        
        //dodavanje jpanela na jframe
        c.gridx = 0;
        c.gridy = 1;
        jfObrazacPostavki.add(jbSpremiSveIZatvori, c);
        
        jfObrazacPostavki.setUndecorated(true);
        jfObrazacPostavki.revalidate();
        jfObrazacPostavki.pack();
        jfObrazacPostavki.setVisible(true);
    }
    
    /**
     * metoda spremanje postavki i zatvaranje obrasca postavki
     * @param jfObrazac
     * @param evt 
     */
    private static void jbSpremiSveIZatvorictionPerformed(JFrame jfObrazac, java.awt.event.ActionEvent evt) { 
        MetodePostavki.azurirajPostavke();
        jfObrazac.dispose();
    } 
    
}
