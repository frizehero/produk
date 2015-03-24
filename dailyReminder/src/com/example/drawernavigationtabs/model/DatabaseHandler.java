package com.example.drawernavigationtabs.model;

import java.util.ArrayList;
import java.util.List;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "reminder";
 
    // Contacts table name
    private static final String TABLE_HARIAN = "harian";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_judul = "judul";
    private static final String KEY_hari = "hari";
    private static final String KEY_tanggal = "tanggal";
    private static final String KEY_waktu= "waktu";
    private static final String KEY_keterangan= "keterangan";
    
    // Contacts table name
    private static final String TABLE_EVENT = "event";
 
    // Contacts Table Columns names
    private static final String KEY_ID_event = "id";
    private static final String KEY_judul_event = "judul_event";
    private static final String KEY_tanggal_event = "tanggal_event";
    private static final String KEY_waktu_event= "waktu_event";
    private static final String KEY_keterangan_event= "keterangan_event";
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_HARIAN + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_judul + " TEXT,"
                + KEY_hari + " TEXT,"
                + KEY_tanggal + " TEXT,"
                + KEY_waktu + " TEXT,"
                + KEY_keterangan + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
        
        String CREATE_CONTACTS_TABLE2 = "CREATE TABLE " + TABLE_EVENT + "("
                + KEY_ID_event + " INTEGER PRIMARY KEY," + KEY_judul_event + " TEXT,"
                + KEY_tanggal_event + " TEXT,"
                + KEY_waktu_event + " TEXT,"
                + KEY_keterangan_event + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE2);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HARIAN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
//    // Adding new contact
//    void addContact(Contact contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
// 
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, contact.getName()); // Contact Name
//        values.put(KEY_PH_NO, contact.getPhoneNumber()); // Contact Phone
// 
//        // Inserting Row
//        db.insert(TABLE_CONTACTS, null, values);
//        db.close(); // Closing database connection
//    }
// 
//    // Getting single contact
//    Contact getContact(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
// 
//        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
//                KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
//                new String[] { String.valueOf(id) }, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
// 
//        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
//                cursor.getString(1), cursor.getString(2));
//        // return contact
//        return contact;
//    }
     
//    // Getting All Contacts
//    public List<Contact> getAllContacts() {
//        List<Contact> contactList = new ArrayList<Contact>();
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
// 
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
// 
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                Contact contact = new Contact();
//                contact.setID(Integer.parseInt(cursor.getString(0)));
//                contact.setName(cursor.getString(1));
//                contact.setPhoneNumber(cursor.getString(2));
//                // Adding contact to list
//                contactList.add(contact);
//            } while (cursor.moveToNext());
//        }
// 
//        // return contact list
//        return contactList;
//    }
 
//    // Updating single contact
//    public int updateContact(Contact contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
// 
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, contact.getName());
//        values.put(KEY_PH_NO, contact.getPhoneNumber());
// 
//        // updating row
//        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
//                new String[] { String.valueOf(contact.getID()) });
//    }
// 
//    // Deleting single contact
//    public void deleteContact(Contact contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
//                new String[] { String.valueOf(contact.getID()) });
//        db.close();
//    }
 
 
    // Getting contacts Count
//    public int getContactsCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_HARIAN;
//        String countQuery2 = "SELECT  * FROM " + TABLE_EVENT;
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
// 
//        // return count
//        return cursor.getCount();
//    }
 
}
