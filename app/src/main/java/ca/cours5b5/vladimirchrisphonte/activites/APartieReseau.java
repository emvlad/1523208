package ca.cours5b5.vladimirchrisphonte.activites;

import android.os.Bundle;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurModeles;
import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurPartieReseau;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.modeles.MPartieReseau;

public class APartieReseau extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie_reseau);

    }

    @Override
    protected void onPause() {
        super.onPause();
        // 1-Avec ControleurPartieReseau, détruire la partie sur le serveur
        ControleurPartieReseau.getInstance().detruireSauvegardeServeur();

        //2-Déconnecter ControleurPartieReseau du serveur
        ControleurPartieReseau.getInstance().deconnecterDuServeur();

    }

    @Override
    protected void onResume() {
        super.onResume();
        /*
         * Connecter le ControleurPartieReseau au serveur
         *
         */
        ControleurPartieReseau.getInstance().connecterAuServeur();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*
         * BONUS: avec ControleurModeles, détruire le modèle MPartieReseau
         *
         */
        ControleurModeles.detruireModele(MPartieReseau.class.getSimpleName());
    }
}

