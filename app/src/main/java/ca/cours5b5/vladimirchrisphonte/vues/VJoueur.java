package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.util.AttributeSet;



public class VJoueur extends android.support.v7.widget.AppCompatTextView {

    public VJoueur(Context context) {
        super(context);
    }

    public VJoueur(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VJoueur(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }

    public void changerCouleurDeFond(int idCouleur) {

        setBackgroundColor(getResources().getColor(idCouleur, null));

    }
}
