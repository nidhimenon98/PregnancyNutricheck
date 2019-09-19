package com.example.pregnancynutricheck;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class AppointmentView extends GroupViewHolder {
    private TextView mTextView;
    private ImageView add;
    public AppointmentView(View itemView) {
        super(itemView);

        mTextView=itemView.findViewById(R.id.textView);
        add=itemView.findViewById(R.id.add);
    }
    public void bind(Appointments appointments){
        mTextView.setText(appointments.getTitle());
    }
}
