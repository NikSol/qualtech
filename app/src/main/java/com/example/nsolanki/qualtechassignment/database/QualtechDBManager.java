package com.example.nsolanki.qualtechassignment.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nsolanki.qualtechassignment.model.entity.BorderCountriesDataEntity;
import com.example.nsolanki.qualtechassignment.model.entity.CountriesDataEntity;
import com.example.nsolanki.qualtechassignment.model.entity.CurrenciesDataEntity;
import com.example.nsolanki.qualtechassignment.model.entity.LanguagesDataEntity;

import java.util.ArrayList;
import java.util.List;

public class QualtechDBManager {

    private static final String TAG = QualtechDBManager.class.getSimpleName();
    private static QualtechDBManager instance;
    private QualtechSqliteDBHelper mQualtechSqliteDBHelper;
    private SQLiteDatabase database;
    private Context context;

    public QualtechDBManager(Context context) {
        this.context = context;
    }

    public QualtechDBManager() {

    }

    public static QualtechDBManager getInstance(Context context) {
        if (instance == null) {
            instance = new QualtechDBManager(context);
        }
        return instance;
    }

    public void openWritableDB() {
        mQualtechSqliteDBHelper = QualtechSqliteDBHelper.getInstance(context);
        database = mQualtechSqliteDBHelper.getWritableDatabase();
    }

    public void openReadableDB() {
        mQualtechSqliteDBHelper = QualtechSqliteDBHelper.getInstance(context);
        database = mQualtechSqliteDBHelper.getReadableDatabase();
    }

    public void closeDB() {
        mQualtechSqliteDBHelper.close();
        database.close();
    }

