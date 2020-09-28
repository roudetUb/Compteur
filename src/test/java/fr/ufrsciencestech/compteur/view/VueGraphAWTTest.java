/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur.view;

import fr.ufrsciencestech.compteur.TestUtils;
import fr.ufrsciencestech.compteur.controler.Controleur;
import fr.ufrsciencestech.compteur.model.Modele;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class VueGraphAWTTest {
    private static VueGraphAWT vueg;
    private Controleur c;
    private Modele m;

    @Before
    public void setUp() {
        vueg = new VueGraphAWT();
        m = new Modele();
        c = new Controleur();
        
        c.setModele(m);
        c.setVue(vueg);
        m.addObserver(vueg);
        vueg.addControleur(c);
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of update method, of class VueGraphique.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        
        //si on oublie d'ajouter la vue comme observateur du modele, elle ne se met pas à jour correctement
        assertEquals(vueg.getAffiche().getText(), "0");
        m.setCompteur(4); 
        assertEquals(vueg.getAffiche().getText(), "4");
        
        vueg.setAffiche(new Label("0", Label.CENTER));
        assertEquals(vueg.getAffiche().getText(), "0");       
    }
    

    @Test
    public void testIncr() {
        System.out.println("incr");
        assertNotNull(vueg);  // Instantiated?
        Label res = (Label)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final Button plus = (Button)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        //tests d'acceptation (de l'interface) : 
        //plus.doClick(); //ne marche pas avec AWT
        ActionEvent ae = new ActionEvent((Object)plus, ActionEvent.ACTION_PERFORMED, "");
        plus.dispatchEvent(ae);  
        
        assertEquals(res.getText(), "1");
        plus.dispatchEvent(ae); 
        assertEquals(res.getText(), "2");
    }
    
    //https://www.javaworld.com/article/2073056/swing-gui-programming/automate-gui-tests-for-swing-applications.html
    @Test
    public void testDecrOk() {
        System.out.println("decr");
        assertNotNull(vueg);  // Instantiated?
        Label res = (Label)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final Button plus = (Button)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final Button minus = (Button)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        //plus.doClick(); //ne marche pas avec AWT
        ActionEvent ae = new ActionEvent((Object)plus, ActionEvent.ACTION_PERFORMED, "");
        plus.dispatchEvent(ae); 
        assertEquals(res.getText(), "1");
        
        ActionEvent ae2 = new ActionEvent((Object)minus, ActionEvent.ACTION_PERFORMED, "");
        minus.dispatchEvent(ae2); 
        assertEquals(res.getText(), "0");
    }
    
    @Test
    public void testDecrZero() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        Label res = (Label)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final Button minus = (Button)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        ActionEvent ae = new ActionEvent((Object)minus, ActionEvent.ACTION_PERFORMED, "");
        minus.dispatchEvent(ae); 
        assertEquals(res.getText(), "0");
    }
}
