package ca.cours5b5.vladimirchrisphonte.vues;


import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

public abstract class Vue extends ConstraintLayout {
    public Vue(Context context) {
        super(context);
    }

    public Vue(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Vue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        Log.d("Atelier04", this.getClass().getSimpleName() + "::" +  "onFinishInflate");
    }
    public abstract void onItemSelected(AdapterView<?> parent, View view, int position, long id);

    public abstract void onNothingSelected(AdapterView<?> parent);
}