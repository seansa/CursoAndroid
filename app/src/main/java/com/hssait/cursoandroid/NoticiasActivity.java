package com.hssait.cursoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONObject;

public class NoticiasActivity extends AppCompatActivity {

    AQuery aQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        aQuery = new AQuery(this);

        aQuery.id(R.id.btnNoticias).clicked(this,"TraerNoticias");
    }

    public void TraerNoticias(View view){
        String url = "http://www.google.com/uds/GnewsSearch?q="+
                aQuery.id(R.id.txtNoticias).getText().toString()+"&v=1.0";
        aQuery.ajax(url, JSONObject.class, this, "jsonCallback");
    }

    public void jsonCallback(String url, JSONObject json, AjaxStatus status){

        if(json != null){
            
        }else{
            Toast.makeText(NoticiasActivity.this,
                    "Error al realizar peticion GET. "
                            + status.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
