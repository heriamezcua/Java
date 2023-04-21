/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import vergeflix.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 * Clase que con distintas funciones para facilitar la carga de datos al
 * programa y poder realizar las funciones que se nos piden.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class DatosCatalogo {

    public static void cargarPeliculas(ArrayList<Media> catalogo) {

        //creo las peliculas con datos verdaderos
        Pelicula p1 = new Pelicula("Interstellar", 12, LocalDate.of(2014, 11, 7),
                true, "   Christopher      Nolan    ", "Matthew          McConaughey", 169, Tematica.CIENCIA_FICCION);

        Pelicula p2 = new Pelicula("Fight Club", 18, LocalDate.of(1999, 11, 5),
                true, "David Fincher", "Brad Pitt", 139, Tematica.DRAMA);

        Pelicula p3 = new Pelicula("American Psycho", 18, LocalDate.of(2000, 9, 29),
                false, "Mary Harron", "Christian Bale", 102, Tematica.SUSPENSE);

        Pelicula p4 = new Pelicula("Blade Runner 2049", 15, LocalDate.of(2017, 10, 6),
                true, "Denis Villeneuve", "Ryan Gosling", 164, Tematica.CIENCIA_FICCION);

        Pelicula p5 = new Pelicula("Voyagers", 15, LocalDate.of(2021, 4, 9),
                false, "Neil Burger", "Tye Sheridan", 108, Tematica.CIENCIA_FICCION);

        Pelicula p6 = new Pelicula("The Devil's Advocate", 18, LocalDate.of(1998, 1, 12),
                true, "Taylor Hackford", "Keanu Reeves", 134, Tematica.SUSPENSE);

        Pelicula p7 = new Pelicula("Ghost in the Shell", 12, LocalDate.of(2002, 11, 27),
                true, "Mamoru Oshii", "Atsuko Tanaka", 83, Tematica.CIENCIA_FICCION);

        Pelicula p8 = new Pelicula("Troy", 13, LocalDate.of(2004, 5, 14),
                false, "Wolfgang Petersen", "Brad Pitt", 163, Tematica.DRAMA);

        Pelicula p9 = new Pelicula("Taxi Driver", 18, LocalDate.of(1977, 3, 10),
                true, "Martin Scorsese", "Robert De Niro", 114, Tematica.DRAMA);

        Pelicula p10 = new Pelicula("300", 18, LocalDate.of(2007, 3, 9),
                false, "Zack Snyder", "Gerard Butler", 117, Tematica.FANTASIA);

        catalogo.add(p1);
        catalogo.add(p2);
        catalogo.add(p3);
        catalogo.add(p4);
        catalogo.add(p5);
        catalogo.add(p6);
        catalogo.add(p7);
        catalogo.add(p8);
        catalogo.add(p9);
        catalogo.add(p10);

        //valoro las peliculas para poder realizar operaciones
        for (Media m : catalogo) {
            if (m instanceof Pelicula p) {
                for (int contador = 0; contador < 10; contador++) {
                    p.votar(((int) (Math.random() * (10 + 1))));
                }
            }
        }
    }

    public static void cargarCapitulos(Temporada t) {

        //añado la temporada 1 de Cowboy Bebop
        if (t.getFechaEstreno().equals(LocalDate.of(1998, Month.APRIL, 3))) {
            Capitulo c1 = new Capitulo("Asteroid Blues", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c2 = new Capitulo("Stray Dog Strut", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c3 = new Capitulo("Honky Tonk Women", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c4 = new Capitulo("Gateway Shuffle", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c5 = new Capitulo("Ballad of Fallen Angels", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c6 = new Capitulo("Sympathy for the Devil", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c7 = new Capitulo("Heavy Metal Queen", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c8 = new Capitulo("Waltz for Venus", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c9 = new Capitulo("Jamming with Edward", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c10 = new Capitulo("Ganymede Elegy", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c11 = new Capitulo("Toys in the Attic", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c12 = new Capitulo("Jupiter Jazz, Part 1", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c13 = new Capitulo("Jupiter Jazz, Part 2", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c14 = new Capitulo("Bohemian Rhapsody", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c15 = new Capitulo("My Funny Valentine", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c16 = new Capitulo("Black Dog Serenade", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c17 = new Capitulo("Mushroom Samba", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c18 = new Capitulo("Speak Like a Child", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c19 = new Capitulo("Wild Horses", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c20 = new Capitulo("Pierrot le Fou", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c21 = new Capitulo("Boogie Woogie Feng Shui", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c22 = new Capitulo("Cowboy Funk", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c23 = new Capitulo("Brain Scratch", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c24 = new Capitulo("Hard Luck Woman", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c25 = new Capitulo("The Real Folk Blues, Part 1", LocalDate.of(1998, Month.APRIL, 3));
            Capitulo c26 = new Capitulo("The Real Folk Blues, Part 2", LocalDate.of(1998, Month.APRIL, 3));

            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
            t.añadirCapitulo(c7);
            t.añadirCapitulo(c8);
            t.añadirCapitulo(c9);
            t.añadirCapitulo(c10);
            t.añadirCapitulo(c11);
            t.añadirCapitulo(c12);
            t.añadirCapitulo(c13);
            t.añadirCapitulo(c14);
            t.añadirCapitulo(c15);
            t.añadirCapitulo(c16);
            t.añadirCapitulo(c17);
            t.añadirCapitulo(c18);
            t.añadirCapitulo(c19);
            t.añadirCapitulo(c20);
            t.añadirCapitulo(c21);
            t.añadirCapitulo(c22);
            t.añadirCapitulo(c23);
            t.añadirCapitulo(c24);
            t.añadirCapitulo(c25);
            t.añadirCapitulo(c26);
        }

        //añado la temporada 1 de MR.ROBOT
        if (t.getFechaEstreno().equals(LocalDate.of(2015, Month.JUNE, 24))) {
            Capitulo c1 = new Capitulo("eps1.0_hellofriend.mov", LocalDate.of(2015, Month.JUNE, 24));
            Capitulo c2 = new Capitulo("eps1.1_ones-and-zer0es.mpeg", LocalDate.of(2015, Month.JUNE, 24));
            Capitulo c3 = new Capitulo("eps1.2_d3bug.mkv", LocalDate.of(2015, Month.JUNE, 24));
            Capitulo c4 = new Capitulo("eps1.3_da3m0ns.mp4", LocalDate.of(2015, Month.JUNE, 24));
            Capitulo c5 = new Capitulo("eps1.4_3xpl0its.wmv", LocalDate.of(2015, Month.JUNE, 24));
            Capitulo c6 = new Capitulo("eps1.5_br4ve-trave1er.asf", LocalDate.of(2015, Month.JUNE, 24));
            Capitulo c7 = new Capitulo("eps1.6_v1ew-s0urce.flv", LocalDate.of(2015, Month.JUNE, 24));
            Capitulo c8 = new Capitulo("eps1.7_wh1ter0se.m4v", LocalDate.of(2015, Month.JUNE, 24));
            Capitulo c9 = new Capitulo("eps1.8_m1rr0r1ng.qt", LocalDate.of(2015, Month.JUNE, 24));
            Capitulo c10 = new Capitulo("eps1.9_zer0-day.avi", LocalDate.of(2015, Month.JUNE, 24));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
            t.añadirCapitulo(c7);
            t.añadirCapitulo(c8);
            t.añadirCapitulo(c9);
            t.añadirCapitulo(c10);
        }

        //añado la temporada 2 de MR.ROBOT
        if (t.getFechaEstreno().equals(LocalDate.of(2016, Month.JULY, 13))) {
            Capitulo c1 = new Capitulo("eps2.0_unm4sk-pt1.tc", LocalDate.of(2016, Month.JULY, 13));
            Capitulo c2 = new Capitulo("eps2.1_unm4sk-pt2.tc", LocalDate.of(2016, Month.JULY, 13));
            Capitulo c3 = new Capitulo("eps2.2_init1.asec", LocalDate.of(2016, Month.JULY, 13));
            Capitulo c4 = new Capitulo("eps2.3_logic-b0mb.hc", LocalDate.of(2016, Month.JULY, 13));
            Capitulo c5 = new Capitulo("eps2.4_m4ster-s1ave.aes", LocalDate.of(2016, Month.JULY, 13));
            Capitulo c6 = new Capitulo("eps2.5_h4ndshake.sme", LocalDate.of(2016, Month.JULY, 13));
            Capitulo c7 = new Capitulo("eps2.6_succ3ss0r.p12", LocalDate.of(2016, Month.JULY, 13));
            Capitulo c8 = new Capitulo("eps2.7_init5.fve", LocalDate.of(2016, Month.JULY, 13));
            Capitulo c9 = new Capitulo("eps2.8_h1dden-pr0cess.axx", LocalDate.of(2016, Month.JULY, 13));
            Capitulo c10 = new Capitulo("eps2.9_pyth0n-pt1.p7z", LocalDate.of(2016, Month.JULY, 13));
            Capitulo c11 = new Capitulo("eps2.9_pyth0n-pt2.p7z", LocalDate.of(2016, Month.JULY, 13));
            Capitulo c12 = new Capitulo("eps2.9_pyth0n-pt3.p7z", LocalDate.of(2016, Month.JULY, 13));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
            t.añadirCapitulo(c7);
            t.añadirCapitulo(c8);
            t.añadirCapitulo(c9);
            t.añadirCapitulo(c10);
            t.añadirCapitulo(c11);
            t.añadirCapitulo(c12);
        }

        //añado la temporada 3 de MR.ROBOT
        if (t.getFechaEstreno().equals(LocalDate.of(2017, Month.OCTOBER, 11))) {
            Capitulo c1 = new Capitulo("eps3.0_power-saver-mode.h", LocalDate.of(2017, Month.OCTOBER, 11));
            Capitulo c2 = new Capitulo("eps3.1_undo.gz", LocalDate.of(2017, Month.OCTOBER, 11));
            Capitulo c3 = new Capitulo("eps3.2_legacy.so", LocalDate.of(2017, Month.OCTOBER, 11));
            Capitulo c4 = new Capitulo("eps3.3_metadata.par2", LocalDate.of(2017, Month.OCTOBER, 11));
            Capitulo c5 = new Capitulo("eps3.4_runtime-err0r.r00", LocalDate.of(2017, Month.OCTOBER, 11));
            Capitulo c6 = new Capitulo("eps3.5_kill-process.inc", LocalDate.of(2017, Month.OCTOBER, 11));
            Capitulo c7 = new Capitulo("eps3.6_fredrick+tanya.chk", LocalDate.of(2017, Month.OCTOBER, 11));
            Capitulo c8 = new Capitulo("eps3.7_dont-delete-me.ko", LocalDate.of(2017, Month.OCTOBER, 11));
            Capitulo c9 = new Capitulo("eps3.8_stage3.torrent", LocalDate.of(2017, Month.OCTOBER, 11));
            Capitulo c10 = new Capitulo("shutdown-r", LocalDate.of(2017, Month.OCTOBER, 11));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
            t.añadirCapitulo(c7);
            t.añadirCapitulo(c8);
            t.añadirCapitulo(c9);
            t.añadirCapitulo(c10);
        }

        //añado la temporada 4 de MR.ROBOT
        if (t.getFechaEstreno().equals(LocalDate.of(2019, Month.OCTOBER, 6))) {
            Capitulo c1 = new Capitulo("401 Unauthorized", LocalDate.of(2019, Month.OCTOBER, 6));
            Capitulo c2 = new Capitulo("402 Payment Required", LocalDate.of(2019, Month.OCTOBER, 6));
            Capitulo c3 = new Capitulo("403 Forbidden", LocalDate.of(2019, Month.OCTOBER, 6));
            Capitulo c4 = new Capitulo("404 Not Found", LocalDate.of(2019, Month.OCTOBER, 6));
            Capitulo c5 = new Capitulo("405 Method Not Allowed", LocalDate.of(2019, Month.OCTOBER, 6));
            Capitulo c6 = new Capitulo("406 Not Acceptable", LocalDate.of(2019, Month.OCTOBER, 6));
            Capitulo c7 = new Capitulo("407 Proxy Authentication Required", LocalDate.of(2019, Month.OCTOBER, 6));
            Capitulo c8 = new Capitulo("408 Request Timeout", LocalDate.of(2019, Month.OCTOBER, 6));
            Capitulo c9 = new Capitulo("409 Conflict", LocalDate.of(2019, Month.OCTOBER, 6));
            Capitulo c10 = new Capitulo("410 Gone", LocalDate.of(2019, Month.OCTOBER, 6));
            Capitulo c11 = new Capitulo("eXit", LocalDate.of(2019, Month.OCTOBER, 6));
            Capitulo c12 = new Capitulo("whoami", LocalDate.of(2019, Month.OCTOBER, 6));
            Capitulo c13 = new Capitulo("Hello Elliot", LocalDate.of(2019, Month.OCTOBER, 6));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
            t.añadirCapitulo(c7);
            t.añadirCapitulo(c8);
            t.añadirCapitulo(c9);
            t.añadirCapitulo(c10);
            t.añadirCapitulo(c11);
            t.añadirCapitulo(c12);
            t.añadirCapitulo(c13);
        }

        //añado la temporada 1 de Stranger things
        if (t.getFechaEstreno().equals(LocalDate.of(2016, Month.JULY, 15))) {
            Capitulo c1 = new Capitulo("Chapter One: The Vanishing of Will Byers", LocalDate.of(2016, Month.JULY, 15));
            Capitulo c2 = new Capitulo("Chapter Two: The Weirdo on Maple Street", LocalDate.of(2016, Month.JULY, 15));
            Capitulo c3 = new Capitulo("Chapter Three: Holly, Jolly", LocalDate.of(2016, Month.JULY, 15));
            Capitulo c4 = new Capitulo("Chapter Four: The Body", LocalDate.of(2016, Month.JULY, 15));
            Capitulo c5 = new Capitulo("Chapter Five: The Flea and the Acrobat", LocalDate.of(2016, Month.JULY, 15));
            Capitulo c6 = new Capitulo("Chapter Six: The Monster", LocalDate.of(2016, Month.JULY, 15));
            Capitulo c7 = new Capitulo("Chapter Seven: The Bathtub", LocalDate.of(2016, Month.JULY, 15));
            Capitulo c8 = new Capitulo("Chapter Eight: The Upside Down", LocalDate.of(2016, Month.JULY, 15));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
            t.añadirCapitulo(c7);
            t.añadirCapitulo(c8);
        }

        //añado la temporada 2 de Stranger things
        if (t.getFechaEstreno().equals(LocalDate.of(2017, Month.NOVEMBER, 27))) {
            Capitulo c1 = new Capitulo("Chapter One: Madmax", LocalDate.of(2017, Month.NOVEMBER, 27));
            Capitulo c2 = new Capitulo("Chapter Two: Trick or Treat, Freak", LocalDate.of(2017, Month.NOVEMBER, 27));
            Capitulo c3 = new Capitulo("Chapter Three: The Pollywog", LocalDate.of(2017, Month.NOVEMBER, 27));
            Capitulo c4 = new Capitulo("Chapter Four: Will the Wise", LocalDate.of(2017, Month.NOVEMBER, 27));
            Capitulo c5 = new Capitulo("Chapter Five: Dig Dug", LocalDate.of(2017, Month.NOVEMBER, 27));
            Capitulo c6 = new Capitulo("Chapter Six: The Spy", LocalDate.of(2017, Month.NOVEMBER, 27));
            Capitulo c7 = new Capitulo("Chapter Seven: The Lost Sister", LocalDate.of(2017, Month.NOVEMBER, 27));
            Capitulo c8 = new Capitulo("Chapter Eight: The Mind Flayer", LocalDate.of(2017, Month.NOVEMBER, 27));
            Capitulo c9 = new Capitulo("Chapter Nine: The Gate", LocalDate.of(2017, Month.NOVEMBER, 27));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
            t.añadirCapitulo(c7);
            t.añadirCapitulo(c8);
            t.añadirCapitulo(c9);
        }

        //añado la temporada 3 de Stranger things
        if (t.getFechaEstreno().equals(LocalDate.of(2019, Month.JULY, 4))) {
            Capitulo c1 = new Capitulo("Chapter One: Suzie, Do You Copy?", LocalDate.of(2019, Month.JULY, 4));
            Capitulo c2 = new Capitulo("Chapter Two: The Mall Rats", LocalDate.of(2019, Month.JULY, 4));
            Capitulo c3 = new Capitulo("Chapter Three: The Case of the Missing Lifeguard", LocalDate.of(2019, Month.JULY, 4));
            Capitulo c4 = new Capitulo("Chapter Four: The Sauna Test", LocalDate.of(2019, Month.JULY, 4));
            Capitulo c5 = new Capitulo("Chapter Five: The Flayed", LocalDate.of(2019, Month.JULY, 4));
            Capitulo c6 = new Capitulo("Chapter Six: E Pluribus Unum", LocalDate.of(2019, Month.JULY, 4));
            Capitulo c7 = new Capitulo("Chapter Seven: The Bite", LocalDate.of(2019, Month.JULY, 4));
            Capitulo c8 = new Capitulo("Chapter Eight: The Battle of Starcourt", LocalDate.of(2019, Month.JULY, 4));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
            t.añadirCapitulo(c7);
            t.añadirCapitulo(c8);
        }

        //añado la temporada 4 de Stranger Things
        if (t.getFechaEstreno().equals(LocalDate.of(2022, Month.MAY, 27))) {
            Capitulo c1 = new Capitulo("Chapter One: The Hellfire Club", LocalDate.of(2022, Month.MAY, 27));
            Capitulo c2 = new Capitulo("Chapter Two: Vecna's Curse", LocalDate.of(2022, Month.MAY, 27));
            Capitulo c3 = new Capitulo("Chapter Three: The Monster and the Superhero", LocalDate.of(2022, Month.MAY, 27));
            Capitulo c4 = new Capitulo("Chapter Four: Dear Billy", LocalDate.of(2022, Month.MAY, 27));
            Capitulo c5 = new Capitulo("Chapter Five: The Nina Project", LocalDate.of(2022, Month.MAY, 27));
            Capitulo c6 = new Capitulo("Chapter Six: The Dive", LocalDate.of(2022, Month.MAY, 27));
            Capitulo c7 = new Capitulo("Chapter Seven: The Massacre at Hawkins Lab", LocalDate.of(2022, Month.MAY, 27));
            Capitulo c8 = new Capitulo("Chapter Eight: Papa", LocalDate.of(2022, Month.MAY, 27));
            Capitulo c9 = new Capitulo("Chapter Nine: The Piggyback", LocalDate.of(2022, Month.MAY, 27));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
            t.añadirCapitulo(c7);
            t.añadirCapitulo(c8);
            t.añadirCapitulo(c9);
        }

        //añado la temporada 1 de Peaky Blinders
        if (t.getFechaEstreno().equals(LocalDate.of(2013, Month.SEPTEMBER, 12))) {
            Capitulo c1 = new Capitulo("Episode 1", LocalDate.of(2013, Month.SEPTEMBER, 12));
            Capitulo c2 = new Capitulo("Episode 2", LocalDate.of(2013, Month.SEPTEMBER, 12));
            Capitulo c3 = new Capitulo("Episode 3", LocalDate.of(2013, Month.SEPTEMBER, 12));
            Capitulo c4 = new Capitulo("Episode 4", LocalDate.of(2013, Month.SEPTEMBER, 12));
            Capitulo c5 = new Capitulo("Episode 5", LocalDate.of(2013, Month.SEPTEMBER, 12));
            Capitulo c6 = new Capitulo("Episode 6", LocalDate.of(2013, Month.SEPTEMBER, 12));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
        }

        //añado la temporada 2 de Peaky Blinders
        if (t.getFechaEstreno().equals(LocalDate.of(2014, Month.OCTOBER, 2))) {
            Capitulo c1 = new Capitulo("Episode 1", LocalDate.of(2014, Month.OCTOBER, 2));
            Capitulo c2 = new Capitulo("Episode 2", LocalDate.of(2014, Month.OCTOBER, 2));
            Capitulo c3 = new Capitulo("Episode 3", LocalDate.of(2014, Month.OCTOBER, 2));
            Capitulo c4 = new Capitulo("Episode 4", LocalDate.of(2014, Month.OCTOBER, 2));
            Capitulo c5 = new Capitulo("Episode 5", LocalDate.of(2014, Month.OCTOBER, 2));
            Capitulo c6 = new Capitulo("Episode 6", LocalDate.of(2014, Month.OCTOBER, 2));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
        }

        //añado la temporada 3 de Peaky Blinders
        if (t.getFechaEstreno().equals(LocalDate.of(2016, Month.MAY, 5))) {
            Capitulo c1 = new Capitulo("Episode 1", LocalDate.of(2016, Month.MAY, 5));
            Capitulo c2 = new Capitulo("Episode 2", LocalDate.of(2016, Month.MAY, 5));
            Capitulo c3 = new Capitulo("Episode 3", LocalDate.of(2016, Month.MAY, 5));
            Capitulo c4 = new Capitulo("Episode 4", LocalDate.of(2016, Month.MAY, 5));
            Capitulo c5 = new Capitulo("Episode 5", LocalDate.of(2016, Month.MAY, 5));
            Capitulo c6 = new Capitulo("Episode 6", LocalDate.of(2016, Month.MAY, 5));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
        }

        //añado la temporada 4 de Peaky Blinders
        if (t.getFechaEstreno().equals(LocalDate.of(2017, Month.NOVEMBER, 15))) {
            Capitulo c1 = new Capitulo("The Noose", LocalDate.of(2017, Month.NOVEMBER, 15));
            Capitulo c2 = new Capitulo("Heathens", LocalDate.of(2017, Month.NOVEMBER, 15));
            Capitulo c3 = new Capitulo("Blackbird", LocalDate.of(2017, Month.NOVEMBER, 15));
            Capitulo c4 = new Capitulo("Dangerous", LocalDate.of(2017, Month.NOVEMBER, 15));
            Capitulo c5 = new Capitulo("The Duel", LocalDate.of(2017, Month.NOVEMBER, 15));
            Capitulo c6 = new Capitulo("The Company", LocalDate.of(2017, Month.NOVEMBER, 15));
            Capitulo c7 = new Capitulo("The Victory", LocalDate.of(2017, Month.NOVEMBER, 15));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
            t.añadirCapitulo(c7);
        }

        //añado la temporada 5 de Peaky Blinders
        if (t.getFechaEstreno().equals(LocalDate.of(2019, Month.AUGUST, 25))) {
            Capitulo c1 = new Capitulo("Black Tuesday", LocalDate.of(2019, Month.AUGUST, 25));
            Capitulo c2 = new Capitulo("Black Cats", LocalDate.of(2019, Month.AUGUST, 25));
            Capitulo c3 = new Capitulo("Strategy", LocalDate.of(2019, Month.AUGUST, 25));
            Capitulo c4 = new Capitulo("The Loop", LocalDate.of(2019, Month.AUGUST, 25));
            Capitulo c5 = new Capitulo("The Shock", LocalDate.of(2019, Month.AUGUST, 25));
            Capitulo c6 = new Capitulo("Mr. Jones", LocalDate.of(2019, Month.AUGUST, 25));
            Capitulo c7 = new Capitulo("The Company", LocalDate.of(2019, Month.AUGUST, 25));
            Capitulo c8 = new Capitulo("The Duel", LocalDate.of(2019, Month.AUGUST, 25));
            Capitulo c9 = new Capitulo("The Mitre", LocalDate.of(2019, Month.AUGUST, 25));
            Capitulo c10 = new Capitulo("The Beginning", LocalDate.of(2019, Month.AUGUST, 25));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
            t.añadirCapitulo(c7);
            t.añadirCapitulo(c8);
            t.añadirCapitulo(c9);
            t.añadirCapitulo(c10);
        }

        //añado la temporada 6 de Peaky Blinders
        if (t.getFechaEstreno().equals(LocalDate.of(2022, Month.FEBRUARY, 27))) {
            Capitulo c1 = new Capitulo("Black Day", LocalDate.of(2022, Month.FEBRUARY, 27));
            Capitulo c2 = new Capitulo("Black Shirt", LocalDate.of(2022, Month.FEBRUARY, 27));
            Capitulo c3 = new Capitulo("Gold", LocalDate.of(2022, Month.FEBRUARY, 27));
            Capitulo c4 = new Capitulo("Sapphire", LocalDate.of(2022, Month.FEBRUARY, 27));
            Capitulo c5 = new Capitulo("The Road to Hell", LocalDate.of(2022, Month.FEBRUARY, 27));
            Capitulo c6 = new Capitulo("Lock and Key", LocalDate.of(2022, Month.FEBRUARY, 27));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
        }

        //añado la primera temporada de BEAT
        if (t.getFechaEstreno().equals(LocalDate.of(2018, Month.NOVEMBER, 9))) {
            Capitulo c1 = new Capitulo("BEAT", LocalDate.of(2018, Month.NOVEMBER, 9));
            Capitulo c2 = new Capitulo("POP", LocalDate.of(2018, Month.NOVEMBER, 9));
            Capitulo c3 = new Capitulo("BPM", LocalDate.of(2018, Month.NOVEMBER, 9));
            Capitulo c4 = new Capitulo("LOOP", LocalDate.of(2018, Month.NOVEMBER, 9));
            Capitulo c5 = new Capitulo("BACKSPIN", LocalDate.of(2018, Month.NOVEMBER, 9));
            Capitulo c6 = new Capitulo("DROP", LocalDate.of(2018, Month.NOVEMBER, 9));
            Capitulo c7 = new Capitulo("CODA", LocalDate.of(2018, Month.NOVEMBER, 9));
            t.añadirCapitulo(c1);
            t.añadirCapitulo(c2);
            t.añadirCapitulo(c3);
            t.añadirCapitulo(c4);
            t.añadirCapitulo(c5);
            t.añadirCapitulo(c6);
            t.añadirCapitulo(c7);
        }

    }

    public static void cargarTemporadas(Serie s) {

        //creo las temporadas de MR.ROBOT
        Temporada m1 = new Temporada(LocalDate.of(2015, Month.JUNE, 24));
        Temporada m2 = new Temporada(LocalDate.of(2016, Month.JULY, 13));
        Temporada m3 = new Temporada(LocalDate.of(2017, Month.OCTOBER, 11));
        Temporada m4 = new Temporada(LocalDate.of(2019, Month.OCTOBER, 6));

        //introduzco los capítulos en la temporada correspondiente
        cargarCapitulos(m1);
        cargarCapitulos(m2);
        cargarCapitulos(m3);
        cargarCapitulos(m4);

        //las añado a su Serie
        if (s.getFechaEstreno().equals(LocalDate.of(2015, Month.JUNE, 24))) {
            s.añadirTemporada(m1);
            s.añadirTemporada(m2);
            s.añadirTemporada(m3);
            s.añadirTemporada(m4);
        }

        //creo las temporadas de Cowboy Bebop
        Temporada c1 = new Temporada(LocalDate.of(1998, Month.APRIL, 3));

        cargarCapitulos(c1);

        if (s.getFechaEstreno().equals(LocalDate.of(1998, Month.APRIL, 3))) {
            s.añadirTemporada(c1);
        }

        //creo las temporadas de Stranger Things
        Temporada s1 = new Temporada(LocalDate.of(2016, Month.JULY, 15));
        Temporada s2 = new Temporada(LocalDate.of(2017, Month.NOVEMBER, 27));
        Temporada s3 = new Temporada(LocalDate.of(2019, Month.JULY, 4));
        Temporada s4 = new Temporada(LocalDate.of(2022, Month.MAY, 27));

        cargarCapitulos(s1);
        cargarCapitulos(s2);
        cargarCapitulos(s3);
        cargarCapitulos(s4);

        if (s.getFechaEstreno().equals(LocalDate.of(2016, Month.JULY, 15))) {
            s.añadirTemporada(s1);
            s.añadirTemporada(s2);
            s.añadirTemporada(s3);
            s.añadirTemporada(s4);
        }

        //creo las temporadas de Peaky Blinders
        Temporada p1 = new Temporada(LocalDate.of(2013, Month.SEPTEMBER, 12));
        Temporada p2 = new Temporada(LocalDate.of(2014, Month.OCTOBER, 2));
        Temporada p3 = new Temporada(LocalDate.of(2016, Month.MAY, 5));
        Temporada p4 = new Temporada(LocalDate.of(2017, Month.NOVEMBER, 15));
        Temporada p5 = new Temporada(LocalDate.of(2019, Month.AUGUST, 25));
        Temporada p6 = new Temporada(LocalDate.of(2022, Month.FEBRUARY, 27));

        cargarCapitulos(p1);
        cargarCapitulos(p2);
        cargarCapitulos(p3);
        cargarCapitulos(p4);
        cargarCapitulos(p5);
        cargarCapitulos(p6);

        if (s.getFechaEstreno().equals(LocalDate.of(2013, Month.SEPTEMBER, 12))) {
            s.añadirTemporada(p1);
            s.añadirTemporada(p2);
            s.añadirTemporada(p3);
            s.añadirTemporada(p4);
            s.añadirTemporada(p5);
            s.añadirTemporada(p6);
        }

        //creo las temporadas de BEAT
        Temporada b1 = new Temporada(LocalDate.of(2018, Month.NOVEMBER, 9));

        cargarCapitulos(b1);

        if (s.getFechaEstreno().equals(LocalDate.of(2018, Month.NOVEMBER, 9))) {
            s.añadirTemporada(b1);
        }

    }

    public static void cargarSeries(ArrayList<Media> catalogo) {
        Serie s1 = new Serie("MR.ROBOT", 18, LocalDate.of(2023, Month.MARCH, 8),
                true, LocalDate.of(2015, Month.JUNE, 24));
        Serie s2 = new Serie("Cowboy Bebop", 14, LocalDate.of(2023, Month.MARCH, 9),
                false, LocalDate.of(1998, Month.APRIL, 3));
        Serie s3 = new Serie("Stranger Things", 14, LocalDate.of(2023, Month.MARCH, 10),
                true, LocalDate.of(2016, Month.JULY, 15));
        Serie s4 = new Serie("Peaky Blinders", 18, LocalDate.of(2023, Month.MARCH, 11),
                false, LocalDate.of(2013, Month.SEPTEMBER, 12));
        Serie s5 = new Serie("BEAT", 18, LocalDate.of(2023, Month.MARCH, 12),
                true, LocalDate.of(2018, Month.NOVEMBER, 9));

        cargarTemporadas(s1);
        cargarTemporadas(s2);
        cargarTemporadas(s3);
        cargarTemporadas(s4);
        cargarTemporadas(s5);

        catalogo.add(s1);
        catalogo.add(s2);
        catalogo.add(s3);
        catalogo.add(s4);
        catalogo.add(s5);

        //valoro los capitulos para poder realizar operaciones
        for (Media m : catalogo) {
            if (m instanceof Serie s) {
                int nTemp = 1;
                while (s.getCopiaTemporada(nTemp) != null) {
                    int nCap = 1;
                    while (s.getCopiaTemporada(nTemp).getCapitulo(nCap) != null) {
                        //solo añado un voto a cada capitulo para que la probabilidad de que salga una serie con una
                        //puntuacion muy alta incremente
                        for (int count = 0; count < 1; count++) {
                            s.meGusta(nTemp, nCap, (int) (Math.random() * (1 + 1)) == 1);
                        }
                        nCap++;
                    }
                    nTemp++;
                }
            }
        }

    }
}
