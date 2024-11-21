/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vergeflixproject.vergeflix;

import java.util.ArrayList;
import java.util.Scanner;
import funciones.*;
import comparator.*;
import java.util.Collections;

/**
 * Permite realizar distintas funciones con películas y series de un catálogo.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class Vergeflix {

    public static void main(String[] args) {
        int numPeliculas = 0;
        int numSeries = 0;

        //creo el catálogo
        ArrayList<Media> catalogo = new ArrayList<>();
        //añado las películas a catálogo
        DatosCatalogo.cargarPeliculas(catalogo);
        //añado las series al catálogo
        DatosCatalogo.cargarSeries(catalogo);

        //calculo el numero de series y peliculas que ya hay cargadas en el catalogo 
        for (Media m : catalogo) {
            if (m instanceof Pelicula) {
                numPeliculas++;
            } else {
                numSeries++;
            }
        }

        int eleccionPrincipal;
        do {
            //despliego el menú principal
            menuSeleccion();

            eleccionPrincipal = ValidarDatos.calcNumRango(1, 4, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");

            //realizo una acción dependiendo de la opción elegida
            switch (eleccionPrincipal) {
                //en caso de que elija el menu de gestion de peliculas
                case 1 -> {
                    int eleccionPelicula = 0;
                    do {
                        //despliego el submenú correspondiente
                        submenuPeliculas();

                        eleccionPelicula = ValidarDatos.calcNumRango(1, 6, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");

                        switch (eleccionPelicula) {
                            //en el caso de elegir añadir pelicula
                            case 1 -> {
                                Pelicula nueva = new Pelicula(toTitleCase(PedirDatosMedia.pedirTitulo("película")), PedirDatosMedia.pedirCalificacionEdad(), PedirDatosMedia.pedirFecha("Introduzca la fecha de incorporación al catálogo (dd-MM-YYYY):"), PedirDatosMedia.pedirDisponibilidad(),
                                        toTitleCase(PedirDatosMedia.pedirNombre("director")), toTitleCase(PedirDatosMedia.pedirNombre("actor")), PedirDatosMedia.pedirDuracion(), PedirDatosMedia.pedirCategoria());
                                //si la pelicula nueva ya se encuentra en el catálogo no la añado
                                if (!peliculasCatalogo(catalogo, numPeliculas).contains(nueva)) {
                                    catalogo.add(nueva);
                                    numPeliculas++;
                                    System.out.println("\u001B[34m¡La película se ha añadido correctamente al catálogo!\u001B[0m");
                                } else {
                                    System.err.println("Lo sentimos, esa película ya se encuentra en el catálogo");
                                }
                            }
                            //en caso de elegir modificar una pelicula
                            case 2 -> {
                                String nombre = PedirDatosMedia.pedirTitulo("película");

                                //si la pelicula se encuentra en el catalogo puede modificarla
                                if (encuentraPelicula(peliculasCatalogo(catalogo, numPeliculas), nombre)) {
                                    int indicePelicula = catalogo.indexOf(getPelicula(peliculasCatalogo(catalogo, numPeliculas), nombre));
                                    int subEleccion = 0;
                                    do {
                                        menuModificarPelicula(nombre);

                                        subEleccion = ValidarDatos.calcNumRango(1, 9, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");

                                        switch (subEleccion) {
                                            case 1 -> {
                                                catalogo.get(indicePelicula).setNombre(PedirDatosMedia.pedirTitulo("película"));
                                                System.out.println("\u001B[34mSe ha modificado el nombre de la película\u001B[0m");
                                            }
                                            case 2 -> {
                                                catalogo.get(indicePelicula).setCalificacionEdad(PedirDatosMedia.pedirCalificacionEdad());
                                                System.out.println("\u001B[34mSe ha modificado la calificacion por edad\u001B[0m");
                                            }
                                            case 3 -> {
                                                catalogo.get(indicePelicula).setFechaIncorporacionAlCatalogo(PedirDatosMedia.pedirFecha("Introduzca la fecha de incorporación al catálogo (dd-MM-YYYY):"));
                                                System.out.println("\u001B[34mSe ha modificado la fecha de incorporación al catálogo\u001B[0m");
                                            }
                                            case 4 -> {
                                                catalogo.get(indicePelicula).setEstaDisponible(PedirDatosMedia.pedirDisponibilidad());
                                                System.out.println("\u001B[34mSe ha modificado la disponibilidad de la película\u001B[0m");
                                            }
                                            case 5 -> {
                                                peliculasCatalogo(catalogo, numPeliculas).get(indicePelicula).setDirector(toTitleCase(PedirDatosMedia.pedirNombre("director")));
                                                System.out.println("\u001B[34mSe ha modificado el nombre del director\u001B[0m");
                                            }
                                            case 6 -> {
                                                peliculasCatalogo(catalogo, numPeliculas).get(indicePelicula).setActorPrincipal(toTitleCase(PedirDatosMedia.pedirNombre("actor")));
                                                System.out.println("\u001B[34mSe ha modificado el nombre del actor\u001B[0m");
                                            }
                                            case 7 -> {
                                                peliculasCatalogo(catalogo, numPeliculas).get(indicePelicula).setDuracion(PedirDatosMedia.pedirDuracion());
                                                System.out.println("\u001B[34mSe ha modificado la duracion\u001B[0m");
                                            }
                                            case 8 -> {
                                                peliculasCatalogo(catalogo, numPeliculas).get(indicePelicula).setCategoria(PedirDatosMedia.pedirCategoria());
                                                System.out.println("\u001B[34mSe ha modificado la categoría\u001B[0m");
                                            }
                                            case 9 -> {
                                                System.out.println("\u001B[34mVolviendo al gestor de películas\u001B[0m");
                                            }
                                        }
                                    } while (subEleccion != 9);
                                } else {
                                    System.out.println(new StringBuilder(RED).append(toTitleCase(nombre)).append(" no se encuentra en el catálogo\u001B[0m"));
                                }
                            }
                            //en el caso de elegir eliminar una pelicula
                            case 3 -> {
                                //hago que introduzca el nombre de la pelicula hasta que no esté vacío
                                String nombrePelicula = PedirDatosMedia.pedirTitulo("película");

                                //si la pelicula se encuentra en el catalogo puede eliminarla
                                if (encuentraPelicula(peliculasCatalogo(catalogo, numPeliculas), nombrePelicula)) {
                                    catalogo.remove(getPelicula(peliculasCatalogo(catalogo, numPeliculas), nombrePelicula));
                                    System.out.println(new StringBuilder(BLUE).append(nombrePelicula).append(" se ha eliminado del catálogo").append(RESET));
                                    numPeliculas--;

                                } else {
                                    System.err.println(new StringBuilder("Lo sentimos, ").append(toTitleCase(nombrePelicula)).append(" no se encuentra en nuestro catálogo."));
                                }

                            }
                            //en el caso de elegir mostrar las peliculas
                            case 4 -> {
                                System.out.println("\u001B[34mMostrando todas las películas del catálogo:\u001B[0m\n");
                                StringBuilder strB = new StringBuilder("");
                                for (Pelicula p : peliculasCatalogo(catalogo, numPeliculas)) {
                                    strB.append(p).append("\n").append("\n");
                                }
                                System.out.println(strB.toString().trim());
                            }
                            //en el caso de elegir valorar una pelicula
                            case 5 -> {
                                //hago que introduzca el nombre de la pelicula hasta que no esté vacío
                                String nombrePelicula = PedirDatosMedia.pedirTitulo("película");

                                //si la pelicula se encuentra en el catalogo puede valorarla
                                if (encuentraPelicula(peliculasCatalogo(catalogo, numPeliculas), nombrePelicula)) {
                                    int puntuacion = ValidarDatos.calcNumRango(0, 10, LeerDatosTeclado.enterInt(new StringBuilder("Introduzca la puntución que le da a ").append(toTitleCase(nombrePelicula)).append(" del 0 al 10:").toString()), "Error, seleccione de 0 a 10");
                                    valorarPelicula(peliculasCatalogo(catalogo, numPeliculas), nombrePelicula, puntuacion);
                                    System.out.println(new StringBuilder(BLUE).append("¡").append("Gracias por valorar ").append(toTitleCase(nombrePelicula)).append("!").append(RESET));
                                } else {
                                    System.err.println(new StringBuilder("Lo sentimos, ").append(toTitleCase(nombrePelicula)).append(" no se encuentra en nuestro catálogo."));
                                }
                            }
                            //elige volver al menu principal
                            case 6 -> {
                                System.out.println("\033[0;31mVolviendo al menú principal...\n\u001B[0m");
                            }
                        }
                    } while (eleccionPelicula != 6);
                }
                //en caso de elegir el gestor de series
                case 2 -> {
                    int eleccionSerie = 0;
                    do {

                        //despliego el submenu correspondiente
                        submenuSeries();

                        eleccionSerie = ValidarDatos.calcNumRango(1, 6, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");

                        switch (eleccionSerie) {
                            //elige añadir serie
                            case 1 -> {
                                Serie nueva = new Serie(toTitleCase(PedirDatosMedia.pedirTitulo("serie")), PedirDatosMedia.pedirCalificacionEdad(),
                                        PedirDatosMedia.pedirFecha("Introduzca la fecha de incorporación al catálogo de la serie (dd-MM-YYYY):"),
                                        PedirDatosMedia.pedirDisponibilidad(), PedirDatosMedia.pedirFecha("Introduzca la fecha de estreno de la serie (dd-MM-YYYY):"));

                                //si la serie nueva ya se encuentra en el catálogo no la añado
                                if (!encuentraSerie(seriesCatalogo(catalogo, numSeries), nueva.getNombre())) {
                                    catalogo.add(nueva);
                                    numSeries++;
                                    System.out.println("\u001B[34m¡La serie se ha añadido correctamente al catálogo!\u001B[0m");
                                } else {
                                    System.err.println("Lo sentimos, esa serie ya se encuentra en el catálogo");
                                }
                            }
                            //elige modificar serie
                            case 2 -> {

                                String nombre = PedirDatosMedia.pedirTitulo("serie");

                                //si la pelicula se encuentra en el catalogo puede modificarla
                                if (encuentraSerie(seriesCatalogo(catalogo, numSeries), nombre)) {
                                    //usar indexOf requiere implementar equals en serie. Cuando es una serie igual a otra
                                    //las respuestas pueden variar tanto... En mi caso, he decidido que una serie es igual
                                    //a otra si tienen 
                                    int indiceCatalogo = catalogo.indexOf(getMedia(catalogo, toTitleCase(nombre)));
                                    int indiceListaSeries = seriesCatalogo(catalogo, numSeries).indexOf(getMedia(catalogo, toTitleCase(nombre)));
                                    int subEleccion = 0;
                                    do {
                                        menuModificarSerie(nombre);
                                        
                                        subEleccion = ValidarDatos.calcNumRango(1, 6, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");

                                        switch (subEleccion) {
                                            case 1 -> {
                                                catalogo.get(indiceCatalogo).setNombre(PedirDatosMedia.pedirTitulo("serie"));
                                                System.out.println("\u001B[34mSe ha modificado el nombre de la serie\u001B[0m");
                                            }
                                            case 2 -> {
                                                catalogo.get(indiceCatalogo).setCalificacionEdad(PedirDatosMedia.pedirCalificacionEdad());
                                                System.out.println("\u001B[34mSe ha modificado la calificacion por edad\u001B[0m");
                                            }
                                            case 3 -> {
                                                catalogo.get(indiceCatalogo).setFechaIncorporacionAlCatalogo(PedirDatosMedia.pedirFecha("Introduzca la fecha de incorporación al catálogo (dd-MM-YYYY):"));
                                                System.out.println("\u001B[34mSe ha modificado la fecha de incorporación al catálogo\u001B[0m");
                                            }
                                            case 4 -> {
                                                catalogo.get(indiceCatalogo).setEstaDisponible(PedirDatosMedia.pedirDisponibilidad());
                                                System.out.println("\u001B[34mSe ha modificado la disponibilidad de la serie\u001B[0m");
                                            }
                                            case 5 -> {
                                                seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).setFechaEstreno(PedirDatosMedia.pedirFecha("Introduzca la fecha de estreno de la serie (dd-MM-YYYY):"));
                                                System.out.println("\u001B[34mSe ha modificado la fecha de estreno\u001B[0m");
                                            }
                                            case 6 -> {
                                                System.out.println("\u001B[34mVolviendo al gestor de series\u001B[0m");
                                            }
                                        }
                                    } while (subEleccion != 6);
                                } else {
                                    System.err.println(new StringBuilder(toTitleCase(nombre)).append(" no se encuentra en el catálogo"));

                                }
                            }
                            //elige eliminar serie
                            case 3 -> {

                                //hago que introduzca el nombre de la pelicula hasta que no esté vacío
                                String nombreSerie = PedirDatosMedia.pedirTitulo("serie");

                                //si la pelicula se encuentra en el catalogo puede eliminarla
                                if (encuentraSerie(seriesCatalogo(catalogo, numSeries), nombreSerie)) {
                                    int indiceListaSeries = seriesCatalogo(catalogo, numSeries).indexOf(getMedia(catalogo, toTitleCase(nombreSerie)));
                                    System.out.println(indiceListaSeries);
                                    catalogo.remove(seriesCatalogo(catalogo, numSeries).get(indiceListaSeries));
                                    System.out.println(new StringBuilder(BLUE).append(toTitleCase(nombreSerie)).append(" se ha eliminado del catálogo").append(RESET));
                                    numSeries--;

                                } else {
                                    System.err.println(new StringBuilder("Lo sentimos ").append(toTitleCase(nombreSerie)).append(" no se encuentra en el catálogo"));
                                }

                            }
                            //elige mostras las series del catalogo
                            case 4 -> {
                                System.out.println("\u001B[34mMostrando todas las series del catálogo:\u001B[0m\n");
                                StringBuilder strB = new StringBuilder("");
                                for (Serie s : seriesCatalogo(catalogo, numSeries)) {
                                    strB.append(s).append("\n").append("\n");
                                }
                                System.out.println(strB.toString().trim());
                            }
                            //elige gestionar una serie concreta
                            case 5 -> {
                                int eleccion = 0;
                                //pido el nombre de la serie a modificar
                                String nombreSerie = PedirDatosMedia.pedirTitulo("serie");

                                if (encuentraSerie(seriesCatalogo(catalogo, numSeries), nombreSerie)) {
                                    int indiceCatalogo = catalogo.indexOf(getMedia(catalogo, toTitleCase(nombreSerie)));
                                    int indiceListaSeries = seriesCatalogo(catalogo, numSeries).indexOf(getMedia(catalogo, toTitleCase(nombreSerie)));
                                    //calculo el numero de temporadas de esa serie
                                    int contador = 0;
                                    do {
                                        contador++;
                                    } while (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).getCopiaTemporada(contador + 1) != null);
                                    int numTemporadas = contador;
                                    do {
                                        //despliego el submenu correspondiente
                                        menuGestionarSerie(nombreSerie);

                                        eleccion = eleccionSerie = ValidarDatos.calcNumRango(1, 8, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");

                                        switch (eleccion) {
                                            //elige añadir temporada
                                            case 1 -> {
                                                if (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).añadirTemporada(PedirDatosMedia.pedirFecha("Introduzca la fecha de estreno de la nueva temporada (dd-MM-YYYY):"))) {
                                                    System.out.println(new StringBuilder(BLUE).append("¡Se ha añadido una nueva temporada a ").append(toTitleCase(nombreSerie)).append("!").append(RESET));
                                                    numTemporadas++;
                                                } else {
                                                    System.err.println("Error, la fecha de estreno de la temporada no es válida");
                                                }
                                            }
                                            //elige modificar temporada
                                            case 2 -> {
                                                System.out.println("""
                                                                   Introduzca qué quiere realizar:
                                                                   1. Modificar fecha de estreno de una temporada
                                                                   2. Modificar un capítulo de una temporada""");

                                                int elec = ValidarDatos.calcNumRango(1, 2, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");

                                                switch (elec) {
                                                    //elige modificar la fecha de estreno
                                                    case 1 -> {
                                                        int nTemp = LeerDatosTeclado.enterInt("Introduzca el número de temporada:");
                                                        if (nTemp >= 1 && nTemp <= numTemporadas) {
                                                            if (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).setTemporada(nTemp, PedirDatosMedia.pedirFecha("Introduzca la nueva fecha de estreno de la temporada (dd-MM-YYYY):"))) {
                                                                System.out.println("\u001B[34m¡La fecha de estreno se ha modificado correctamente!");

                                                            } else {
                                                                System.err.println("Error, ¡La fecha de estreno de la temporada no puede ser anterior a la de su serie o posterior a la de sus capítulos!");
                                                            }
                                                        } else {
                                                            System.err.println("La temporada introducida no se encuentra en la serie");

                                                        }
                                                    }
                                                    //elige modificar algun capítulo
                                                    case 2 -> {
                                                        int nTemp = LeerDatosTeclado.enterInt("Introduzca el número de temporada:");
                                                        if (nTemp >= 1 && nTemp <= numTemporadas) {
                                                            //calculo el número de capitulos de esa temporada en específico
                                                            int c = 0;
                                                            do {
                                                                c++;
                                                            } while (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).getCopiaTemporada(nTemp).getCapitulo(c + 1) != null);
                                                            int numCapitulos = c;
                                                            int nCap = LeerDatosTeclado.enterInt("Introduzca el número del capítulo:");

                                                            if (nCap >= 1 && nCap <= numCapitulos) {

                                                                System.out.println("""
                                                                   Introduzca qué quiere realizar:
                                                                   1. Modificar fecha de emisión y título del capítulo
                                                                   2. Modificar fecha de emisión del capítulo
                                                                   3. Modificar el título del capítulo
                                                                   4. Cancelar""");

                                                                int subElec = ValidarDatos.calcNumRango(1, 4, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");

                                                                switch (subElec) {
                                                                    case 1 -> {
                                                                        if (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).setCapitulo(nTemp, nCap, PedirDatosMedia.pedirFecha("Introduzca la nueva fecha de emisión:"), PedirDatosMedia.pedirTitulo("capítulo"))) {
                                                                            System.out.println("\u001B[34m¡Se ha modificado la fecha de emisión y el título del capítulo correctamente!\u001B[0m");
                                                                        } else {
                                                                            System.err.println("No se ha podido modificar el capítulo");
                                                                        }
                                                                    }
                                                                    case 2 -> {
                                                                        if (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).setCapitulo(nTemp, nCap, PedirDatosMedia.pedirFecha("Introduzca la nueva fecha de emisión:"))) {
                                                                            System.out.println("\u001B[34m¡Se ha modificado la fecha de emisión del capítulo correctamente!\u001B[0m");
                                                                        } else {
                                                                            System.err.println("No se ha podido modificar el capítulo");
                                                                        }
                                                                    }
                                                                    case 3 -> {
                                                                        if (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).setCapitulo(nTemp, nCap, PedirDatosMedia.pedirTitulo("capítulo"))) {
                                                                            System.out.println("\u001B[34m¡Se ha modificado el título del capítulo correctamente!\u001B[0m");
                                                                        } else {
                                                                            System.err.println("No se ha podido modificar el capítulo");
                                                                        }

                                                                    }
                                                                    case 4 -> {
                                                                        System.err.println("Cancelando operación...");
                                                                    }
                                                                }
                                                            } else {
                                                                System.err.println("El capítulo introducido no se encuentra en la temporada");

                                                            }
                                                        } else {
                                                            System.err.println("La temporada introducida no se encuentra en la serie");

                                                        }

                                                    }
                                                }

                                            }
                                            //en caso de elegir eliminar temporada
                                            case 3 -> {

                                                int numEliminar = LeerDatosTeclado.enterInt("Introduzca el número de la temporada que quiere eliminar:");

                                                //al eliminar una temporada, al mostrar las temporadas de la serie la dos pasará a ser la 1 y sucesivamente
                                                if (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).eliminarTemporada(numEliminar)) {
                                                    StringBuilder mensaje = new StringBuilder();
                                                    mensaje.append("\033[0;31mLa temporada ").append(numEliminar).append(" de ").append(toTitleCase(nombreSerie)).append(" se ha eliminado correctamente\u001B[0m");
                                                    System.out.println(mensaje);
                                                    numTemporadas--;

                                                } else {
                                                    System.err.println("Esa temporada no se encuentra en la serie...");
                                                }
                                            }
                                            //elige añadir capítulos
                                            case 4 -> {
                                                System.out.println("""
                                                                   Introduzca cómo quiere añadir el capítulo:
                                                                   1. Por fecha de emisión y título (al final de la temporada)
                                                                   2. Por posicion, fecha de emisión y título""");

                                                int elec = ValidarDatos.calcNumRango(1, 2, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");

                                                int nTemp = LeerDatosTeclado.enterInt("Introduzca el número de la temporada donde se encuentra el capítulo:");

                                                if (nTemp >= 1 && nTemp <= numTemporadas) {
                                                    switch (elec) {
                                                        case 1 -> {
                                                            if (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).añadirCapitulo(nTemp,
                                                                    PedirDatosMedia.pedirFecha("Introduzca la fecha de emisión del capítulo (dd-MM-YYYY):"),
                                                                    PedirDatosMedia.pedirTitulo("capítulo"))) {
                                                                System.out.println("\u001B[34mSe ha añadido el capítulo con éxito\u001B[0m");
                                                            } else {
                                                                System.err.println("No se ha podido introducir. Asegurese de que fecha y número de temporada sean correctos");
                                                            }
                                                        }
                                                        case 2 -> {
                                                            if (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).añadirCapitulo(nTemp, LeerDatosTeclado.enterInt("Introduzca la posición del capítulo en la temporada"),
                                                                    PedirDatosMedia.pedirFecha("Introduzca la fecha de emisión del capítulo (dd-MM-YYYY):"),
                                                                    PedirDatosMedia.pedirTitulo("capítulo"))) {
                                                                System.out.println("\u001B[34mSe ha añadido el capítulo con éxito\u001B[0m");
                                                            } else {
                                                                System.err.println("No se ha podido introducir");
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    System.err.println("La temporada introducida no se encuentra en la serie");
                                                }
                                            }
                                            //elige eliminar capítulos
                                            case 5 -> {
                                                System.out.println("""
                                                                   Introduzca según la operación que desea realizar:
                                                                   1. Eliminar capítulos según su título
                                                                   2. Eliminar capítulos según una expresión regular""");

                                                int elec = ValidarDatos.calcNumRango(1, 2, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");

                                                switch (elec) {
                                                    case 1 -> {
                                                        int nTemp = LeerDatosTeclado.enterInt("Introduzca el número de la temporada donde se encuentra el capítulo:");
                                                        String nombreCap = PedirDatosMedia.pedirTitulo("capítulo");

                                                        if (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).eliminarCapitulo(nTemp, nombreCap)) {
                                                            StringBuilder mensaje = new StringBuilder();
                                                            mensaje.append("\u001B[34mEl capítulo ").append(toTitleCase(nombreCap)).append(" se ha eliminado correctamente de ").append(toTitleCase(nombreSerie)).append("\u001B[0m");
                                                            System.out.println(mensaje);

                                                        } else {
                                                            System.err.println("Ese capítulo no se encuentra en la serie...");
                                                        }

                                                    }
                                                    case 2 -> {
                                                        int nTemp = LeerDatosTeclado.enterInt("Introduzca el número de la temporada donde se encuentra el capítulo:");
                                                        String regexCap = LeerDatosTeclado.enterString("Introduzca la expresión regular:");
                                                        int numCapEliminados = seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).eliminarCapítulos(regexCap);
                                                        if (numCapEliminados != 0) {
                                                            StringBuilder mensaje = new StringBuilder();
                                                            mensaje.append(BLUE).append("Se ha(n) eliminado ").append(numCapEliminados);
                                                            mensaje.append(" capítulo(s) de ").append(toTitleCase(nombreSerie)).append(RESET);
                                                            System.out.println(mensaje);

                                                        } else {
                                                            System.err.println("La expresión regular introducida no concuerda con ningún capítulo...");
                                                        }
                                                    }
                                                }
                                            }
                                            //en caso de elegir lista las temporadas y capitulos de esa serie
                                            case 6 -> {
                                                System.out.println(new StringBuilder(BLUE).append("Visualizando temporadas y capítulos de ").append(toTitleCase(nombreSerie)).append(":").append(RESET));

                                                StringBuilder strTemporadas = new StringBuilder();
                                                int container = 1;

                                                do {
                                                    if (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).getCopiaTemporada(container) != null) {
                                                        strTemporadas.append("\nTEMPORADA ").append(container).append("\n").append(seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).getCopiaTemporada(container)).append("\n\n");
                                                    }
                                                    container++;

                                                } while (container <= numTemporadas);
                                                System.out.println(strTemporadas.toString().trim());
                                            }
                                            //elige valorar capitulo
                                            case 7 -> {
                                                System.out.println("""
                                                                   Introduzca según la operación que desea realizar:
                                                                   1. Valorar capítulo según su título
                                                                   2. Valorar capítulo según su posición
                                                                   """);

                                                int elec = ValidarDatos.calcNumRango(1, 2, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");

                                                switch (elec) {
                                                    case 1 -> {
                                                        int nTemp = LeerDatosTeclado.enterInt("Introduzca el número de la temporada donde se encuentra el capítulo:");
                                                        String nombreCap = PedirDatosMedia.pedirTitulo("capítulo");
                                                        int numLike = ValidarDatos.calcNumRango(1, 2, LeerDatosTeclado.enterInt("¿Le ha gustado el capítulo?\n\033[0;31m1. Si\u001B[0m\n\u001B[34m2. No\u001B[0m"), "Seleccione una opción válida:");

                                                        if (nTemp >= 1 && nTemp <= numTemporadas) {
                                                            if (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).meGusta(nTemp, nombreCap, (numLike == 1))) {
                                                                System.out.println(new StringBuilder(BLUE).append("¡Gracias por valorar ").append(toTitleCase(nombreCap)).append("!").append(RESET));

                                                            } else {
                                                                System.err.println("No se ha podido valorar");
                                                            }
                                                        } else {
                                                            System.err.println("La temporada introducida no se encuentra en la serie");

                                                        }

                                                    }
                                                    case 2 -> {
                                                        int nTemp = LeerDatosTeclado.enterInt("Introduzca el número de la temporada donde se encuentra el capítulo:");
                                                        int nCap = LeerDatosTeclado.enterInt("Introduzca el número del capítulo:");
                                                        int numLike = ValidarDatos.calcNumRango(1, 2, LeerDatosTeclado.enterInt("¿Le ha gustado el capítulo?\n\033[0;31m1. Si\u001B[0m\n\u001B[34m2. No\u001B[0m"), "Seleccione una opción válida:");

                                                        if (nTemp >= 1 && nTemp <= numTemporadas) {
                                                            int numCapitulos = 0;
                                                            int c = 1;
                                                            while (seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).getCopiaTemporada(nTemp).getCapitulo(c) != null) {
                                                                c++;
                                                            }
                                                            numCapitulos = c++;
                                                            if (nCap >= 1 && nCap <= numCapitulos) {
                                                                seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).meGusta(nTemp, nCap, (numLike == 1));
                                                                System.out.println(new StringBuilder(BLUE).append("¡Gracias por valorar ").append(toTitleCase(seriesCatalogo(catalogo, numSeries).get(indiceListaSeries).getCapitulo(nTemp, nCap).getTitulo())).append("!").append(RESET));

                                                            } else {
                                                                System.err.println("El capítulo introducido no se encuentra en la temporada de la serie");
                                                            }
                                                        } else {
                                                            System.err.println("La temporada introducida no se encuentra en la serie");
                                                        }
                                                    }
                                                }

                                            }
                                            //elige volver
                                            case 8 -> {
                                                System.out.println("\033[0;31mVolviendo al gestor de series...\u001B[0m");
                                            }
                                        }
                                    } while (eleccion != 8);
                                } else {
                                    System.err.println(new StringBuilder("Lo sentimos ").append(toTitleCase(nombreSerie)).append(" no se encuentra en el catálogo"));
                                }

                            }
                            //elige volver
                            case 6 -> {
                                System.out.println("\033[0;31mVolviendo al menú principal...\n\u001B[0m");
                            }
                        }
                    } while (eleccionSerie != 6);
                }
                //elige abrir el gestor del catalogo
                case 3 -> {
                    int eleccionCatalogo = 0;
                    do {
                        //despliego el submenu correspondiente
                        submenuCatalogo();

                        eleccionCatalogo = ValidarDatos.calcNumRango(1, 7, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");

                        switch (eleccionCatalogo) {
                            case 1 -> {
                                //primero copio el catálogo porque el original no lo quiero ordenar
                                ArrayList<Media> copiaCatalogo = new ArrayList<>(catalogo);
                                //ahora instancio la clase con el Comparator que necesite
                                OrdenarMediaEdad edad = new OrdenarMediaEdad();
                                //ordeno la copia del catalogo
                                Collections.sort(copiaCatalogo, edad);
                                System.out.println("\u001B[34mMostrando películas y series del catálogo según su calificación de edad:\u001B[0m");
                                for (Media m : copiaCatalogo) {
                                    System.out.println(new StringBuilder().append("\n").append(m));
                                }
                            }
                            case 2 -> {
                                //primero copio las peliculas del catalogo porque las originales no las quiero ordenar
                                ArrayList<Pelicula> copiaListaPeliculas = new ArrayList<>(peliculasCatalogo(catalogo, numPeliculas));
                                //ahora instancio la clase con el Comparator que necesite
                                OrdenarMejoresPeliculas porMejores = new OrdenarMejoresPeliculas();
                                //ordeno la copia del ArrayList
                                //podría haberlo hecho en un mismo Comparator pero que se entiende mejor y permite reutilizacion dividirlos
                                Collections.sort(copiaListaPeliculas, porMejores);

                                int n = LeerDatosTeclado.enterInt("Introduzca el número de películas que desea visualizar:");
                                if (n > 0 && n <= numPeliculas) {
                                    ArrayList<Pelicula> nMejores = new ArrayList<>(copiaListaPeliculas.subList(0, n));
                                    OrdenarPeliculasTematica porTematica = new OrdenarPeliculasTematica();
                                    Collections.sort(nMejores, porTematica);

                                    System.out.println(new StringBuilder("\u001B[34mMostrando las ").append(n).append(" películas mejor valoradas, ordenadas por Temática:\u001B[0m"));
                                    for (Pelicula p : nMejores) {
                                        System.out.println(new StringBuilder().append("\n").append(p));
                                    }

                                } else {
                                    System.err.println("Error, el número de películas no es válido");
                                }

                            }
                            case 3 -> {
                                //primero copio las peliculas del catalogo porque las originales no las quiero ordenar
                                ArrayList<Pelicula> copiaListaPeliculas = new ArrayList<>(peliculasCatalogo(catalogo, numPeliculas));
                                //ahora instancio la clase con el Comparator que necesite
                                OrdenarMejoresPeliculas porMejores = new OrdenarMejoresPeliculas();
                                //ordeno la copia del ArrayList
                                //podría haberlo hecho en un mismo Comparator pero que se entiende mejor y permite reutilizacion dividirlos
                                Collections.sort(copiaListaPeliculas, porMejores);

                                int n = LeerDatosTeclado.enterInt("Introduzca el número de películas que desea visualizar:");
                                if (n > 0 && n <= numPeliculas) {
                                    ArrayList<Pelicula> nMejores = new ArrayList<>(copiaListaPeliculas.subList(0, n));
                                    OrdenarPeliculasActor porActor = new OrdenarPeliculasActor();
                                    Collections.sort(nMejores, porActor);

                                    System.out.println(new StringBuilder("\u001B[34mMostrando las ").append(n).append(" películas mejor valoradas, ordenadas por Actor:\u001B[0m"));
                                    for (Pelicula p : nMejores) {
                                        System.out.println(new StringBuilder().append("\n").append(p));
                                    }

                                } else {
                                    System.err.println("Error, el número de películas no es válido");
                                }
                            }
                            case 4 -> {
                                //primero copio las peliculas del catalogo porque las originales no las quiero ordenar
                                ArrayList<Pelicula> copiaListaPeliculas = new ArrayList<>(peliculasCatalogo(catalogo, numPeliculas));
                                //ahora instancio la clase con el Comparator que necesite
                                OrdenarMejoresPeliculas porMejores = new OrdenarMejoresPeliculas();
                                //ordeno la copia del ArrayList
                                //podría haberlo hecho en un mismo Comparator pero que se entiende mejor y permite reutilizacion dividirlos
                                Collections.sort(copiaListaPeliculas, porMejores);
                                //ahora que tengo las mejores cojo las n primeras y las ordeno por la primera letra del director
                                int n = LeerDatosTeclado.enterInt("Introduzca el número de películas que desea visualizar:");
                                if (n > 0 && n <= numPeliculas) {
                                    ArrayList<Pelicula> nMejores = new ArrayList<>(copiaListaPeliculas.subList(0, n));
                                    OrdenarPeliculasDirector porDirector = new OrdenarPeliculasDirector();
                                    Collections.sort(nMejores, porDirector);

                                    System.out.println(new StringBuilder("\u001B[34mMostrando las ").append(n).append(" películas mejor valoradas, ordenadas por Director:\u001B[0m"));
                                    for (Pelicula p : nMejores) {
                                        System.out.println(new StringBuilder().append("\n").append(p));
                                    }

                                } else {
                                    System.err.println("Error, el número de películas no es válido");
                                }
                            }
                            case 5 -> {
                                //primero copio las series del catalogo porque las originales no las quiero ordenar
                                ArrayList<Serie> copiaListaSeries = new ArrayList<>(seriesCatalogo(catalogo, numSeries));
                                //ahora instancio la clase con el Comparator que necesite
                                OrdenarMejoresSeries porMejores = new OrdenarMejoresSeries();
                                //ordeno la copia del ArrayList
                                Collections.sort(copiaListaSeries, porMejores);

                                //ahora que tengo las mejores cojo las n primeras
                                int n = LeerDatosTeclado.enterInt("Introduzca el número de series que desea visualizar:");
                                if (n > 0 && n <= numSeries) {
                                    ArrayList<Serie> nMejores = new ArrayList<>(copiaListaSeries.subList(0, n));

                                    System.out.println(new StringBuilder("\u001B[34mMostrando las ").append(n).append(" series mejor valoradas:\u001B[0m"));
                                    for (Serie s : nMejores) {
                                        System.out.println(new StringBuilder().append("\n").append(s));
                                    }

                                } else {
                                    System.err.println("Error, el número de series no es válido");
                                }
                            }
                            case 6 -> {
                                //primero copio los elementos del catalogo porque las originales no las quiero ordenar
                                ArrayList<Media> copiaCatalogo = new ArrayList<>(catalogo);
                                //ahora instancio la clase con el Comparator que necesite
                                OrdenarMediaPuntuacion porMejores = new OrdenarMediaPuntuacion();
                                //ordeno la copia del ArrayList
                                Collections.sort(copiaCatalogo, porMejores);

                                //ahora que tengo las mejores cojo las n primeras
                                int n = LeerDatosTeclado.enterInt("Introduzca el número de elementos que desea visualizar:");
                                int nDisponibles = 0;
                                for (Media m : catalogo) {
                                    if (m.getEstaDisponible()) {
                                        nDisponibles++;
                                    }
                                }

                                if (n > 0 && n <= nDisponibles) {
                                    ArrayList<Media> nMejoresDisponibles = new ArrayList<>();

                                    System.out.println(new StringBuilder("\u001B[34mMostrando las ").append(n).append(" series o películas mejor valoradas del catálogo:\u001B[0m"));
                                    for (Media m : copiaCatalogo) {
                                        if (m.getEstaDisponible() && n != 0) {
                                            nMejoresDisponibles.add(m);
                                            n--;
                                        }
                                    }

                                    for (Media m : nMejoresDisponibles) {
                                        System.out.println(new StringBuilder().append("\n").append(m));
                                    }

                                } else {
                                    System.err.println("Error, el número de elementos disponibles no es válido");
                                }
                            }
                            case 7 -> {
                                System.out.println("\033[0;31mVolviendo al menú principal...\n\u001B[0m");

                            }
                        }
                    } while (eleccionCatalogo != 7);
                }
            }

        } while (eleccionPrincipal != 4);
        System.out.println("\u001B[34m¡Esperamos verle pronto!\u001B[0m");
    }

    /**
     * Devuelve un ArrayList de peliculas que contiene copias de referencias de
     * las peliculas del catalogo.
     *
     * @param catalogo el catalogo del que vamos a copiar las referencias de las
     * peliculas
     * @param numPeliculas el numero total de peliculas del catalogo
     * @return un ArrayList de tipo Pelicula con copias de referencias de
     * peliculas
     */
    private static ArrayList<Pelicula> peliculasCatalogo(ArrayList<Media> catalogo, int numPeliculas) {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        //lo lógico creo que sería copiar las referencias porque no quiero realizar funciones 
        //con copias de peliculas sino con las peliculas del catalogo en si
        for (int indice = 0, contador = 0; indice < catalogo.size() && contador != numPeliculas; indice++) {
            if (catalogo.get(indice) instanceof Pelicula pelicula) {
                listaPeliculas.add(pelicula);
                contador++;
            }
        }
        return listaPeliculas;
    }

    /**
     * Permite valorar una pelicula del 0 al 10 incluidos.
     *
     * @param listaPeliculas la lista donde se encuentra la pelicula que
     * queremos valorar
     * @param nombrePelicula el nombre de la pelicula que queremos valorar (se
     * que dos peliculas se pueden llamar igual pero no veo logico preguntar
     * Director, actor, fecha... al usuario para poder realizar esta tarea)
     * @param puntuacion
     */
    private static void valorarPelicula(ArrayList<Pelicula> listaPeliculas, String nombrePelicula, int puntuacion) {
        boolean seVota = false;
        for (int indice = 0; indice < listaPeliculas.size() && !seVota; indice++) {
            if (listaPeliculas.get(indice).getNombre().equalsIgnoreCase(nombrePelicula)) {
                //voto en la lista de peliculas y no sobre el catálogo porque intencionadamente contiene
                //las referencias de la películas del catálogo
                listaPeliculas.get(indice).votar(puntuacion);
                seVota = true;
            }
        }
    }

    /**
     * Devuelve true si el nombre de una pelicula ya se encuentra en la lista de
     * películas del catálogo.
     *
     * @param listaPeliculas la lista de todas las películas del catálogo
     * @param nombrePelicula el nombre de la pelicula que quermos encontrar
     * @return true si encuentra el nombre
     */
    private static boolean encuentraPelicula(ArrayList<Pelicula> listaPeliculas, String nombrePelicula) {
        boolean laEncuentra = false;

        if (ValidarDatos.validarTitulo(nombrePelicula)) {
            for (int indice = 0; indice < listaPeliculas.size() && !laEncuentra; indice++) {
                laEncuentra = (listaPeliculas.get(indice).getNombre().equalsIgnoreCase(nombrePelicula));
            }
        }

        return laEncuentra;
    }

    /**
     * Devuelve una copia de la pelicula dentro de la lista de peliculas a cuyo
     * nombre coincide.
     *
     * @param listaPeliculas la lista de peliculas del catálogo
     * @param nombrePelicula el nombre de la pelicula que queremos obtener copia
     * @return una copia de la pelicula cuyo nombre introduce el usuario
     */
    private static Pelicula getPelicula(ArrayList<Pelicula> listaPeliculas, String nombrePelicula) {
        int indicePelicula = -1;
        boolean obtieneIndice = false;
        for (int indice = 0; indice < listaPeliculas.size() && !obtieneIndice; indice++) {
            if (listaPeliculas.get(indice).getNombre().equalsIgnoreCase(nombrePelicula)) {
                indicePelicula = indice;
                obtieneIndice = (listaPeliculas.get(indice).getNombre().equalsIgnoreCase(nombrePelicula));
            }
        }

        return new Pelicula(listaPeliculas.get(indicePelicula));
    }

    /**
     * Devuelve un ArrayList de series que contiene copias de referencias de las
     * series del catalogo.
     *
     * @param catalogo el catalogo del que vamos a copiar las referencias de las
     * series
     * @param numSeries el numero total de series del catalogo
     * @return un ArrayList de tipo Serie con copias de referencias de series
     */
    private static ArrayList<Serie> seriesCatalogo(ArrayList<Media> catalogo, int numSeries) {
        ArrayList<Serie> listaSeries = new ArrayList<>();

        //lo lógico creo que sería copiar las referencias porque no quiero realizar funciones 
        //con copias de series sino con las series del catalogo en si
        for (int indice = 0, contador = 0; indice < catalogo.size() && contador != numSeries; indice++) {
            if (catalogo.get(indice) instanceof Serie serie) {
                listaSeries.add(serie);
                contador++;
            }
        }
        return listaSeries;
    }

    /**
     * Devuelve true si el nombre de una serie ya se encuentra en la lista de
     * series del catálogo.
     *
     * @param listaSeries la lista de todas las series del catálogo
     * @param nombreSerie el nombre de la serie que quermos encontrar
     * @return true si encuentra el nombre
     */
    private static boolean encuentraSerie(ArrayList<Serie> listaSeries, String nombreSerie) {
        boolean laEncuentra = false;

        if (ValidarDatos.validarTitulo(nombreSerie)) {
            for (int indice = 0; indice < listaSeries.size() && !laEncuentra; indice++) {
                laEncuentra = (listaSeries.get(indice).getNombre().equalsIgnoreCase(nombreSerie));
            }
        }

        return laEncuentra;
    }

    /**
     * Devuelve una copia de la serie dentro de la lista de series a cuyo nombre
     * coincide.
     *
     * @param listaSeries la lista de series del catálogo
     * @param nombrePelicula el nombre de la series que queremos obtener copia
     * @return una copia de la serie cuyo nombre introduce el usuario
     */
    private static Serie getSerie(ArrayList<Serie> listaSeries, String nombreSerie) {
        int indiceSerie = -1;
        boolean obtieneIndice = false;
        for (int indice = 0; indice < listaSeries.size() && !obtieneIndice; indice++) {
            if (listaSeries.get(indice).getNombre().equalsIgnoreCase(toTitleCase(nombreSerie))) {
                indiceSerie = indice;
                obtieneIndice = (listaSeries.get(indice).getNombre().equalsIgnoreCase(nombreSerie));
            }
        }

        return new Serie(listaSeries.get(indiceSerie));
    }

    /**
     * Devuelve una copia de la serie o pelicula dentro del catalogo cuyo nombre
     * coincide.
     *
     * @param listaSeries la lista de series del catálogo
     * @param nombrePelicula el nombre de la series que queremos obtener copia
     * @return una copia de la serie cuyo nombre introduce el usuario
     */
    private static Media getMedia(ArrayList<Media> catalogo, String nombreMedia) {
        int indiceMedia = -1;
        boolean obtieneIndice = false;
        for (int indice = 0; indice < catalogo.size() && !obtieneIndice; indice++) {
            if (catalogo.get(indice).getNombre().equalsIgnoreCase(toTitleCase(nombreMedia))) {
                indiceMedia = indice;
                obtieneIndice = (catalogo.get(indice).getNombre().equalsIgnoreCase(nombreMedia));
            }
        }

        return (catalogo.get(indiceMedia) instanceof Serie) ? new Serie((Serie) catalogo.get(indiceMedia)) : (Pelicula) new Pelicula((Pelicula) catalogo.get(indiceMedia));
    }

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\033[0;31m";
    private static final String BLUE = "\u001B[34m";

    /**
     * Muestra las opciones que el usuario podrá realizar en el menú principal.
     */
    private static void menuSeleccion() {
        System.out.print("""  
                  \u001B[34m***************************\u001B[0m
                  \u001B[34m*        VERGEFLIX        *\u001B[0m
                  \u001B[34m***************************\u001B[0m
                  ¿Qué desea realizar?
                  1. Gestionar Películas
                  2. Gestionar Series
                  3. Consultar catálogo
                  4. Salir
                  """);
    }

    /**
     * Muestra las opciones que el usuario puede realizar dentro del submenú de
     * gestión de películas.
     */
    private static void submenuPeliculas() {
        System.out.println("""
                           
                           \u001B[34m*** GESTOR DE PELÍCULAS SELECCIONADO ***\u001B[0m
                           ¿Qué desea realizar?
                           1. Añadir Película
                           2. Modificar Película
                           3. Eliminar Película
                           4. Listar Películas
                           5. Valorar Película
                           6. Volver""");
    }

    /**
     * Muestra las opciones que el usuario puede realizar al elegir la opción de
     * modificar película.
     */
    private static void menuModificarPelicula(String nombrePelicula) {
        System.out.println(new StringBuilder(BLUE).append("\n--- Modificando ").append(toTitleCase(nombrePelicula)).append(" ---\u001B[0m"));
        System.out.println("""
                           ¿Qué desea realizar?
                           1. Modificar Título
                           2. Modificar Calificacion de Edad
                           3. Modificar Fecha de Incorporación
                           4. Modificar Disponibilidad
                           5. Modificar Director
                           6. Modificar Actor Principal
                           7. Modificar Duración
                           8. Modificar Temática
                           9. Terminar de Modificar""");
    }

    /**
     * Muestra las opciones que el usuario puede realizar dentro del submenú de
     * gestión de series.
     */
    private static void submenuSeries() {
        System.out.println("""
                           
                           \u001B[34m*** GESTOR DE SERIES SELECCIONADO ***\u001B[0m
                           ¿Qué desea realizar?
                           1. Añadir Serie
                           2. Modificar Serie
                           3. Eliminar Serie
                           4. Listar Series
                           5. Gestionar Serie concreta
                           6. Volver""");
    }

    /**
     * Muestra las opciones que el usuario puede realizar al elegir modificar
     * una serie.
     */
    private static void menuModificarSerie(String nombreSerie) {
        System.out.println(new StringBuilder(BLUE).append("\n--- Modificando ").append(toTitleCase(nombreSerie)).append(" ---\u001B[0m"));
        System.out.println("""
                           ¿Qué desea realizar?
                           1. Modificar Título
                           2. Modificar Calificacion de Edad
                           3. Modificar Fecha de Incorporación
                           4. Modificar Disponibilidad
                           5. Modificar Fecha de estreno
                           6. Terminar de Modificar""");
    }

    /**
     * Muestra las opciones que el usuario puede realizar al elegir gestinar una
     * serie concreta.
     */
    private static void menuGestionarSerie(String nombreSerie) {
        System.out.println(new StringBuilder(BLUE).append("\n--- Gestionando ").append(toTitleCase(nombreSerie)).append(" ---\u001B[0m"));
        System.out.println("""
                           ¿Qué desea realizar?
                           1. Añadir Temporada
                           2. Modificar Temporada
                           3. Eliminar Temporada
                           4. Añadir Capítulos
                           5. Eliminar Capítulos
                           6. Listar Temporadas y Capítulos
                           7. Valorar Capítulo
                           8. Terminar de Gestionar""");
    }

    /**
     * Muestra las opciones que el usuario puede realizar dentro del submenú del
     * catálogo.
     */
    private static void submenuCatalogo() {
        System.out.println("""
                           
                           \u001B[34m*** CONSULTOR DEL CATÁLOGO SELECCIONADO ***\u001B[0m
                           ¿Qué desea realizar?
                           1. Mostrar series o películas según su calificación de edad
                           2. Listar las n mejores películas por temática
                           3. Listar las n mejores películas por autor
                           4. Listar las n mejores películas por director
                           5. Listar las n mejores series
                           6. Listar los n mejores elementos disponibles del catálogo (serie o película)
                           7. Volver""");
    }

    /**
     * Transforma formato del string introducido en Titlecase. Ejemplo: Texto En
     * Titlecase.
     *
     * @param s el string que queremos que tenga formato Titlecase
     * @return el string en Titlecase
     */
    private static String toTitleCase(String s) {
        Scanner input = new Scanner(s);

        StringBuilder sB = new StringBuilder("");
        do {
            String palabra = input.next();
            sB.append(palabra.substring(0, 1).toUpperCase()).append(palabra.substring(1).toLowerCase()).append(" ");
        } while (input.hasNext());

        return sB.toString().trim();
    }

}
