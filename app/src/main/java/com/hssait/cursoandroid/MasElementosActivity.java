package com.hssait.cursoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MasElementosActivity extends Activity{

    RadioGroup group;
    RadioButton rbtn;
    TextView lblResultado;
    CheckBox cb1, cb2, cb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_elementos);

        lblResultado = (TextView)findViewById(R.id.lblResultado);
        group = (RadioGroup)findViewById(R.id.radioGroup);
        cb1   = (CheckBox)findViewById(R.id.cbOpcion4);
        cb2   = (CheckBox)findViewById(R.id.cbOpcion5);
        cb3   = (CheckBox)findViewById(R.id.cbOpcion6);
    }

    public String RadioButtonSeleccionado() {
        int _id = group.getCheckedRadioButtonId();
        rbtn = (RadioButton)findViewById(_id);
        return rbtn.getText().toString();
    }

    public String CheckBoxSeleccionados(){
        String valores = "";

        if (cb1.isChecked()){
            valores += cb1.getText().toString() + " ";
        }
        if (cb2.isChecked()){
            valores += cb2.getText().toString() + " ";
        }
        if (cb3.isChecked()){
            valores += cb3.getText().toString();
        }

        return valores;
    }

    public void MostrarResultado(View view){
        lblResultado.setText( RadioButtonSeleccionado() + " " + CheckBoxSeleccionados() );
    }


}
