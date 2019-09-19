package com.example.pregnancynutricheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerViewMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ArrayList<Appointments> appointments=new ArrayList<>();
        
        ArrayList<AppointmentSchedule> appointmentSchedules=new ArrayList<>();
        appointmentSchedules.add(new AppointmentSchedule("1"));
        appointmentSchedules.add(new AppointmentSchedule("2"));
        appointmentSchedules.add(new AppointmentSchedule("3"));
        
        Appointments no=new Appointments("Past Appointmnets",appointmentSchedules);
        appointments.add(no);

        ArrayList<AppointmentSchedule> appointmentSchedules1=new ArrayList<>();
        appointmentSchedules1.add(new AppointmentSchedule("1"));
        appointmentSchedules1.add(new AppointmentSchedule("2"));
        appointmentSchedules1.add(new AppointmentSchedule("3"));

        Appointments noo=new Appointments("Upcoming Appointments",appointmentSchedules);
        appointments.add(noo);
        
        AppointmentScheduleAdapter adapter=new AppointmentScheduleAdapter(appointments);
        recyclerView.setAdapter(adapter);

    }
}
