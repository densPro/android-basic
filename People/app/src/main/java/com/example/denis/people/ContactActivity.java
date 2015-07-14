package com.example.denis.people;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.denis.people.db.ContactDBHelper;

/**
 * Created by denis on 30/06/2015.
 */
public class ContactActivity extends ActionBarActivity {

    private ContentValues dataContact;
    private ContactDBHelper DataBasehelper;
    private EditText nameEditText, phoneEditText, addressEditText, emailEditText;
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
        nameEditText = (EditText)findViewById(R.id.editTextName);
        phoneEditText = (EditText)findViewById(R.id.editTextPhone);
        addressEditText = (EditText)findViewById(R.id.editTextAddress);
        emailEditText = (EditText)findViewById(R.id.editTextEmail);
        /*b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 DataBasehelper = new ContactDBHelper(ContactActivity.this);
                 SQLiteDatabase db = DataBasehelper.getWritableDatabase();
                 dataContact.clear();
                 dataContact.put(ContactDBHelper.Columns.CONTACT_NAME,"juan");
                 //db.insertWithOnConflict(ContactDBHelper.TABLE, null, dataContact, SQLiteDatabase.CONFLICT_IGNORE);
                 db.insert(ContactDBHelper.TABLE,null, dataContact );
                 updateUI();
                 db.close();

             }
         });*/

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
    private void insertTable(String name ,int phone ,String address,String email ){

        DataBasehelper = new ContactDBHelper(ContactActivity.this);
        SQLiteDatabase db = DataBasehelper.getWritableDatabase();
        dataContact.clear();
        dataContact.put(ContactDBHelper.Columns.CONTACT_NAME, name);
        dataContact.put(ContactDBHelper.Columns.CONTACT_PHONE,phone);
        dataContact.put(ContactDBHelper.Columns.CONTACT_ADDRESS,address);
        dataContact.put(ContactDBHelper.Columns.CONTACT_EMAIL,email);
        db.insert(ContactDBHelper.TABLE, null, dataContact);
        Toast.makeText(getApplicationContext(),
                "contact added", Toast.LENGTH_LONG).show();
        db.close();
    }
    // buttons
    public void Save(View b){
        String name = nameEditText.getText().toString();
        int phone = Integer.parseInt(phoneEditText.getText().toString());
        String address = addressEditText.getText().toString();
        String email = emailEditText.getText().toString();
        insertTable(name, phone, address, email);
       // ContactActivity.this.finish();
        Intent it=new Intent(this,MainActivity.class);
        startActivity(it);
    }

    public  void Cancel(View b){
        ContactActivity.this.finish();
    }
}
