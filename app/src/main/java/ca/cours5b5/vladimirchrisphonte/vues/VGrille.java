package ca.cours5b5.vladimirchrisphonte.vues;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.vladimirchrisphonte.modeles.MParametres;

public class VGrille extends GridLayout {

	private int nombreRangees;

	private class Colonne extends ArrayList<VCase>{

	}
	private List<Colonne> colonnesDeCases = new ArrayList<>();

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



	@Override
	protected void onFinishInflate(){
		super.onFinishInflate();
		this.creerGrille(MParametres.instance.getHauteur(), MParametres.instance.getLargeur());
	}

	private void initialiser(){
	}

	void creerGrille(int hauteur, int largeur){
		ajouterEnTetes(largeur);
		ajouterCases(hauteur, largeur);

	}
	private void initialiserColonnes(int largeur){

	}
	private void ajouterEnTetes(int largeur){

		for(int i=0;i<largeur;i++) {
			this.addView(new VEntete(this.getContext(), i), getMiseEnPageEntete(i));
		}
	}
	private LayoutParams getMiseEnPageEntete(int colonne){
		int rangee = 0;

		float poidsColonne = 1;
		float poidsRangee = 3;

		Spec specRangee = GridLayout.spec(rangee, poidsRangee);
		Spec specColonne = GridLayout.spec(colonne, poidsColonne);

		LayoutParams layParams = new LayoutParams(specRangee, specColonne);

		layParams.width = 4;
		layParams.height = 4;
		layParams.setGravity(Gravity.FILL);


		layParams.rightMargin = 2;
		layParams.leftMargin = 0;

		return layParams;
	}
	private void ajouterCases(int hauteur, int largeur){
		for(int i=0;i<hauteur;i++) {
			for (int j=0; j<largeur;j++){
				this.addView(new VCase(this.getContext(),j, i), getMiseEnPageCase(j, hauteur - i - 1));
			}
		}

	}
	private LayoutParams getMiseEnPageCase(int colonne, int rangee){

		float poidsColonne = 1;
		float poidsRangee = 1;

		Spec specRangee = GridLayout.spec(rangee+1, poidsRangee);
		Spec specColonne = GridLayout.spec(colonne, poidsColonne);

		LayoutParams layParams = new LayoutParams(specRangee, specColonne);

		layParams.width = 0;
		layParams.height = 0;
		layParams.setGravity(Gravity.FILL);


		layParams.rightMargin = 2;
		layParams.leftMargin = 0;

		return layParams;

	}
}
