package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class VGrille extends GridLayout {

	/*
    width;
    height;
    absoluteX;
    absoluteY;
    */
	
	private int nombreRangees;
	private List<Colonne> colonnesDeCases;
	private List<VEntete> entetes;

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
	
	private class Colonne extends ArrayList<VCase> {
		
	}


	@Override
	protected void onFinishInflate() {

		super.onFinishInflate();
	}
	private void creerGrille(int hauteur, int largeur){

		
	}
	
	private void initialiserColonnes(int largeur){
		
	}
	
	private void ajouterEntetes(int largeur){
		
	}
	private LayoutParams getMiseEnPageEntete(int colonne){


		return null;
	}
	private void ajouterCases(int hauteur, int largeur){
		
	}
	
	private LayoutParams getMiseEnPageCase(int rangee, int colonne){


		return null;
	}
	
	
	

   // private void demanderActionEntete(){

        /*
        * On demande l'action JOUER_COUP_ICI
        *
        * L'action est à exécuter quand l'usager clique sur un en-tête
         */
   // }
/*
    private void installerListenerEntete(VEntete entete, final int colonne){

    }


    private void afficherJeton(int colonne, int rangee, GCouleur jeton){

    }

*/


}
