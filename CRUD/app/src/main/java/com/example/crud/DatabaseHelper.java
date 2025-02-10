package com.example.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserDatabase.db";
    public static final String TABLE = "user";
    public static final int VERSION = 1;
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        String createTable = "CREATE TABLE "+ TABLE + " (" +ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                NAME + " TEXT, "+
                PASSWORD + " TEXT)";
        db.execSQL(createTable);
    }

public void onUpgrade(SQLiteDatabase db,int oldVersion , int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
}

public boolean insertData(String name,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(NAME,name);
        value.put(PASSWORD,password);
        long result = db.insert(TABLE,null,value);
        return result != -1;

}

public Cursor getAllData(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE,null);
}






}
