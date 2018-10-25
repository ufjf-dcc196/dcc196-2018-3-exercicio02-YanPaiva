package com.example.yan.exercicio02_yan;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewSeriadoActivity extends AppCompatActivity {
    private Button btnCadastrarSerie;
    private EditText edtSeriado;
    private EditText edtTemporada;
    private EditText edtNumTemporada;
    private EditText edtEpisodeo;
    private EditText edtNumEpisodeo;
    private SeriadoDBHelper dbHelper;
    private SeriadoAdapter adapter;
    private RecyclerView rcSeriado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_seriado);

        dbHelper = new SeriadoDBHelper(getApplicationContext());


        btnCadastrarSerie = (Button) findViewById(R.id.btn_new_seriado_cadastrar);
        edtSeriado = findViewById(R.id.edt_txt_New_seriado_Nome);
        edtTemporada = findViewById(R.id.edt_txt_New_seriado_Temporada);
        edtNumTemporada = findViewById(R.id.edt_txt_new_seriado_NumTemp);
        edtEpisodeo = findViewById(R.id.edt_txt_New_seriado_Episodeo);
        edtNumEpisodeo = findViewById(R.id.edt_txt_new_seriado_NumTemp2);


        btnCadastrarSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues valores = new ContentValues();
                valores.put(SeriadoContract.SeriadoBD.COLUMN_NAME_NOME,edtSeriado.getText().toString());
                long id = db.insert(SeriadoContract.SeriadoBD.TABLE_NAME,null, valores);

                valores = new ContentValues();
                valores.put(SeriadoContract.TemporadaBD.COLUMN_NAME_TITULO, edtTemporada.getText().toString());
                valores.put(SeriadoContract.TemporadaBD.COLUMN_NAME_NUMERO, edtNumTemporada.getText().toString());
                valores.put(SeriadoContract.TemporadaBD.COLUMN_NAME_ID_SERIADO, id);
                id = db.insert(SeriadoContract.TemporadaBD.TABLE_NAME,null, valores);

                valores = new ContentValues();
                valores.put(SeriadoContract.EpisodeoBD.COLUMN_NAME_TITULO, edtEpisodeo.getText().toString());
                valores.put(SeriadoContract.EpisodeoBD.COLUMN_NAME_NUMERO, edtNumEpisodeo.getText().toString());
                valores.put(SeriadoContract.EpisodeoBD.COLUMN_NAME_ID_TEMPORADA, id);
                db.insert(SeriadoContract.EpisodeoBD.TABLE_NAME,null, valores);


                Intent resultado = new Intent();
                setResult(Activity.RESULT_OK, resultado);
                finish();

            }
        });

    }
}
