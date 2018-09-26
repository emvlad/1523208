package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.vladimirchrisphonte.modeles.MPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;

public class VPartie extends Vue{
	
	//instances
	private VGrille grille;
	
	//Le (s) constructeur (s)
		
	public VPartie(Context context){

	}
	
	public Vpartie(Context context, AttributeSet attrs){

	}
	
	public VPartie(Context context, AttributeSet attrs, int defStyleAttr){


	}
	


	//méthodes
	//accesseurs
	private getPartie(Modele modele){

	}

	
	//affichage
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
	}
	
	private void initialiser(){}
	
	private void observerPartie(){
		/*Appeler observer pour obtenir le modèle
		*Une fois le modèle obtenu, créer la grille d'affichage
		*/
	}
	
	private void initialiserGrille(MPartie partie){}
	
	
}
