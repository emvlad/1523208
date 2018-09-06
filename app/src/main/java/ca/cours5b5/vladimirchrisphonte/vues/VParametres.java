package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;

import android.util.AttributeSet;

import android.widget.ArrayAdapter;
import android.widget.Spinner;


import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.global.GConstants;

public class VParametres extends Vue {


    public VParametres(Context context) {
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

       // Log.d("Atelier03", this.getClass().getSimpleName() + "::onFinishInflate");

        Spinner spinnerLarger = this.findViewById(R.id.spinLargeur);
        ArrayAdapter<Integer> adapterLarger = new ArrayAdapter<>(this.getContext(),
                R.layout.support_simple_spinner_dropdown_item);

        spinnerLarger.setAdapter(adapterLarger);

        for (int i = GConstants.LARGEUR_MIN; i <= GConstants.LARGEUR_MAX; i++) {
            adapterLarger.add(i);
        }
        spinnerLarger.setSelection(GConstants.LAREUR_DEFAUT);


        //hauteur
        Spinner spinnerHauteur = this.findViewById(R.id.spinHauteur);
        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(),
                R.layout.support_simple_spinner_dropdown_item);

        spinnerHauteur.setAdapter(adapterHauteur);
        for (int j = GConstants.HAUTEUR_MIN; j <= GConstants.HAUTEUR_MAX; j++) {
            adapterHauteur.add(j);
        }
        spinnerHauteur.setSelection(GConstants.HAUTEUR_DEFAUT);


        //Win
        Spinner spinnerWin = this.findViewById(R.id.spinGagner);
        ArrayAdapter<Integer> adapterGagner = new ArrayAdapter<>(this.getContext(),
                R.layout.support_simple_spinner_dropdown_item);

        spinnerWin.setAdapter(adapterGagner);

        for (int i = GConstants.GAGNER_MIN; i <= GConstants.GAGNER_MAX; i++) {
            adapterGagner.add(i);
        }
        spinnerWin.setSelection(GConstants.GAGNER_DEFAUT);

    }

}
