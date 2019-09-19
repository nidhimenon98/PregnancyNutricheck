package com.example.pregnancynutricheck;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class AppointmentScheduleView extends ChildViewHolder {
    private TextView mTextView;
    public AppointmentScheduleView(View itemView) {
        super(itemView);
        mTextView=itemView.findViewById(R.id.textView);
    }

    public void bind(AppointmentSchedule appointmentSchedule){
        mTextView.setText(appointmentSchedule.name);
    }
}
