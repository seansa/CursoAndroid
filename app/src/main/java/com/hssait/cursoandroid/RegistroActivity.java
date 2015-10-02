package com.hssait.cursoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.hssait.cursoandroid.modelo.Persona;
import com.hssait.cursoandroid.modelo.Usuario;

public class RegistroActivity extends Activity {

    EditText txtUsuario, txtClave, txtNombre, txtApellido, txtEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtApellido = (EditText)findViewById(R.id.txtApellidoRegistro);
        txtNombre   = (EditText)findViewById(R.id.txtNombreRegistro);
        txtClave    = (EditText)findViewById(R.id.txtClaveRegistro);
        txtUsuario  = (EditText)findViewById(R.id.txtUsuarioRegistro);
        txtEdad     = (EditText)findViewById(R.id.txtEdadRegistro);

    }

    public void RegistrarUsuario(View view) {
        String usuario = txtUsuario.getText().toString();
        Usuario u = new Select().from(Usuario.class).where("usuario = ?", usuario).executeSingle();

        if (u != null){
            Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
        }else{
            Registrar(usuario);
            finish();
        }
    }

    private void Registrar(String user) {
        String apellido = txtApellido.getText().toString();
        String nombre = txtNombre.getText().toString();
        String clave = txtClave.getText().toString();
        int edad = Integer.parseInt(txtEdad.getText().toString());

        Usuario u  = new Usuario();
        u.usuario  = user;
        u.clave    = clave;
        u.persona  = new Persona();
        u.persona.apellido = apellido;
        u.persona.nombre   = nombre;
        u.persona.edad     = edad;
        u.persona.save();
        u.save();
    }
}
