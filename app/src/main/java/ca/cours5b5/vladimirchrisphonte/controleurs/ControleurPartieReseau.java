package ca.cours5b5.vladimirchrisphonte.controleurs;

import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.vladimirchrisphonte.global.GCommande;
import ca.cours5b5.vladimirchrisphonte.modeles.MPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.MPartieReseau;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;
import ca.cours5b5.vladimirchrisphonte.proxy.ProxyListe;
import ca.cours5b5.vladimirchrisphonte.usagers.UsagerCourant;

import static ca.cours5b5.vladimirchrisphonte.global.GConstantes.CLE_ID_JOUEUR_HOTE;

public class ControleurPartieReseau {

    private static final ControleurPartieReseau instance = null;
    private ProxyListe proxyEmettreCoups;
    private ProxyListe proxyRecevoirCoups;

    public static ControleurPartieReseau getInstance(){
        
       return instance;
    }


    public void connecterAuServeur() {

        ControleurModeles.getModele(MPartieReseau.class.getSimpleName(), new ListenerGetModele() {
            @Override
            public void reagirAuModele(Modele modele) {

                MPartieReseau mPartieReseau = (MPartieReseau) modele;

                connecterAuServeur(mPartieReseau.getId());

            }
        });

    }
    private void connecterAuServeur(String idJoueurHote) {

        String idPlayer = UsagerCourant.getId();

        if (idPlayer == idJoueurHote) {

            connecterEnTantQueJoueurHote(getCheminCoupsJoueurHote(idJoueurHote), getCheminCoupsJoueurInvite(idJoueurHote));

        } else {

            connecterEnTantQueJoueurInvite(getCheminCoupsJoueurHote(idJoueurHote), getCheminCoupsJoueurInvite(idJoueurHote));

        }

        proxyEmettreCoups.connecterAuServeur();
        proxyRecevoirCoups.connecterAuServeur();

        proxyRecevoirCoups.setActionNouvelItem(GCommande.RECEVOIR_COUP_RESEAU);
    }

    private void connecterEnTantQueJoueurHote(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite) {
        /*
         * Créer les proxy... avec les bons chemins
         *
         */
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurHote);

        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurInvite);
    }
    private void connecterEnTantQueJoueurInvite(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite) {

        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurInvite);

        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurHote);
    }

    public void deconnecterDuServeur() {

        proxyEmettreCoups.detruireValeurs();

        proxyEmettreCoups.deconnecterDuServeur();
        proxyRecevoirCoups.deconnecterDuServeur();


    }

    public void transmettreCoup(Integer idColonne) {

        proxyEmettreCoups.ajouterValeur(idColonne);
    }

    private String getCheminCoupsJoueurInvite(String idJoueurHote) {
        /*
         * Utiliser p.ex. la constante CLE_COUPS_JOUR_INVITE
         */

        return  null;
    }
        private String getCheminCoupsJoueurHote(String idJoueurHote) {
            /*
             * Utiliser p.ex. la constante CLE_COUPS_JOUR_HOTE
             */
            return null;
        }
            private String getCheminPartie(String idJoueurHote){

        /*
         * Le chemin contient l'id de la partie (id du joueur hote)
         */
        return null;
            }

    public void detruireSauvegardeServeur() {
        /*
         * Appeler p.ex. le detruireSauvegarde de Serveur (avec le bon chemin)
         */
    }

    public void creerEtDemarrerPartie(final String idJoueurHote, final String idJoueurInvite) {
        /*
         * Créer le modèle avec getModele
         * Ajouter les id usagers (joueur hôte et invité)
         * Sauvegarder le modèle (pour l'envoyer vers le serveur)
         * Démarrer partie
         *
         */}

    private void demarrerPartie(MPartieReseau partie) {
        /*
         * Utiliser une action pour faire la transition
         * vers l'activité APartieReseau
         * (avec l'objetJson de la partie en argument)
         *
         */
    }
}
