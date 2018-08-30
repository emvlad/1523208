package ca.cours5b5.vladimirchrisphonte.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.vladimirchrisphonte.R;


public class AParametres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        String orientation;

        if (this.getResources().getBoolean(R.bool.est_portrait)) {
            orientation = "(portrait)";
        } else {
            orientation = "(paysage)";
        }

        Log.d("MonEtiquette",this.getResources().getString(R.string.bonjour) + orientation);



    }
}
