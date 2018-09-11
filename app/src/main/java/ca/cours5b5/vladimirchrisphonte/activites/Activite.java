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

        Log.d("Atelier04", this.getClass().getSimpleName()+"::onCreate");
    }


    @Override
    protected void onResume() {

        super.onResume();


        Log.d("Atelier04", this.getClass().getSimpleName()+"::onResume");
    }


    //Utiliser onPause pour sauvegarder les données
    @Override
    protected void onPause(){
        super.onPause();

        Log.d("Atelier04", this.getClass().getSimpleName()+"::onPause");

    }
    //sauvegarde temporaire
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        //code to save here

        Log.d("Atelier04", this.getClass().getSimpleName()+"::onSaveInstanceState");


        //ex: stoquer un entier
      //  outState.putInt("Mirror",10);


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Atelier04", this.getClass().getSimpleName()+"::onDestroy");
        
        //juste avant de détruire
    }







}
