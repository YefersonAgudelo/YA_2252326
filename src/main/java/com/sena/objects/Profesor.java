package com.sena.objects;

import java.util.Calendar;
import java.util.Date;

public class Profesor {
    int documento;
    String nombre;
    String telefono;
    String direccion;
    String titulo;
    Date fecha;

    public Profesor() {
    }

    public Profesor(int documento, String nombre, String telefono, String direccion, String titulo) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.titulo = titulo;

    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String infoP(){
        String info= "Documento: "+this.documento+"\n"+
                "Nombre: "+this.nombre+"\n"+
                "Telefono: "+this.telefono+"\n"+
                "Direccion: "+this.direccion+"\n"+
                "Titulo: "+this.titulo+"\n"+
                "Fecha de registro"+this.fecha;
        return info;
    }
}
