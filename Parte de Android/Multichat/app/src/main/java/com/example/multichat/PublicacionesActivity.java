package com.example.multichat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.multichat.Config.Config;
import com.example.multichat.Interface.ApiService;
import com.example.multichat.modelos.Publicacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PublicacionesActivity extends AppCompatActivity {

    private ListView lv;
    private EditText nombre, mensaje;
    private Button btnEnviar;
    private AdapterPublicaciones adapter;
    private ApiService servicio = Config.getRetrofit().create(ApiService.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicaciones);

        lv = findViewById(R.id.listaMensajes);
        nombre = findViewById(R.id.nombre);
        mensaje = findViewById(R.id.mensaje);
        btnEnviar = findViewById(R.id.btnEnviar);

        getPublicaciones();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nombre.getText().toString().isEmpty()) {
                    Config.mensaje(getApplicationContext(), "Ingrese un nombre");
                } else if(mensaje.getText().toString().isEmpty()) {
                    Config.mensaje(getApplicationContext(), "Escriba un mensaje");
                } else {
                    savePublicacion(nombre.getText().toString(), mensaje.getText().toString());
                }
            }
        });

    }

    private void savePublicacion(String nombre, String mensaje) {
        Call<Publicacion> call = servicio.savePublicacion(nombre, mensaje);

        call.enqueue(new Callback<Publicacion>() {
            @Override
            public void onResponse(Call<Publicacion> call, Response<Publicacion> response) {
                if (response.isSuccessful()) {
                    Config.mensaje(getApplicationContext(), "Envío exitoso");
                    startActivity(new Intent(getApplicationContext(), PublicacionesActivity.class));
                    finish();
                } else {
                    Config.mensaje(getApplicationContext(), "Error");
                }
            }

            @Override
            public void onFailure(Call<Publicacion> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });
    }

    private void getPublicaciones() {
        Call<List<Publicacion>> listCall = servicio.getPublicaciones();

        listCall.enqueue(new Callback<List<Publicacion>>() {
            @Override
            public void onResponse(Call<List<Publicacion>> call, Response<List<Publicacion>> response) {
                Log.d("ERROR", response.body().toString());
                adapter = new AdapterPublicaciones(getApplicationContext(), response.body());
                lv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Publicacion>> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });
    }

    class AdapterPublicaciones extends ArrayAdapter<Publicacion> {
        List<Publicacion> listaPublicaciones;

        public AdapterPublicaciones(@NonNull Context context, List<Publicacion> lista) {
            super(context, R.layout.publicacion, lista);
            listaPublicaciones = lista;
        }



        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.publicacion, null);
            TextView n = view.findViewById(R.id.txtNombre);
            TextView g = view.findViewById(R.id.txtMensaje);

            n.setText(listaPublicaciones.get(position).getNombre());
            g.setText(listaPublicaciones.get(position).getDescripcion());

            return view;
        }
    }
}