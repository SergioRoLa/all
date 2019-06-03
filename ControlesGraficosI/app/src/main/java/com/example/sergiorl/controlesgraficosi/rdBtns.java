package com.example.sergiorl.controlesgraficosi;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class rdBtns extends AppCompatActivity {

    private EditText txtV;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rd_btns);

        txtV = (EditText)findViewById(R.id.txtIn);
        txtView = (TextView)findViewById(R.id.txtMessage);

        txtV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    if (Float.parseFloat(s.toString()) % 2 == 0){
                        txtView.setText("Es par");
                    } else {
                        txtView.setText("Es impar, ingresa uno par");
                    }
                } catch (Exception e){
                    txtView.setText("Ingresa un numero");
                    Toast.makeText(rdBtns.this, "Ingresa un numero", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void launch1stAct(View view){
        Intent intentSA = new Intent(this, buttons.class);
        startActivity(intentSA);
        finish();
    }

    public void launch3rdAct(View view) {
        Intent intentTA = new Intent(this, textInput.class);
        startActivity(intentTA);
        finish();
    }


}
