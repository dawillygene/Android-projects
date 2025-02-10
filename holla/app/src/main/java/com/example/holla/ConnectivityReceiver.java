package com.example.holla;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

public class ConnectivityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (NetworkUtils.isInternetAvailable(context)) {
            MessageStorage storage = new MessageStorage(context);
            Cursor cursor = storage.getAllMessages();

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    long id = cursor.getLong(cursor.getColumnIndexOrThrow(MessageDatabaseHelper.COLUMN_ID));
                    String sender = cursor.getString(cursor.getColumnIndexOrThrow(MessageDatabaseHelper.COLUMN_SENDER));
                    String message = cursor.getString(cursor.getColumnIndexOrThrow(MessageDatabaseHelper.COLUMN_MESSAGE));

                    // Retry sending the message
                    SmsService smsService = new SmsService();
                    smsService.sendDataToServer(context, sender, message);




                    // Remove from database after sending
                    storage.deleteMessage(id);
                }
                cursor.close();
            }
        }
    }
}
