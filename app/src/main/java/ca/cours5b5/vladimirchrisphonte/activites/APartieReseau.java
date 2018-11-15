package ca.cours5b5.vladimirchrisphonte.activites;

import android.os.Bundle;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurPartieReseau;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;

public class APartieReseau extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie_reseau);

    }

    @Override
    protected void onPause() {
        super.onPause();
        /*
         * 1-Avec ControleurPartieReseau, détruire la partie sur le serveur
         *
         *
         * 2-Déconnecter ControleurPartieReseau du serveur
         */

    }
    @Override
    protected void onResume() {
        super.onResume();
        /*
         * Connecter le ControleurPartieReseau au serveur
         *
         */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*
         * BONUS: avec ControleurModeles, détruire le modèle MPartieReseau
         *
         */
    }
}

