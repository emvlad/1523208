package ca.cours5b5.vladimirchrisphonte.usagers;

import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.proxy.ProxyValeur;

public final class JoueurInvite implements Fournisseur {
    private JoueurInvite() {
    }

    private static final JoueurInvite instance =null;

    public static JoueurInvite getInstance(){

        return  instance;
    }

    protected String idJoueurInvite;
    protected String idJoueurHote;
    protected ProxyValeur proxyInviterJoueur;

    public void setIdJoueurs(String idJoueurHote, String idJoueurInvite) {
        /*
         * Initialiser après avoir sauvegarder les données
         */
    }

    protected void initialiser() {
        /*
         * Créer et initialiser le proxy
         * Fournir l'action RECEVOIR_JOUEUR_INVITE
         */
    }

    public void connecterAuServeur() {
    }

    public void deconnecterDuServeur() {
    }

    private String getCheminPartie() {

      String  cheminPartie= null;

    return  cheminPartie;
    }

    protected String getCheminInviterJoueur() {

        String  CheminInviterJoueur= null;

        return  CheminInviterJoueur;
    }

    private void fournirActionRecevoirInvite() {
        /*
         * Si le joueur courant est le joueur invité:
         * demarrerPartie
         */

    }
    protected void demarrerPartie() {
        /*
         * Charger la partie du serveur
         * Démarrer la partie
         */
    }
}
