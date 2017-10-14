package com.example.nsolanki.qualtechassignment.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QualtechSqliteDBHelper extends SQLiteOpenHelper {

    private static QualtechSqliteDBHelper instance;

    public QualtechSqliteDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public QualtechSqliteDBHelper(Context context) {
        super(context, DatabaseMetadata.DATABASE_NAME, null, DatabaseMetadata.DATABASE_VERSION);
    }

    public static synchronized QualtechSqliteDBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new QualtechSqliteDBHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatabaseMetadata.Countries.CREATE_TABLE);
        sqLiteDatabase.execSQL(DatabaseMetadata.Languages.CREATE_TABLE);
        sqLiteDatabase.execSQL(DatabaseMetadata.Currencies.CREATE_TABLE);
        sqLiteDatabase.execSQL(DatabaseMetadata.Borders.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int previousVersion, int newVersion) {

    }
}
