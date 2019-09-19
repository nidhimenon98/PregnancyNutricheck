package com.example.pregnancynutricheck;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Appointments extends ExpandableGroup<AppointmentSchedule> {
    public Appointments(String title, List<AppointmentSchedule> items) {
        super(title, items);
    }
}
