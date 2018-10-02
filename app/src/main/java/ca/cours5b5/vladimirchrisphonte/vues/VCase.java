package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import ca.cours5b5.vladimirchrisphonte.global.GCouleur;

public class VCase  extends AppCompatButton {

    //constructeurs
    public VCase(Context context) {
        super(context);
    }

    public VCase(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VCase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
	
	public VCase (Context context, int rangee, int colonne){
        super(context);
		
		/*
		*afficher la rangée et la colonne
		*changer la couleur de fond si désiré
		*/
	}
	

  //  public void afficherJeton(GCouleur jeton){

        /*
        * Changer la couleur de fond selon le jeton à afficher
         */

   // }

}
