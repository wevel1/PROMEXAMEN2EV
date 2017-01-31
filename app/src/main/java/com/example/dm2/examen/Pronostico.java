package com.example.dm2.examen;

import java.util.Date;

/**
 * Created by dm2 on 31/01/2017.
 */
public class Pronostico {
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora_datos(String hora_datos) {
        this.hora_datos = hora_datos;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public void setViento(String viento) {
        this.viento = viento;
    }

    public void setDir_viento(String dir_viento) {
        this.dir_viento = dir_viento;
    }

    public void setIco_viento(String ico_viento) {
        this.ico_viento = ico_viento;
    }

    public String getFecha() {

        return fecha;
    }

    public String getHora_datos() {
        return hora_datos;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public String getTexto() {
        return texto;
    }

    public String getHumedad() {
        return humedad;
    }

    public String getPresion() {
        return presion;
    }

    public String getIcono() {
        return icono;
    }

    public String getViento() {
        return viento;
    }

    public String getDir_viento() {
        return dir_viento;
    }

    public String getIco_viento() {
        return ico_viento;
    }

    private String fecha;
    private String hora_datos;
    private String temperatura;
    private String texto;
    private String humedad;
    private String presion;
    private String icono;
    private String viento;
    private String dir_viento;
    private String ico_viento;
}
