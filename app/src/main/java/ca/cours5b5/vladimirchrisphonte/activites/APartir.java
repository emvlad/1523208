package ca.cours5b5.vladimirchrisphonte.activites;


import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.modeles.MPartie;

public class APartir extends Activite {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_partie);

        if(savedInstanceState != null){
            restaurerPartie(savedInstanceState);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void restaurerPartie(Bundle savedInstanceState){

        Log.d("Atelier06", APartir.class.getSimpleName() + "::restaurerPartie, clé: "
                +MPartie.class.getSimpleName());
        
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        sauvegarderPartie(outState);

    }

    private void sauvegarderPartie(Bundle outState) {
        Log.d("Atelier06", APartir.class.getSimpleName() + "::sauvegarderPartie, clé: "
                +MPartie.class.getSimpleName());
    }

}
