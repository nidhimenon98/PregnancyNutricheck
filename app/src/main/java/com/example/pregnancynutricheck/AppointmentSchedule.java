package com.example.pregnancynutricheck;

import android.os.Parcel;
import android.os.Parcelable;

public class AppointmentSchedule implements Parcelable {
    public final String name;

    public AppointmentSchedule(String name) {
        this.name = name;
    }

    protected AppointmentSchedule(Parcel in) {
        name = in.readString();
    }

    public static final Creator<AppointmentSchedule> CREATOR = new Creator<AppointmentSchedule>() {
        @Override
        public AppointmentSchedule createFromParcel(Parcel in) {
            return new AppointmentSchedule(in);
        }

        @Override
        public AppointmentSchedule[] newArray(int size) {
            return new AppointmentSchedule[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
