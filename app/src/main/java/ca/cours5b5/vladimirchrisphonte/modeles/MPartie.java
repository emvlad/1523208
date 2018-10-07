package ca.cours5b5.vladimirchrisphonte.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurSerialisation;
import ca.cours5b5.vladimirchrisphonte.global.GCouleur;
import ca.cours5b5.vladimirchrisphonte.serialisation.AttributSerialisable;


public class MPartie extends Modele{

    @AttributSerialisable
	public MParametresPartie parametres;
	
	private final String __parametres ="parametres";
	
	
	public MPartie(MParametresPartie parametres){

		this.parametres = parametres;


	}
	
	public MParametresPartie getParametres(){

		return this.parametres;
	}
	
	@Override
	public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {
		
		/*
		*not used for now
		*
		*   for(Map.Entry<String, Object> entry : objetJson.entrySet()){

            String chaineValeur = (String) entry.getValue();
		*/
	}

	@Override
	public Map<String, Object> enObjetJson() throws ErreurSerialisation {

		Map<String, Object> objetJson = new HashMap<>();

		//objetJson.put(__hauteur, hauteur.toString());


		return objetJson;
	}
}
