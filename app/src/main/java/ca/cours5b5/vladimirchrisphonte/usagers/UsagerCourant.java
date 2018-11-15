package ca.cours5b5.vladimirchrisphonte.usagers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UsagerCourant {


    public static boolean siUsagerConnecte(){

       boolean usagerConnected = false;

        FirebaseUser usagerFirebase = FirebaseAuth.getInstance().getCurrentUser();

        if(usagerFirebase != null){

            usagerConnected = true;
        }

        return usagerConnected;
    }


    public static String getId(){

      String   idUsagerCourant = "default" ;

        if(siUsagerConnecte()){

            idUsagerCourant = FirebaseAuth.getInstance().getCurrentUser().getUid();
        }

    return idUsagerCourant;

    }





}
