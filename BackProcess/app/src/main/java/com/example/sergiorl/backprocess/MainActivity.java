package com.example.sergiorl.backprocess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnTareaSegundoPlano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTareaSegundoPlano = (Button) findViewById(R.id.btnTareaSegundoPlano);
        btnTareaSegundoPlano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PercentTwo(MainActivity.this).execute("Carga Finalizada X2");
            }
        });
    }
}