/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;
import model.Postavke;
import view.jp.JpObavijestiIPostavke;

/**
 *
 * @author ahilis001
 */
public class MetodePostavki {
    
    static String strPutanjaPostavki;
    /**
     * Metoda za otvaranje datoteke konfiguracije
     * i ucitanjanje u konfiguracije listu.
     * @param strPutanja
     */
    public static void ucitajPostavke(String strPutanja){
        strPutanjaPostavki = strPutanja;
        
        //inicijalizacija postavki
        Properties postavkeIzDatoteke = new Properties();
        
        try (InputStream inputStream = new FileInputStream(new File(strPutanja))) {
            
            //za datoteku .properties
//            postavke.load(inputStream);
            
            //za datoteku .xml
            postavkeIzDatoteke.loadFromXML(inputStream);

            Postavke.getAlListaPostavki().clear();
            for (String key : postavkeIzDatoteke.stringPropertyNames()) {
                Postavke.getAlListaPostavki().add(new Postavke(key, postavkeIzDatoteke.getProperty(key)));
            }
            
            //sortiranje postavki po kljucu
            Collections.sort(Postavke.getAlListaPostavki(), new Comparator<Postavke>() {
                @Override
                public int compare(Postavke o1, Postavke o2) {
                    return o1.getJtbKey().getText().compareTo(o2.getJtbKey().getText());
                }
            });
            JpObavijestiIPostavke.getJtaObavijesti().setText("Postavke učitane");
        } catch (IOException ex) {
            JpObavijestiIPostavke.getJtaObavijesti().setText("Greška kod otvaranja datoteke konfiguracija.xml.");
        } 
    }
    
    public static void azurirajPostavke(){
        
        try {
            
            //otvaranje streama za upis u .xml datoteku
            try (FileOutputStream fos = new FileOutputStream(strPutanjaPostavki)) {
                Properties postavkePomocne = new Properties();
                
                for (Postavke postavke : Postavke.getAlListaPostavki()) {
                    //ako je bool
                    if (postavke.getJtbValue().getText().equals("true") || postavke.getJtbValue().getText().equals("false")) {
                        postavke.getJtbValue().setText(String.valueOf(postavke.getJcbValue().isSelected()));
                    }
                    postavkePomocne.setProperty(postavke.getJtbKey().getText(), postavke.getJtbValue().getText());
                }
                
                //spremanje u .xml datoteku s komentarom
//                properties.storeToXML(fos, "ključne riječi se razdvajaju zarezom - ','");
                //spremanje u .xml datoteku bez komentara
                postavkePomocne.storeToXML(fos, "");
                
                ucitajPostavke(strPutanjaPostavki);
            }
        } catch (Exception ex) {
            JpObavijestiIPostavke.getJtaObavijesti().setText("Greška kod ažuriranja postavki");
        }
    }
    
    public static void postaviOdredenuPostavku(String strKey, String strNewValue){
    
        for (Postavke postavka : Postavke.getAlListaPostavki()) {
            if (postavka.getJtbKey().getText().equals(strKey)) {
                postavka.getJtbValue().setText(strNewValue);
            }
        }
        
        azurirajPostavke();
    }

    public static String getStrPutanjaPostavki() {
        return strPutanjaPostavki;
    }

    public static void setStrPutanjaPostavki(String strPutanjaPostavki) {
        MetodePostavki.strPutanjaPostavki = strPutanjaPostavki;
    }
    
}
