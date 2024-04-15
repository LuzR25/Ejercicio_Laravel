package com.example.multichat.Interface;

import com.example.multichat.modelos.Publicacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("publicaciones")
    Call<List<Publicacion>> getPublicaciones();

    @POST("publicaciones")
    @FormUrlEncoded
    Call<Publicacion> savePublicacion(
            @Field("nombre") String nombre,
            @Field("descripcion") String descripcion
    );

}
