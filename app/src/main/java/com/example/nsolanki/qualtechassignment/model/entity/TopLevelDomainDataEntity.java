package com.example.nsolanki.qualtechassignment.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopLevelDomainDataEntity implements Parcelable {

    private String domainCode;

    public TopLevelDomainDataEntity() {

    }

    public TopLevelDomainDataEntity(String domainCode) {
        this.domainCode = domainCode;
    }

    protected TopLevelDomainDataEntity(Parcel in) {
        domainCode = in.readString();
    }

    public static final Creator<TopLevelDomainDataEntity> CREATOR = new Creator<TopLevelDomainDataEntity>() {
        @Override
        public TopLevelDomainDataEntity createFromParcel(Parcel in) {
            return new TopLevelDomainDataEntity(in);
        }

        @Override
        public TopLevelDomainDataEntity[] newArray(int size) {
            return new TopLevelDomainDataEntity[size];
        }
    };

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(domainCode);
    }
}
