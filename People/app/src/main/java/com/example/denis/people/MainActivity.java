package com.example.denis.people;

import android.app.FragmentManager;
import android.app.ListFragment;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.Switch;
import android.widget.Toast;

import com.example.denis.people.db.ContactDBHelper;

import java.util.ArrayList;


public  class MainActivity extends ActionBarActivity  {
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
/*private void updateUI() {

        DataBasehelper = new ContactDBHelper(ContactActivity.this);
        SQLiteDatabase sqlDB = DataBasehelper.getReadableDatabase();
        Cursor cursor = sqlDB.query(ContactDBHelper.TABLE,
                new String[]{ContactDBHelper.Columns._ID, ContactDBHelper.Columns.CONTACT_NAME},
                null, null, null, null, null);

        listAdapter = new SimpleCursorAdapter(
                this,
                R.layout.new_contact,
                cursor,
                new String[]{ContactDBHelper.Columns.CONTACT_NAME},
                new int[]{R.id.contactTextView},
                0
        );

       // this.setListAdapter(listAdapter);
    }*/


    public static class SimpleListFragment extends ListFragment
    {

        ArrayList<String> Contacts=  new ArrayList<>();;

       //como hacer dos contructores
       /* public SimpleListFragment(ArrayList<String> contacts) {
            Contacts = contacts;
        }*/

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
            ContactDBHelper dbh=new ContactDBHelper(this.getActivity());
            SQLiteDatabase sqlDB = dbh.getWritableDatabase();
            String arg = l.getAdapter().getItem(position).toString();
            String[] args = new String[]{ arg};
            sqlDB.execSQL("DELETE FROM contacts WHERE name=?", args);
           /// Toast.makeText(getApplicationContext(),
             //       "Contacto eliminado con exito.!", Toast.LENGTH_LONG).show();
            sqlDB.close();
            Intent i = new Intent(getActivity().getApplicationContext(),MainActivity.class);
            startActivity(i);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            ContactDBHelper dbh=new ContactDBHelper(this.getActivity());
            SQLiteDatabase sqlDB = dbh.getWritableDatabase();
            Cursor cursor = sqlDB.query("contacts",
                    new String[]{"name"},
            null, null, null, null, null);
            if (cursor.moveToFirst()) {

                //Recorremos el cursor hasta que no haya más registros
                do {
                    Contacts.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    inflater.getContext(), android.R.layout.simple_list_item_1,
                    Contacts);
            setListAdapter(adapter);
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

}
