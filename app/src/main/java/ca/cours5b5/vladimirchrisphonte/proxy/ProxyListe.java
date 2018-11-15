package ca.cours5b5.vladimirchrisphonte.proxy;

import android.app.DownloadManager;

import ca.cours5b5.vladimirchrisphonte.controleurs.Action;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.global.GCommande;

public class ProxyListe extends Proxy implements Fournisseur {

    private ChildEventListener childEventListener;
    private DownloadManager.Query requete;
    private Action actionNouvelItem;

    @Override
    public void detruireValeurs() {

    }

    private List<DatabaseReference> noeudsAjoutes;
    public ProxyListe(String cheminServeur) {


    }

    public void setActionNouvelItem(GCommande commande){

    }

    public void ajouterValeur(Object valeur) {
        /*
         * Créer un sous-noeud avec push()
         * Mémoriser le noeud ajouté
         * Ajouter la valeur avec setValue()
         */
        @Override
        public void connecterAuServeur() {
            super.connecterAuServeur();
            /*
             * Céer le listener
             * sauvegarder la requête
             * ajouter le listener
             */
        }

    }

    private void creerListener(){

    }

    protected Query getRequete() {
        /*
         * On veut trier par clé et limiter à un nombre max (utiliser une constante)
         */
        @Override
        public void deconnecterDuServeur () {
            /*
             * retirer le listener
             * oublier les noeuds ajoutés
             * déconnecter via super
             */
        }
        @Override
        public void detruireValeurs() {

        }

    }


}
