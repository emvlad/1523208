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

    //instance
    private static Map<Modele, ListenerObservateur> observations = new HashMap<>();

    public static MPartie partie = new MPartie(new MParametresPartie());
    /*
     * l'attribut est private: la vue doit obtenir le modèle par l'observation
     *
     */
    static {

    }

    //reçoit 2 paramètres
    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

		/*
		*Appeler le listener une première fois
		 - MParametres.instance ou Controleur.partie
		Bonus: pourquoi le modèle est identifié par son nom?
		et(pas son objet comme dans le Map)
		*/

		//condition1 sans model

        //Enregistrer le listener dans le Map observations


     //   if (nomModele.equals(MParametres.class.getSimpleName())) {

            observations.put(MParametres.instance, listenerObservateur);
            lancerObservation(MParametres.instance);

/*
        } else if (nomModele.equals(MPartie.class.getSimpleName())) {

            partie = new MPartie(MParametres.instance.getParametresPartie().cloner());

            //Enregistrer le listener dans le Map observations
            observations.put(ControleurObservation.partie,listenerObservateur);
            lancerObservation(ControleurObservation.partie);


        }
        */


    }


    public  static void lancerObservation(Modele modele){

        /*if (modele != null) {

            observations.get(modele).reagirNouveauModele(modele);

        }
        if (modele != null) {

            observations.get(modele).reagirChangementAuModele(modele);

        }
*/
    }

}