package ca.cours5b5.vladimirchrisphonte.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;
import ca.cours5b5.vladimirchrisphonte.modeles.Mparametres;
import ca.cours5b5.vladimirchrisphonte.serialisation.Jsonification;

public abstract class Activite extends AppCompatActivity {

    private Modele monModele;

    static {
        Log.d("Atelier04", Activite.class.getSimpleName()+"::static");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal); //activity_parametres?

        Log.d("Atelier04", this.getClass().getSimpleName() + "::onCreate");


        if (savedInstanceState != null) {
            //récupérer les données
            String json = savedInstanceState.getString("maCle");
            Map<String, Object> objetJson = Jsonification.enObjetJson(json);
            monModele.aPartirObjetJson(objetJson);
        }
    }

    //TODO
    //sauvegarde temporaire
    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);

        Map<String, Object> objetJson = monModele.enObjetJson();
        String json = Jsonification.enChaine(objetJson);

        outState.putString("maCle", json);



        Log.d("Atelier04", this.getClass().getSimpleName() + "::onSaveInstanceState");

        //code to save here


       // objetJson.put(__hauteur, hauteur.toString);

        //récupérer
       // hauteur = Integer.valueOf((String)entry.getValue);

    }

    @Override
    protected void onResume () {

        super.onResume();


        Log.d("Atelier04", this.getClass().getSimpleName() + "::onResume");
    }

    //Utiliser onPause pour sauvegarder les données
    @Override
    protected void onPause () {
        super.onPause();

        Log.d("Atelier04", this.getClass().getSimpleName() + "::onPause");

    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        Log.d("Atelier04", this.getClass().getSimpleName() + "::onDestroy");

        //juste avant de détruire sauvegarder
    }



}
