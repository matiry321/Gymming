package com.example.gymming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    private Button btnPlans,btnAllActivities,btnAbout;



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
            btnPlans=findViewById(R.id.btnPlans);
            btnAllActivities=findViewById(R.id.btnAllActivities);
            btnAbout=findViewById(R.id.btnAbout);

            Utils.initTrainings();
            btnAllActivities.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent intent=new Intent(MainActivity2.this,All_exe_Activity.class);
                    startActivity(intent);
                }
            });
    }
}