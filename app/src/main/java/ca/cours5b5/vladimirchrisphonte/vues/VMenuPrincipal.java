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

    private Button boutonParametres;
    private Action actionParametres;

    private Button boutonPartie;
    private Action actionPartie;

    private Button boutonConnexion;
    private Action actionConnexion;

    private Button boutonDeConnexion;
    private Action actionDeConnexion;

    private Button boutonPartieReseau;
    private Action actionPartieReseau;

    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        recupererControles();

        demanderActions();

        installerListeners();
        initialiserConnexionInputs();

    }


    private void recupererControles() {

        boutonParametres = findViewById(R.id.bouton_parametres);
        boutonPartie = findViewById(R.id.bouton_partie);

        boutonConnexion = findViewById(R.id.button_connexion);
        boutonDeConnexion = findViewById(R.id.button_deconnexion);

        boutonPartieReseau = findViewById(R.id.button_partieReseau);

    }

    private void demanderActions() {

        actionParametres = ControleurAction.demanderAction(GCommande.OUVRIR_MENU_PARAMETRES);
        actionPartie = ControleurAction.demanderAction(GCommande.DEMARRER_PARTIE);

        actionConnexion =  ControleurAction.demanderAction(GCommande.CONNEXION);
        actionDeConnexion =  ControleurAction.demanderAction(GCommande.DECONNEXION);
        actionPartieReseau = ControleurAction.demanderAction(GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU);

    }

    private void installerListeners() {

        installerListenerParametres();
        installerListenerPartie();

        installerListenerConnexion();
        installerListenerDeconnexion();
        installerListenerPartieReseau();

    }

    private void installerListenerPartie() {

        boutonPartie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPartie.executerDesQuePossible();
            }
        });

    }

    private void installerListenerParametres() {

        boutonParametres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionParametres.executerDesQuePossible();
            }
        });

    }

    private void installerListenerConnexion() {

        boutonConnexion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionConnexion.executerDesQuePossible();
            }
        });

    }
    private void installerListenerDeconnexion() {

        boutonDeConnexion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionDeConnexion.executerDesQuePossible();
            }
        });

    }

    private void installerListenerPartieReseau() {

        boutonPartieReseau.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPartieReseau.executerDesQuePossible();
            }
        });

    }

    public void initialiserConnexionInputs() {

        boutonConnexion.setOnClickListener(null);

        if (UsagerCourant.siUsagerConnecte()) {
            installerListenerDeconnexion();
            boutonConnexion.setText(R.string.deconnexion);
        } else {
            installerListenerConnexion();
            boutonConnexion.setText(R.string.connexion);
        }

    }

}


