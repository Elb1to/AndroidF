package gg.rubit.Services;

import gg.rubit.Entidades.DatosConversacion;
import gg.rubit.Entidades.DatosUsuarios;
import gg.rubit.Request.PartidaRequest;
import gg.rubit.Request.UsuarioRequest;
import gg.rubit.Response.IdResponse;
import gg.rubit.Response.UsuarioResponse;

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
