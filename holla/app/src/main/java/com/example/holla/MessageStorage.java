package com.example.holla;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MessageStorage {
    private final MessageDatabaseHelper dbHelper;

    public MessageStorage(Context context) {
        dbHelper = new MessageDatabaseHelper(context);
    }

    public void saveMessage(String sender, String message) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MessageDatabaseHelper.COLUMN_SENDER, sender);
        values.put(MessageDatabaseHelper.COLUMN_MESSAGE, message);
        db.insert(MessageDatabaseHelper.TABLE_MESSAGES, null, values);
    }

    public Cursor getAllMessages() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.query(MessageDatabaseHelper.TABLE_MESSAGES, null, null, null, null, null, null);
    }

    public void deleteMessage(long id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(MessageDatabaseHelper.TABLE_MESSAGES, MessageDatabaseHelper.COLUMN_ID + "=?", new String[]{String.valueOf(id)});
    }
}
