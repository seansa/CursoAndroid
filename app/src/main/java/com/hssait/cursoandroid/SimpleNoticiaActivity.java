package com.hssait.cursoandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.androidquery.AQuery;

public class SimpleNoticiaActivity extends Activity {

    AQuery aQuery;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_noticia);
        aQuery = new AQuery(this);
        bundle = getIntent().getExtras();
        CargarDatos();
    }

    public void CargarDatos() {
        aQuery.id(R.id.lblNoticiaTitulo).getTextView().setText(bundle.getString("Titulo"));
        aQuery.id(R.id.imgNoticia).image(bundle.getString("url"));
        aQuery.id(R.id.imgNoticia).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(bundle.getString("urlNoticia")));
                startActivity(i);
            }
        });
    }
}
