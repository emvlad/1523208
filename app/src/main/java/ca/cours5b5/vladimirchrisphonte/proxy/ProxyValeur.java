package ca.cours5b5.vladimirchrisphonte.proxy;

import com.google.firebase.database.ValueEventListener;

import ca.cours5b5.vladimirchrisphonte.controleurs.Action;
import ca.cours5b5.vladimirchrisphonte.global.GCommande;

public class ProxyValeur extends Proxy {
    private ValueEventListener valueEventListener;
    private Action actionNouvelleValeur;
    private boolean valeurEcrite;

    public ProxyValeur(String cheminServeur) {
        super(cheminServeur);
    }

    public void setActionNouvelleValeur(GCommande commande) {
    }

    @Override
    public void connecterAuServeur() {
    }

    public void deconnecterDuServeur() {
    }

    @Override
    public void detruireValeurs() {
    }

    private void creerListener() {
    }

}
