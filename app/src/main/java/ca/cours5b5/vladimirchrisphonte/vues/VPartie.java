package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurObservation;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.vladimirchrisphonte.modeles.MPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;

public class VPartie extends Vue{

    public VGrille grille;


    //constructeurs
    public VPartie(Context context) {
        super(context);
    }

    public VPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr); }



    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    private void initialiser() {

    }


    //méthodes
    private void observerPartie(){
        /*
        *Appeler observer pour obtenir le modèle
        * Une fois le modèle obtenu, créer la grille d'affichage
         */

    }

    private MPartie getPartie(Modele nodle) {
        return null;
    }

    private  void initialiserGrille(MPartie partie){

    }



}
