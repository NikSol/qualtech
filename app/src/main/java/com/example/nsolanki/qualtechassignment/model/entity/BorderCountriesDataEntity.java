package com.example.nsolanki.qualtechassignment.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BorderCountriesDataEntity implements Parcelable {

    private String borderCountry;

    public BorderCountriesDataEntity() {
    }

    public BorderCountriesDataEntity(String borderCountry) {
        this.borderCountry = borderCountry;
    }

    protected BorderCountriesDataEntity(Parcel in) {
        borderCountry = in.readString();
    }

    public static final Creator<BorderCountriesDataEntity> CREATOR = new Creator<BorderCountriesDataEntity>() {
        @Override
        public BorderCountriesDataEntity createFromParcel(Parcel in) {
            return new BorderCountriesDataEntity(in);
        }

        @Override
        public BorderCountriesDataEntity[] newArray(int size) {
            return new BorderCountriesDataEntity[size];
        }
    };

    public String getBorderCountry() {
        return borderCountry;
    }

    public void setBorderCountry(String borderCountry) {
        this.borderCountry = borderCountry;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(borderCountry);
    }
}
