package ca.cours5b5.vladimirchrisphonte.donnees;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.util.Map;


import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurSerialisation;
import ca.cours5b5.vladimirchrisphonte.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public void chargerModele(String cheminSauvegarde, ListenerChargement listenerChargement)   {

       try {
                if(bundle != null && bundle.containsKey(getCle(cheminSauvegarde))){

                    String json = bundle.getString(cheminSauvegarde);

                    Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

                    listenerChargement.reagirSucces(objetJson);}

                    else{
                    listenerChargement.reagirErreur(new ErreurSerialisation("Erreur: chargement impossible"));

                }

      }
       catch (Exception e) {

           listenerChargement.reagirErreur(e);


        }

    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        if(bundle != null){

            String json = Jsonification.enChaineJson(objetJson);
            bundle.putString(getCle(cheminSauvegarde), json);

        }
    }

    @Override
    public void detruireModele(String cheminSauvegarde) {
        if(bundle != null){

            bundle.remove(getCle(cheminSauvegarde));

        }
    }

    private String getCle(String cheminSauvegarde){

      return   getNomModele(cheminSauvegarde);

    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde) {
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.removeValue();

    }

}