package com.example.gymming;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {
    private static final String TRAINING_KEY = "training";

    private ArrayList<Plan> plans = new ArrayList<>();
    private Context context;
    private String type = "";

    public PlanAdapter(Context context)
    {
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtName.setText(plans.get(position).getTraining().getName());
        holder.txtDesc.setText(plans.get(position).getTraining().getShortdescp());
        holder.txtTime.setText(String.valueOf(plans.get(position).getMinutes()));
        Glide.with(context)
                .asBitmap()
                .load(plans.get(position).getTraining().getImageUrl())
                .into(holder.trainingImage);
        if(plans.get(position).isAccomplished())
        {
            holder.emptyCircle.setVisibility(View.GONE);
            holder.CheckedCircle.setVisibility(View.GONE);
        }
        else
        {
            holder.emptyCircle.setVisibility(View.VISIBLE);
            holder.CheckedCircle.setVisibility(View.GONE);
        }
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ThedescActivity.class);
               // intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(TRAINING_KEY,plans.get(position).getTraining());
                context.startActivity(intent);
            }
        });
        if(type.equals("edit"))
        {
            holder.emptyCircle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context)
                            .setTitle("Finished")
                            .setMessage("Have you finished " + plans.get(position).getTraining().getName() + "?")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    for (Plan p : Utils.getPlans()) {
                                        if (p.equals(plans.get(position))) {
                                            p.setAccomplished(true);
                                        }
                                    }
                                    notifyDataSetChanged();
                                }

                            });
                    builder.create().show();
                }
            });
            holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context)
                            .setTitle("Remove")
                            .setMessage("Are u sure u want to delete" +plans.get(position).getTraining().getName()+""+"from your plan")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if(Utils.removePlans(plans.get(position)))
                                    {
                                        Toast.makeText(context, "Plan removed successfully", Toast.LENGTH_SHORT).show();
                                        notifyDataSetChanged();
                                    }

                                }
                            });
                    builder.create().show();
                            return true;
                }
            });
        }

    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
        notifyDataSetChanged();
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView txtTime,txtName,txtDesc;
        private MaterialCardView parent;
        private ImageView trainingImage,CheckedCircle,emptyCircle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTime=itemView.findViewById(R.id.txtTime);
            txtName=itemView.findViewById(R.id.txtName);
            txtDesc=itemView.findViewById(R.id.txtDesc);
            parent=itemView.findViewById(R.id.parent);
            trainingImage=itemView.findViewById(R.id.trainingImage);
            CheckedCircle=itemView.findViewById(R.id.CheckedCircle);
            emptyCircle=itemView.findViewById(R.id.emptyCircle);
        }
    }
}
