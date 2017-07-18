package br.com.alura.frutasapp;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by user on 15/07/2017.
 */

public class FrutaRetrofit {

    private final Retrofit retrofit;

    public FrutaRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/muxidev/desafio-android/master/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public FrutaService getFrutaService(){
        return retrofit.create(FrutaService.class);
    }

}
