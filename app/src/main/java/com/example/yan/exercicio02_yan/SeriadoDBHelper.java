package com.example.yan.exercicio02_yan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SeriadoDBHelper extends SQLiteOpenHelper {
    public final static int DATABASE_VERSION = 1;
    public final static String DATABASE_NAME = "Seriado.db";

    public SeriadoDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SeriadoContract.SeriadoBD.CREATE_SERIADO);
        db.execSQL(SeriadoContract.TemporadaBD.CREATE_TEMPORADA);
        db.execSQL(SeriadoContract.EpisodeoBD.CREATE_EPISODEO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SeriadoContract.EpisodeoBD.DROP_EPISODEO);
        db.execSQL(SeriadoContract.TemporadaBD.DROP_TEMPORADA);
        db.execSQL(SeriadoContract.SeriadoBD.DROP_SERIADO);
        onCreate(db);
    }
}
