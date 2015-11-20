package com.example.elinos.epl361winter15team8;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.elinos.epl361winter15team8.R;

public class MonumentsAnsMuseumsList extends AppCompatActivity {
    ListView list;
    String[] museumsTitles;
    String[] museumsDescriptions;
    int[] images = {R.drawable.byzantinemuseum, R.drawable.leventio, R.drawable.motorcyclemuseum, R.drawable.nationalstrugglemuseum, R.drawable.byzantinemuseum, R.drawable.leventio, R.drawable.motorcyclemuseum, R.drawable.nationalstrugglemuseum};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monuments_ans_museums_list);


       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        Resources res = getResources();
        museumsTitles = res.getStringArray(R.array.titles);
        museumsDescriptions = res.getStringArray(R.array.descriptions);
        list = (ListView) findViewById(R.id.listView);
        myAdapter adapter = new myAdapter(this, museumsTitles, images, museumsDescriptions);
        list.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_monuments_ans_museums_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void yourMethodName(View v) {
        startActivity(new Intent(MonumentsAnsMuseumsList.this, myAdapter.class));
    }

    public void exit(View v) {
        // TODO Auto-generated method stub
        finish();
        System.exit(0);
    }

    class myAdapter extends ArrayAdapter<String> {
        Context context;
        int images[];
        String[] titleArray;
        String[] descriptions;

        public myAdapter(Context context, String[] titles, int images[], String[] desc) {
            super(context, R.layout.activity_single_row, R.id.textView, titles);
            this.context = context;
            this.images = images;
            this.titleArray = titles;
            this.descriptions = desc;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.activity_single_row, parent, false);
            ImageView myImage = (ImageView) row.findViewById(R.id.imageView);
            TextView myTitle = (TextView) row.findViewById(R.id.textView);
            TextView myDescription = (TextView) row.findViewById(R.id.textView2);

            myImage.setImageResource(images[position]);
            myTitle.setText(titleArray[position]);
            myDescription.setText(titleArray[position]);

            return row;
        }

    }
}