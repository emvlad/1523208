package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

import ca.cours5b5.vladimirchrisphonte.global.GCouleur;

public class VGrille extends GridLayout {

    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void demanderActionEntete(){

        /*
        * On demande l'action JOUER_COUP_ICI
        *
        * L'action est à exécuter quand l'usager clique sur un en-tête
         */
    }

    private void installerListenerEntete(VEntete entete, final int colonne){

    }


    private void afficherJeton(int colonne, int rangee, GCouleur jeton){

    }




}
