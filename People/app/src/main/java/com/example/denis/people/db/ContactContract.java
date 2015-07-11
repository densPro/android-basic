package com.example.denis.people.db;

import android.provider.BaseColumns;

/**
 * Created by denis on 01/07/2015.
 */
public class ContactContract {
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
}
