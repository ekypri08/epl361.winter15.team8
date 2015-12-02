package com.example.elinos.epl361winter15team8;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.media.MediaPlayer;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
         MediaPlayer mp1;

        mp1 = MediaPlayer.create(MainMenu.this, R.raw.s9223049);


        mp1.start();
        //mp1.reset();
    }
    public void goMyPath(View v){
        Intent intent=new Intent(MainMenu.this, MyPath.class);
        startActivity(intent);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void goMonumentsList(View v){
        Intent intent=new Intent(MainMenu.this, MonumentsAnsMuseumsList.class);
        startActivity(intent);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void goMap(View v){
        Intent intent=new Intent(MainMenu.this, map.class);
        startActivity(intent);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }
    public void exit(View v) {
        // TODO Auto-generated method stub
        finish();
        System.exit(0);
    }
}