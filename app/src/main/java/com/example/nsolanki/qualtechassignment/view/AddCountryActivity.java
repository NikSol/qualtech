package com.example.nsolanki.qualtechassignment.view;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nsolanki.qualtechassignment.R;
import com.example.nsolanki.qualtechassignment.contract.IAddCountryContract;
import com.example.nsolanki.qualtechassignment.database.QualtechDBManager;
import com.example.nsolanki.qualtechassignment.model.entity.BorderCountriesDataEntity;
import com.example.nsolanki.qualtechassignment.model.entity.CountriesDataEntity;
import com.example.nsolanki.qualtechassignment.model.entity.CurrenciesDataEntity;
import com.example.nsolanki.qualtechassignment.model.entity.LanguagesDataEntity;
import com.example.nsolanki.qualtechassignment.presenter.AddCountryPresenter;

import java.util.ArrayList;
import java.util.List;

public class AddCountryActivity extends AppCompatActivity implements IAddCountryContract.IAddCountryView {

    private AddCountryPresenter mAddCountryPresenter;
    private QualtechDBManager mQualtechDBManager;
    private EditText mCountryEditText, mAlpha2CodeEditText, mAlpha3CodeEditText, mCapitalEditText, mRegionEditText,
            mSubRegionEditText, mPopulationEditText, mDemonymEditText, mAreaEditText, mGiniEditText, mNativeNameEditText, mNumericCodeEditText,
            mRelevanceEditText, mBordersEditText, mCurrenciesEditText, mLanguagesEditText;
    private Button mAddCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAddCountryPresenter = new AddCountryPresenter();
        mQualtechDBManager = QualtechDBManager.getInstance(this);
        setContentView(R.layout.activity_add_country);
        findViewsById();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAddCountryPresenter.bind(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAddCountryPresenter.unbind();
    }

    private void findViewsById() {
        mCountryEditText = findViewById(R.id.add_country_country_et);
        mAlpha2CodeEditText = findViewById(R.id.add_country_alpha2Code_et);
        mAlpha3CodeEditText = findViewById(R.id.add_country_alpha3Code_et);
        mCapitalEditText = findViewById(R.id.add_country_capital_et);
        mRegionEditText = findViewById(R.id.add_country_region_et);
        mSubRegionEditText = findViewById(R.id.add_country_subregion_et);
        mPopulationEditText = findViewById(R.id.add_country_population_et);
        mDemonymEditText = findViewById(R.id.add_country_demonym_et);
        mAreaEditText = findViewById(R.id.add_country_area_et);
        mGiniEditText = findViewById(R.id.add_country_gini_et);
        mNativeNameEditText = findViewById(R.id.add_country_nativeName_et);
        mNumericCodeEditText = findViewById(R.id.add_country_numericCode_et);
        mRelevanceEditText = findViewById(R.id.add_country_relevance_et);
        mBordersEditText = findViewById(R.id.add_country_borders_et);
        mCurrenciesEditText = findViewById(R.id.add_country_currencies_et);
        mLanguagesEditText = findViewById(R.id.add_country_languages_et);
        mAddCountry = findViewById(R.id.add_country_button);
        mAddCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAddCountryPresenter.handleAddButtonClick(mQualtechDBManager);
            }
        });
    }

    @Override
    public CountriesDataEntity provideDataToAdd() {
        CountriesDataEntity countriesDataEntity = new CountriesDataEntity();
        try {
            countriesDataEntity.setCountryName(mCountryEditText.getText().toString());
            countriesDataEntity.setAlpha2Code(mAlpha2CodeEditText.getText().toString());
            countriesDataEntity.setAlpha3Code(mAlpha3CodeEditText.getText().toString());
            countriesDataEntity.setCapital(mCapitalEditText.getText().toString());
            countriesDataEntity.setRegion(mRegionEditText.getText().toString());
            countriesDataEntity.setSubRegion(mSubRegionEditText.getText().toString());
            String population = mPopulationEditText.getText().toString();
            if (!population.isEmpty()) {
                countriesDataEntity.setPopulation(Long.parseLong(population));
            }else{
                countriesDataEntity.setPopulation(0l);
            }
            countriesDataEntity.setDemonym(mDemonymEditText.getText().toString());
            String area = mAreaEditText.getText().toString();
            if (!area.isEmpty())
                countriesDataEntity.setArea(Long.parseLong(area));
            else
                countriesDataEntity.setArea(0l);
            String gini = mGiniEditText.getText().toString();
            if (!gini.isEmpty())
                countriesDataEntity.setGini(Long.parseLong(gini));
            else
                countriesDataEntity.setGini(0.0f);
            countriesDataEntity.setNativeName(mNativeNameEditText.getText().toString());
            countriesDataEntity.setNumericCode(mNumericCodeEditText.getText().toString());
            countriesDataEntity.setRelevance(mRelevanceEditText.getText().toString());

            List<BorderCountriesDataEntity> borderCountriesDataEntityList = new ArrayList<>();
            String borders = mBordersEditText.getText().toString();
            if (!borders.isEmpty()) {
                BorderCountriesDataEntity borderCountriesDataEntity = new BorderCountriesDataEntity();
                borderCountriesDataEntity.setBorderCountry(borders);
                borderCountriesDataEntityList.add(borderCountriesDataEntity);
                countriesDataEntity.setBorderCountriesDataEntityList(borderCountriesDataEntityList);
            }

            List<CurrenciesDataEntity> currenciesDataEntityList = new ArrayList<>();
            String currencies = mCurrenciesEditText.getText().toString();
            if (!currencies.isEmpty()) {
                CurrenciesDataEntity currenciesDataEntity = new CurrenciesDataEntity();
                currenciesDataEntity.setCurrencyName(currencies);
                currenciesDataEntityList.add(currenciesDataEntity);
                countriesDataEntity.setCurrenciesDataEntityList(currenciesDataEntityList);
            }

            List<LanguagesDataEntity> languagesDataEntityList = new ArrayList<>();
            String languages = mLanguagesEditText.getText().toString();
            if (!languages.isEmpty()) {
                LanguagesDataEntity languagesDataEntity = new LanguagesDataEntity();
                languagesDataEntity.setLanguages(languages);
                languagesDataEntityList.add(languagesDataEntity);
                countriesDataEntity.setLanguagesDataEntityList(languagesDataEntityList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countriesDataEntity;
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateBackToListing() {
        finish();
    }

    @Override
    public String provideAddErrorString() {
        return getString(R.string.add_error_message);
    }
}
