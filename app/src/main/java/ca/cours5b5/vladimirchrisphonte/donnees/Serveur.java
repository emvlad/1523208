package ca.cours5b5.vladimirchrisphonte.donnees;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.setValue(objetJson);
    }



    @Override
    public void chargerModele(String cheminSauvegarde, ListenerChargement listenerChargement) {
        /*
         * BONUS: est-ce possible d'implanter cette méthode avec cette signature?
         */

        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){

                    Map<String, Object> objetJson = (Map<String, Object>) dataSnapshot.getValue();

                    // Données lues

                }else{

                    // Pas de données dans ce noeud

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Erreur de lecture

            }
        });

    }



    @Override
    public void detruireSauvegarde(String cheminSauvegarde){

        /*
         * BONUS
         */
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.removeValue();



    }
}
