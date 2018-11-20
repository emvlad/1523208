package ca.cours5b5.vladimirchrisphonte.usagers;

import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.proxy.ProxyListe;

public final class JoueursEnAttente implements Fournisseur {

    private static final JoueursEnAttente instance = null;
    private ProxyListe proxyJoueursEnAttente;
    private String __joueursEnAttente;

    private JoueursEnAttente() {
        /*
         * Créer et initialiser le proxy
         * Fournir les actions
         */
    }

    public static JoueursEnAttente getInstance() {
        return instance;
    }

    private void fournirActions() {
        /*
         * Fournir l'action RECEVOIR_JOUEUR_EN_ATTENTE
         */
    }

    private void fournirActionAjouterJoueurEnAttente() {
        /*
         * Si le joueur en attente n'est pas l'usager courant
         * Basculer en mode invitation
         */
    }

    public void inscrireJoueurEnAttente() {
        /* Ajouter l'id de l'usager courant à la liste de joueurs en attente
         * (utiliser le proxyJoueursEnAttente)
         */
    }


    private void basculerEnModeInvitation(String idJoueurEnAttente) {
        /*
         * Basculer en mode hôte ou en mode invite
         * à vous de choisir un test qui fonctionne pour chaque IdUsager
         *
         */
    }

    private void basculerEnModeHote(String idJoueurHote, String idJoueurInvite) {
        /*
         * Créer et démarrer la partie à l'aide du ControleurPartieReseau
         *
         */
    }

    private void basculerEnModeInvite(String idJoueurHote, String idJoueurInvite) {
        /*
         * ajouter les id usager à JoueurInvite
         * connecter JoueurInvite au serveur
         *
         * (autrement dit, on attent d'être invité à la partie)
         */
    }

    public void connecterAuServeur() {
    }

    public void deconnecterDuServeur() {
    }
}
