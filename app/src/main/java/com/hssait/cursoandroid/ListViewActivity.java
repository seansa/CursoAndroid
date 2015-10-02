package com.hssait.cursoandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.hssait.cursoandroid.modelo.Item;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView lista;
    private EditText txtItem;
    private List<String> items;
    private ArrayAdapter<String> adapter;
    public boolean eliminado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        txtItem = (EditText) findViewById(R.id.txtItemListView);
        lista = (ListView) findViewById(R.id.listaItems);
        items = new ArrayList<>();

        InicializarLista();
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        String itemNombre = (String) lista.getItemAtPosition(position);
        Alerta(itemNombre);
    }

    public void Alerta(final String nombre){
        AlertDialog.Builder builder = new AlertDialog.Builder(ListViewActivity.this);
        builder.setMessage("¿Eliminar Item?")
                .setTitle("Eliminar")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Usar esta forma, filtrando por el ID
                        //new Delete().from(Item.class).where("nombre = ?", nombre).execute();
                        Item i = new Select().from(Item.class)
                                .where("nombre = ?", nombre).executeSingle();
                        i.delete();
                        items.remove(nombre);
                        adapter.notifyDataSetChanged();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        builder.create();
        builder.show();

    }

    private void InicializarLista() {
        List<Item> valores = new Select().from(Item.class).execute();
        for (Item i : valores) {
            items.add(i.nombre);
        }
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);
        lista.setAdapter(adapter);
    }

    public void AgregarItem(View view) {
        String item = txtItem.getText().toString();
        if (!item.isEmpty()) {
            Item i = new Item();
            i.nombre = item;
            i.save();
            items.add(item);
            LimpiarTexto();
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(ListViewActivity.this, "Debe ingresar un item",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void LimpiarTexto() {
        txtItem.getText().clear();
    }
}
