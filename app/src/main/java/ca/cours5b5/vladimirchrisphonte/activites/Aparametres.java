package ca.cours5b5.vladimirchrisphonte.activites;


import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;
import ca.cours5b5.vladimirchrisphonte.serialisation.Jsonification;


public class Aparametres extends Activite {


    static {
        Log.d("Atelier04", Aparametres.class.getSimpleName() + "::static");

    }

    private String maCle = "Aparametres";
    Modele monModele = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        String orientation;

        if (this.getResources().getBoolean(R.bool.est_portrait)) {
            orientation = " Affichage Portrait";
        } else {
            orientation = " Affichage Paysage)";
        }


        if(savedInstanceState != null){

            String json = savedInstanceState.getString("maCle");
            Map<String, Object> objetJson = Jsonification.enObjetJson((json));
            monModele.aPartirObjetJson(objetJson);
        }



        Log.d("MonEtiquette", this.getResources().getString(R.string.bonjour) + orientation);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Map<String, Object> objetJson = monModele.enObjetJson();

        String json = Jsonification.enChaine(objetJson);
        outState.putString("maCle", json);

    }

    private void restaurerParametres(Bundle savedInstanceState) {




    }

    private void sauvegarderParametres(Bundle outState) {

    }


}
