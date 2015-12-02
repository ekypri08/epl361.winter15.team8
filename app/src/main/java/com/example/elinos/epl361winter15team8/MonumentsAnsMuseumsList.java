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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.elinos.epl361winter15team8.R;

import java.util.ArrayList;

public class MonumentsAnsMuseumsList extends AppCompatActivity implements customAdapter.customButtonListener {
    public final static String key = "epl361";
    int feuture=0 ;
    ListView list;
    String[] museumsTitles;
    String[] museumsDescriptions;
    int[] images = {R.drawable.byzantinemuseum, R.drawable.leventio, R.drawable.motorcyclemuseum, R.drawable.nationalstrugglemuseum, R.drawable.byzantinemuseum, R.drawable.leventio, R.drawable.motorcyclemuseum, R.drawable.nationalstrugglemuseum};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monuments_ans_museums_list);
        list = (ListView) findViewById(R.id.listView);
        customAdapter ad = new customAdapter(this);
        list.setAdapter(ad);
        ad.setCustomButtonListener(MonumentsAnsMuseumsList.this);
        list.setAdapter(ad);


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

     /*   Resources res = getResources();
        museumsTitles = res.getStringArray(R.array.titles);
        museumsDescriptions = res.getStringArray(R.array.descriptions);
        list = (ListView) findViewById(R.id.listView);
        myAdapter adapter = new myAdapter(this, museumsTitles, images, museumsDescriptions);
        list.setAdapter(adapter);*/

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

    @Override
    public void onButtonClickListener(int pos, Class val) {
        feuture=pos;
        Intent intent = new Intent(this, Monument.class);
        intent.putExtra(key, feuture);
        startActivity(intent);
    }

    public void goBack(View v) {
        Intent intent = new Intent(MonumentsAnsMuseumsList.this, MainMenu.class);
        startActivity(intent);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void goHome(View v) {
        Intent intent = new Intent(MonumentsAnsMuseumsList.this, MainMenu.class);
        startActivity(intent);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void exit(View v) {
        // TODO Auto-generated method stub
        finish();
        System.exit(0);
    }
}


/*

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
*/

class MyViewHolder{
    ImageView myImage;
    TextView myTitle;
    TextView myDescription;

    SingleRow singleRow;
    // ArrayList<SingleRow> list;

    MyViewHolder(View v){
        // list = new ArrayList<SingleRow>();
        //* singleRow.description = String.valueOf(v.findViewById(R.id.textView2));
   /*     singleRow.title = String.valueOf(v.findViewById(R.id.textView));
        singleRow.image = Integer.valueOf(String.valueOf(v.findViewById(R.id.imageView)));*/
        myImage = (ImageView) v.findViewById(R.id.imageView);
        myTitle = (TextView) v.findViewById(R.id.textView);
        myDescription = (TextView) v.findViewById(R.id.textView2);
    }

}

class SingleRow{
    int image;
    String title;
    String description;
    SingleRow(String title, String  description, int image){
        this.title = title;
        this.description = description;
        this.image = image;
    }
}

class customAdapter extends BaseAdapter {
    customButtonListener custom;

    public interface customButtonListener {
        public void onButtonClickListener(int pos, Class val);
    }

    public void setCustomButtonListener(customButtonListener listener) {
        this.custom = listener;
    }

    ArrayList<SingleRow> list;
    Context context;

    customAdapter(Context c) {
        context = c;
        list = new ArrayList<SingleRow>();
        Resources res = c.getResources();
        String[] titles = res.getStringArray(R.array.titles);
        String[] descriptions = res.getStringArray(R.array.descriptions);
        int[] images = {R.drawable.byzantinemuseum, R.drawable.leventio, R.drawable.motorcyclemuseum, R.drawable.nationalstrugglemuseum, R.drawable.byzantinemuseum, R.drawable.leventio, R.drawable.motorcyclemuseum, R.drawable.nationalstrugglemuseum};

        for (int i = 0; i < 8; i++) {
            list.add(new SingleRow(titles[i], descriptions[i], images[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //System.out.println(this.getItemId(position));
        View row = convertView;
        MyViewHolder holder = null;
        if (row == null) {
            System.out.println(this.getItemId(position));
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.activity_single_row, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (MyViewHolder) row.getTag();
        }


        TextView title = (TextView) row.findViewById(R.id.textView);
        TextView description = (TextView) row.findViewById(R.id.textView2);
        ImageView image = (ImageView) row.findViewById(R.id.imageView);
//        holder.list.get(position);

        SingleRow temp = list.get(position);
        title.setText(temp.title);
        description.setText(temp.description);
        image.setImageResource(temp.image);

        row.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
/*                switch (position*//*v.getId()*//*) {
                    case 0*//*row.id.imageView*//*:
                        custom.onButtonClickListener(position, Path1.class);
                        break;
                    case 1*//*row.id.imageView*//*:
                        custom.onButtonClickListener(position, Path1.class);
                        break;
                    case 2*//*row.id.imageView*//*:
                        custom.onButtonClickListener(position, Path1.class);
                        break;
                    case 3*//*row.id.imageView*//*:
                        custom.onButtonClickListener(position, Path1.class);
                        break;

                }*/
                custom.onButtonClickListener(position, Path1.class);
            }
        });

        return row;

    }

}
