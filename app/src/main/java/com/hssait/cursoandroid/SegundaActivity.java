package com.hssait.cursoandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    public void LanzarSpinnerActivity(View view){
        Intent i = new Intent(getApplicationContext(), SpinnerActivity.class);
        startActivity(i);
    }
    public void LanzarListViewActivity(View view){
        Intent i = new Intent(getApplicationContext(), ListViewActivity.class);
        startActivity(i);
    }
    public void LanzarMasElementosActivity(View view){
        Intent i = new Intent(getApplicationContext(), MasElementosActivity.class);
        startActivity(i);
    }

}
