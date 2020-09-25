/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur;

import fr.ufrsciencestech.compteur.Modele;
import fr.ufrsciencestech.compteur.Controleur;
import fr.ufrsciencestech.compteur.Controleur;
import fr.ufrsciencestech.compteur.Modele;
import javax.swing.*;

/**
 *
 * @author celine
 */
public class TestMVC {
    
    public TestMVC(){
        Modele modele = new Modele();
        VueGraphique vueg = new VueGraphique();
        VueConsole vuec = new VueConsole();
        Controleur controleur = new Controleur();
        controleur.setModele(modele);                 //
        modele.addObserver(vueg);         //
        modele.addObserver(vuec);         //
        vueg.addControleur(controleur);
        vueg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vueg.pack();
        vueg.setVisible(true);
    }
    
     public static void main (String[] args){
        new TestMVC();
    }
}
