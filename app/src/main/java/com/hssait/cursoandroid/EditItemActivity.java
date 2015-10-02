package com.hssait.cursoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.activeandroid.query.Update;
import com.hssait.cursoandroid.modelo.Item;

public class EditItemActivity extends Activity {

    EditText txtItem;
    Bundle bundle;
    String item = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        bundle = getIntent().getExtras();
        txtItem = (EditText) findViewById(R.id.txtModificarItem);
        item = bundle.get("item").toString();
        PoblarCampos();
    }

    private void PoblarCampos() {
        txtItem.setText(item);
    }

    public void ModificarItem(View view){
        String valor = txtItem.getText().toString();
        new Update(Item.class).set("nombre = ?", valor).where("nombre = ?", item).execute();
        finish();
    }

    public void Salir(View view){
        finish();
    }

}
