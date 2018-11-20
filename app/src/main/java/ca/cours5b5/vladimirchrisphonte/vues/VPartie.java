package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.util.AttributeSet;



import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurObservation;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurObservation;
import ca.cours5b5.vladimirchrisphonte.global.GCouleur;
import ca.cours5b5.vladimirchrisphonte.modeles.MGrille;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametresPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.MPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;


public abstract class VPartie extends Vue {



    private VGrille grille;
    private List<VJoueur> joueurs;
    private VJoueur joueur1, joueur2;


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

        initialiser();
        initialiserJoueurs();
        observerPartie();

    }

    private void initialiser() {

        grille = findViewById(R.id.grille);
        joueurs = new ArrayList<>();

    }
    private void initialiserJoueurs() {
        joueurs.add(joueur1);
        joueurs.add(joueur2);


    }


    protected String getNomModele(){

        return MPartie.class.getSimpleName();


    }
    private void observerPartie() {

         ControleurObservation.observerModele(getNomModele(),new ListenerObservateur(){

            @Override
            public void reagirNouveauModele(Modele modele) {

                MPartie partie = getPartie(modele);

                preparerAffichage(partie);

                miseAJourGrille(partie);
                reagirChangementAuModele(modele);

            }

            @Override
            public void reagirChangementAuModele(Modele modele) {

                MPartie partie = getPartie(modele);

                miseAJourGrille(partie);
                miseAJourCouleurJoueurs(partie);

            }
        });
    }


    private void preparerAffichage(MPartie partie) {

        MParametresPartie parametresPartie = partie.getParametres();

        grille.creerGrille(parametresPartie.getHauteur(), parametresPartie.getLargeur());

    }

    private MPartie getPartie(Modele modele){

        try{

            return (MPartie) modele;

        }catch(ClassCastException e){

            throw new ErreurObservation(e);

        }

    }

    private void miseAJourGrille(MPartie partie){


        grille.afficherJetons(partie.getGrille());


    }

    private void reinitialiserAffichage(MPartie partie) {

        MParametresPartie parametresPartie = partie.getParametres();



    }

    public void verifierPartieFini(MPartie mPartie) {

        MGrille mGrille = mPartie.getGrille();

        int colonnesJouables = mGrille.getColonnes().size();

        for (int i = 0; i < mGrille.getColonnes().size(); i++) {


        }

        if (colonnesJouables == 0) {
            reagirPartieFini(mPartie);
        }

    }

    public void reagirPartieFini(MPartie mPartie) {

        mPartie.recommencerPartie();

        reinitialiserAffichage(mPartie);

        miseAJourGrille(mPartie);

        miseAJourCouleurJoueurs(mPartie);

    }

    private void miseAJourCouleurJoueurs(MPartie partie){


    }

    private void changerCouleurJoueur(int joueur, GCouleur gCouleur) {



}


    private int gCouleurACouleur(GCouleur gCouleur) {
        int couleur;
        switch (gCouleur){

            case ROUGE:

                couleur = R.color.ROUGE;
                break;

            case JAUNE:

                couleur = R.color.JAUNE;
                break;

            default:

                couleur = R.color.colorPrimary;
                break;
        }

        return couleur;
    }
}
