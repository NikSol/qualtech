package com.example.nsolanki.qualtechassignment.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslationsEntity implements Parcelable {

    @JsonProperty("de")
    String de;

    @JsonProperty("es")
    String es;

    @JsonProperty("fr")
    String fr;

    @JsonProperty("ja")
    String ja;

    @JsonProperty("it")
    String it;

    public TranslationsEntity() {
    }

    protected TranslationsEntity(Parcel in) {
        de = in.readString();
        es = in.readString();
        fr = in.readString();
        ja = in.readString();
        it = in.readString();
    }

    public static final Creator<TranslationsEntity> CREATOR = new Creator<TranslationsEntity>() {
        @Override
        public TranslationsEntity createFromParcel(Parcel in) {
            return new TranslationsEntity(in);
        }

        @Override
        public TranslationsEntity[] newArray(int size) {
            return new TranslationsEntity[size];
        }
    };

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getJa() {
        return ja;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(de);
        parcel.writeString(es);
        parcel.writeString(fr);
        parcel.writeString(ja);
        parcel.writeString(it);
    }
}
