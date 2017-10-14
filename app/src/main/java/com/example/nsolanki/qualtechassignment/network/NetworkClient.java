package com.example.nsolanki.qualtechassignment.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NetworkClient {

    private String BASE_URL = "https://restcountries.eu/rest/v1/all/";
    private static NetworkClient instance;
    Retrofit mRetrofit;

    public <T> T create(Class<T> service) {
        if (mRetrofit == null) {
            initRetrofit();
        }
        return mRetrofit.create(service);
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(initOkHttpClient())
                .build();
    }

    private OkHttpClient initOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        return builder.build();
    }
}
