package ca.cours5b5.vladimirchrisphonte.activites;


import android.os.Bundle;


import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametres;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametresPartie;
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
    protected void onResume() {
        super.onResume();
    }

    private void restaurerPartie(Bundle savedInstanceState){

       // Log.d("Atelier06", APartie.class.getSimpleName() + "::restaurerPartie, clé: "
       //         +MPartie.class.getSimpleName());

        String cle = MParametres.class.getSimpleName();
        String json = savedInstanceState.getString(cle);

        Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

        Integer hauteur = null,largeur = null,pourGagner = null;

        MParametresPartie.instance = new MParametresPartie(hauteur,largeur,pourGagner);

        MParametresPartie.instance.aPartirObjetJson(objetJson);
        
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        sauvegarderPartie(outState);

    }

    private void sauvegarderPartie(Bundle outState) {
      //  Log.d("Atelier06", APartie.class.getSimpleName() + "::sauvegarderPartie, clé: "
        //        +MPartie.class.getSimpleName());

        String cle = MParametresPartie.class.getSimpleName();
        Map<String, Object> objetJson = MParametres.instance.enObjetJson();

        String json = Jsonification.enChaineJson(objetJson);
        outState.putString(cle, json);


    }

}
