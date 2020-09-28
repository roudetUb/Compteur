/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur.model;

import fr.ufrsciencestech.compteur.model.Modele;
import static junit.framework.Assert.*;
import org.junit.*;

/**
 *
 * @author celine
 */
public class ModeleTest {
    Modele m;
    
    public ModeleTest() {
        m = new Modele();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Modele.
     */
     @Test
    public void testGetCompteur() {
        System.out.println("getCompteur");
        int cpt = 0;
        assertTrue(m.getCompteur() == cpt);
    }
    
    @Test
    public void testSetCompteur() {
        System.out.println("setCompteur");
        int cpt = 2;
        m.setCompteur(2);
        assertTrue(m.getCompteur() == cpt);
        
        //test avec des valeurs negatives
        m.setCompteur(-4);
        assertTrue(m.getCompteur() == 0);
    }
    
}
