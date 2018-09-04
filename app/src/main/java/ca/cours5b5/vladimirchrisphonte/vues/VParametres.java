package ca.cours5b5.vladimirchrisphonte.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import ca.cours5b5.vladimirchrisphonte.R;

public class VParametres extends ConstraintLayout {


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

        for (int i = 0; i < 5; i++) {
            adapterLarger.add(i);
        }
        spinnerLarger.setSelection(0);


        //hauteur
        Spinner spinnerHauteur = this.findViewById(R.id.spinHauteur);
        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(),
                R.layout.support_simple_spinner_dropdown_item);

        spinnerHauteur.setAdapter(adapterHauteur);
        for (int j = 0; j < 5; j++) {
            adapterHauteur.add(j);
        }
        spinnerHauteur.setSelection(0);


        //Win
        Spinner spinnerWin = this.findViewById(R.id.spinGagner);
        ArrayAdapter<Integer> adapterGagner = new ArrayAdapter<>(this.getContext(),
                R.layout.support_simple_spinner_dropdown_item);

        spinnerWin.setAdapter(adapterGagner);

        for (int i = 0; i < 5; i++) {
            adapterGagner.add(i);
        }
        spinnerWin.setSelection(0);

    }

}
