package com.example.gymming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class All_exe_Activity extends AppCompatActivity {
    private RecyclerView booksRecview;
    private RecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_exe_);

        booksRecview=findViewById(R.id.booksRecview);
        adapter=new RecAdapter();
        booksRecview.setAdapter(adapter);
        booksRecview.setLayoutManager(new GridLayoutManager(this,2));

        ArrayList<Modelclass> allTrain=Utils.getExercises();
        if(null!= allTrain)
        {
            adapter.setExercises(allTrain);
        }
       // booksRecview=findViewById(R.id.booksRecview);
    }
}