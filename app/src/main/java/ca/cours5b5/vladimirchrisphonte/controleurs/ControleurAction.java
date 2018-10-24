package ca.cours5b5.vladimirchrisphonte.controleurs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vladimirchrisphonte.global.GCommande;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametres;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;

public class ControleurAction {

    private ControleurAction(){}
    private static Map<GCommande, Action> actions;
    private static List<Action> fileAttenteExecution;

    static {
        actions = new HashMap<>();

        initialiserActions();

        fileAttenteExecution = new ArrayList<>();
    }
    private static void initialiserActions() {

        for(GCommande commande : GCommande.values()){

            actions.put(commande, new Action());

        }

    }

    public static Action demanderAction(GCommande commande) {

        /*
         *Retourner l'action au demandeur
         */
        return actions.get(commande);
    }

    public static void fournirAction(Fournisseur fournisseur, GCommande commande,
                                     ListenerFournisseur listenerFournisseur) {

        /*
         *Enregistrer le fournisseur
         * Appeler la méthode qui exécute chaque actin de la file d'attente(bonus:pourquoi)
         *
         */
        enregistrerFournisseur(fournisseur, commande, listenerFournisseur);
        executerActionsExecutables();
    }

    static void executerDesQuePossible(Action action) {

        /*
         *Mettre l'action en file d'attente
         * Appeler la méthode qui exécute chaque action
          * de la file d'attente
         *
         */

        ajouterActionEnFileDAttente(action);
        executerActionsExecutables();
    }

    public static void executerActionsExecutables() {

        /*
         *Itérer ls file d'attente
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
        for (Action action : fileAttenteExecution) {

            if (siActionExecutable(action)) {

                fileAttenteExecution.remove(action);

                executerMaintenant(action);

                lancerObservationSiApplicable(action);

            }
        }
    }

    static boolean siActionExecutable(Action action) {

        return (action.listenerFournisseur == null) ? false : true;

        /*
         *Une action est exécutable si:
         *
         * if (listenerFournisseur != null)
         * excutable = true;
         */

    }

    public static synchronized void executerMaintenant(Action action) {
        /*
         *appeler le listenerFournisseur de l'action
         * bonus: à qui sert synchronized = controler la séquence des actions.
         */
        action.listenerFournisseur.executer(action.args);
    }

    public static void lancerObservationSiApplicable(Action action) {
        /*
         *appeler le contrôleur pour lancer l'observation
         * du fournisseur (seulement si le fournisseur est un modèle)
         */

        if (action.fournisseur instanceof Modele) {

            ControleurObservation.lancerObservation((Modele) action.fournisseur);

        }
    }

    public static void enregistrerFournisseur(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur) {
        /*
         *enregistrer le fournisseur et le listenerFournisseur dans l'action
         */

        Action action = actions.get(commande);

        action.fournisseur = fournisseur;

        action.listenerFournisseur = listenerFournisseur;
    }

    public static void ajouterActionEnFileDAttente(Action action){

        /*
         *créer un clone de l'action et ajouter le clone à la file dattente
         *
         * bonus: pourquoi un clone = créer une image identique en attendant son exécution
         */
        Action clone = action.cloner();

        fileAttenteExecution.add(clone);

    }
    public static void oublierFournisseur(Fournisseur fournisseur) {

        for(Action action : actions.values()){

            if(action.fournisseur == fournisseur){

                action.fournisseur = null;
                action.listenerFournisseur = null;

            }
        }
    }

}