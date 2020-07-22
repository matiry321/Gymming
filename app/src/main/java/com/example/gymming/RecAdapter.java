package com.example.gymming;


import android.icu.text.Normalizer2;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.RecViewHolder> //use ctrl+space
 {
     private static final String TAG = "TrainingAdapter";
     private ArrayList<Modelclass> exercises=new ArrayList<>();
     private Context mContext;
     public RecAdapter()
     {
         this.mContext=mContext;
     }

     @NonNull
     @Override
     public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) //creates the view holder to hold our views
      {
         //LayoutInflater inflater=LayoutInflater.from(mContext);
         View view =LayoutInflater.from(mContext).inflate(R.layout.exercise_layout,parent,false);//LAyoutInflater class returns us view object in corresponding to all the view in the layout file
         return new RecViewHolder(view);
     }

     @Override
     public void onBindViewHolder(@NonNull RecViewHolder holder, int position)
     {
        Log.d(TAG,"onBindViewHolder: Called");

        holder.activityname.setText(Modelclass.get(position).getName());
        holder.shortDesc.setText(Modelclass.get(position).getShortdescp());
         Glide.with(mContext)
                 .asBitmap()
                 .load(Modelclass.get(position).getImageUrl())
                 .into(holder.image);

         holder.parent.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(mContext, "Yet to be completed", Toast.LENGTH_SHORT).show();


             }
         });


     }

     @Override
     public int getItemCount() {
         return exercises.size();
     }

     public void setExercises(ArrayList<Modelclass> exercises)
     {
         this.exercises = exercises;
         notifyDataSetChanged();
     }

     public class RecViewHolder extends RecyclerView.ViewHolder //this is an inner class i.e viewholder class that will retain our views for recycle purpose
    {
        private CardView parent;

        private TextView activityname,shortDesc;
        private ImageView image;
        public RecViewHolder(@NonNull View itemView)
        {
            super(itemView);
            activityname=itemView.findViewById(R.id.activityname);
            shortDesc=itemView.findViewById(R.id.shortDesc);
            image=itemView.findViewById(R.id.image);
            parent=itemView.findViewById(R.id.parent);

        }


    }


}
