package ca.cours5b5.vladimirchrisphonte.modeles;

import java.util.List;
import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurSerialisation;
import ca.cours5b5.vladimirchrisphonte.global.GCouleur;

public class MGrille extends Modele{

    private List<MColonne> colonnes;

    //constructeur
    public  MGrille(int largeur){

    }


    private void initialiserColonnes(int largeur){

    }


    //accesseurs
    public List<MColonne> getColonne() {
        return this.colonnes;
    }

    //méthodes

    public void placerJeton(int colonne, GCouleur couleur) {

    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {
        /*
        * not used
         */

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        /*
        * not use
         */
        return null;
    }
}
