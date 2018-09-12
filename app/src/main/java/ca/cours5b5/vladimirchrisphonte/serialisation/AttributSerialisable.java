package ca.cours5b5.vladimirchrisphonte.serialisation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//Identifie les attributs à sérialiser
public @Retention(RetentionPolicy.RUNTIME)@interface AttributSerialisable {

}



/*
Rem: L'annotation @Retention(RetentionPolicy.RUNTIME) est nécessaire
     (par défaut, les annotations sont effacées après la compilation).
 */