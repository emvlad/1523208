package ca.cours5b5.vladimirchrisphonte.controleurs;


import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametres;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametresPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.MPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;

public class ControleurObservation {

//FIXME: cest temporaire, on va écrire un contrôleur de modèles a l'atelier09

    private ControleurObservation(){}
    //instance
    private static Map<Modele, ListenerObservateur> observations;


    /*
     * l'attribut est private: la vue doit obtenir le modèle par l'observation
     *
     */
    static {
        observations = new HashMap<>();
    }

    //reçoit 2 paramètres
    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur) {

        Modele modele = ControleurModeles.getModele(nomModele);

        observations.put(modele, listenerObservateur);

        listenerObservateur.reagirNouveauModele(modele);

    }

    public static void lancerObservation(Modele modele) {

        final ListenerObservateur listenerObservateur = observations.get(modele);

        if (listenerObservateur != null) {

            listenerObservateur.reagirChangementAuModele(modele);

        }
    }

    public static void detruireObservation(Modele modele) {

        observations.remove(modele);

    }
}