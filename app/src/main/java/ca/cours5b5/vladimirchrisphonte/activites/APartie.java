package ca.cours5b5.vladimirchrisphonte.activites;



import android.os.Bundle;

import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.global.GConstantes;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametres;
import ca.cours5b5.vladimirchrisphonte.serialisation.Jsonification;

public class APartie extends Activite {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartie);
        if(savedInstanceState != null){
            restaurerPartie(savedInstanceState);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        sauvegarderPartie(outState);

    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    private void restaurerParametres(Bundle savedInstanceState){
        String json = savedInstanceState.getString(GConstantes.cle);

        Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

        mParametres.aPartirObjetJson(objetJson);

    }

    private void restaurerPartie(Bundle savedInstanceState){

        String json = savedInstanceState.getString(GConstantes.cle);

        Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

        mParametres.aPartirObjetJson(objetJson);

        // Log.d("Atelier06", APartie.class.getSimpleName() + "::restaurerPartie, clé: "
        //         +MPartie.class.getSimpleName());

    }

    private void sauvegarderPartie(Bundle outState) {
        //  Log.d("Atelier06", APartie.class.getSimpleName() + "::sauvegarderPartie, clé: "
        //        +MPartie.class.getSimpleName());

        Map<String, Object> objetJson = MParametres.instance.enObjetJson();

        String json = Jsonification.enChaineJson(objetJson);

        outState.putString(GConstantes.cle, json);
    }

}