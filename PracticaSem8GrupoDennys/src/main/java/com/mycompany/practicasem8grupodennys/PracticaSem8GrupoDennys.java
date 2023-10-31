package com.mycompany.practicasem8grupodennys;

import javax.swing.JOptionPane;

public class PracticaSem8GrupoDennys {

    public static void main(String[] args) {
        ListaReproduccion lista = new ListaReproduccion();

        // Agregamos algunas canciones de ejemplo
        lista.agregarCancion(new Cancion("Canción 1", "Artista 1", "Álbum 1", 2015), 0);
        lista.agregarCancion(new Cancion("Canción 2", "Artista 2", "Álbum 2", 2016), 1);
        lista.agregarCancion(new Cancion("Canción 3", "Artista 3", "Álbum 3", 2017), 2);
        lista.agregarCancion(new Cancion("Canción 4", "Artista 4", "Álbum 4", 2018), 3);
        lista.agregarCancion(new Cancion("Canción 5", "Artista 5", "Álbum 5", 2019), 4);
        while (true) {
            int opcion = mostrarMenuPrincipal();

            switch (opcion) {
                case 1:
                    mostrarCanciones(lista);
                    break;
                case 2:
                    mostrarCancionActual(lista);
                    break;
                case 3:
                    buscarPorAnoYReproducir(lista);
                    break;
                case 4:
                    lista.activarAleatorio();
                    JOptionPane.showMessageDialog(null, "Modo aleatorio activado");
                    break;
                case 5:
                    System.exit(0); 
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    public static int mostrarMenuPrincipal() {
        String[] opciones = {"Ver canciones", "Reproducir", "Buscar canción por año", "Activar aleatorio", "Salir"};
        int seleccion = JOptionPane.showOptionDialog(null, "Elige una opción", "Menú Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        return seleccion + 1; 
    }

    public static void mostrarCanciones(ListaReproduccion lista) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            Cancion cancion = lista.obtenerCancion(i);
            sb.append(cancion.getNombre()).append(" - ")
                    .append(cancion.getArtista()).append(" - ")
                    .append(cancion.getAlbum()).append(" - ")
                    .append(cancion.getAno()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Canciones", JOptionPane.PLAIN_MESSAGE);
    }

    public static void mostrarCancionActual(ListaReproduccion lista) {
        String[] opciones = {"Anterior", "Siguiente"};
        int seleccion = JOptionPane.showOptionDialog(null, "Reproduciendo: " + lista.getCancionActual().getNombre(),
                "Reproduciendo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[1]);

        if (seleccion == JOptionPane.YES_OPTION) {
            lista.anterior();
        } else if (seleccion == JOptionPane.NO_OPTION) {
            lista.siguiente();
        }
    }

    public static void buscarPorAnoYReproducir(ListaReproduccion lista) {
        String anoStr = JOptionPane.showInputDialog(null, "Introduce el año de la canción:", "Búsqueda por año", JOptionPane.QUESTION_MESSAGE);
        try {
            int ano = Integer.parseInt(anoStr);
            lista.buscarPorAno(ano);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Año no válido.");
        }
    }
}
