package ca.cours5b5.vladimirchrisphonte.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import ca.cours5b5.vladimirchrisphonte.R;

public abstract class Activite extends AppCompatActivity {


    static {
        Log.d("Atelier04", Activite.class.getSimpleName()+"::static");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);



    }

    @Override
    protected void onResume() {

        super.onResume();
    }


    //Utiliser onPause pour sauvegarder les données
    @Override
    protected void onPause(){
        super.onPause();

    }
    //sauvegarde temporaire
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        //code to save here


        //ex: stoque un entier
        outState.putInt("Mirror",10);


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        //juste avant de détruire
    }






}
