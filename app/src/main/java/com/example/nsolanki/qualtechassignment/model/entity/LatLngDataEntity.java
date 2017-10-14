package com.example.nsolanki.qualtechassignment.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatLngDataEntity implements Parcelable{

    private double mCoordinate;

    public LatLngDataEntity() {
    }

    public LatLngDataEntity(double cordinate) {
        this.mCoordinate = cordinate;
    }

    protected LatLngDataEntity(Parcel in) {
        mCoordinate = in.readDouble();
    }

    public static final Creator<LatLngDataEntity> CREATOR = new Creator<LatLngDataEntity>() {
        @Override
        public LatLngDataEntity createFromParcel(Parcel in) {
            return new LatLngDataEntity(in);
        }

        @Override
        public LatLngDataEntity[] newArray(int size) {
            return new LatLngDataEntity[size];
        }
    };

    public double getCoordinate() {
        return mCoordinate;
    }

    public void setCoordinate(double coordinate) {
        this.mCoordinate = coordinate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(mCoordinate);
    }
}
