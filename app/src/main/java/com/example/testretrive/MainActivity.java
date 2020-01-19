package com.example.testretrive;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference rootRef = db.getReference();
    DatabaseReference userRe = rootRef.child("MEMBERS");
    DatabaseReference bopaiah = userRe.child("KG BOPAIAH");
    DatabaseReference appachu = userRe.child("APPACHU RANJAN");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Post list");



        mRecyclerView=findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));







    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Model,ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(

                        Model.class,
                        R.layout.row,
                        ViewHolder.class,
                        bopaiah
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int i) {


                        viewHolder.setDetails(getApplicationContext(),model.getDate(),model.getAmount(),model.getURL(),model.getWork());

                    }
                };


        mRecyclerView.setAdapter(firebaseRecyclerAdapter);



    }
}
