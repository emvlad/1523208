package ca.cours5b5.vladimirchrisphonte.controleurs;

import ca.cours5b5.vladimirchrisphonte.global.GCouleur;

public class ControleurPartie {


    private static final ControleurPartie instance = null;

    private ControleurPartie() {

    }

    public static ControleurPartie getInstance() {
        return instance;
    }


    public void gagnerPartie(GCouleur couleurGagnante) {
        /*
         * Utiliser une action pour afficher le message au gagnant:
         *
         * String message = //
            View maVue = //
            Snackbar fenetreMessage = Snackbar.make(maVue, message, Snackbar.LENGTH_SHORT);
            fenetreMessage.show();

            ======================
                   On peut aussi ajouter un listener pour réagir à la fenêtre qui disparaît
                    Snackbar fenetreMessage = Snackbar.make(maVue, message, Snackbar.LENGTH_SHORT);
                    fenetreMessage.addCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                    // Le message n'est plus affiché
                    });
                    fenetreMessage.show();
         */
    }
}
