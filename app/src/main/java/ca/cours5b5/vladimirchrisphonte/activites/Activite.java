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

        Log.d("Atelier04", this.getClass().getSimpleName()+"::onCreate");
        if(savedInstanceState !=null){

            //récupérer les données
            String json = savedInstanceState.getString("strKey");
            Map<String, Object> objetJson = Jsonification.enObjetJson(json);

            monModele.aPartirObjetJson(objetJson);
        }


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
        //ex: stoquer un entier
        //  outState.putInt("Mirror",10);

        Log.d("Atelier04", this.getClass().getSimpleName()+"::onSaveInstanceState");


        Map<String, Object> objetJson = monModele.enObjetJson();
        String json = Jsonification.enChaine(objetJson);

        outState.putString("strKey",json);


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Atelier04", this.getClass().getSimpleName()+"::onDestroy");

        //juste avant de détruire
    }







}
