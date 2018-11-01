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




/*
    Firebase: écrire dans la base de données

    *L'usager doit être authentifié pour accéder à la base de données

  * Votre base de données est un arbre Json
  * 1-Pour écrire il faut un chemin vers un noeud et une valeur
  * 2-Pour détruire la valeur il faut le chemin vers le noeud
              * Ensuite, on demande de détruire ce noeud:
             * * ATTENTION: tout les sous-noeuds sont aussi détruits
                noeud.removeValue();

*/
