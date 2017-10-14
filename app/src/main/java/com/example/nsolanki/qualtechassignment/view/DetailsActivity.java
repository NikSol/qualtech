package com.example.nsolanki.qualtechassignment.view;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nsolanki.qualtechassignment.PermissionConstants;
import com.example.nsolanki.qualtechassignment.R;
import com.example.nsolanki.qualtechassignment.StringConstants;
import com.example.nsolanki.qualtechassignment.contract.IDetailsContract;
import com.example.nsolanki.qualtechassignment.database.QualtechDBManager;
import com.example.nsolanki.qualtechassignment.model.entity.BorderCountriesDataEntity;
import com.example.nsolanki.qualtechassignment.model.entity.CountriesDataEntity;
import com.example.nsolanki.qualtechassignment.model.entity.CurrenciesDataEntity;
import com.example.nsolanki.qualtechassignment.model.entity.LanguagesDataEntity;
import com.example.nsolanki.qualtechassignment.presenter.DetailsPresenter;

import static com.example.nsolanki.qualtechassignment.view.ViewConstants.COUNTRY_SELECTED;

public class DetailsActivity extends AppCompatActivity implements IDetailsContract.IDetailsView {

    private static final String TAG = DetailsActivity.class.getSimpleName();
    private DetailsPresenter mDetailsPresenter;
    private QualtechDBManager mQualtechDBManager;
    private CountriesDataEntity mCountriesDataEntity;

    EditText mCountryEditText, mAlpha2CodeEditText, mAlpha3CodeEditText, mCapitalEditText, mRegionEditText,
            mSubRegionEditText, mPopulationEditText, mDemonymEditText, mAreaEditText, mGiniEditText, mNativeNameEditText, mNumericCodeEditText, mRelevanceEditText;
    TextView mBordersTextView, mCurrenciesTextView, mLanguagesTextView;
    Button mUpdateButton, mDeleteButton, mCameraButton, mDialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetailsPresenter = new DetailsPresenter();
        mQualtechDBManager = QualtechDBManager.getInstance(this);
        setContentView(R.layout.activity_details);
        findViewsById();
        receiveDataFromBundle(getIntent());
        setDataToView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDetailsPresenter.bind(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDetailsPresenter.unbind();
    }

