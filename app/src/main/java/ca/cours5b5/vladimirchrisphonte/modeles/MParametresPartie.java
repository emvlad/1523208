package ca.cours5b5.vladimirchrisphonte.modeles;


import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurSerialisation;
import ca.cours5b5.vladimirchrisphonte.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele {


    @AttributSerialisable
    public Integer hauteur;
    protected final String __hauteur = "hauteur";


    @AttributSerialisable
    public Integer largeur;
    protected final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    protected final String __pourGagner = "pourGagner";

    //constructeur
    public MParametresPartie() {

    }


    public static MParametresPartie aPartirMParametres(MParametres mParametres) {

/*  Retourne une instance de MParametresPartie aec
    exactement les mêmes hauteur/largeur/pourGagner
 */
        return null;
    }
    public MParametresPartie cloner(){
        /*
        * Retournne une instance de MParametresPartie avec exactement les mêmes
        * hauteur/largeur/pourGagner
        * que l'objet courant
         */

        return null;

    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {
        return null;
    }

    public Integer getHauteur() {
        return hauteur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public Integer getPourGagner() {
        return pourGagner;
    }


    public void setPourGagner(int pourGagner) {
        this.pourGagner = pourGagner;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;

    }



}

