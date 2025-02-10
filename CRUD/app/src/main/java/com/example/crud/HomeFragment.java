package com.example.crud;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    private EditText name,password;
    private Button btn;
    private RecyclerView recyclerView;
    private DatabaseHelper dbHelper;
    private UserAdapter adapter;

public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
    View view = inflater.inflate(R.layout.fragment_home,container,false);
    name = view.findViewById(R.id.name);
    password = view.findViewById(R.id.password);
    btn = view.findViewById(R.id.save);
    recyclerView = view.findViewById(R.id.homeRecycler);
 dbHelper = new DatabaseHelper(getActivity());
  btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
  });

}





    public HomeFragment() {

    }


    public static HomeFragment newInstance() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}