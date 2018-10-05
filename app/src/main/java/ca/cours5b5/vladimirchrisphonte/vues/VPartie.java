package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurObservation;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.vladimirchrisphonte.modeles.MPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;

import static ca.cours5b5.vladimirchrisphonte.controleurs.ControleurObservation.observerModele;


public class VPartie extends Vue{

    private MPartie grille  ;
    private MPartie partie;

    private ListenerObservateur listenerObservateur;


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

       initialiserGrille(grille);

        observerPartie();


    }


    //méthodes
    private void observerPartie(){
        /*
        *Appeler observer pour obtenir le modèle
        * Une fois le modèle obtenu, créer la grille d'affichage
         */
        observerModele(MPartie.class.getSimpleName(), listenerObservateur);

        initialiserGrille(partie);



    }

    private MPartie getPartie(Modele modele) {

       modele = this.partie;

        return (MPartie) modele;
    }

    private  void initialiserGrille(MPartie partie){
        ArrayAdapter<Integer> adapterGrille = new ArrayAdapter<>(getContext(), R.layout.activity_apartie);

        //.....uncompleted


    }



}
