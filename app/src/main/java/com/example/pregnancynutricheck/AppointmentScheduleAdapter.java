package com.example.pregnancynutricheck;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class AppointmentScheduleAdapter extends ExpandableRecyclerViewAdapter<AppointmentView,AppointmentScheduleView> {
    public AppointmentScheduleAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public AppointmentView onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recycler_view_first,parent,false);
        return new AppointmentView(v);
    }

    @Override
    public AppointmentScheduleView onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recycler_view_second,parent,false);
        return new AppointmentScheduleView(v);
    }

    @Override
    public void onBindChildViewHolder(AppointmentScheduleView holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final AppointmentSchedule a =(AppointmentSchedule) group.getItems().get(childIndex);
        holder.bind(a);
    }

    @Override
    public void onBindGroupViewHolder(AppointmentView holder, int flatPosition, ExpandableGroup group) {
        final Appointments appointments=(Appointments) group;
        holder.bind(appointments);
    }
}

