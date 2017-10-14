package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by nsolanki on 10/14/2017.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountriesDataEntity {

    public static final String TAG = CountriesDataEntity.class.getCanonicalName();

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
    int numericCode;

    @JsonProperty("relevance")
    int relevance;

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

    public int getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(int numericCode) {
        this.numericCode = numericCode;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
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
}
