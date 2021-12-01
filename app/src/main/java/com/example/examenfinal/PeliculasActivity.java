package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.examenfinal.adapter.PeliculasAdapter;
import com.example.examenfinal.services.PeliculasService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeliculasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);

        RecyclerView rv = findViewById(R.id.rvListaPelis);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/peliculas/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PeliculasService peliculasService = retrofit.create(PeliculasService.class);

        peliculasService.getAll().enqueue(new Callback<List<Peliculas>>() {
            @Override
            public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                if(response.code()==200){
                    PeliculasAdapter adapter = new PeliculasAdapter(response.body());
                    rv.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<Peliculas>> call, Throwable t) {
                Log.i("Main_app","No hay conexion");
            }
        });
    }

}