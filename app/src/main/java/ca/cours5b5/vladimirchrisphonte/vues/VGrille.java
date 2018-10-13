package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.util.AttributeSet;



import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.vladimirchrisphonte.global.GCouleur;

public class VGrille extends GridLayout {


	
	private int nombreRangees;
	private List<Colonne> colonnesDeCases  ;
	private List<VEntete> entetes;


	int rangee, colonne;
	float poidsRangee, poidsColonne;



	//constructeurs
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


	
<<<<<<< HEAD
	private class Colonne extends ArrayList<VCase> {


    }
=======
	public class Colonne extends ArrayList<VCase> {
		
	}



	@Override
	protected void onFinishInflate() {

		super.onFinishInflate();




	}

	private void creerGrille(int hauteur, int largeur){

  /*
	Spec specRangee = GridLayout.Spec(rangee,poidsRangee);
	Spec specColonne = GridLayout.Spec(colonne,poidsColonne);

	LayoutParams mesParams = new LayoutParams(specRangee,specColonne);
    mesParams.width=0;
    mesParams.height=0;
    mesParams.setGravity(Gravity.FILL);

    mesParams.rightMargin = 5;
    mesParams.leftMargin = 5;

    GridLayout grille;
    grille.addView(monControle, mesParents);

*/
		
	}
	
	private void initialiserColonnes(int largeur){


		
	}
	
	private void ajouterEntetes(int largeur){


	}
	public void creerGrille(int hauteur, int largeur){

		
	}
	
	public void initialiserColonnes(int largeur){
		
	}
	
	public void ajouterEntetes(int largeur){

		
	}
	public LayoutParams getMiseEnPageEntete(int colonne){




		return null;
	}
	public void ajouterCases(int hauteur, int largeur){
		
	}
	
	public LayoutParams getMiseEnPageCase(int rangee, int colonne){


		return null;
	}

	

   private void demanderActionEntete(){

        /*
     	  On demande l'action JOUER_COUP_ICI
          L'action est à exécuter quand l'usager clique sur un en-tête
         */
   }

    private void installerListenerEntete(VEntete entete, final int colonne){



    }


    private void afficherJeton(int colonne, int rangee, GCouleur jeton){

    }




}
