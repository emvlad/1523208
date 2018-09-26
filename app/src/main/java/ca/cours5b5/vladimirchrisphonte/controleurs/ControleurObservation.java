package ca.cours5b5.vladimirchrisphonte.controleurs;

import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametres;
import ca.cours5b5.vladimirchrisphonte.modeles.MPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;

public class ControleurObservation {

//FIXME: cest temporaire, on va écrire un contrôleur de modèles a l'atelier09

    //instance
    private static Map<Modele, ListenerObservateur> observations;

    private static MPartie partie;
    /*
     * l'attribut est private: la vue doit obtenir le modèle par l'observation
     *
     */
    static {

    }

    //reçoit 2 paramètres
    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

		/*Enregistrer le listener dans le Map observations
		*Appelr le listener une première fois
		 - MParametres.instance ou Controleur.partie

		Bonus: pourquoi le modèle est identifié par son nom?
		et(pas son objet comme dans le Map)

		*/
        ControleurObservation.observerModele(MParametres.class.getSimpleName(), new ListenerObservateur(){
        //    @Override
            public void reagirChangementAuModele(Modele modele){
              //  afficherParametres((MParametres) modele);
            }
        });

    }

}
