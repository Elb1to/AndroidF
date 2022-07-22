package com.example.lecchat.Servicios;

import com.example.lecchat.DatosConversacion.DatosConversacion;
import com.example.lecchat.DatosConversacion.SubTemas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface InterfacesAPI {

    //@GET("conversacion")
    //Call<List<DatosConversacion>> getLisTDialogs();


    @GET("conversacion/{id}")
    Call<List<DatosConversacion>> getListDialogs(@Path("id") int id);

    @GET("lecciones/{id}")
    Call<List<SubTemas>> getSubTemas(@Path("id") int id);

}
