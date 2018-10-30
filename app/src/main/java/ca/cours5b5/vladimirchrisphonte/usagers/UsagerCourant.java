package ca.cours5b5.vladimirchrisphonte.usagers;

public class UsagerCourant {

    private static String usagerCourant;

    public static boolean siUsagerConnecte(){

       boolean usagerConnect = false;
        /*
         * Retourne vrai si l'usager est connecté
         *
         * Utiliser FirebaseAuth
         *
         */
        String fireBaseAuthConnect = null;

        if(fireBaseAuthConnect != null){

            usagerConnect = true;
        }


        return usagerConnect;
    }


    public static String getId(){

      String   idUsagerCourant=null;
        /*
         * Retourne l'identifiant de l'usager connecté
         * Sinon retourner un ID par défaut
         *
         * Utiliser FirebaseAuth
         *
         */
        if(siUsagerConnecte()){

            idUsagerCourant="Id_FirebaseAuth?";
        }

    return idUsagerCourant;

    }


    /*Code pour réagir à la fin de la connexion (à ajouter à une activité):
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CODE_CONNEXION_FB ) {

            if (resultCode == RESULT_OK) {

                // Connexion réussie

            } else {

                // connexion échouée
            }
        }
    }

*/
/*Code pour la connexion (à ajouter dans une activité):

List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());

Intent intentionConnexion = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(fournisseursDeConnexion)
            .build();

this.startActivityForResult(intentionConnexion, CODE_CONNEXION_FB );
 */

/*Code pour la déconnexion

AuthUI.getInstance()
        .signOut(this)
        .addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@NonNull Task<Void> task) {

                // Déconnexion terminée
            }
        });


 */
/*
    Firebase: écrire dans la base de données

    *L'usager doit être authentifié pour accéder à la base de données

  * Votre base de données est un arbre Json
  * 1-Pour écrire il faut un chemin vers un noeud et une valeur
  * 2-Pour détruire la valeur il faut le chemin vers le noeud
  * **
  * Pour obtenir le noeud:

     String chemin = //
            DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(chemin);

        * Pour écrire une valeur:
             Map<String, Object> objetJson = //
             noeud.setValue(objetJson);

             * Ensuite, on demande de détruire ce noeud:
             * * ATTENTION: tout les sous-noeuds sont aussi détruits
                noeud.removeValue();




*/


}
