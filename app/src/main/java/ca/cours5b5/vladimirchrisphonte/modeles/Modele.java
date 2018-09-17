package ca.cours5b5.vladimirchrisphonte.modeles;

import java.util.Map;

public abstract class Modele {


    //Chaque modèle devra implanter ces deux méthodes

    //1- La méthode aPartirObjetJson charge les données du modèle
    //à partir d'une sauvegarde en objetJson (Map<String, Object);

    public  abstract void aPartirObjetJson(Map<String, Object> objetJson);




    //2- La méthode enObjetJson retourne une sauvegarde des données du modèle objetJson
    public abstract  Map<String, Object> enObjetJson();
}


