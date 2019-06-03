package com.example.sergiorl.controlesgraficosi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class textInput extends AppCompatActivity {

    private CheckBox checkBox;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);

        checkBox = (CheckBox)findViewById(R.id.checkbox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBox.setText("Marcado el checkbox esta");
                } else {
                    checkBox.setText("Desmarcado el checkbox esta");
                }
            }
        });

    }

    public void rdBtnClicked(View view){
        textView = (TextView)findViewById(R.id.textView);
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.rdBtn1:
                if (checked){
                    textView.setText("First radio button was selected");
                }
            break;
            case R.id.rdBtn2:
                if (checked){
                    textView.setText("Second radio button was selected");
                }
            break;
        }
    }

    public void launch2ndAct(View view){
        Intent intentSA = new Intent(this, rdBtns.class);
        startActivity(intentSA);
        finish();
    }

    public void launch1stAct(View view) {
        Intent intentFA = new Intent(this, buttons.class);
        startActivity(intentFA);
        finish();
    }
}
