package com.example.nsolanki.qualtechassignment.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountriesDataEntity implements Parcelable {

    public static final String TAG = CountriesDataEntity.class.getCanonicalName();

    /*Using this field to uniquley identify the data from other tables*/
    int countryId;

    @JsonProperty("name")
    String countryName;

    @JsonProperty("alpha2Code")
    String alpha2Code;

    @JsonProperty("alpha3Code")
    String alpha3Code;

    @JsonProperty("capital")
    String capital;

    @JsonProperty("region")
    String region;

    @JsonProperty("subregion")
    String subRegion;

    @JsonProperty("population")
    Long population;

    @JsonProperty("demonym")
    String demonym;

    @JsonProperty("area")
    Long area;

    @JsonProperty("gini")
    float gini;

    @JsonProperty("nativeName")
    String nativeName;

    @JsonProperty("numericCode")
    String numericCode;

    @JsonProperty("relevance")
    String relevance;

    @JsonProperty("topLevelDomain")
    List<TopLevelDomainDataEntity> mTopLevelDomainDataEntityList;

    @JsonProperty("callingCodes")
    List<CallingCodesDataEntity> mCallingCodesDataEntityList;

    @JsonProperty("altSpellings")
    List<AlternateSpellingsDataEntity> mAlternateSpellingsDataEntityList;

    @JsonProperty("latlng")
    List<LatLngDataEntity> mLatLngDataEntityList;

    @JsonProperty("timezones")
    List<TimeZonesDataEntity> mTimeZonesDataEntityList;

    @JsonProperty("borders")
    List<BorderCountriesDataEntity> mBorderCountriesDataEntityList;

    @JsonProperty("currencies")
    List<CurrenciesDataEntity> mCurrenciesDataEntityList;

    @JsonProperty("languages")
    List<LanguagesDataEntity> mLanguagesDataEntityList;

    @JsonProperty("translations")
    TranslationsEntity mTranslationsEntity;

    public CountriesDataEntity() {
        this.mTopLevelDomainDataEntityList = new ArrayList<>();
        this.mCallingCodesDataEntityList = new ArrayList<>();
        this.mAlternateSpellingsDataEntityList = new ArrayList<>();
        this.mLatLngDataEntityList = new ArrayList<>();
        this.mTimeZonesDataEntityList = new ArrayList<>();
        this.mBorderCountriesDataEntityList = new ArrayList<>();
        this.mCurrenciesDataEntityList = new ArrayList<>();
        this.mLanguagesDataEntityList = new ArrayList<>();
    }

    protected CountriesDataEntity(Parcel in) {
        countryName = in.readString();
        alpha2Code = in.readString();
        alpha3Code = in.readString();
        capital = in.readString();
        region = in.readString();
        subRegion = in.readString();
        if (in.readByte() == 0) {
            population = null;
        } else {
            population = in.readLong();
        }
        demonym = in.readString();
        if (in.readByte() == 0) {
            area = null;
        } else {
            area = in.readLong();
        }
        gini = in.readFloat();
        nativeName = in.readString();
        numericCode = in.readString();
        relevance = in.readString();
        mTopLevelDomainDataEntityList = in.createTypedArrayList(TopLevelDomainDataEntity.CREATOR);
        mCallingCodesDataEntityList = in.createTypedArrayList(CallingCodesDataEntity.CREATOR);
        mAlternateSpellingsDataEntityList = in.createTypedArrayList(AlternateSpellingsDataEntity.CREATOR);
        mLatLngDataEntityList = in.createTypedArrayList(LatLngDataEntity.CREATOR);
        mTimeZonesDataEntityList = in.createTypedArrayList(TimeZonesDataEntity.CREATOR);
        mBorderCountriesDataEntityList = in.createTypedArrayList(BorderCountriesDataEntity.CREATOR);
        mCurrenciesDataEntityList = in.createTypedArrayList(CurrenciesDataEntity.CREATOR);
        mLanguagesDataEntityList = in.createTypedArrayList(LanguagesDataEntity.CREATOR);
        mTranslationsEntity = in.readParcelable(TranslationsEntity.class.getClassLoader());
        countryId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(countryName);
        dest.writeString(alpha2Code);
        dest.writeString(alpha3Code);
        dest.writeString(capital);
        dest.writeString(region);
        dest.writeString(subRegion);
        if (population == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(population);
        }
        dest.writeString(demonym);
        if (area == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(area);
        }
        dest.writeFloat(gini);
        dest.writeString(nativeName);
        dest.writeString(numericCode);
        dest.writeString(relevance);
        dest.writeTypedList(mTopLevelDomainDataEntityList);
        dest.writeTypedList(mCallingCodesDataEntityList);
        dest.writeTypedList(mAlternateSpellingsDataEntityList);
        dest.writeTypedList(mLatLngDataEntityList);
        dest.writeTypedList(mTimeZonesDataEntityList);
        dest.writeTypedList(mBorderCountriesDataEntityList);
        dest.writeTypedList(mCurrenciesDataEntityList);
        dest.writeTypedList(mLanguagesDataEntityList);
        dest.writeParcelable(mTranslationsEntity, flags);
        dest.writeInt(countryId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CountriesDataEntity> CREATOR = new Creator<CountriesDataEntity>() {
        @Override
        public CountriesDataEntity createFromParcel(Parcel in) {
            return new CountriesDataEntity(in);
        }

        @Override
        public CountriesDataEntity[] newArray(int size) {
            return new CountriesDataEntity[size];
        }
    };

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public float getGini() {
        return gini;
    }

    public void setGini(float gini) {
        this.gini = gini;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public List<TopLevelDomainDataEntity> getTopLevelDomainDataEntityList() {
        return mTopLevelDomainDataEntityList;
    }

    public void setTopLevelDomainDataEntityList(List<TopLevelDomainDataEntity> topLevelDomainDataEntityList) {
        mTopLevelDomainDataEntityList = topLevelDomainDataEntityList;
    }

    public List<CallingCodesDataEntity> getCallingCodesDataEntityList() {
        return mCallingCodesDataEntityList;
    }

    public void setCallingCodesDataEntityList(List<CallingCodesDataEntity> callingCodesDataEntityList) {
        mCallingCodesDataEntityList = callingCodesDataEntityList;
    }

    public List<AlternateSpellingsDataEntity> getAlternateSpellingsDataEntityList() {
        return mAlternateSpellingsDataEntityList;
    }

    public void setAlternateSpellingsDataEntityList(List<AlternateSpellingsDataEntity> alternateSpellingsDataEntityList) {
        mAlternateSpellingsDataEntityList = alternateSpellingsDataEntityList;
    }

    public List<LatLngDataEntity> getLatLngDataEntityList() {
        return mLatLngDataEntityList;
    }

    public void setLatLngDataEntityList(List<LatLngDataEntity> latLngDataEntityList) {
        mLatLngDataEntityList = latLngDataEntityList;
    }

    public List<TimeZonesDataEntity> getTimeZonesDataEntityList() {
        return mTimeZonesDataEntityList;
    }

    public void setTimeZonesDataEntityList(List<TimeZonesDataEntity> timeZonesDataEntityList) {
        mTimeZonesDataEntityList = timeZonesDataEntityList;
    }

    public List<BorderCountriesDataEntity> getBorderCountriesDataEntityList() {
        return mBorderCountriesDataEntityList;
    }

    public void setBorderCountriesDataEntityList(List<BorderCountriesDataEntity> borderCountriesDataEntityList) {
        mBorderCountriesDataEntityList = borderCountriesDataEntityList;
    }

    public List<CurrenciesDataEntity> getCurrenciesDataEntityList() {
        return mCurrenciesDataEntityList;
    }

    public void setCurrenciesDataEntityList(List<CurrenciesDataEntity> currenciesDataEntityList) {
        mCurrenciesDataEntityList = currenciesDataEntityList;
    }

    public List<LanguagesDataEntity> getLanguagesDataEntityList() {
        return mLanguagesDataEntityList;
    }

    public void setLanguagesDataEntityList(List<LanguagesDataEntity> languagesDataEntityList) {
        mLanguagesDataEntityList = languagesDataEntityList;
    }

    public TranslationsEntity getTranslationsEntity() {
        return mTranslationsEntity;
    }

    public void setTranslationsEntity(TranslationsEntity translationsEntity) {
        mTranslationsEntity = translationsEntity;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public boolean isDataEmpty() {
        return countryName.isEmpty() && alpha2Code.isEmpty() && alpha3Code.isEmpty() && capital.isEmpty() && region.isEmpty() && subRegion.isEmpty()
                && population == 0l && demonym.isEmpty() && area == 0l && gini == 0.0f && nativeName.isEmpty() && numericCode.isEmpty() && relevance.isEmpty()
                && mTopLevelDomainDataEntityList.isEmpty() && mCallingCodesDataEntityList.isEmpty() && mAlternateSpellingsDataEntityList.isEmpty()
                && mLatLngDataEntityList.isEmpty() && mTimeZonesDataEntityList.isEmpty() && mBorderCountriesDataEntityList.isEmpty()
                && mCurrenciesDataEntityList.isEmpty() && mLanguagesDataEntityList.isEmpty();
    }
}
