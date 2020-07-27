package com.example.gymming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ThedescActivity extends AppCompatActivity implements PlanDetailDialog.PassPlanInterface {
    private static final String TAG="TheDescActivity";

    private static final String TRAINING_KEY = "trainings";

    @Override
    public void getPlan(Plan plan) {
        Log.d(TAG,"getPlan:Plan" +plan.toString());
        if(Utils.addPlan(plan))
        {
            Toast.makeText(this, plan.getTraining().getName()+"Added to ur plan", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,PlanActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
    private Button Addtoplan;
    private TextView trainingname,longdesc;
    private ImageView imgofexerc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thedesc);

        initViews();

        Intent intent = getIntent();

        if(null!=intent)
        {
            final Modelclass training=intent.getParcelableExtra(TRAINING_KEY);
            if(null!=training)
            {
                trainingname.setText(training.getName());
                longdesc.setText(training.getLongdescp());
                Glide.with(this)
                        .asBitmap()
                        .load(training.getImageUrl())
                        .into(imgofexerc);
                Addtoplan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PlanDetailDialog dialog = new PlanDetailDialog();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(TRAINING_KEY,training);
                        dialog.setArguments(bundle);
                        dialog.show(getSupportFragmentManager(),"plan detail dialog");
                    }
                });
            }
        }
    }

    private void initViews()
    {
        Log.d(TAG,"intiViews:started");
        Addtoplan=findViewById(R.id.Addtoplan);
        trainingname=findViewById(R.id.trainingname);
        longdesc=findViewById(R.id.longdesc);
        imgofexerc=findViewById(R.id.imgofexerc);
    }


}