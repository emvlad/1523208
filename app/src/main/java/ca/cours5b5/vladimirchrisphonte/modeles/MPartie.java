package ca.cours5b5.vladimirchrisphonte.modeles;

import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurSerialisation;
import ca.cours5b5.vladimirchrisphonte.global.GCouleur;
import ca.cours5b5.vladimirchrisphonte.serialisation.AttributSerialisable;


public class MPartie extends Modele{

    @AttributSerialisable
	public MParametresPartie parametres;
	
	private final String __parametres ="parametres";
	
	
	public MPartie(MParametresPartie parametres){
		
	}
	
	public MParametresPartie getParametres(){
		return null;
	}
	
	@Override
	public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {
		
		/*
		*not used for now
		*/
	}

	@Override
	public Map<String, Object> enObjetJson() throws ErreurSerialisation {
		return null;
	}
}
