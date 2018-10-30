package ca.cours5b5.vladimirchrisphonte.donnees;

import java.util.Map;



public final class Serveur extends SourceDeDonnees {

     private  Serveur (){

     }

     private static final Serveur instance = new Serveur();


    public static Serveur getInstance() {

        return instance;
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        /*
         * Sauvegarder sur le serveur
         *
         * Utiliser FirebaseDatabase et DatabaseReference
         *
         */
    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {
        /*
         * BONUS: est-ce possible d'implanter cette méthode avec cette signature?
         */
        return null;
    }

    @Override
    public String getNomModele(String cheminSauvegarde) {

        String nomModele= null;
        String nom = cheminSauvegarde.getClass().getSimpleName();

        if (nom != null) {
            nomModele =nom;
        }

        return nomModele;
    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde){

        /*
         * BONUS
         */

    }
}

/*Tickets:
-Serveur
-Usager courant
-Connexion
-Déconnexion
-Écrire - Effacer dans la BD.

 */