package com.example.nsolanki.qualtechassignment.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeZonesDataEntity implements Parcelable {

    private String timeZone;

    public TimeZonesDataEntity() {
    }

    public TimeZonesDataEntity(String timeZone) {
        this.timeZone = timeZone;
    }

    protected TimeZonesDataEntity(Parcel in) {
        timeZone = in.readString();
    }

    public static final Creator<TimeZonesDataEntity> CREATOR = new Creator<TimeZonesDataEntity>() {
        @Override
        public TimeZonesDataEntity createFromParcel(Parcel in) {
            return new TimeZonesDataEntity(in);
        }

        @Override
        public TimeZonesDataEntity[] newArray(int size) {
            return new TimeZonesDataEntity[size];
        }
    };

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(timeZone);
    }
}
