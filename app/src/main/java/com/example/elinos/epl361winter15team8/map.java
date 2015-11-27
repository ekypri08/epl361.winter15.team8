package com.example.elinos.epl361winter15team8;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class map extends AppCompatActivity {

    public final static String key = "epl361";
    int feuture=0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
     /*  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


    }
    public void back(View v){
        Intent intent=new Intent(map.this, MainMenu.class);
        startActivity(intent);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }
    public void home(View v){
        Intent intent=new Intent(map.this, MainMenu.class);
        startActivity(intent);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }
    public void faneromeni(View v) {
        feuture=0;
        Intent intent = new Intent(this, Monument.class);
        intent.putExtra(key, feuture);
        startActivity(intent);

    }

    public void byzantine(View v) {
        feuture=1;
        Intent intent = new Intent(this, Monument.class);
        intent.putExtra(key,feuture);
        startActivity(intent);

    }

}

