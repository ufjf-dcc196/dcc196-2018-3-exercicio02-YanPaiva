package com.example.yan.exercicio02_yan;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class SerieActivity extends AppCompatActivity {
    private RecyclerView rcSeriados;
    private SeriadoDBHelper dbHelper;
    private SeriadoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);
        dbHelper = new SeriadoDBHelper(getApplicationContext());
        rcSeriados = (RecyclerView) findViewById(R.id.RecyclerViewSerie);
        adapter = new SeriadoAdapter(getCursorSeriado());
        adapter.setCursor(getCursorSeriado());
        rcSeriados.setAdapter(adapter);
        rcSeriados.setLayoutManager(new LinearLayoutManager(this));



    }
    private Cursor getCursorSeriado() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] visao = {
                SeriadoContract.SeriadoBD.COLUMN_NAME_NOME,
                SeriadoContract.SeriadoBD._ID
        };
        String sort = SeriadoContract.SeriadoBD.COLUMN_NAME_NOME+ " DESC";
        Cursor c = db.query(SeriadoContract.SeriadoBD.TABLE_NAME, visao,null,null,null,null, sort);
        Log.i("SQLTEST", "getCursorSeriado: "+c.getCount());
        return c;
    }
}
