package com.example.denis.people;

import android.app.FragmentManager;
import android.app.ListFragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
    private ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button btnAddContact = (Button)findViewById(R.id.btnAdd);
        //btnAddContact.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //   public void onClick(View v) {
        //        Intent i = new Intent(getApplicationContext(),ContactActivity.class);
        //        startActivity(i);
        //    }
        // });
        FragmentManager fm = getFragmentManager();

        SimpleListFragment list = new SimpleListFragment();
        fm.beginTransaction().add(android.R.id.content, list).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_Contact) {
            Intent i = new Intent(getApplicationContext(),ContactActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class SimpleListFragment extends ListFragment
    {

        String[] Contacts = new String[] { "default" };


        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    inflater.getContext(), android.R.layout.simple_list_item_1,
                    Contacts);
            setListAdapter(adapter);
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

}
