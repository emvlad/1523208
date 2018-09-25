package ca.cours5b5.vladimirchrisphonte.activites.interfaces;

import ca.cours5b5.vladimirchrisphonte.modeles.Modele;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;

    //FIXME: cest temporaire, on va écrire un contrôleur de modèles a l'atelier09

    private  static  MPartie partie;
    /*
    * l'attribut est private: la vue doit obtenir le modèle par l'observation
    *
     */
    static {

    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

    }




}


