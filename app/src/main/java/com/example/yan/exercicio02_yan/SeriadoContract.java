package com.example.yan.exercicio02_yan;

import android.provider.BaseColumns;

public final class SeriadoContract {
    public final class SeriadoBD implements BaseColumns{
        public final static String TABLE_NAME = "Seriado";
        public final static String COLUMN_NAME_NOME = "nome";
        public final static String CREATE_SERIADO  = "CREATE TABLE "+SeriadoBD.TABLE_NAME+" ("
                + SeriadoBD._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SeriadoBD.COLUMN_NAME_NOME+ " TEXT "
                +")";
        public final static String DROP_SERIADO = "DROP TABLE IF EXISTS "+SeriadoBD.TABLE_NAME;

    }
    public final class TemporadaBD implements BaseColumns{
        public final static String TABLE_NAME = "Temporada";
        public final static String COLUMN_NAME_TITULO = "titulo";
        public final static String COLUMN_NAME_NUMERO = "numero";
        public final static String COLUMN_NAME_ID_SERIADO = "id_seriado";

        public final static String CREATE_TEMPORADA  = "CREATE TABLE "+TemporadaBD.TABLE_NAME+" ("
                + TemporadaBD._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TemporadaBD.COLUMN_NAME_TITULO+ " TEXT, "
                + TemporadaBD.COLUMN_NAME_NUMERO+ " INTEGER, "
                + TemporadaBD.COLUMN_NAME_ID_SERIADO + " INTEGER,"+
                " FOREIGN KEY ("+EpisodeoBD.COLUMN_NAME_ID_SERIADO+" REFERENCES ("
                +SeriadoBD._ID+")"
                +")";
        public final static String DROP_TEMPORADA = "DROP TABLE IF EXISTS "+SeriadoBD.TABLE_NAME;

    }
    public final class EpisodeoBD implements BaseColumns{
        public final static String TABLE_NAME = "Episodeo";
        public final static String COLUMN_NAME_TITULO = "titulo";
        public final static String COLUMN_NAME_NUMERO = "numero";
        public final static String COLUMN_NAME_ID_SERIADO = "id_temporada";

        public final static String CREATE_EPISODEO  = "CREATE TABLE "+EpisodeoBD.TABLE_NAME+" ("
                + EpisodeoBD._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EpisodeoBD.COLUMN_NAME_TITULO+ " TEXT, "
                + EpisodeoBD.COLUMN_NAME_NUMERO+ " INTEGER, "
                + EpisodeoBD.COLUMN_NAME_ID_SERIADO + " INTEGER," +
                " FOREIGN KEY ("+EpisodeoBD.COLUMN_NAME_ID_SERIADO+" REFERENCES ("+
                TemporadaBD._ID+")"
                +")";
        public final static String DROP_EPISODEO = "DROP TABLE IF EXISTS "+SeriadoBD.TABLE_NAME;


    }
}
