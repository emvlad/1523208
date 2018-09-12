package ca.cours5b5.vladimirchrisphonte.modeles;

import java.util.Map;

public abstract class Modele {

    public  abstract void aPartirObjetJson(Map<String, Object> objetJson);

    public abstract  Map<String, Object> enObjetJson();
}


/*
1- La méthode aPartirObjetJson charge les données du modèle
   à partir d'une sauvegarde en objetJson (Map<String, Object);
2- La méthode enObjetJson retoure une sauvegarde des données du modèle objetJson
3- Chaque modèle devra implanter ces deux méthodes
 */