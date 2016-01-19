package com.crackbrain.tanveen.database_sh_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Al on 1/19/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "DB_1";
    public static final int DATABASE_VERSION = 2 ;
    public static final String TABLE_NAME    = "employe";

    public static final String ID_KEY = "_id";
    public static final String NAME_KEY = "name";
    public static final String EMAIL_KEY = "email";
    public static final String PHONE_KEY = "phone";
    public static final String ADDRESS_KEY = "address";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
      String CreatingTABLE_1 = "CREATE TABLE " + TABLE_NAME + "("
              + ID_KEY + " INTEGER PRIMARY KEY," + NAME_KEY + " TEXT," +
              EMAIL_KEY + " TEXT,"+ PHONE_KEY + " TEXT," + ADDRESS_KEY + " TEXT" + ")";  // Primary ker ar akhane _(underscore Must be lagbe)

        db.execSQL(CreatingTABLE_1);
        Log.e("Table Create",CreatingTABLE_1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }


    public long insertData(EmplyeData emp)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        //values.put(ID_KEY,emp.getId());
        values.put(NAME_KEY,emp.getName());
        values.put(EMAIL_KEY,emp.getEmail());
        values.put(PHONE_KEY,emp.getPhone());
        values.put(ADDRESS_KEY,emp.getAddress());

        long inserted =  db.insert(TABLE_NAME,null,values);

        db.close();
        return inserted;

    }

    public ArrayList<EmplyeData> getAllEmplyees()
    {
        ArrayList<EmplyeData> allemployees = new ArrayList<EmplyeData>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);


        if(cursor != null && cursor.getCount() > 0)
        {

            cursor.moveToFirst();

            for(int i = 0; i < cursor.getCount(); i++)
            {
                int id =  cursor.getInt(cursor.getColumnIndex(ID_KEY));
                String name = cursor.getString(cursor.getColumnIndex(NAME_KEY));
                String email = cursor.getString(cursor.getColumnIndex(EMAIL_KEY));
                String phone = cursor.getString(cursor.getColumnIndex(PHONE_KEY));
                String address = cursor.getString(cursor.getColumnIndex(ADDRESS_KEY));

                EmplyeData emp = new EmplyeData(id,name,email,phone,address);

                allemployees.add(emp);

                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return allemployees;
    }
}
