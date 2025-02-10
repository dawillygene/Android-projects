package com.example.studentmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDB.db";
    private static final String USERS = "users";
    private  static final String COLUMN_ID = "_id";
    private  static final String COLUMN_NAME= "name";
    private static final String COLUMN_PASSWORD = "password";
    private static final int VERSION = 1;



    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }

    public void onCreate(SQLiteDatabase db){
    
        
        db.execSQL("CREATE TABLE " + USERS + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT, "
                + COLUMN_PASSWORD + " TEXT)");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
         db.execSQL("DROP TABLE IF EXISTS " + USERS);
         onCreate(db);
    }


    public boolean insertUser(String name,String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_PASSWORD,password);
        long result = db.insert(USERS,null,values);
        db.close();
        return result != -1;
    }

    public ArrayList<Student> readAllUsers(){
        SQLiteDatabase db = getReadableDatabase();

        //Cursor cursor = db.query(USERS,null,null,null,null,null,null);
        Cursor cursor = db.rawQuery("SELECT * FROM " + USERS,null);

        ArrayList<Student> userArray = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                userArray.add(new Student(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                ));
           }while (cursor.moveToNext());

    }
        cursor.close();
        db.close();
        return userArray;
    }

  
}
