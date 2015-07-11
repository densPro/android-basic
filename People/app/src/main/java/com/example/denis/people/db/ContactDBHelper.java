package com.example.denis.people.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by denis on 01/07/2015.
 */
public class ContactDBHelper extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE contacts(name TEXT,phone INTEGER,address TEXT,email TEXT)";
    public ContactDBHelper(Context context) {
        super(context,ContactContract.DB_NAME, null, ContactContract.DB_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
          db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           db.execSQL("DROP TABLE IF EXISTS contacts");
           db.execSQL(sqlCreate);
    }
}
