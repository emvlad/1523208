package ca.cours5b5.vladimirchrisphonte.modeles;

import java.util.List;
import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurSerialisation;
import ca.cours5b5.vladimirchrisphonte.global.GCouleur;

public class MColonne extends Modele{

    private List<GCouleur> jetons;


    //constructeur
    public MColonne() {

    }
    public  void placerJeton(GCouleur couleur){

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

        /*
        * not used
         */

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {
        return null;
    }
}
