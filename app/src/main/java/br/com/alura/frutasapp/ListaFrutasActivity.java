package br.com.alura.frutasapp;

import android.Manifest;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//http://www.devmedia.com.br/consumindo-json-em-aplicacoes-android/27589
public class ListaFrutasActivity extends AppCompatActivity {

    ListView listaFrutas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_frutas);

        listaFrutas = (ListView) findViewById(R.id.lista_frutas);
        // Capturando click em um item da lista.
        listaFrutas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Fruta fruta = (Fruta) listaFrutas.getItemAtPosition(position);
                Toast.makeText(ListaFrutasActivity.this,"Fruta " +fruta.getName()+ " clicada", Toast.LENGTH_SHORT).show();
                Intent intentVaiParaTelaDaFruta = new Intent(ListaFrutasActivity.this, FrutaActivity.class);
                intentVaiParaTelaDaFruta.putExtra("fruta", fruta);
                startActivity(intentVaiParaTelaDaFruta);
            }
        });


        Call<FrutaDTO> call = new FrutaRetrofit().getFrutaService().getFruta();
        call.enqueue(new Callback<FrutaDTO>() {
            @Override
            public void onResponse(Call<FrutaDTO> call, Response<FrutaDTO> response) {
                FrutaDTO frutas = response.body();
                Log.i("onResponse chamado", "onResponse chamado com sucesso ");
                carregaLista(frutas);
            }

            @Override
            public void onFailure(Call<FrutaDTO> call, Throwable t) {
                Log.e("onFailure chamado: ", t.getMessage());
            }
        });
    }

    private void carregaLista(FrutaDTO dto) {

        List<Fruta> frutas = dto.getFruits();
        for (Fruta fruta: frutas) {
            Log.i("Nome da fruta  ", fruta.getName());
        }
        FrutasAdapter adapter = new FrutasAdapter(this,frutas);
        listaFrutas.setAdapter(adapter);
    }

}
