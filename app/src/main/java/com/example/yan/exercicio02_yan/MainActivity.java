package com.example.yan.exercicio02_yan;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import Model.Seriado;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_LISTA_SERIADO = 1;
    private static final int REQUEST_CADASTRA_SERIADO = 2;

    public static final ArrayList<Seriado> seriados = new ArrayList<>();

    private Button btnCadastroSeriado;
    private Button btnListarSeriado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCadastroSeriado = findViewById(R.id.btn_CadastrarSeries);
        btnListarSeriado = findViewById(R.id.btn_MeuSeriado);
        btnCadastroSeriado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewSeriadoActivity.class);
                startActivityForResult(intent,  REQUEST_CADASTRA_SERIADO);
            }
        });

        btnListarSeriado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SerieActivity.class);
                startActivityForResult(intent,  REQUEST_LISTA_SERIADO);
            }
        });

    }
/*     @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MainActivity.REQUEST_LISTA_SERIADO && resultCode== Activity.RESULT_OK && data != null){
            Bundle bundleResultado = data.getExtras();


        }else if(requestCode == MainActivity.REQUEST_EMAIL && resultCode== Activity.RESULT_OK && data != null){

            Bundle bundleResultado = data.getExtras();
            String email = bundleResultado.getString(MainActivity.EXTERNO_EMAIL);
            String nome = bundleResultado.getString(MainActivity.EXTERNO_NOME);
            Toast.makeText(getApplicationContext(), "EXTERNO: "+nome+ " EMAIL: "+email, Toast.LENGTH_SHORT).show();
            contExterno++;
            txtQtdExterno.setText(Integer.toString(contExterno));
        }
    }*/
}
