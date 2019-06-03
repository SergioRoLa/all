package com.example.sergiorl.controlesgraficosi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class buttons extends AppCompatActivity {

    private TextView textView;
    private Button[] buttons;
    private ImageButton imageButton;
    private ToggleButton toggleButton;
    private Switch aSwitch;
    private Integer btnsId[] = {R.id.simpleBtn, R.id.btnWithIcon, R.id.btnAccept, R.id.btnCancel};
    private String btnMessages[] = {"Ah, me presionaste", "No me apagues D:", "Aceptaste terminos y condiciones", "Cancelastes oyes :c"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        instanceButtonsAndTextView();
        actionButtons();
    }

    public void instanceButtonsAndTextView(){
        textView = (TextView) findViewById(R.id.txtView);
        buttons = new Button[4];
        for (int i = 0; i<btnsId.length; i++){
            buttons[i] = (Button) findViewById(btnsId[i]);
        }
        imageButton = (ImageButton) findViewById(R.id.imgBtn);
        toggleButton = (ToggleButton) findViewById(R.id.tglBtn);
        aSwitch = (Switch) findViewById(R.id.swt);
    }

    public void actionButtons(){
        for (int i = 0; i < btnMessages.length; i++){
            final int j = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(btnMessages[j]);
                }
            });
        }
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Starting system buddy");
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    textView.setText("Toggle button has been presionado");
                } else {
                    textView.setText("Toggle button has been despresionado");
                }
            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    textView.setText("Switch has been encendido");
                } else {
                    textView.setText("Switch has been desencendido");
                }
            }
        });
    }

    public void launch2ndAct(View view){
        Intent intentSA = new Intent(this, rdBtns.class);
        startActivity(intentSA);
        finish();
    }

    public void launch3rdAct(View view){
        Intent intentTA = new Intent(this, textInput.class);
        startActivity(intentTA);
        finish();
    }

}
