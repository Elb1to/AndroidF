package gg.rubit.api.request;

import java.util.HashMap;
import java.util.Map;

public class RankingPodioRequest {


    private String nombre;
    private String apellido;
    private long puntajeac;

    public RankingPodioRequest(String nombre, String apellido, long puntajeac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntajeac = puntajeac;
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public long getPuntajeac() {
        return puntajeac;
    }


    public void setPuntajeac(long puntajeac) {
        this.puntajeac = puntajeac;
    }
}