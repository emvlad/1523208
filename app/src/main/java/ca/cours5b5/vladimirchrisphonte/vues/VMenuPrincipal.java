package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.controleurs.Action;
import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurAction;
import ca.cours5b5.vladimirchrisphonte.global.GCommande;
import ca.cours5b5.vladimirchrisphonte.usagers.UsagerCourant;


public class VMenuPrincipal extends Vue {



    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Button boutonParametres;
    private Action actionParametres;

    private Button boutonPartie;
    private Action actionPartie;

    private Button boutonPartieReseau;
    private Action actionPartieReseau;

    private Button boutonConnexion;
    private Action actionConnexion;
    private Action actionDeconnexion;


    private Button boutonChangLangue;
    private Action actionChangLangue;


    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        recupererControles();

        demanderActions();

        installerListeners();

        ajusterTexteConnexionDeconnexion();

    }


    private void recupererControles() {

        boutonParametres = findViewById(R.id.bouton_parametres);

        boutonPartie = findViewById(R.id.bouton_partie);

        boutonPartieReseau = findViewById(R.id.bouton_partie_reseau);

        boutonConnexion = findViewById(R.id.bouton_connexion);

        boutonChangLangue = findViewById(R.id.bouton_chang_langue);



    }

    private void demanderActions() {

        actionParametres = ControleurAction.demanderAction(GCommande.OUVRIR_MENU_PARAMETRES);

        actionPartie = ControleurAction.demanderAction(GCommande.DEMARRER_PARTIE);

        actionPartieReseau = ControleurAction.demanderAction(GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU);

        actionConnexion = ControleurAction.demanderAction(GCommande.CONNEXION);

        actionDeconnexion = ControleurAction.demanderAction(GCommande.DECONNEXION);

        actionChangLangue = ControleurAction.demanderAction(GCommande.CHANGE_LANGUE);

    }


    private void installerListeners() {

        boutonParametres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionParametres.executerDesQuePossible();
            }
        });

        boutonPartie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                actionPartie.executerDesQuePossible();
            }
        });

        boutonPartieReseau.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                actionPartieReseau.executerDesQuePossible();
            }
        });

        boutonChangLangue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                actionChangLangue.executerDesQuePossible();

            }
        });

        boutonConnexion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!UsagerCourant.siUsagerConnecte()){

                    actionConnexion.executerDesQuePossible();
                    boutonConnexion.setText(R.string.deconnexion);

                }else{

                    actionDeconnexion.executerDesQuePossible();
                    boutonConnexion.setText(R.string.connexion);

                }

            }
        });
    }


    private void ajusterTexteConnexionDeconnexion() {
        if(UsagerCourant.siUsagerConnecte()){

            boutonConnexion.setText(R.string.deconnexion);

        }else{

            boutonConnexion.setText(R.string.connexion);

        }
    }

}
