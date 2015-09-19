package com.hssait.cursoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class SegundaActivity extends Activity {

    //Declaracion
    Button btnSpinner, btnListView, btnMas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //Asignacion
        btnSpinner = (Button)findViewById(R.id.btnSpinner);
        btnListView = (Button)findViewById(R.id.btnListView);
        btnMas = (Button)findViewById(R.id.btnMasElementos);
    }
}
