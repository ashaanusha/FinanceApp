package com.example.financeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBaseClass extends SQLiteOpenHelper {
    ArrayList<Map<String, String>> data;
    public static final String DB_NAME = "customer";
    public static final String TABLE_NAME = "table_name";
    public static final String NAME = "name";
    public static final String FATHERNAME = "fathernme";
    public static final String OCCUPATION = "occupation";
    public static final String MOBILENO = "mobile";
    public static final String ADDRESS = "address";
    public static final String AMOUNT = "amount";
    public static final String NET_AMOUNT = "netamount";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + NAME + " TEXT,"
                    + FATHERNAME + " TEXT,"
                    + OCCUPATION + " TEXT,"
                    + MOBILENO + " TEXT,"
                    + ADDRESS + " TEXT,"
                    + AMOUNT + " TEXT,"
                    + NET_AMOUNT + " TEXT"
                    + ")";


    public static final String TABLE_NAME1 = "table_name1";
    public static final String NAME1 = "name1";
    public static final String MOBILENUMBER1 = "Mobile_number1";
    public static final String AMOUNT1= "Amount1";
    public static final String ADDRESS1 = "address1";
    public static final String RATEOFINTREST1 = "Rate_of_interest1";
    public static final String AMOUNTIN1 = "Amount_in1";
    public static final String AMOUNTOUT1 = "Amount_out1";
    public static final String CREATE_TABLE1 =
            "CREATE TABLE " + TABLE_NAME1 + "("
                    + NAME1 + " TEXT,"
                    + MOBILENUMBER1 + " TEXT,"
                    + AMOUNT1 + " TEXT,"
                    + ADDRESS1 + " TEXT,"
                    + RATEOFINTREST1 + " TEXT,"
                    + AMOUNTIN1 + " TEXT,"
                    + AMOUNTOUT1 + " TEXT"
                    + ")";
    public DataBaseClass(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertValues(String name_str, String father_name_str, String occupation_str,String mobile_str,String address_str,String amount_str,String netamount_str) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, name_str);
        values.put(FATHERNAME, father_name_str);
        values.put(OCCUPATION, occupation_str);
        values.put(MOBILENO, mobile_str);
        values.put(ADDRESS, address_str);
        values.put(AMOUNT, amount_str);
        values.put(NET_AMOUNT, netamount_str);


        sqLiteDatabase.insert(TABLE_NAME, null, values);
        // Toast.makeText(DataBaseClass.class, "successfully saved", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<Map<String, String>> getRetrive() {
       data = new ArrayList();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {

            do {
                Map<String, String> hmap = new HashMap<>();

                hmap.put(NAME, cursor.getString(cursor.getColumnIndex(NAME)));
                hmap.put(FATHERNAME, cursor.getString(cursor.getColumnIndex(FATHERNAME)));
                hmap.put(OCCUPATION, cursor.getString(cursor.getColumnIndex(OCCUPATION)));
                hmap.put(MOBILENO, cursor.getString(cursor.getColumnIndex(MOBILENO)));
                hmap.put(ADDRESS, cursor.getString(cursor.getColumnIndex(ADDRESS)));
                hmap.put(AMOUNT, cursor.getString(cursor.getColumnIndex(AMOUNT)));
                hmap.put(NET_AMOUNT, cursor.getString(cursor.getColumnIndex(NET_AMOUNT)));
                data.add(hmap);

            } while (cursor.moveToNext());
        }
       return data;
   }

    public void insertValues1(String name_str, String Mobile_number_str, String Amount_str,String address_str,String Rate_of_interest_str,String Amount_in_str,String Amount_out_str) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME1, name_str);
        values.put(MOBILENUMBER1, Mobile_number_str);
        values.put(AMOUNT1, Amount_str);
        values.put(ADDRESS1, address_str);
        values.put(RATEOFINTREST1, Rate_of_interest_str);
        values.put(AMOUNTIN1, Amount_in_str);
        values.put(AMOUNTOUT1, Amount_out_str);


        sqLiteDatabase.insert(TABLE_NAME1, null, values);
        // Toast.makeText(DataBaseClass.class, "successfully saved", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<Map<String, String>> getRetrive1() {
        data = new ArrayList();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME1, null);

        if (cursor.moveToFirst()) {

            do {
                Map<String, String> hmap = new HashMap<>();

                hmap.put(NAME1, cursor.getString(cursor.getColumnIndex(NAME1)));
                hmap.put(MOBILENUMBER1, cursor.getString(cursor.getColumnIndex(MOBILENUMBER1)));
                hmap.put(AMOUNT1, cursor.getString(cursor.getColumnIndex(AMOUNT1)));
                hmap.put(ADDRESS1, cursor.getString(cursor.getColumnIndex(ADDRESS1)));
                hmap.put(RATEOFINTREST1, cursor.getString(cursor.getColumnIndex(RATEOFINTREST1)));
                hmap.put(AMOUNTIN1, cursor.getString(cursor.getColumnIndex(AMOUNTIN1)));
                hmap.put(AMOUNTOUT1, cursor.getString(cursor.getColumnIndex(AMOUNTOUT1)));
                data.add(hmap);

            } while (cursor.moveToNext());
        }
        return data;
    }
}