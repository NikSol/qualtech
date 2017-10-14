package com.example.nsolanki.qualtechassignment.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlternateSpellingsDataEntity implements Parcelable {

    private String alternateSpellings;

    public AlternateSpellingsDataEntity() {
    }

    public AlternateSpellingsDataEntity(String alternateSpellings) {
        this.alternateSpellings = alternateSpellings;
    }

    protected AlternateSpellingsDataEntity(Parcel in) {
        alternateSpellings = in.readString();
    }

    public static final Creator<AlternateSpellingsDataEntity> CREATOR = new Creator<AlternateSpellingsDataEntity>() {
        @Override
        public AlternateSpellingsDataEntity createFromParcel(Parcel in) {
            return new AlternateSpellingsDataEntity(in);
        }

        @Override
        public AlternateSpellingsDataEntity[] newArray(int size) {
            return new AlternateSpellingsDataEntity[size];
        }
    };

    public String getAlternateSpellings() {
        return alternateSpellings;
    }

    public void setAlternateSpellings(String alternateSpellings) {
        this.alternateSpellings = alternateSpellings;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(alternateSpellings);
    }
}
