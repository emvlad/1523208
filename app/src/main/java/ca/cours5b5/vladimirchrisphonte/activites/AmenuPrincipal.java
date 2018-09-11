package ca.cours5b5.vladimirchrisphonte.activites;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import ca.cours5b5.vladimirchrisphonte.R;

public class AmenuPrincipal extends Activite {

    private Button btnGoAct ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);

        this.btnGoAct = findViewById(R.id.btnGo);

        btnGoAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent otherAct = new Intent(getApplicationContext(),Aparametres.class);
                startActivity(otherAct);

                finish();

            }

        });
    }
}
