package com.hssait.cursoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    //Declaracion
    private Button btnAceptar;
    private EditText txtUser, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignacion/Inicializacion
        btnAceptar = (Button)findViewById(R.id.btnAceptarMain);
        txtUser    = (EditText)findViewById(R.id.txtUsuario);
        txtPass    = (EditText)findViewById(R.id.txtContrasenia);
    }
}
