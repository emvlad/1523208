package ca.cours5b5.vladimirchrisphonte.donnees;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.util.Map;


import ca.cours5b5.vladimirchrisphonte.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }


    //update ajout listener
    @Override
    public void chargerModele(String cheminSauvegarde, ListenerChargement listenerChargement)   {


       try {
                if(bundle != null && bundle.containsKey(getCle(cheminSauvegarde))){

                    String json = bundle.getString(cheminSauvegarde);

                    Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

                    listenerChargement.reagirSucces(objetJson);}

                    else{

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

    private String getCle(String cheminSauvegarde){

        String cleSauvegarde = getNomModele(cheminSauvegarde);

        return  cleSauvegarde;

    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde) {
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.removeValue();

    }






}