package com.mycompany.practicasem8grupodennys;

public class ListaReproduccion {
    private Cancion[] canciones;
    private int posicionActual;
    private boolean aleatorio;

    public ListaReproduccion() {
        canciones = new Cancion[5];
        posicionActual = 0;
        aleatorio = false;
    }

    public void agregarCancion(Cancion cancion, int posicion) {
        if (posicion >= 0 && posicion < canciones.length) {
            canciones[posicion] = cancion;
        } else {
            System.out.println("Posición inválida");
        }
    }
    
    public Cancion obtenerCancion(int posicion) {
        if (posicion >= 0 && posicion < canciones.length) {
            return canciones[posicion];
        } else {
            System.out.println("Posición inválida");
            return null;
        }
    }
    
    public Cancion getCancionActual() {
        return canciones[posicionActual];
    }

    public void reproducir() {
        System.out.println("Reproduciendo: " + canciones[posicionActual].getNombre());
    }

    public void siguiente() {
        if (aleatorio) {
            posicionActual = (int) (Math.random() * 5);
        } else {
            posicionActual = (posicionActual + 1) % 5;
        }
        reproducir();
    }

    public void anterior() {
        if (aleatorio) {
            posicionActual = (int) (Math.random() * 5);
        } else {
            posicionActual = (posicionActual - 1 + 5) % 5; 
        }
        reproducir();
    }

    public void buscarPorAno(int ano) {
        for (int i = 0; i < canciones.length; i++) {
            if (canciones[i].getAno() == ano) {
                posicionActual = i;
                reproducir();
                return;
            }
        }
        System.out.println("No se encontró una canción de ese año.");
    }

    public void activarAleatorio() {
        aleatorio = true;
    }

    public void desactivarAleatorio() {
        aleatorio = false;
    }
}
