package com.hssait.cursoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.hssait.cursoandroid.modelo.Item;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView lista;
    private EditText txtItem;
    private List<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        txtItem   = (EditText)findViewById(R.id.txtItemListView);
        lista     = (ListView)findViewById(R.id.listaItems);
        items     = new ArrayList<>();

        InicializarLista();
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            String itemNombre = (String) lista.getItemAtPosition(position);

            Toast.makeText(getApplicationContext(),
                    "Posicion : " + position + " Item : " + itemNombre ,Toast.LENGTH_LONG).show();
    }

    private void InicializarLista() {
        List<Item> valores = new Select().from(Item.class).execute();
        for(Item i: valores){
            items.add(i.nombre);
        }
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);
        lista.setAdapter(adapter);
    }

    public void AgregarItem(View view){
        String item = txtItem.getText().toString();
        if (!item.isEmpty()){
            Item i = new Item();
            i.nombre = item;
            i.save();
            items.add(item);
            LimpiarTexto();
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText(ListViewActivity.this, "Debe ingresar un item",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void LimpiarTexto() {
        txtItem.getText().clear();
    }
}
