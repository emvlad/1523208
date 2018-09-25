package ca.cours5b5.vladimirchrisphonte.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;

import ca.cours5b5.vladimirchrisphonte.R;


public class mainActParametres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        String orientation;

        //condition de la forme d'orientation encours du device
        if (this.getResources().getBoolean(R.bool.est_portrait)) {
            orientation = "(portrait)";
        } else {
            orientation = "(paysage)";
        }


        //TODO: condition pour afficher l'orientation
        Log.d("MonEtiquette", this.getResources().getString(R.string.bonjour));

        Log.d("Pivot", "L'orientation est: " + orientation);


        //TODO: condition pour afficher les valeurs des controles:
        Log.d("Choice", this.getResources().getString(R.string.largeur) + "L was chosen");
        Log.d("Choice", this.getResources().getString(R.string.hauteur) + "H was chosen");

        Log.d("Result", this.getResources().getString(R.string.gagner) + "You won");


    }
}
