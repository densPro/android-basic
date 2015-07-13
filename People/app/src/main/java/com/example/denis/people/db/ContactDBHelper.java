package com.example.denis.people.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by denis on 01/07/2015.
 */
public class ContactDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "com.example.denis.people.db.contacts";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "contacts";


    public class Columns {
        public static final String CONTACT_NAME = "name";
        public static final String CONTACT_PHONE = "phone";
        public static final String CONTACT_ADDRESS = "address";
        public static final String CONTACT_EMAIL = "email";

        public static final String _ID = BaseColumns._ID;
    }
    String sqlCreate = "CREATE TABLE contacts(name TEXT,phone INTEGER,address TEXT,email TEXT)";
    public ContactDBHelper(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
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
