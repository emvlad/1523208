package ca.cours5b5.vladimirchrisphonte.vues;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class VGrille extends GridLayout {


<<<<<<< HEAD

=======
	
>>>>>>> e42fdc14bbcb1e3fe8588c060510245db4ad5fc2
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


<<<<<<< HEAD
	}

	public class Colonne extends ArrayList<VCase> {

=======
    public VGrille(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		
		
    }
	
	public class Colonne extends ArrayList<VCase> {
		
>>>>>>> e42fdc14bbcb1e3fe8588c060510245db4ad5fc2
	}


	@Override
	protected void onFinishInflate() {

		super.onFinishInflate();


	}
	public void creerGrille(int hauteur, int largeur){

<<<<<<< HEAD

	}

	public void initialiserColonnes(int largeur){

	}

	public void ajouterEntetes(int largeur){

=======
		
	}
	
	public void initialiserColonnes(int largeur){
		
	}
	
	public void ajouterEntetes(int largeur){
		
>>>>>>> e42fdc14bbcb1e3fe8588c060510245db4ad5fc2
	}
	public LayoutParams getMiseEnPageEntete(int colonne){


		return null;
	}
	public void ajouterCases(int hauteur, int largeur){
<<<<<<< HEAD

	}

=======
		
	}
	
>>>>>>> e42fdc14bbcb1e3fe8588c060510245db4ad5fc2
	public LayoutParams getMiseEnPageCase(int rangee, int colonne){


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