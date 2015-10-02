package com.hssait.cursoandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.hssait.cursoandroid.modelo.Usuario;

public class MainActivity extends Activity {

    //Declaracion
    private Button btnAceptar;
    private EditText txtUser, txtPass;
    String usuario, contrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignacion/Inicializacion
        btnAceptar = (Button) findViewById(R.id.btnAceptarMain);
        txtUser    = (EditText) findViewById(R.id.txtUsuario);
        txtPass    = (EditText) findViewById(R.id.txtContrasenia);
    }

    public boolean ValidarCredenciales() {
        usuario = txtUser.getText().toString();
        contrasenia = txtPass.getText().toString();
        return (new Select().from(Usuario.class)
                .where("usuario = ? AND clave = ?", usuario, contrasenia).executeSingle()) != null;
    }

    //onClick btnAceptarMain
    public void AceptarMain(View view){
        Saludar(ValidarCredenciales());
    }

    private void Saludar(boolean valor) {
        if (valor){
            Toast.makeText(getApplicationContext(),"Bienvenido " + usuario,
                    Toast.LENGTH_SHORT).show();
            LanzarSegundaActividad();
        }else{
            Toast.makeText(MainActivity.this, "Error Usuario/Contraseña",
                    Toast.LENGTH_LONG).show();
            LimpiarValores();
        }
    }

    private void LimpiarValores() {
        txtUser.getText().clear();
        txtPass.getText().clear();
    }

    private void LanzarSegundaActividad() {
        Intent i = new Intent(getApplicationContext(),SegundaActivity.class);
        startActivity(i);
        finish();
    }

    public void LanzarRegistroUsuario(View view){
        Intent i = new Intent(getApplicationContext(),RegistroActivity.class);
        startActivity(i);
        LimpiarValores();
    }
}
