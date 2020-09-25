/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author celine
 */
public class Controleur implements ActionListener {
    private Modele m;
    private VueGraphique vg;
    
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        if(((Component)e.getSource()).getName().equals("Plus")) 
            m.update(1);
        else
            m.update(-1); 
    }
    public void setModele(Modele m){
        this.m = m;
    }
    public void setVue(VueGraphique vg){
        this.vg = vg;
    }
}
