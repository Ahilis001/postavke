/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.jf.jfObrazacPostavki;

/**
 *
 * @author ahilis001
 */
public class JpObavijestiIPostavke extends JPanel{
    
    private static JTextField jtaObavijesti = new JTextField();

    public JpObavijestiIPostavke() {
    }
    
    /**
     * generira obrazac s obavijestima i postavkama
     * @return 
     */
    public static JpObavijestiIPostavke generirajObrazac(){
        
        jtaObavijesti.setEditable(false);
        //todo dovrsiti jpanel
        JpObavijestiIPostavke jpObavijestiIPostavke = new JpObavijestiIPostavke();
        
        jpObavijestiIPostavke.setLayout(new GridBagLayout());
        jpObavijestiIPostavke.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Obavijesti i postavke", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        
        //postavljanje poravnanja i layouta jFramea
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        
        c.gridx = 0;
        c.gridy = 0;
        jpObavijestiIPostavke.add(jtaObavijesti, c);
        
        //dodavanje jButtona za otvaranje postavki
        JButton jbOtvoriPostavke = new JButton("Postavke");
        jbOtvoriPostavke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otvoriPostavke();
            }
        });
        
        c.gridx = 1;
        c.gridy = 0;
        jpObavijestiIPostavke.add(jbOtvoriPostavke, c);
        
        return jpObavijestiIPostavke;
    
    }
    
    /**
     * metoda za dodavanje gumba postavki 
     * @return 
     */
    public static JButton jbGumbPostavki() { 
        //dodavanje jButtona za spremanje i zatvaranje
        JButton jbOtvoriPostavke = new JButton("Postavke");
        jbOtvoriPostavke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otvoriPostavke();
            }
        });
        
        return jbOtvoriPostavke;
    } 
    
    private static void otvoriPostavke() { 
        jfObrazacPostavki.generirajObrazac();
    }

    public static JTextField getJtaObavijesti() {
        return jtaObavijesti;
    }

    public static void setJtaObavijesti(JTextField jtaObavijesti) {
        JpObavijestiIPostavke.jtaObavijesti = jtaObavijesti;
    }
}
