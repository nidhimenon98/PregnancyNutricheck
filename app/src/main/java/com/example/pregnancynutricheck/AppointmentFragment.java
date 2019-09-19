package com.example.pregnancynutricheck;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppointmentFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_appointment, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Inflate the layout for this fragment

        ArrayList<Appointments> appointments=new ArrayList<>();

        ArrayList<AppointmentSchedule> appointmentSchedules=new ArrayList<>();
        appointmentSchedules.add(new AppointmentSchedule("1"));
        appointmentSchedules.add(new AppointmentSchedule("2"));
        appointmentSchedules.add(new AppointmentSchedule("3"));

        Appointments no=new Appointments("Past Appointments",appointmentSchedules);
        appointments.add(no);

        ArrayList<AppointmentSchedule> appointmentSchedules1=new ArrayList<>();
        appointmentSchedules1.add(new AppointmentSchedule("1"));
        appointmentSchedules1.add(new AppointmentSchedule("2"));
        appointmentSchedules1.add(new AppointmentSchedule("3"));

        Appointments noo=new Appointments("Upcoming Appointments",appointmentSchedules);
        appointments.add(noo);

        AppointmentScheduleAdapter adapter=new AppointmentScheduleAdapter(appointments);
        recyclerView.setAdapter(adapter);

        setHasOptionsMenu(true);
        return view;
    }
}