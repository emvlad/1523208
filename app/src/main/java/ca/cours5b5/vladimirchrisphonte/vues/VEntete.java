package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.Display;
import android.widget.Toast;

public class VEntete extends AppCompatButton {
	
	
	private int colonne;

	//constructeurs
	public VEntete(Context context){
		 super(context);
	}
	public VEntete(Context context, AttributeSet attrs)	{
		  super(context, attrs);
	}

	public VEntete(Context context, AttributeSet attrs, int defStyleAttr )	{
		super(context, attrs, defStyleAttr);
	}
	
	public VEntete(Context context, int colonne){
		super(context);

		// afficher le numéro de la colonne!

		for(int i = 0; i < colonne; i++)
		    Toast.makeText(getContext(), i, Toast.LENGTH_SHORT).show();


	}
	
	
	
}