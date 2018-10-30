package ca.cours5b5.vladimirchrisphonte.donnees;

import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.global.GConstantes;


public abstract class SourceDeDonnees {

    public abstract Map<String, Object> chargerModele(final String cheminSauvegarde);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);



    public String getNomModele(String cheminSauvegarde){


        return cheminSauvegarde.split(GConstantes.EXTENSION_PAR_DEFAUT)[0];

    }




    public abstract void detruireSauvegarde(String cheminSauvegarde);




}
