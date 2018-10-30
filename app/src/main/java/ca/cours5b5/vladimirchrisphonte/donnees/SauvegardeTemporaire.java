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

        if(bundle != null && bundle.containsKey(cheminSauvegarde)){

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
    public String getNomModele(String cheminSauvegarde) {

        String nomModele= null;
        String nom = cheminSauvegarde.getClass().getSimpleName();

        if (nom != null) {
             nomModele =nom;
        }

        return nomModele;

    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde) {

    }






}