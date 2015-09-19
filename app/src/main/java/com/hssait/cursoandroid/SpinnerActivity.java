package com.hssait.cursoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerActivity extends Activity {

    private Spinner spinnerOpciones, spinnerValores;
    private ArrayList<String> primero, segundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinnerOpciones = (Spinner)findViewById(R.id.spinnerOpciones);
        spinnerValores = (Spinner)findViewById(R.id.spinnerValores);
        primero = new ArrayList<>();
        segundo = new ArrayList<>();

        CargarListas();
        InicializarSpinners();
    }

    private void InicializarSpinners() {

        ArrayAdapter<String> adapterOpciones = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, primero);

        ArrayAdapter<String> adapterValores = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, segundo);

        spinnerOpciones.setAdapter(adapterOpciones);
        spinnerValores.setAdapter(adapterValores);

    }

    private void CargarListas() {
        primero.add("Opcion 1");
        primero.add("Opcion 2");
        primero.add("Opcion 3");

        segundo.add("Valor 1");
        segundo.add("Valor 2");
        segundo.add("Valor 3");
    }

    public void MostrarValoresSpinners(View view){
        Toast.makeText(getApplicationContext(),
                        "\nSpinner Opciones : " + String.valueOf(spinnerOpciones.getSelectedItem())+
                        "\nSpinner Valores : " + String.valueOf(spinnerValores.getSelectedItem()),
                Toast.LENGTH_LONG).show();
    }
}
