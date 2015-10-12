package com.hssait.cursoandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
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

    public void LanzarNoticiasActivity(View view){
        Intent i = new Intent(getApplicationContext(), NoticiasActivity.class);
        startActivity(i);
    }

}
