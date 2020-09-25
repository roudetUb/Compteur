/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur;

import javax.swing.*;

//pour springIoC :
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author celine
 */
public class TestMVC {
    private VueGraphique vueg;      //pour pouvoir changer de vue si on le souhaite
    private Controleur controleur;  //pour pouvoir changer de controleur si on le souhaite
    
    /**
     * @return the vueg
     */
    public VueGraphique getVueg() {
        return vueg;
    }

    /**
     * @param vueg the vueg to set
     */
    public void setVueg(VueGraphique vueg) {
        this.vueg = vueg;
    }

    /**
     * @return the controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * @param controleur the controleur to set
     */
    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }
    
    
    public TestMVC(){
        //sans utiliser SpringIoC :
        vueg = new VueGraphique();
        controleur = new Controleur();
        Modele modele = new Modele();
        VueConsole vuec = new VueConsole();

        controleur.setModele(modele);                 
        modele.addObserver(vueg);        
        modele.addObserver(vuec);         
        vueg.addControleur(controleur);
        
        vueg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vueg.pack();
        vueg.setVisible(true);
    }
    
    public static void main(String[] args){
        TestMVC test = new TestMVC();    //sans utiliser SpringIoC
        
        //La meme chose mais avec SpringIoC :
        /*ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TestMVC test = (TestMVC)context.getBean("MVC");  //SpringIoC
        //test.controleur = (Controleur)context.getBean("Controleur");  //SpringIoC

        test.setControleur(new Controleur());
        test.setVueg(new VueGraphique());
        Modele m = new Modele(); 
        test.getControleur().setModele(m);  
        
        m.addObserver(test.getVueg());
        test.getVueg().addControleur(test.getControleur());
        
        VueConsole vuec = new VueConsole();
        m.addObserver(vuec);  
        test.getVueg().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.getVueg().pack();
        test.getVueg().setVisible(true);*/
    }
}
