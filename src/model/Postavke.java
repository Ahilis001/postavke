/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static controler.MetodePostavki.azurirajPostavke;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 *
 * @author ahilis001
 */
public class Postavke {
    
    static ArrayList<Postavke> alListaPostavki = new ArrayList<>();
    
    JTextField jtbKey = new JTextField();
    JTextField jtbValue  = new JTextField();
    JCheckBox jcbValue = new JCheckBox();

    public Postavke(String strKey, String strValue) {
        this.jtbKey.setText(strKey);
        this.jtbValue.setText(strValue);
        
        if (jtbValue.getText().equals("true") || jtbValue.getText().equals("false")) {
            if (jtbValue.getText().equals("true")) {
                this.jcbValue.setSelected(true);
            }
            
            else{
                this.jcbValue.setSelected(false);
            }
        }
    }

    public JTextField getJtbKey() {
        return jtbKey;
    }

    public void setJtbKey(JTextField jtbKey) {
        this.jtbKey = jtbKey;
    }

    public JTextField getJtbValue() {
        return jtbValue;
    }

    public void setJtbValue(JTextField jtbValue) {
        this.jtbValue = jtbValue;
    }

    public JCheckBox getJcbValue() {
        return jcbValue;
    }

    public void setJcbValue(JCheckBox jcbValue) {
        this.jcbValue = jcbValue;
    }
    
    public static ArrayList<Postavke> getAlListaPostavki() {
        return alListaPostavki;
    }

    public static void setAlListaPostavki(ArrayList<Postavke> alListaPostavki) {
        Postavke.alListaPostavki = alListaPostavki;
    }

    /**
     * vraca vrijednosti za key
     * @param strKey
     * @param jtbKey
     * @return 
     */
    public static String dajPostavku(String strKey){
        
        //ako postoji postavka s tim keyem, vraca se vrijednost
        for (Postavke postavka : alListaPostavki) {
            if (postavka.getJtbKey().getText().equals(strKey)) {
                return postavka.getJtbValue().getText();
            } 

        }
        
        return null;
    }
    
    /**
     * azurira vrijeddnost za key
     * @param strKey
     * @param strValue
     */
    public static void azurirajPostavku(String strKey, String strValue){
        
        //ako postoji postavka s tim keyem, vraca se vrijednost
        for (Postavke postavka : alListaPostavki) {
            if (postavka.getJtbKey().getText().equals(strKey)) {
                
                //ako je bool
                if (postavka.getJtbValue().getText().equals("true") || postavka.getJtbValue().getText().equals("false")) {
                    postavka.getJtbValue().setText(String.valueOf(strValue));
                }
                
                //za drugu vrijednost
                else{
                    postavka.getJtbValue().setText(strValue);
                }
            }
        }
        azurirajPostavke();
    }
}
