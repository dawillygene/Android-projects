package com.example.navigation_drawer;

import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyReviewsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;
    private DatabaseHelper dbHelper;
    private List<Review> reviewList;

    public MyReviewsFragment() {
        // Required empty public constructor
    }

    public static MyReviewsFragment newInstance() {
        return new MyReviewsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DatabaseHelper(getContext()); // Initialize the database helper
        reviewList = new ArrayList<>(); // Initialize the list to hold reviews
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_reviews, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Load reviews from the database
        loadReviews();

        // Set up the adapter
        reviewAdapter = new ReviewAdapter(reviewList);
        recyclerView.setAdapter(reviewAdapter);

        return view;
    }

    private void loadReviews() {
        // Fetch reviews from the database
        Cursor cursor = dbHelper.getAllReviews();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Extract data from the cursor
                String restaurantName = cursor.getString(cursor.getColumnIndexOrThrow("restaurant_name"));
                String reviewText = cursor.getString(cursor.getColumnIndexOrThrow("review_text"));
                int rating = cursor.getInt(cursor.getColumnIndexOrThrow("rating"));

                // Create a Review object and add it to the list
                Review review = new Review(restaurantName, reviewText, rating);
                reviewList.add(review);
            } while (cursor.moveToNext());

            cursor.close();
        } else {
            Toast.makeText(getContext(), "No reviews found", Toast.LENGTH_SHORT).show();
        }
    }
}