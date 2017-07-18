package br.com.alura.frutasapp;

import android.widget.ImageView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by user on 14/07/2017.
 */

public interface FrutaService {

    @GET("fruits.json")
    Call<FrutaDTO> getFruta();

}
