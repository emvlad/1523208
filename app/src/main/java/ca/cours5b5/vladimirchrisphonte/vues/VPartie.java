package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurObservation;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametresPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.MPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;

public class VPartie extends Vue {

    public VGrille grille = findViewById(R.id.vgrille);

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


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ControleurObservation.observerModele(MPartie.class.getSimpleName(), new ListenerObservateur() {
            @Override
            public void reagirChangementAuModele(Modele modele) {
                MPartie partie = (MPartie) modele;
                MParametresPartie parametresPartie = partie.getParametres();

                int hauteur = parametresPartie.getHauteur();
                int largeur = parametresPartie.getLargeur();

                grille.creerGrille(hauteur, largeur);
            }

            @Override
            public void reagirNouveauModele(Modele modele) {

            }


        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }

    private void initialiser(){

    }


    //méthodes
    private void observerPartie() {
        /*
         *Appeler observer pour obtenir le modèle
         * Une fois le modèle obtenu, créer la grille d'affichage
         */


    }

    private MPartie getPartie(Modele modele) {
        return null;
    }

    private void initialiserGrille(MPartie partie) {

    }

}

