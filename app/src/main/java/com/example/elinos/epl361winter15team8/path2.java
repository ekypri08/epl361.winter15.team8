package com.example.elinos.epl361winter15team8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class path2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_path2, menu);
        return true;
    }
    public void back(View v){
        Intent intent=new Intent(path2.this,MyPath.class);
        System.exit(1);
        startActivity(intent);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);}


    public void home(View v){
        Intent intent=new Intent(path2.this,MainMenu.class);
        System.exit(1);
        startActivity(intent);}
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
}
