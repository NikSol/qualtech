package com.example.nsolanki.qualtechassignment.network;

import com.example.nsolanki.qualtechassignment.model.entity.CountriesDataEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CountriesAPI {

    @GET("https://restcountries.eu/rest/v1/all")
    Call<List<CountriesDataEntity>> getCountriesList();
}
