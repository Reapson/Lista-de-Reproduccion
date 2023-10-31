package com.mycompany.practicasem8grupodennys;

public class Cancion {
    private String nombre;
    private String artista;
    private String album;
    private int ano;
    
    public Cancion(String nombre, String artista, String album, int ano) {
        this.nombre = nombre;
        this.artista = artista;
        this.album = album;
        this.ano = ano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
}
