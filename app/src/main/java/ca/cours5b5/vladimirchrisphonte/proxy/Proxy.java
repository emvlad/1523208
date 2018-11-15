package ca.cours5b5.vladimirchrisphonte.proxy;

public abstract class Proxy {

    private String cheminServeur;
    protected DatabaseReference noeudServeur;

    public Proxy(String cheminServeur){

    }


    public void connecterAuServeur() {
        /*
         * Obtenir le noeud
         *
         */
    }

    public void deconnecterDuServeur(){
            /*
            * Oublier le noeud
            *
            *
            */
    }
    public abstract void detruireValeurs();
}
