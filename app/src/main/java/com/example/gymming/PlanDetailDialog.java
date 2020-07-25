package com.example.gymming;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class PlanDetailDialog extends DialogFragment {

    public interface PassPlanInterface
    {
        void getPlan(Plan plan);
    }
    private PassPlanInterface passPlanInterface;
    private static final String TRAINING_KEY = "training";
    private Button dismiss,add;
    private EditText howmuch;
    private TextView edittext;
    private Spinner spinner;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view=getActivity().getLayoutInflater().inflate(R.layout.dialog_plan_details,null);//getActivity to get access to parent activity
        initViews(view);

        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Enter Details");

        Bundle bundle=getArguments();
        if(null!=bundle)
        {
            final Modelclass training = bundle.getParcelable(TRAINING_KEY);
            if(null!=training)
            {
                edittext.setText(training.getName());
                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String day=spinner.getSelectedItem().toString();
                        int minutes = Integer.valueOf(edittext.getText().toString());
                        Plan plan=new Plan(training,minutes,day,false);

                        try {

                                passPlanInterface=(PassPlanInterface)getActivity();
                                passPlanInterface.getPlan(plan);
                                dismiss();
                            }
                            catch(ClassCastException e)
                            {
                                e.printStackTrace();
                                dismiss();
                            }
                        }

                });
            }
        }

        return builder.create();
    }

    private void initViews(View view)
    {
        dismiss=view.findViewById(R.id.dismiss);
        add=view.findViewById(R.id.add);
        howmuch=view.findViewById(R.id.howmuch);
        edittext=view.findViewById(R.id.edittext);
        spinner=view.findViewById(R.id.spinner);
    }
}
