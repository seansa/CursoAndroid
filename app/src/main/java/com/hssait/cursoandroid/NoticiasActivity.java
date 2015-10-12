package com.hssait.cursoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidquery.AQuery;

public class NoticiasActivity extends AppCompatActivity {

    AQuery aQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        aQuery = new AQuery(this);
    }
}
