package ca.cours5b5.vladimirchrisphonte.controleurs;

import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerFournisseur;

public class Action {
    Fournisseur fournisseur;
    ListenerFournisseur listenerFournisseur;
    Object[] args;

    public void setArguments(Object... args) {
        this.args = args;
    }

    //méthode
    public void executerDesQuePossible() {

        /*
         *Appeler le contrôleur.
         * Il va gérer l'action (mettre en file d'attente,
         * exécuter si possible)
         */

        //Action
        // cloner();
        /*
         *Ne pas oublier de cloner le tableau!
         * (à moins qu'il soit null)
         *
         *
         */

        ControleurAction.executerDesQuePossible(this);
    }

    Action cloner() {

        Action clone = new Action();

        clone.fournisseur = fournisseur;
        clone.listenerFournisseur = listenerFournisseur;

        clone.args = (args == null) ? null : args.clone();

        return clone;
    }


}


