package com.example.gymming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import android.util.Log;

public class PlanActivity extends AppCompatActivity {

    private static final String TAG ="PlanActivity";

    private TextView Mondayedit,Tuesdayedit,Wednesdayedit,Thursdayedit,Fridayedit,Saturdayedit,Sundayedit;
    private Button addplan;
    private RecyclerView rec1,rec2,rec3,rec4,rec5,rec6,rec7;
    private RelativeLayout noplanRel;
    private NestedScrollView scroll;

    private PlanAdapter mondayAdap,TuesAdap,WedAdap,ThurAdap,FriAdap,SatAdap,SunAdap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        Mondayedit = findViewById(R.id.Mondayedit);
        Tuesdayedit = findViewById(R.id.Tuesdayedit);
        Wednesdayedit = findViewById(R.id.Wednesdayedit);
        Thursdayedit = findViewById(R.id.Thursdayedit);
        Fridayedit = findViewById(R.id.Fridayedit);
        Saturdayedit = findViewById(R.id.Saturdayedit);
        Sundayedit = findViewById(R.id.Sundayedit);
        addplan = findViewById(R.id.addplan);
        rec1 = findViewById(R.id.rec1);
        rec2 = findViewById(R.id.rec2);
        rec3 = findViewById(R.id.rec3);
        rec4 = findViewById(R.id.rec4);
        rec5 = findViewById(R.id.rec5);
        rec6 = findViewById(R.id.rec6);
        rec7 = findViewById(R.id.rec7);
        noplanRel = findViewById(R.id.noplanRel);
        scroll = findViewById(R.id.scroll);

        ArrayList<Plan> plans=Utils.getPlans();
        if(null!=plans)
        {
            if (plans.size() > 0)
            {
                noplanRel.setVisibility(View.GONE);
                scroll.setVisibility(View.VISIBLE);

                initRecview();
                setEditOnClickListener();
            }
            else
                {
                noplanRel.setVisibility(View.VISIBLE);
                scroll.setVisibility(View.GONE);
                addplan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PlanActivity.this, All_exe_Activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
                }
                } else {
                        noplanRel.setVisibility(View.VISIBLE);
                        scroll.setVisibility(View.GONE);
                        addplan.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(PlanActivity.this, All_exe_Activity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        });
                    }
        }
        private void setEditOnClickListener()
        {
            final Intent intent =new Intent(this,EditActivity.class);
            Mondayedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("day","Monday");
                    startActivity(intent);
                }
            });
            Tuesdayedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("day","Tuesday");
                    startActivity(intent);
                }
            });
            Wednesdayedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("day","Wednesday");
                    startActivity(intent);
                }
            });
           Thursdayedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("day","Thursday");
                    startActivity(intent);
                }
            });
            Fridayedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("day","Friday");
                    startActivity(intent);
                }
            });
            Saturdayedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("day","Saturday");
                    startActivity(intent);
                }
            });
            Sundayedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("day","Sunday");
                    startActivity(intent);
                }
            });

        }
        private void initRecview()
        {
            Log.d(TAG,"initRecViews: started");
            mondayAdap=new PlanAdapter(this);
            rec1.setAdapter(mondayAdap);
            rec1.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
            mondayAdap.setPlans(getPlansByDay("Monday"));

            TuesAdap=new PlanAdapter(this);
            rec2.setAdapter(TuesAdap);
            rec2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
            TuesAdap.setPlans(getPlansByDay("Tuesday"));

            WedAdap=new PlanAdapter(this);
            rec3.setAdapter(WedAdap);
            rec3.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
            WedAdap.setPlans(getPlansByDay("Wednesday"));

            ThurAdap=new PlanAdapter(this);
            rec4.setAdapter(ThurAdap);
            rec4.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
            ThurAdap.setPlans(getPlansByDay("Thursday"));

            FriAdap=new PlanAdapter(this);
            rec5.setAdapter(FriAdap);
            rec5.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
            FriAdap.setPlans(getPlansByDay("Friday"));

            SatAdap=new PlanAdapter(this);
            rec6.setAdapter(SatAdap);
            rec6.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
            SatAdap.setPlans(getPlansByDay("Saturday"));

            SunAdap=new PlanAdapter(this);
            rec7.setAdapter(SunAdap);
            rec7.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
            SunAdap.setPlans(getPlansByDay("Sunday"));





        }
        private ArrayList<Plan> getPlansByDay(String day) {
            ArrayList<Plan> allPlans = Utils.getPlans();
            ArrayList<Plan> plans = new ArrayList<>();
            for (Plan p : allPlans) {
                if (p.getDay().equalsIgnoreCase(day)) {
                    plans.add(p);
                }
            }
            return plans;
        }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}