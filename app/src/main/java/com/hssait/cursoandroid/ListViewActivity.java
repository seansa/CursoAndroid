package com.hssait.cursoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends Activity {

    private ListView lista;
    private Button btnAgrega;
    private EditText txtItem;
    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        btnAgrega = (Button)findViewById(R.id.btnAgregarItemListView);
        txtItem   = (EditText)findViewById(R.id.txtItemListView);
        lista     = (ListView)findViewById(R.id.listaItems);
        items = new ArrayList<>();

        InicializarLista();
    }

    private void InicializarLista() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, items);
        lista.setAdapter(adapter);
    }
}
