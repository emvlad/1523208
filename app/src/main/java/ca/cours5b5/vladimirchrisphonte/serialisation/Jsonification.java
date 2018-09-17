package ca.cours5b5.vladimirchrisphonte.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class Jsonification {


    //TODO

    //fields
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();



    //à partir d'un objet Json - obtenir une chaine
    public static String enChaine(Map<String, Object> objetJson) {

        String chaineJson = gson.toJson(objetJson);

        return chaineJson;
    }


    //à partir d'une chaine obtenir un objet Json
    public static Map<String, Object> enObjetJson(String json) {

        Map<String, Object> objetJson = gson.fromJson(json,Map.class);

        return objetJson;
    }

}
