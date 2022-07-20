package gg.rubit.api;

import java.util.List;

import gg.rubit.Entidades.DatosConversacion;
import gg.rubit.Entidades.DatosUsuarios;
import gg.rubit.api.response.IdResponse;
import gg.rubit.api.response.UserResponse;
import gg.rubit.api.request.RequestGame;
import gg.rubit.api.request.RequestUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("login")
    Call<UserResponse> login(@Body RequestUser request);

    @POST("usuarios")
    Call<IdResponse> postRegistrarUsuarios(@Body DatosUsuarios estudiante);

    @POST("datos_usuarios")
    Call<UserResponse> postRegistrarDatosUsuarios(@Body DatosUsuarios estudiante);

    @POST("usuarios")
    Call<Integer> postRegistrarPartida(@Body RequestGame partida);

    @GET("conversacion")
    Call<List<DatosConversacion>> getDialogsList();
}