    public List<CountriesDataEntity> getCountriesListFromCusror(int countryId) {
        List<CountriesDataEntity> countriesDataEntityList = new ArrayList<>();
        Cursor cursor = null;
        String whereClause;
        if (countryId >= 0) {
            whereClause = DatabaseMetadata.Countries.COUNTRY_ID + "=" + countryId;
        } else {
            whereClause = null;
        }
        cursor = database.query(true, DatabaseMetadata.Countries.TABLE_COUNTRIES, DatabaseMetadata.Countries.COLUMNS, whereClause, null, null, null, null, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    CountriesDataEntity countriesDataEntity = new CountriesDataEntity();
                    countriesDataEntity.setCountryName(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Countries.COUNTRY_NAME)));
                    countriesDataEntity.setAlpha2Code(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Countries.ALPHA_CODE2)));
                    countriesDataEntity.setAlpha3Code(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Countries.ALPHA_CODE3)));
                    countriesDataEntity.setArea(cursor.getLong(cursor.getColumnIndex(DatabaseMetadata.Countries.AREA)));
                    countriesDataEntity.setCapital(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Countries.CAPITAL)));
                    countriesDataEntity.setDemonym(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Countries.DEMONYM)));
                    countriesDataEntity.setGini(cursor.getFloat(cursor.getColumnIndex(DatabaseMetadata.Countries.GINI)));
                    countriesDataEntity.setNativeName(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Countries.NATIVE_NAME)));
                    countriesDataEntity.setNumericCode(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Countries.NUMERIC_CODE)));
                    countriesDataEntity.setPopulation(cursor.getLong(cursor.getColumnIndex(DatabaseMetadata.Countries.POPULATION)));
                    countriesDataEntity.setRegion(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Countries.REGION)));
                    countriesDataEntity.setSubRegion(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Countries.SUBREGION)));
                    countriesDataEntity.setRelevance(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Countries.RELEVANCE)));
                    countriesDataEntity.setCountryId(cursor.getInt(cursor.getColumnIndex(DatabaseMetadata.Countries.COUNTRY_ID)));
                    countriesDataEntity.setBorderCountriesDataEntityList(getBorderCountriesDataEntityList(countriesDataEntity.getCountryId()));
                    countriesDataEntity.setLanguagesDataEntityList(getLanguagesDataEntityList(countriesDataEntity.getCountryId()));
                    countriesDataEntity.setCurrenciesDataEntityList(getCurrenciesDataEntityList(countriesDataEntity.getCountryId()));
                    countriesDataEntityList.add(countriesDataEntity);

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {

        }
        return countriesDataEntityList;
    }

    private List<CurrenciesDataEntity> getCurrenciesDataEntityList(int countryId) {
        List<CurrenciesDataEntity> currenciesDataEntityList = new ArrayList<>();
        Cursor cursor = null;
        try {
            if (database == null) {
                Log.v(TAG, "getLanguagesDataEntity database is null");
                return null;
            }
            String whereClause = DatabaseMetadata.Currencies.CURRENCY_COUNTRY_ID + "=" + countryId;
            cursor = database.query(true, DatabaseMetadata.Currencies.TABLE_CURRENCY, DatabaseMetadata.Currencies.COLUMNS, whereClause, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    CurrenciesDataEntity currenciesDataEntity = new CurrenciesDataEntity();
                    currenciesDataEntity.setCurrencyName(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Currencies.CURRENCY_NAME)));
                    currenciesDataEntityList.add(currenciesDataEntity);
                    currenciesDataEntity = null;
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return currenciesDataEntityList;
    }

    private List<LanguagesDataEntity> getLanguagesDataEntityList(int countryId) {
        List<LanguagesDataEntity> languagesDataEntityList = new ArrayList<>();
        Cursor cursor = null;
        try {
            if (database == null) {
                Log.v(TAG, "getLanguagesDataEntity database is null");
                return null;
            }
            String whereClause = DatabaseMetadata.Languages.LANG_COUNTRY_ID + "=" + countryId;
            cursor = database.query(true, DatabaseMetadata.Languages.TABLE_LANGUAGES, DatabaseMetadata.Languages.COLUMNS, whereClause, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    LanguagesDataEntity languagesDataEntity = new LanguagesDataEntity();
                    languagesDataEntity.setLanguages(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Languages.LANGUAGE_NAME)));
                    languagesDataEntityList.add(languagesDataEntity);
                    languagesDataEntity = null;
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return languagesDataEntityList;
    }

    private List<BorderCountriesDataEntity> getBorderCountriesDataEntityList(int countryId) {
        List<BorderCountriesDataEntity> borderCountriesDataEntityList = new ArrayList<>();
        Cursor cursor = null;
        try {
            if (database == null) {
                Log.v(TAG, "getBorderCountriesDataEntity database is null");
                return null;
            }
            String whereClause = DatabaseMetadata.Borders.BORDERS_COUNTRY_ID + "=" + countryId;
            cursor = database.query(true, DatabaseMetadata.Borders.TABLE_BORDERS, DatabaseMetadata.Borders.COLUMNS, whereClause, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {

                    BorderCountriesDataEntity boundaryCountriesDataEntity = new BorderCountriesDataEntity();
                    boundaryCountriesDataEntity.setBorderCountry(cursor.getString(cursor.getColumnIndex(DatabaseMetadata.Borders.BORDERS_NAME)));
                    borderCountriesDataEntityList.add(boundaryCountriesDataEntity);
                    boundaryCountriesDataEntity = null;
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return borderCountriesDataEntityList;
    }


    public long insertCountriesListEntityIntoDB(List<CountriesDataEntity> countriesDataEntityList) {
        openWritableDB();
        long count = 0;
        try {
            if (database == null) {
                return -1;
            }

            for (CountriesDataEntity countriesDataEntity : countriesDataEntityList) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseMetadata.Countries.COUNTRY_NAME, countriesDataEntity.getCountryName());
                contentValues.put(DatabaseMetadata.Countries.ALPHA_CODE2, countriesDataEntity.getAlpha2Code());
                contentValues.put(DatabaseMetadata.Countries.ALPHA_CODE3, countriesDataEntity.getAlpha3Code());
                contentValues.put(DatabaseMetadata.Countries.CAPITAL, countriesDataEntity.getCapital());
                contentValues.put(DatabaseMetadata.Countries.REGION, countriesDataEntity.getRegion());
                contentValues.put(DatabaseMetadata.Countries.SUBREGION, countriesDataEntity.getSubRegion());
                contentValues.put(DatabaseMetadata.Countries.POPULATION, countriesDataEntity.getPopulation());
                contentValues.put(DatabaseMetadata.Countries.DEMONYM, countriesDataEntity.getDemonym());
                contentValues.put(DatabaseMetadata.Countries.AREA, countriesDataEntity.getArea());
                contentValues.put(DatabaseMetadata.Countries.GINI, countriesDataEntity.getGini());
                contentValues.put(DatabaseMetadata.Countries.NATIVE_NAME, countriesDataEntity.getNativeName());
                contentValues.put(DatabaseMetadata.Countries.NUMERIC_CODE, countriesDataEntity.getNumericCode());
                contentValues.put(DatabaseMetadata.Countries.RELEVANCE, countriesDataEntity.getRelevance());
                long rowId = database.insert(DatabaseMetadata.Countries.TABLE_COUNTRIES, null, contentValues);
                if (countriesDataEntity.getBorderCountriesDataEntityList() != null && countriesDataEntity.getBorderCountriesDataEntityList().size() > 0) {
                    insertBorderListIntoDB(countriesDataEntity.getBorderCountriesDataEntityList(), rowId);
                }
                if (countriesDataEntity.getCurrenciesDataEntityList() != null && countriesDataEntity.getCurrenciesDataEntityList().size() > 0) {
                    insertCurrenciesIntoDB(countriesDataEntity.getCurrenciesDataEntityList(), rowId);
                }
                if (countriesDataEntity.getLanguagesDataEntityList() != null && countriesDataEntity.getLanguagesDataEntityList().size() > 0) {
                    insertLanguagesListIntoDB(countriesDataEntity.getLanguagesDataEntityList(), rowId);
                }
                count++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    private void insertLanguagesListIntoDB(List<LanguagesDataEntity> languagesDataEntityList, long rowId) {
        openWritableDB();
        long count = 0;
        try {
            if (database == null) {
                Log.e(TAG, "insertLanguagesDataEntityIntoDB database is null");
                return;
            }

            for (LanguagesDataEntity languagesDataEntity : languagesDataEntityList) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseMetadata.Languages.LANGUAGE_NAME, languagesDataEntity.getLanguages());
                contentValues.put(DatabaseMetadata.Languages.LANG_COUNTRY_ID, rowId);
                database.insert(DatabaseMetadata.Languages.TABLE_LANGUAGES, null, contentValues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertCurrenciesIntoDB(List<CurrenciesDataEntity> currenciesDataEntityList, long rowId) {
        openWritableDB();
        long count = 0;
        try {
            if (database == null) {
                return;
            }

            for (CurrenciesDataEntity currenciesDataEntity : currenciesDataEntityList) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseMetadata.Currencies.CURRENCY_NAME, currenciesDataEntity.getCurrencyName());
                contentValues.put(DatabaseMetadata.Currencies.CURRENCY_COUNTRY_ID, rowId);
                database.insert(DatabaseMetadata.Currencies.TABLE_CURRENCY, null, contentValues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertBorderListIntoDB(List<BorderCountriesDataEntity> borderCountriesDataEntityList, long rowId) {
        openWritableDB();
        long count = 0;
        try {
            if (database == null) {
                Log.e(TAG, "insertLanguagesDataEntityIntoDB database is null");
                return;
            }

            for (BorderCountriesDataEntity borderCountriesDataEntity : borderCountriesDataEntityList) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseMetadata.Borders.BORDERS_NAME, borderCountriesDataEntity.getBorderCountry());
                contentValues.put(DatabaseMetadata.Borders.BORDERS_COUNTRY_ID, rowId);
                database.insert(DatabaseMetadata.Borders.TABLE_BORDERS, null, contentValues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int deleteCountryEntry(int countryId) {
        openWritableDB();
        try {
            if (database == null) {
                Log.e(TAG, "deleteCountryEntry from database is null");
            }
            String whereClause = DatabaseMetadata.Countries.COUNTRY_ID + "=" + countryId;
            int count = database.delete(DatabaseMetadata.Countries.TABLE_COUNTRIES, whereClause, null);
            deleteBorderEntry(countryId);
            deleteLanguagesEntry(countryId);
            deleteCurrencyEntry(countryId);

            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int deleteBorderEntry(int countryId) {
        openWritableDB();
        try {
            if (database == null) {
                Log.e(TAG, "deleteBorderEntry from database is null");
            }
            String whereClause = DatabaseMetadata.Borders.BORDERS_COUNTRY_ID + "=" + countryId;
            int count = database.delete(DatabaseMetadata.Borders.TABLE_BORDERS, whereClause, null);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int deleteCurrencyEntry(int countryId) {
        openWritableDB();
        try {
            if (database == null) {
                Log.e(TAG, "deleteCurrencyEntry from database is null");
            }
            String whereClause = DatabaseMetadata.Currencies.CURRENCY_COUNTRY_ID + "=" + countryId;
            int count = database.delete(DatabaseMetadata.Currencies.TABLE_CURRENCY, whereClause, null);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int deleteLanguagesEntry(int countryId) {
        openWritableDB();
        try {
            if (database == null) {
                Log.e(TAG, "deleteLanguagesEntry from database is null");
            }
            String whereClause = DatabaseMetadata.Languages.LANG_COUNTRY_ID + "=" + countryId;
            int count = database.delete(DatabaseMetadata.Languages.TABLE_LANGUAGES, whereClause, null);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public long updateCountryDataEntry(CountriesDataEntity countryDataEntity) {
        openWritableDB();
        long count = 0;
        try {
            if (database == null) {
                Log.e(TAG, "updateCountryDataEntry database is null");
            }


            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseMetadata.Countries.COUNTRY_NAME, countryDataEntity.getCountryName());
            contentValues.put(DatabaseMetadata.Countries.ALPHA_CODE2, countryDataEntity.getAlpha2Code());
            contentValues.put(DatabaseMetadata.Countries.ALPHA_CODE3, countryDataEntity.getAlpha3Code());
            contentValues.put(DatabaseMetadata.Countries.CAPITAL, countryDataEntity.getCapital());
            contentValues.put(DatabaseMetadata.Countries.REGION, countryDataEntity.getRegion());
            contentValues.put(DatabaseMetadata.Countries.SUBREGION, countryDataEntity.getSubRegion());
            contentValues.put(DatabaseMetadata.Countries.POPULATION, countryDataEntity.getPopulation());
            contentValues.put(DatabaseMetadata.Countries.DEMONYM, countryDataEntity.getDemonym());
            contentValues.put(DatabaseMetadata.Countries.AREA, countryDataEntity.getArea());
            contentValues.put(DatabaseMetadata.Countries.GINI, countryDataEntity.getGini());
            contentValues.put(DatabaseMetadata.Countries.NATIVE_NAME, countryDataEntity.getNativeName());
            contentValues.put(DatabaseMetadata.Countries.NUMERIC_CODE, countryDataEntity.getNumericCode());
            contentValues.put(DatabaseMetadata.Countries.RELEVANCE, countryDataEntity.getRelevance());

            String whereClause = DatabaseMetadata.Countries.COUNTRY_ID + "=" + countryDataEntity.getCountryId();

            count = database.update(DatabaseMetadata.Countries.TABLE_COUNTRIES, contentValues, whereClause, null);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
