package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.vladimirchrisphonte.modeles.MPartie;

public class VPartie extends Vue{


    //constructeurs
    public VPartie(Context context) {
        super(context);
    }

    public VPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //méthodes
    private void observerPartie(){
        /*
        *Dans reagirChangementAuModle,
        * on veut rafraichîr la grille
         */

    }

    private  void miseAJourGrille(MPartie partie){

    }



}
