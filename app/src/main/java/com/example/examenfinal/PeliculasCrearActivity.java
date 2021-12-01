package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examenfinal.services.PeliculasService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeliculasCrearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_crear);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/peliculas/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PeliculasService peliculasService = retrofit.create(PeliculasService.class);

        Button button = findViewById(R.id.btnCrear);

        EditText nombre = findViewById(R.id.eNombre);
        EditText fecha = findViewById(R.id.eFecha);
        EditText vistas = findViewById(R.id.eVistas);
        EditText tienda = findViewById(R.id.eTienda);
        EditText imagen = findViewById(R.id.eImagen);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Peliculas peliculas = new Peliculas();
                peliculas.setNombre(nombre.getText().toString());
                peliculas.setFechaEstreno(fecha.getText().toString());
                peliculas.setVistas(vistas.getText().toString());
                peliculas.setTiendas(tienda.getText().toString());
                peliculas.setImagen(imagen.getText().toString());

                peliculasService.crear(peliculas).enqueue(new Callback<Peliculas>() {
                    @Override
                    public void onResponse(Call<Peliculas> call, Response<Peliculas> response) {
                        if(response.code()==200){
                            Log.i("Main_app","conexion exitosa");
                        }
                        else{
                            Log.i("Main_app","error de conexion");
                        }
                    }
                    @Override
                    public void onFailure(Call<Peliculas> call, Throwable t) {
                        Log.i("Main_app","no hubo conexion");
                    }
                });
            }
        });
    }
}