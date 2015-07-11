package com.example.denis.people;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import com.example.denis.people.db.ContactContract;
import com.example.denis.people.db.ContactDBHelper;

/**
 * Created by denis on 30/06/2015.
 */
public class ContactActivity extends ActionBarActivity {
    private ContentValues dataContact;
    private ListActivity listActivity;
    private ContactDBHelper helper;
    private ListAdapter listAdapter;
    public ContactActivity() {
        dataContact = new ContentValues();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Contact");
        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactActivity.this.finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 helper = new ContactDBHelper(ContactActivity.this);
                 SQLiteDatabase db = helper.getWritableDatabase();
                 dataContact.clear();
                 dataContact.put(ContactContract.Columns.CONTACT_NAME,"juan");
                 //db.insertWithOnConflict(ContactContract.TABLE, null, dataContact, SQLiteDatabase.CONFLICT_IGNORE);
                 db.insert(ContactContract.TABLE,null, dataContact );
                 updateUI();
                 db.close();

             }
         });

    }

    private void updateUI() {
        helper = new ContactDBHelper(ContactActivity.this);
        SQLiteDatabase sqlDB = helper.getReadableDatabase();
        Cursor cursor = sqlDB.query(ContactContract.TABLE,
                new String[]{ContactContract.Columns._ID, ContactContract.Columns.CONTACT_NAME},
                null, null, null, null, null);

        listAdapter = new SimpleCursorAdapter(
                this,
                R.layout.new_contact,
                cursor,
                new String[]{ContactContract.Columns.CONTACT_NAME},
                new int[]{R.id.contactTextView},
                0
        );

       // this.setListAdapter(listAdapter);
    }
}
