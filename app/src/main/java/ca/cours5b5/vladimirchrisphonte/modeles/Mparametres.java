package ca.cours5b5.vladimirchrisphonte.modeles;


import java.util.List;
import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.serialisation.AttributSerialisable;


public class Mparametres extends Modele {


    //FIXME: c'est temporaire; gestionnaire de modèles à venir at#7

    //instances
    public static Mparametres instance = new Mparametres();

    @AttributSerialisable  //indique quel attribut(instance) du modèle sera sauvegardé.
    public Integer hauteur;
    private final String __hauteur = "hauteur";

   @AttributSerialisable
    public Integer largeur;
    private final String __largeur = "largeur";


    @AttributSerialisable
    public Integer pourGagner;


    //TODO
    //méthodes
    public List<Integer> getChoixHauteur() {

        return null;
    }

    public List<Integer> getChoixLargeur() {

        return null;
    }

    public List<Integer> getChoixPourGagner() {

        return null;
    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {



    }

    @Override
    public Map<String, Object> enObjetJson() {




        return enObjetJson();
    }
}


/*
a) L'annotation @AttributSerialisable indique quel attribut(instance) du modèle sera sauvegardé.
b) Un attribut de la forme __attr sert à stoquer le nom de l'attribut.

 */






