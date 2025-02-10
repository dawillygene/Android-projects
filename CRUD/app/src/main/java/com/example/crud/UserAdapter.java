package com.example.crud;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;



public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private Context context;
    private Cursor cursor;

    public UserAdapter(Context context,Cursor cursor){
        this.context = context;
        this.cursor = cursor;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(context).inflate(android.R.layout.activity_list_item,parent,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder,int position){
        if(!cursor.moveToPosition(position)){
            return;
        }
        String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.NAME));
        String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PASSWORD));
        holder.textName.setText(name);
        holder.textPassword.setText(password);

    }


    public int getItemCount(){
        return cursor.getCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textName;
        public TextView textPassword;

        public ViewHolder(View itemView){
            super(itemView);
            textName = itemView.findViewById(android.R.id.text1);
            textPassword = itemView.findViewById(android.R.id.text2);
        }



    }

}
