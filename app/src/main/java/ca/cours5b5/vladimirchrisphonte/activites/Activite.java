package ca.cours5b5.vladimirchrisphonte.activites;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.util.Map;
import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametres;
import ca.cours5b5.vladimirchrisphonte.serialisation.Jsonification;


public abstract class Activite extends AppCompatActivity {

    MParametres mParametres = new MParametres();
    static{
        Log.d("Atelier04", Activite.class.getSimpleName() + "::static");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Atelier04", this.getClass().getSimpleName() + "::" +  "onCreate");

        affichageAtelier02();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_parametres);
        //Log.d("Atelier06",this.getClass().getSimpleName()+"::onCreate");

        if(savedInstanceState != null){
            String json = savedInstanceState.getString("MaCle");
            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);
            mParametres.aPartirObjetJson(objetJson);
        }

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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Atelier04", this.getClass().getSimpleName() + "::" +  "onSaveInstanceState");
    }


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
}
