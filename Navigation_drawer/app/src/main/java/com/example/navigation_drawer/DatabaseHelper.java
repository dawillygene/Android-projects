package com.example.navigation_drawer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "restaurant_reviews.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_REVIEWS = "reviews";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_RESTAURANT_NAME = "restaurant_name";
    private static final String COLUMN_REVIEW_TEXT = "review_text";
    private static final String COLUMN_RATING = "rating";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_REVIEWS + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_RESTAURANT_NAME + " TEXT, "
                + COLUMN_REVIEW_TEXT + " TEXT, "
                + COLUMN_RATING + " INTEGER)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REVIEWS);
        onCreate(db);
    }

    public long addReview(String restaurantName, String reviewText, int rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_RESTAURANT_NAME, restaurantName);
        values.put(COLUMN_REVIEW_TEXT, reviewText);
        values.put(COLUMN_RATING, rating);
        return db.insert(TABLE_REVIEWS, null, values);
    }

    public Cursor getAllReviews() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_REVIEWS, null, null, null, null, null, null);
    }
}