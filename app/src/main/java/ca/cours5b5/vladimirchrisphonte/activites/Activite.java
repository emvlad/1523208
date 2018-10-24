package ca.cours5b5.vladimirchrisphonte.activites;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurModeles;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametres;

import donnees.Disque;
import donnees.SauvegardeTemporaire;

public abstract class Activite extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Atelier04", this.getClass().getSimpleName() + "::" +  "onCreate");

        initialiserControleurModeles(savedInstanceState);
        initialiserApplication();
        //  affichageAtelier02();
    }
    protected void initialiserControleurModeles(Bundle savedInstanceState) {
        ControleurModeles.setSequenceDeChargement(
                new SauvegardeTemporaire(savedInstanceState),
                Disque.getInstance());

    }
    protected void initialiserApplication(){

        Disque.getInstance().setRepertoireRacine(getFilesDir());

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Log.d("Atelier04", this.getClass().getSimpleName() + "::" +  "onSaveInstanceState");
        ControleurModeles.sauvegarderModeleDansCetteSource(MParametres.class.getSimpleName(),
                new SauvegardeTemporaire(outState));


    }

/*

 static{
        Log.d("Atelier04", Activite.class.getSimpleName() + "::static");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Atelier04", this.getClass().getSimpleName() + "::" +  "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Atelier04", this.getClass().getSimpleName() + "::" +  "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Atelier04", this.getClass().getSimpleName() + "::" +  "onDestroy");

    }
*/


/*
    private void affichageAtelier02(){

        String message = this.getResources().getString(R.string.bonjour);

        Log.d("Atelier01", message);

        String ajoutOrientation = " (";

        if(getResources().getBoolean(R.bool.si_portrait)){

            ajoutOrientation += this.getResources().getString(R.string.portrait);

        }else{

            ajoutOrientation += this.getResources().getString(R.string.paysage);

        }

        message += ajoutOrientation + ")";

        Log.d("Atelier02", message);
    }
    */
}