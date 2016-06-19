package com.example.lucas.estruturadados.config;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public class RetrofitConfig {

    private static final String BASE_URL = "empty"; //TODO include BASE_URL
    private Retrofit retrofit;

    public RetrofitConfig() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public <T> T createService(Class<T> tClass) {
        return retrofit.create(tClass);
    }

}
