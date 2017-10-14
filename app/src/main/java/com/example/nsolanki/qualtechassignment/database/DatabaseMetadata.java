package com.example.nsolanki.qualtechassignment.database;


public class DatabaseMetadata {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "qualtech.db";

    public static class Countries {
        public static final String TABLE_COUNTRIES = "COUNTRIES";
        public static final String COUNTRY_ID = "COUNTRY_ID";
        public static final String COUNTRY_NAME = "COUNTRY_NAME";
        public static final String ALPHA_CODE2 = "ALPHA_CODE2";
        public static final String ALPHA_CODE3 = "ALPHA_CODE3";
        public static final String CAPITAL = "CAPITAL";
        public static final String REGION = "REGION";
        public static final String SUBREGION = "SUBREGION";
        public static final String POPULATION = "POPULATION";
        public static final String DEMONYM = "DEMONYM";
        public static final String AREA = "AREA";
        public static final String GINI = "GINI";
        public static final String RELEVANCE = "RELEVANCE";
        public static final String NATIVE_NAME = "NATIVE_NAME";
        public static final String NUMERIC_CODE = "NUMERIC_CODE";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_COUNTRIES + " ( " + COUNTRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COUNTRY_NAME + " TEXT ," + ALPHA_CODE2 + " TEXT," + ALPHA_CODE3 + " TEXT," + CAPITAL + " TEXT," +
                REGION + " TEXT," + SUBREGION + " TEXT," + POPULATION + " INTEGER," + DEMONYM + " TEXT," + AREA + " INTEGER," + GINI + " INTEGER," + RELEVANCE + " INTEGER," + NATIVE_NAME + " TEXT," + NUMERIC_CODE + " INTEGER" + ")";

        public static final String[] COLUMNS = {COUNTRY_ID, COUNTRY_NAME, ALPHA_CODE2, ALPHA_CODE3, CAPITAL, REGION, SUBREGION, POPULATION, DEMONYM, AREA, GINI, RELEVANCE, NATIVE_NAME, NUMERIC_CODE};

    }

    public static class Languages {
        public static final String TABLE_LANGUAGES = "LANGUAGES";
        public static final String LANG_COUNTRY_ID = "COUNTRY_ID";
        public static final String LANGUAGE_NAME = "LANGUAGE_NAME";
        public static final String[] COLUMNS = {LANG_COUNTRY_ID, LANGUAGE_NAME};
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_LANGUAGES + " ( " + LANG_COUNTRY_ID + " INTEGER," + LANGUAGE_NAME + " TEXT" + ")";

    }

    public static class Currencies {
        public static final String TABLE_CURRENCY = "CURRENCY";
        public static final String CURRENCY_COUNTRY_ID = "COUNTRY_ID";
        public static final String CURRENCY_NAME = "CURRENCY_NAME";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_CURRENCY + " ( " + CURRENCY_COUNTRY_ID + " INTEGER," + CURRENCY_NAME + " TEXT" + ")";
        public static final String[] COLUMNS = {CURRENCY_COUNTRY_ID, CURRENCY_NAME};
    }

    public static class Borders {
        public static final String TABLE_BORDERS = "BORDERS";
        public static final String BORDERS_COUNTRY_ID = "COUNTRY_ID";
        public static final String BORDERS_NAME = "BORDER_NAME";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_BORDERS + " ( " + BORDERS_COUNTRY_ID + " INTEGER," + BORDERS_NAME + " TEXT" + ")";
        public static final String[] COLUMNS = {BORDERS_COUNTRY_ID, BORDERS_NAME};
    }
}
