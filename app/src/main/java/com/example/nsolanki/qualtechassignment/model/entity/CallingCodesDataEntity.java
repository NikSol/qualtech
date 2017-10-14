package com.example.nsolanki.qualtechassignment.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallingCodesDataEntity implements Parcelable {

    private String callingCodes;

    public CallingCodesDataEntity() {
    }

    public CallingCodesDataEntity(String callingCodes) {
        this.callingCodes = callingCodes;
    }

    protected CallingCodesDataEntity(Parcel in) {
        callingCodes = in.readString();
    }

    public static final Creator<CallingCodesDataEntity> CREATOR = new Creator<CallingCodesDataEntity>() {
        @Override
        public CallingCodesDataEntity createFromParcel(Parcel in) {
            return new CallingCodesDataEntity(in);
        }

        @Override
        public CallingCodesDataEntity[] newArray(int size) {
            return new CallingCodesDataEntity[size];
        }
    };

    public String getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(String callingCodes) {
        this.callingCodes = callingCodes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(callingCodes);
    }
}
