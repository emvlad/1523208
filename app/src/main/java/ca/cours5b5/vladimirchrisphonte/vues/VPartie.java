package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.util.AttributeSet;
<<<<<<< HEAD
import android.widget.ArrayAdapter;

import ca.cours5b5.vladimirchrisphonte.R;
=======
import android.util.Log;
import android.widget.AdapterView;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurObservation;
>>>>>>> devDroAway
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametresPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.MPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;

<<<<<<< HEAD
import static ca.cours5b5.vladimirchrisphonte.controleurs.ControleurObservation.observerModele;


public class VPartie extends Vue{

    private MPartie grille ;

    private MPartie partie;
    private ListenerObservateur listenerObservateur;
=======
public class VPartie extends Vue {

    public VGrille grille = findViewById(R.id.vgrille);
>>>>>>> devDroAway


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
<<<<<<< HEAD

       initialiserGrille(grille);

        observerPartie();


    }

=======
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
        public AdapterView.OnItemSelectedListener(AdapterView<?>parent, View view, int position, long id){

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }

    private void initialiser(){

    }

>>>>>>> devDroAway

    //méthodes
    private void observerPartie() {
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

<<<<<<< HEAD
    private  void initialiserGrille(MPartie partie){
        ArrayAdapter<Integer> grillAdapter = new ArrayAdapter<>(getContext(), R.layout.activity_apartie);

        //.....uncompleted

        //grille.setAdapter(grillAdapter);

=======
    private void initialiserGrille(MPartie partie) {
>>>>>>> devDroAway

    }

}



