package com.example.examenfinal.services;
import com.example.examenfinal.Peliculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface PeliculasService {
    @GET("N00038907")
    Call<List<Peliculas>> getAll();

    @POST("N00038907")
    Call<Peliculas> crear(@Body Peliculas peliculas);
}
