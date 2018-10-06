package ca.cours5b5.vladimirchrisphonte.controleurs;

import java.util.List;
import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vladimirchrisphonte.global.GCommande;

public class ControleurAction {

    private static Map<GCommande, Action> actions;
    private static List<Action> fileAttenteExecution;

    static {
        /*
         *CQFS ==> initialiser le Map actions comme suit:
         *
         * 1- pour chaque GCommande -->insérer une action vide
         *
         * alors on a plus besoin à tester si une GCommande est dans
         * le Map...elles y sont toutes!
         *
         *
         */
    }

    public static Action demanderAction(GCommande commande) {

        /*
         *Retourner l'action au demandeur
         */
        return null;
    }

    public static void fournirAction(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur) {

        /*
         *Enregistrer le fournisseur
         * Appeler la méthode qui exécute chaque action de la file d'attente(bonus:pourquoi)
         *
         */
    }

    static void executerDesQuePossible(Action action) {

        /*
         *Mettre l'action en file d'attente
         * Appeler la méthode qui exécute chaque action
         * de la file d'attente
         *
         */
    }

    public static void executerActionsExecutables() {

        /*
         *Itérer la file d'attente
         * Si l'action est exécutable:
         *
         *  Avant d'exécuter l'action:
         *  -l'enlever de la file d'attente
         *
         *  Appeler la méthode pour exécuter l'action maintenant
         *
         *  Après avoir exécuter l'action:
         *   -lancer l'observation du fournisseur de cette action (si possible)
         */
    }

    static boolean siActionExecutable(Action action) {

        boolean executable = false;

        /*
         *Une action est exécutable si:
         *

        if (listenerFournisseur != null)

          excutable = true;
     */

        return executable;
    }

    public static synchronized void executerMaintenant(Action action) {
        /*
         *appeler le listenerFournisseur de l'action
         * bonus: à qui sert synchronized = controler la séquence des actions.

         */

        new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {

            }
        };
    }

    public static void lancerObservationSiApplicable(Action action) {
        /*
         *appeler le contrôleur pour lancer l'observation
         * du fournisseur (seulement si le fournisseur est un modèle)

         */
       // if(si le fournisseur est un modèle)
        new ControleurObservation();
    }

    public static void enregistrerFournisseur(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur) {
        /*
         *enregistrer le fournisseur et le listenerFournisseur dans l'action

         */
    }

    public static void ajouterActionEnFileDAttente(Action action){

        /*
        *créer un clone de l'action et ajouter le clone à la file dattente
        *
        * bonus: pourquoi un clone = crééer une image identique en attendant son exécution
         */



    }

}
