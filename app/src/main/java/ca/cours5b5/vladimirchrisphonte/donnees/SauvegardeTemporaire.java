package ca.cours5b5.vladimirchrisphonte.donnees;

import android.os.Bundle;

import java.util.Map;


import ca.cours5b5.vladimirchrisphonte.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {

        if(bundle != null && bundle.containsKey(getCle(cheminSauvegarde))){

            String json = bundle.getString(cheminSauvegarde);

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

            return objetJson;

        }else{

            return null;

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

    }






}