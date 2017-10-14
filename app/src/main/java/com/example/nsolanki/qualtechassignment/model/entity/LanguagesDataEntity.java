package com.example.nsolanki.qualtechassignment.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguagesDataEntity implements Parcelable {

    private String languages;


    public LanguagesDataEntity() {
    }

    public LanguagesDataEntity(String languages) {
        this.languages = languages;
    }

    protected LanguagesDataEntity(Parcel in) {
        languages = in.readString();
    }

    public static final Creator<LanguagesDataEntity> CREATOR = new Creator<LanguagesDataEntity>() {
        @Override
        public LanguagesDataEntity createFromParcel(Parcel in) {
            return new LanguagesDataEntity(in);
        }

        @Override
        public LanguagesDataEntity[] newArray(int size) {
            return new LanguagesDataEntity[size];
        }
    };

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(languages);
    }
}
