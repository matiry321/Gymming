package com.example.gymming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
        adapter=new RecAdapter(All_exe_Activity.this);
        booksRecview.setAdapter(adapter);
        booksRecview.setLayoutManager(new GridLayoutManager(this,2));

        ArrayList<Modelclass> allTrain=Utils.getExercises();
        if(null!= allTrain)
        {
            adapter.setExercises(allTrain);
        }
       // booksRecview=findViewById(R.id.booksRecview);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}