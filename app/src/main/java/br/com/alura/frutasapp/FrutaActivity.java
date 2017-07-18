package br.com.alura.frutasapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by user on 14/07/2017.
 */

class FrutaActivity extends AppCompatActivity{

    private FrutaHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruta);

        //Novo FormularioHelper, passando como parametro o this, que ? uma refer?ncia para FormularioActivity.
        helper = new FrutaHelper(this);

        //Recuperando a Intent passada pelo ListaAlunosActivity.
        Intent intent = getIntent();
        Fruta fruta = (Fruta) intent.getSerializableExtra("fruta");
        if (fruta != null) {
            helper.preencheInfo(fruta);
        }
    }

}
