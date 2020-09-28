/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur.view;

import fr.ufrsciencestech.compteur.view.VueConsole;
import fr.ufrsciencestech.compteur.model.Modele;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class VueConsoleTest {
    VueConsole vuec;
    Modele m;
    
    public VueConsoleTest() {
    }
    
    @Before
    public void setUp() {
        vuec = new VueConsole();
        m = new Modele();
    }
        
    @Test
    public void testUpdate() {
        System.out.println("update");    
       
        //si on oublie d'ajouter la vue comme observateur du modele, elle ne se met pas à jour correctement
        assertEquals(vuec.getTrace(), "Valeur initiale : " + 0);
        m.setCompteur(4);                 
        assertTrue(m.getCompteur() == 4);
        assertEquals(vuec.getTrace(), "Valeur initiale : " + 0);   //aucune influence sur la vue
        
        //si on ajoute la vue comme observateur du modele, elle se met à jour correctement
        assertEquals(vuec.getTrace(), "Valeur initiale : " + 0);
        m.addObserver(vuec);    //on ajoute la vue comme observateur du modele
        //on passe par la methode setCompteur de la classe Modele :
        m.setCompteur(2);
        assertTrue(m.getCompteur() == 2);
        assertEquals(vuec.getTrace(), "Nouvelle valeur : " + 2);  //mise à jour correcte
        
        //on passe par la methode update de la classe Modele :
        m.update(2);
        assertTrue(m.getCompteur() == 4);
        assertEquals(vuec.getTrace(), "Nouvelle valeur : " + 4);  //mise à jour correcte
        
        //on passe par la methode update de la classe Modele (en decrementant trop) :
        m.update(-6);
        assertTrue(m.getCompteur() == 0);
        assertEquals(vuec.getTrace(), "Nouvelle valeur : " + 0);  //mise à jour correcte
    }
}
