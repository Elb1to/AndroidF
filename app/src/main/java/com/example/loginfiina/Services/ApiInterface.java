package com.example.loginfiina.Services;

import com.example.loginfiina.Entidades.DatosConversacion;
import com.example.loginfiina.Entidades.DatosUsuarios;
import com.example.loginfiina.Request.PartidaRequest;
import com.example.loginfiina.Request.UsuarioRequest;
import com.example.loginfiina.Response.IdResponse;
import com.example.loginfiina.Response.UsuarioResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("login")
    Call<UsuarioResponse> login(@Body UsuarioRequest request);

    @POST("usuarios")
    Call<IdResponse> postRegistrarUsuarios(@Body DatosUsuarios estudiante);

    @POST("datos_usuarios")
    Call<UsuarioResponse> postRegistrarDatosUsuarios(@Body DatosUsuarios estudiante);

    @POST("usuarios")
    Call<Integer> postRegistrarPartida(@Body PartidaRequest partida);

    @GET("conversacion")
    Call<List<DatosConversacion>> getDialogsList();
}
