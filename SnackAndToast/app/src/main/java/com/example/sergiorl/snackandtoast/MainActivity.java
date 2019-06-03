package com.example.sergiorl.snackandtoast;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button[] buttons;
    private int idBtns[] = {R.id.btnTst, R.id.btnSnk};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new Button[2];
        for (int i = 0; i < idBtns.length; i++){
            buttons[i] = (Button) findViewById(idBtns[i]);
        }

    buttons[0].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText( MainActivity.this, "I'm a Toast", Toast.LENGTH_SHORT).show();
        }
    });

        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Esto es una prueba", Snackbar.LENGTH_LONG).setAction("Press", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText( MainActivity.this, "You pressed the Snackbar button", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

    }
}
