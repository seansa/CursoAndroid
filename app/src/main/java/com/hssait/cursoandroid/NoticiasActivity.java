package com.hssait.cursoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.hssait.cursoandroid.modelo.Noticia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NoticiasActivity extends AppCompatActivity {

    AQuery aQuery;
    ArrayList<Noticia> noticias;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        aQuery = new AQuery(this);
        noticias = new ArrayList<>();

        aQuery.id(R.id.btnNoticias).clicked(this, "TraerNoticias");
        aQuery.id(R.id.listaNoticias).itemClicked(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), SimpleNoticiaActivity.class);
                for (Noticia n : noticias) {
                    if (n.titulo.compareTo(aQuery.id(R.id.listaNoticias)
                            .getListView().getItemAtPosition(position).toString())==0){
                        i.putExtra("Titulo", n.titulo);
                        i.putExtra("urlNoticia", n.urlNoticia);
                        i.putExtra("url", n.imgUrl);
                        break;
                    }
                }
                startActivity(i);
            }
        });
    }

    public void TraerNoticias(View view) {
        String url = "http://www.google.com/uds/GnewsSearch?q=" +
                aQuery.id(R.id.txtNoticias).getText().toString() + "&v=1.0";
        aQuery.ajax(url, JSONObject.class, this, "jsonCallback");
    }

    public void jsonCallback(String url, JSONObject json, AjaxStatus status) throws JSONException {

        if (json != null) {
            JSONObject data = json.getJSONObject("responseData");
            JSONArray jsonArray = data.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                System.out.println(i + "---_---");
                JSONObject tmp = jsonArray.getJSONObject(i);
                if (tmp.optJSONObject("image")!=null){
                    JSONObject imageObj = tmp.getJSONObject("image");
                    noticias.add(new Noticia(imageObj.optString("url"),
                            tmp.getString("titleNoFormatting"), tmp.getString("signedRedirectUrl")));
                }else{
                    noticias.add(new Noticia("no image",
                            tmp.getString("titleNoFormatting"), tmp.getString("signedRedirectUrl")));
                }
            }
            CargarLista();

        } else {
            Toast.makeText(NoticiasActivity.this,
                    "Error al realizar peticion GET. "
                            + status.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void CargarLista() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ObtenerTitulos());
        aQuery.id(R.id.listaNoticias).adapter(adapter);
    }

    private ArrayList<String> ObtenerTitulos() {
        ArrayList<String> aux = new ArrayList<>();
        for (Noticia n : noticias) {
            aux.add(n.titulo);
        }
        return aux;
    }
}
