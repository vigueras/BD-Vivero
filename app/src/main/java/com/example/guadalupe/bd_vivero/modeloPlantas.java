package com.example.guadalupe.bd_vivero;

public class modeloPlantas {

    private String id_plantas;
    private String nombre_plantas;
    private String tipo_plantas;
    private String color_plantas;
    private String precio;

    public String getId_plantas() {
        return id_plantas;
    }

    public String getNombre_plantas() {
        return nombre_plantas;
    }

    public String getTipo_plantas() {
        return tipo_plantas;
    }

    public String getColor_plantas() {
        return color_plantas;
    }

    public String getPrecio() {
        return precio;
    }

    public modeloPlantas(String id_plantas, String nombre_plantas , String tipo_plantas, String color_plantas, String precio){
        this.id_plantas = id_plantas;
        this.nombre_plantas=nombre_plantas;
        this.tipo_plantas=tipo_plantas;
        this.color_plantas=color_plantas;
        this.precio=precio;
    }

}

