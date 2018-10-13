package ca.cours5b5.vladimirchrisphonte.activites;



import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.global.GConstantes;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametres;
import ca.cours5b5.vladimirchrisphonte.serialisation.Jsonification;


public class AParametres extends Activite {

    static{
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::static");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            restaurerParametres(savedInstanceState);
        }
        setContentView(R.layout.activity_parametres);
    }

    private void restaurerParametres(Bundle savedInstanceState){

        String json = savedInstanceState.getString(GConstantes.cle);

        Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

        MParametres.instance.aPartirObjetJson(objetJson);
        MParametres.instance = new MParametres();

        Log.d("Atelier05", AParametres.class.getSimpleName() + "::restaurerParametres, clé: " + GConstantes.cle);
        Log.d("Atelier05", AParametres.class.getSimpleName() + "::restaurerParametres, json:\n" + json);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.sauvegarderParametres(outState);

    }

    private void sauvegarderParametres(Bundle outState){

        Map<String, Object> objetJson = MParametres.instance.enObjetJson();

        String json = Jsonification.enChaineJson(objetJson);
        outState.putString(GConstantes.cle, json);

        Log.d("Atelier05", AParametres.class.getSimpleName() + "::sauvegarderParametres, clé: " + GConstantes.cle);
        Log.d("Atelier05", AParametres.class.getSimpleName() + "::sauvegarderParametres, json: \n" + json);


    }
}