    private void findViewsById() {
        mCountryEditText = findViewById(R.id.details_country_et);
        mAlpha2CodeEditText = findViewById(R.id.details_alpha2Code_et);
        mAlpha3CodeEditText = findViewById(R.id.details_alpha3Code_et);
        mCapitalEditText = findViewById(R.id.details_capital_et);
        mRegionEditText = findViewById(R.id.details_region_et);
        mSubRegionEditText = findViewById(R.id.details_subregion_et);
        mPopulationEditText = findViewById(R.id.details_population_et);
        mDemonymEditText = findViewById(R.id.details_demonym_et);
        mAreaEditText = findViewById(R.id.details_area_et);
        mGiniEditText = findViewById(R.id.details_gini_et);
        mNativeNameEditText = findViewById(R.id.details_nativeName_et);
        mNumericCodeEditText = findViewById(R.id.details_numericCode_et);
        mRelevanceEditText = findViewById(R.id.details_relevance_et);
        mBordersTextView = findViewById(R.id.details_borders_tv);
        mCurrenciesTextView = findViewById(R.id.details_currencies_tv);
        mLanguagesTextView = findViewById(R.id.details_languages_tv);
        mUpdateButton = findViewById(R.id.details_update_button);
        mDeleteButton = findViewById(R.id.details_delete_button);
        mCameraButton = findViewById(R.id.details_camera_button);
        mDialButton = findViewById(R.id.details_dial_button);
        mCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(DetailsActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(DetailsActivity.this,
                            Manifest.permission.CAMERA)) {
                        buildPermissionRationaleDialog(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    requestPermissions(new String[]{Manifest.permission.CAMERA}, PermissionConstants.PERMISSION_CAMERA);
                                }
                            }
                        }, getResources().getString(R.string.string_title_camera), getResources().getString(R.string.string_messgae_camera)).show();
                    } else {
                        ActivityCompat.requestPermissions(DetailsActivity.this,
                                new String[]{Manifest.permission.CAMERA},
                                PermissionConstants.PERMISSION_CAMERA);
                    }
                }
            }
        });

        mDialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(DetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(DetailsActivity.this,
                            Manifest.permission.CALL_PHONE)) {
                        buildPermissionRationaleDialog(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PermissionConstants.PERMISSION_CALL);
                                }
                            }
                        }, getResources().getString(R.string.string_title_call_phone), getResources().getString(R.string.string_messgae_phone)).show();
                    } else {
                        ActivityCompat.requestPermissions(DetailsActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                PermissionConstants.PERMISSION_CALL);
                    }
                } else {
                    iniateCall();
                }
            }
        });
        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDetailsPresenter.handleUpdateButtonClick(mQualtechDBManager);
            }
        });
        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDetailsPresenter.handleDeleteButtonClick(mQualtechDBManager);
            }
        });
    }

    private void receiveDataFromBundle(Intent intent) {
        if (intent == null)
            return;
        Bundle bundle = intent.getExtras();
        if (bundle == null)
            return;
        mCountriesDataEntity = bundle.getParcelable(COUNTRY_SELECTED);
    }

    private void setDataToView() {
        if (mCountriesDataEntity == null)
            return;
        if (mCountriesDataEntity.getCountryName() != null)
            mCountryEditText.setText(mCountriesDataEntity.getCountryName());
        if (mCountriesDataEntity.getAlpha2Code() != null)
            mAlpha2CodeEditText.setText(mCountriesDataEntity.getAlpha2Code());
        if (mCountriesDataEntity.getAlpha3Code() != null)
            mAlpha3CodeEditText.setText(mCountriesDataEntity.getAlpha3Code());
        if (mCountriesDataEntity.getCapital() != null)
            mCapitalEditText.setText(mCountriesDataEntity.getCapital());
        if (mCountriesDataEntity.getRegion() != null)
            mRegionEditText.setText(mCountriesDataEntity.getRegion());
        if (mCountriesDataEntity.getSubRegion() != null)
            mSubRegionEditText.setText(mCountriesDataEntity.getSubRegion());
        mPopulationEditText.setText(String.valueOf(mCountriesDataEntity.getPopulation()));
        if (mCountriesDataEntity.getDemonym() != null)
            mDemonymEditText.setText(mCountriesDataEntity.getDemonym());
        mAreaEditText.setText(String.valueOf(mCountriesDataEntity.getArea()));
        mGiniEditText.setText(String.valueOf(mCountriesDataEntity.getGini()));
        if (mCountriesDataEntity.getNativeName() != null)
            mNativeNameEditText.setText(mCountriesDataEntity.getNativeName());
        if (mCountriesDataEntity.getNumericCode() != null)
            mNumericCodeEditText.setText(mCountriesDataEntity.getNumericCode());
        if (mCountriesDataEntity.getRelevance() != null)
            mRelevanceEditText.setText(mCountriesDataEntity.getRelevance());

        StringBuilder borders = new StringBuilder(getString(R.string.label_border));
        for (int i = 0; i < mCountriesDataEntity.getBorderCountriesDataEntityList().size(); i++) {
            BorderCountriesDataEntity borderCountriesDataEntity = mCountriesDataEntity.getBorderCountriesDataEntityList().get(i);
            borders.append(borderCountriesDataEntity.getBorderCountry());
            if (i != mCountriesDataEntity.getBorderCountriesDataEntityList().size() - 1)
                borders.append(StringConstants.COMMA).append(StringConstants.SPACE);
        }
        mBordersTextView.setText(borders.toString());

        StringBuilder currencies = new StringBuilder(getString(R.string.label_country));
        for (int i = 0; i < mCountriesDataEntity.getCurrenciesDataEntityList().size(); i++) {
            CurrenciesDataEntity currenciesDataEntity = mCountriesDataEntity.getCurrenciesDataEntityList().get(i);
            currencies.append(currenciesDataEntity.getCurrencyName());
            if (i != mCountriesDataEntity.getBorderCountriesDataEntityList().size() - 1)
                currencies.append(StringConstants.COMMA).append(StringConstants.SPACE);
        }
        mCurrenciesTextView.setText(currencies.toString());

        StringBuilder languages = new StringBuilder(getString(R.string.label_language));
        for (int i = 0; i < mCountriesDataEntity.getLanguagesDataEntityList().size(); i++) {
            LanguagesDataEntity languagesDataEntity = mCountriesDataEntity.getLanguagesDataEntityList().get(i);
            languages.append(languagesDataEntity.getLanguages());
            if (i != mCountriesDataEntity.getBorderCountriesDataEntityList().size() - 1)
                languages.append(StringConstants.COMMA).append(StringConstants.SPACE);
        }
        mLanguagesTextView.setText(languages.toString());
    }

    @Override
    public CountriesDataEntity provideDataForUpdate() {
        try {
            mCountriesDataEntity.setCountryName(mCountryEditText.getText().toString());
            mCountriesDataEntity.setAlpha2Code(mAlpha2CodeEditText.getText().toString());
            mCountriesDataEntity.setAlpha3Code(mAlpha3CodeEditText.getText().toString());
            mCountriesDataEntity.setCapital(mCapitalEditText.getText().toString());
            mCountriesDataEntity.setRegion(mRegionEditText.getText().toString());
            mCountriesDataEntity.setSubRegion(mSubRegionEditText.getText().toString());
            String population = mPopulationEditText.getText().toString();
            if (!population.isEmpty()) {
                mCountriesDataEntity.setPopulation(Long.parseLong(population));
            } else {
                mCountriesDataEntity.setPopulation(0l);
            }
            mCountriesDataEntity.setDemonym(mDemonymEditText.getText().toString());
            String area = mAreaEditText.getText().toString();
            if (!area.isEmpty()) {
                mCountriesDataEntity.setArea(Long.parseLong(area));
            } else {
                mCountriesDataEntity.setArea(0l);
            }
            String gini = mGiniEditText.getText().toString();
            if (!gini.isEmpty()) {
                mCountriesDataEntity.setGini(Float.parseFloat(gini));
            } else {
                mCountriesDataEntity.setGini(0.0f);
            }
            mCountriesDataEntity.setNativeName(mNativeNameEditText.getText().toString());
            mCountriesDataEntity.setNumericCode(mNumericCodeEditText.getText().toString());
            mCountriesDataEntity.setRelevance(mRelevanceEditText.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mCountriesDataEntity;
    }

    @Override
    public void navigateBackToListing() {
        finish();
    }

    @Override
    public String provideUpdateErrorString() {
        return getString(R.string.update_error_message);
    }

    @Override
    public String provideDeleteErrorString() {
        return getString(R.string.delete_error_message);
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PermissionConstants.PERMISSION_CALL:
                checkForPermissionGrant(grantResults, permissions);
                break;
            case PermissionConstants.PERMISSION_CAMERA:
                checkForPermissionGrantCamera(grantResults, permissions);
            default:
                break;
        }
    }

    public void checkForPermissionGrant(int[] grantResults, String[] permissions) {
        if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            iniateCall();
        }

    }

    public void checkForPermissionGrantCamera(int[] grantResults, String[] permissions) {
        if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openCamera();
        }

    }

    @SuppressLint("MissingPermission")
    private void openCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    @SuppressLint("MissingPermission")
    private void iniateCall() {
        String number = "23454568678";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }


    protected AlertDialog.Builder buildPermissionRationaleDialog(DialogInterface.OnClickListener listener, String title, String Message) {
        return new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(Message)
                .setPositiveButton(android.R.string.ok, listener)
                .setCancelable(true);
    }
}
