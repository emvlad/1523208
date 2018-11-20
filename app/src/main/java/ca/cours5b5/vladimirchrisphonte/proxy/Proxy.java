package ca.cours5b5.vladimirchrisphonte.proxy;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class Proxy {

    private String cheminServeur;
    protected DatabaseReference noeudServeur;

    Proxy monProxy = new ProxyListe(cheminServeur);

    public Proxy(String cheminServeur){
        this.cheminServeur = cheminServeur;

    }

    public void connecterAuServeur() {
        noeudServeur = FirebaseDatabase.getInstance().getReference(cheminServeur);
    }

    public void deconnecterDuServeur(){

        monProxy.deconnecterDuServeur();
    }

    public abstract void detruireValeurs();


}
