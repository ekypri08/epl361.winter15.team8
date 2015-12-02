package com.example.elinos.epl361winter15team8;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Monument extends AppCompatActivity {
    String[] museumsTitles_map;
    String[] museumsDescriptions_map;
    int[] images_map = {R.drawable.faneromeni,R.drawable.byzantinemuseum, R.drawable.leventio, R.drawable.nationalstrugglemuseum, R.drawable.motorcyclemuseum,R.drawable.savvas,R.drawable.famagusta};
    public final static String key = "epl361";
    ImageView myImage;
    TextView myTitle;
    TextView myDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monument);
        Resources res = getResources();
        museumsTitles_map = res.getStringArray(R.array.titles);
        museumsDescriptions_map = res.getStringArray(R.array.description_map);
        Intent intent = getIntent();
        int feuture = (int)intent.getIntExtra(key,0);
        myImage = (ImageView) findViewById(R.id.imageView);
        myTitle = (TextView) findViewById(R.id.textView4);
        myDescription = (TextView) findViewById(R.id.textView6);


        myTitle.setText(museumsTitles_map[feuture]);
        myDescription.setText(museumsDescriptions_map[feuture]);
        myImage.setImageResource(images_map[feuture]);
        //setContentView(R.layout.monument);

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        Intent intent=new Intent(Monument.this,map.class);
        System.exit(1);
        startActivity(intent);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);}

    public void home(View v){
        Intent intent=new Intent(Monument.this,MainMenu.class);
        System.exit(1);
        startActivity(intent);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

}

