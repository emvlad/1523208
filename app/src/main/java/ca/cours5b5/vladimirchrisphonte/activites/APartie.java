package ca.cours5b5.vladimirchrisphonte.activites;


import android.os.Bundle;

import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametresPartie;

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


        
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        sauvegarderPartie(outState);

    }

    private void sauvegarderPartie(Bundle outState) {
      //  Log.d("Atelier06", APartie.class.getSimpleName() + "::sauvegarderPartie, clé: "
        //        +MPartie.class.getSimpleName());





    }

}
