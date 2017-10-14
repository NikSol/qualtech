package com.example.nsolanki.qualtechassignment.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrenciesDataEntity implements Parcelable {

    private String currencyName;

    public CurrenciesDataEntity() {
    }

    public CurrenciesDataEntity(String currencyName) {
        this.currencyName = currencyName;
    }

    protected CurrenciesDataEntity(Parcel in) {
        currencyName = in.readString();
    }

    public static final Creator<CurrenciesDataEntity> CREATOR = new Creator<CurrenciesDataEntity>() {
        @Override
        public CurrenciesDataEntity createFromParcel(Parcel in) {
            return new CurrenciesDataEntity(in);
        }

        @Override
        public CurrenciesDataEntity[] newArray(int size) {
            return new CurrenciesDataEntity[size];
        }
    };

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(currencyName);
    }
}
