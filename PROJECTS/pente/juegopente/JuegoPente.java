/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pente.juegopente;

/**
 *
 * @author amezc
 */
public class JuegoPente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Declaro variables a su valor inicial
        int tamanio = 0;
        int cantFichasGanar = 0;
        int fichasCapturadas = 0;
        int bolsaFichas2 = 0;
        int bolsaFichas1 = 0;
        String jugador1 = "";
        String jugador2 = "";
        String estaJugando = "";
        int ficha = FICHA_EQUIS;
        int fila = 0;
        int columna = 0;
        boolean isColocada = false;

        //Comienza el juego
        do { //valido que el tamanio sea el apropiado
            tamanio = funciones.LeerDatosTeclado.enterInt("Introduce tamanio del tablero (10 - 19):");
            if (tamanio < 10 || tamanio > 19) {
                System.out.println("Tamanio fuera de rango");
            }
        } while (tamanio < 10 || tamanio > 19);
        int[][] tablero = funciones.FuncionesMatrices.crearMatriz(tamanio, tamanio, CASILLA_VACIA);

        do { //valido que la cantidad de fichas sea la apropiada
            cantFichasGanar = funciones.LeerDatosTeclado.enterInt("Introduce la cantidad de fichas a capturar para ganar (5 - 10):");
            if (cantFichasGanar < 5 || cantFichasGanar > 10) {
                System.out.println("Cantidad fuera de rango");
            }
        } while (cantFichasGanar < 5 || cantFichasGanar > 10);

        jugador1 = funciones.LeerDatosTeclado.enterString("Nombre jugador 1:");
        jugador2 = funciones.LeerDatosTeclado.enterString("Nombre jugador 2:");
        mostrarTablero(tablero);

        // con este bucle lograremos que el juego no acabe hasta que se cumplan las condiciones para terminarlo
        do {
            //operador ternario para cambiar de ficha y por tanto jugador
            ficha = (ficha == FICHA_CIRCULO) ? FICHA_EQUIS : FICHA_CIRCULO;
            estaJugando = (ficha == FICHA_CIRCULO) ? jugador1 : jugador2;
            System.out.println("\n" + estaJugando + " te toca");

            //con este bucle validamos que la fila y columna introducidas sean correctas sino que vuelva a introducir
            do {
                fila = funciones.LeerDatosTeclado.enterInt("Introduce fila (1 al " + tablero.length + "):") - 1;
                columna = funciones.LeerDatosTeclado.enterInt("Introduce columna (1 al " + tablero[0].length + "):") - 1;
                isColocada = colocarFicha(tablero, ficha, fila, columna);

            } while (!isColocada);

            //si se puede, capturamos fichas en esa posicion y mostramos el resultado final dependiendo del jugador
            fichasCapturadas = capturarFichas(tablero, fila, columna);
            mostrarTablero(tablero, fila, columna);
            System.out.println("Fichas capturadas: " + fichasCapturadas);
            switch (ficha) {
                case 1:
                    bolsaFichas1 += fichasCapturadas;
                    System.out.println("Total capturadas: " + bolsaFichas1);
                    break;
                case 2:
                    bolsaFichas2 += fichasCapturadas;
                    System.out.println("Total capturadas: " + bolsaFichas2);
                    break;
            }

        } while (!comprobarLinea(tablero, fila, columna) && casillasLibres(tablero) && bolsaFichas1 < cantFichasGanar && bolsaFichas2 < cantFichasGanar);

        //como ya NO se cumple al menos una de las condiciones para que el juego continue notificamos por que ha acabado el juego
        if (comprobarLinea(tablero, fila, columna)) {
            System.out.println(estaJugando + " ha conseguido 5 en linea!!");
        } else if (!casillasLibres(tablero)) {
            System.out.println("Empate. Se ha llenado el tablero...");
        } else if (bolsaFichas1 >= cantFichasGanar) {
            System.out.println(jugador1 + " ha conseguido capturar " + bolsaFichas1 + " fichas! (de " + cantFichasGanar + ")");
        } else if (bolsaFichas2 >= cantFichasGanar) {
            System.out.println(jugador2 + " ha conseguido capturar " + bolsaFichas2 + " fichas! (de " + cantFichasGanar + ")");
        }

        //fin del juego
    }

    public static final int CASILLA_VACIA = 0;
    public static final int FICHA_CIRCULO = 1;
    public static final int FICHA_EQUIS = 2;

    public static boolean colocarFicha(int[][] tablero, int ficha, int fila, int columna) {
        boolean colocada = false;
        boolean isEnRango = false;

        for (int filaTablero = 0; filaTablero < tablero.length; filaTablero++) {
            for (int columnaTablero = 0; columnaTablero < tablero[filaTablero].length; columnaTablero++) {
                if (filaTablero == fila && columnaTablero == columna) {
                    isEnRango = true;
                    if (tablero[filaTablero][columnaTablero] == 0) {
                        tablero[fila][columna] = ficha;
                        colocada = true;
                    } else {
                        System.out.println("ERROR. Ya hay una ficha en esa posicion...");
                    }
                }
            }
        }

        if (!isEnRango) {
            System.out.println("ERROR. Introduce posicion del 1 al " + tablero.length + "...");
        }

        return colocada;
    }

    public static int capturarFichas(int[][] tablero, int fila, int columna) {
        int capturadas = 0;

        //1 compruebo si puedo capturar fichas en la fila de la ultima posicion introducida y las capturo creando una funcion para ello
        capturadas += capturarEnFila(tablero, fila, columna);

        //2 compruebo si puedo capturar fichas en la columna de la ultima posicion introducida y las capturo creando una funcion para ello
        capturadas += capturarEnColumna(tablero, fila, columna);

        //3 compruebo si puedo capturar fichas en la diagonal "principal" de la ultima posicion introducida y las capturo creando una funcion para ello
        capturadas += capturarEnDiagPrincipal(tablero, fila, columna);

        //4 compruebo si puedo capturar fichas en la diagonal "secundaria" de la ultima posicion introducida y las capturo creando una funcion para ello
        capturadas += capturarEnDiagSecundaria(tablero, fila, columna);

        return capturadas;
    }

    public static int capturarEnFila(int[][] tablero, int fila, int columna) {
        int capturadas = 0;

        //si columna < 3 no podremos "capurar" por la izquierda
        if (columna < 3) {
            for (int elemento = columna; elemento < columna + 3; elemento++) {
                if (tablero[fila][elemento] != tablero[fila][elemento + 1] && tablero[fila][elemento + 1] == tablero[fila][elemento + 2]
                        && tablero[fila][elemento] == tablero[fila][elemento + 3] && tablero[fila][elemento] == tablero[fila][columna] && tablero[fila][elemento + 1] != 0) {
                    tablero[fila][elemento + 1] = 0;
                    tablero[fila][elemento + 2] = 0;
                    capturadas += 2;
                }
            }
        } else if (columna > (tablero[fila].length - 4)) { //si columna < 4 contando por la derecha no podremos "capurar" por la derecha
            for (int elemento = columna; elemento > columna - 3; elemento--) {
                if (tablero[fila][elemento] != tablero[fila][elemento - 1] && tablero[fila][elemento - 1] == tablero[fila][elemento - 2]
                        && tablero[fila][elemento] == tablero[fila][elemento - 3] && tablero[fila][elemento] == tablero[fila][columna] && tablero[fila][elemento - 1] != 0) {
                    tablero[fila][elemento - 1] = 0;
                    tablero[fila][elemento - 2] = 0;
                    capturadas += 2;
                }
            }
        } else {
            for (int elemento = columna - 3; elemento <= columna; elemento++) { //podremos capturar por ambos lados
                if (tablero[fila][elemento] != tablero[fila][elemento + 1] && tablero[fila][elemento + 1] == tablero[fila][elemento + 2]
                        && tablero[fila][elemento] == tablero[fila][elemento + 3] && tablero[fila][elemento] == tablero[fila][columna] && tablero[fila][elemento + 1] != 0) {
                    tablero[fila][elemento + 1] = 0;
                    tablero[fila][elemento + 2] = 0;
                    capturadas += 2;
                }
            }
        }
        return capturadas;
    }

    public static int capturarEnColumna(int[][] tablero, int fila, int columna) {
        int capturadas = 0;

        //si fila < 3 no podremos "capurar" por arriba
        if (fila < 3) {
            for (int elemento = fila; elemento < fila + 3; elemento++) {
                if (tablero[elemento][columna] != tablero[elemento + 1][columna] && tablero[elemento + 1][columna] == tablero[elemento + 2][columna]
                        && tablero[elemento][columna] == tablero[elemento + 3][columna] && tablero[elemento][columna] == tablero[fila][columna] && tablero[elemento + 1][columna] != 0) {
                    tablero[elemento + 1][columna] = 0;
                    tablero[elemento + 2][columna] = 0;
                    capturadas += 2;
                }
            }
        } else if (fila > (tablero.length - 4)) { //si columna > 4 contando por abajo no podremos "capurar" abajo
            for (int elemento = fila; elemento > fila - 3; elemento--) {
                if (tablero[elemento][columna] != tablero[elemento - 1][columna] && tablero[elemento - 1][columna] == tablero[elemento - 2][columna]
                        && tablero[elemento][columna] == tablero[elemento - 3][columna] && tablero[elemento][columna] == tablero[fila][columna] && tablero[elemento - 1][columna] != 0) {
                    tablero[elemento - 1][columna] = 0;
                    tablero[elemento - 2][columna] = 0;
                    capturadas += 2;
                }
            }
        } else {
            for (int elemento = fila - 3; elemento <= fila; elemento++) { //si no se cumple lo anterior podremos capturar por arriba o abajo
                if (tablero[elemento][columna] != tablero[elemento + 1][columna] && tablero[elemento + 1][columna] == tablero[elemento + 2][columna]
                        && tablero[elemento][columna] == tablero[elemento + 3][columna] && tablero[elemento][columna] == tablero[fila][columna] && tablero[elemento + 1][columna] != 0) {
                    tablero[elemento + 1][columna] = 0;
                    tablero[elemento + 2][columna] = 0;
                    capturadas += 2;
                }
            }
        }
        return capturadas;
    }

    public static int capturarEnDiagPrincipal(int tablero[][], int fila, int columna) {
        int capturadas = 0;

        //dependiendo de la posicion de la ficha podremos capturar en la diagonal principal en distintos casos
        if ((fila < 3 && columna <= (tablero.length - 4)) || (columna < 3 && fila <= (tablero.length - 4))) {
            if (tablero[fila][columna] != tablero[fila + 1][columna + 1] && tablero[fila + 1][columna + 1] == tablero[fila + 2][columna + 2]
                    && tablero[fila][columna] == tablero[fila + 3][columna + 3] && tablero[fila][columna] != 0 && tablero[fila + 1][columna + 1] != 0) {
                tablero[fila + 1][columna + 1] = 0;
                tablero[fila + 2][columna + 2] = 0;
                capturadas += 2;
            }
        } else if ((columna > (tablero.length - 4) && fila >= 3) || (fila > (tablero.length - 4) && columna >= 3)) {
            if (tablero[fila][columna] != tablero[fila - 1][columna - 1] && tablero[fila - 1][columna - 1] == tablero[fila - 2][columna - 2]
                    && tablero[fila][columna] == tablero[fila - 3][columna - 3] && tablero[fila][columna] != 0 && tablero[fila - 1][columna - 1] != 0) {
                tablero[fila - 1][columna - 1] = 0;
                tablero[fila - 2][columna - 2] = 0;
                capturadas += 2;
            }
        } else if (extraerDiagonalPrin(tablero, fila, columna).length >= 6) {
            if (tablero[fila][columna] != tablero[fila + 1][columna + 1] && tablero[fila + 1][columna + 1] == tablero[fila + 2][columna + 2]
                    && tablero[fila][columna] == tablero[fila + 3][columna + 3] && tablero[fila][columna] != 0 && tablero[fila + 1][columna + 1] != 0) {
                tablero[fila + 1][columna + 1] = 0;
                tablero[fila + 2][columna + 2] = 0;
                capturadas += 2;
            }

            if (tablero[fila][columna] != tablero[fila - 1][columna - 1] && tablero[fila - 1][columna - 1] == tablero[fila - 2][columna - 2]
                    && tablero[fila][columna] == tablero[fila - 3][columna - 3] && tablero[fila][columna] != 0 && tablero[fila - 1][columna - 1] != 0) {
                tablero[fila - 1][columna - 1] = 0;
                tablero[fila - 2][columna - 2] = 0;
                capturadas += 2;
            }
        }

        return capturadas;
    }

    public static int capturarEnDiagSecundaria(int tablero[][], int fila, int columna) {
        int capturadas = 0;

        //dependiendo de la posicion de la ficha podremos capturar en la diagonal secundaria en distintos casos
        if ((fila < 3 && columna >= 3) || (columna > (tablero.length - 4) && fila <= (tablero.length - 4))) {
            if (tablero[fila][columna] != tablero[fila + 1][columna - 1] && tablero[fila + 1][columna - 1] == tablero[fila + 2][columna - 2]
                    && tablero[fila][columna] == tablero[fila + 3][columna - 3] && tablero[fila][columna] != 0 && tablero[fila + 1][columna - 1] != 0) {
                tablero[fila + 1][columna - 1] = 0;
                tablero[fila + 2][columna - 2] = 0;
                capturadas += 2;
            }
        } else if ((fila >= 3 && columna < 3) || (fila > (tablero.length - 4) && columna <= (tablero.length - 4))) {
            if (tablero[fila][columna] != tablero[fila - 1][columna + 1] && tablero[fila - 1][columna + 1] == tablero[fila - 2][columna + 2]
                    && tablero[fila][columna] == tablero[fila - 3][columna + 3] && tablero[fila][columna] != 0 && tablero[fila - 1][columna + 1] != 0) {
                tablero[fila - 1][columna + 1] = 0;
                tablero[fila - 2][columna + 2] = 0;
                capturadas += 2;
            }
        } else if (extraerDiagonalSec(tablero, fila, columna).length >= 6) {
            if (tablero[fila][columna] != tablero[fila + 1][columna - 1] && tablero[fila + 1][columna - 1] == tablero[fila + 2][columna - 2]
                    && tablero[fila][columna] == tablero[fila + 3][columna - 3] && tablero[fila][columna] != 0 && tablero[fila + 1][columna - 1] != 0) {
                tablero[fila + 1][columna - 1] = 0;
                tablero[fila + 2][columna - 2] = 0;
                capturadas += 2;
            }

            if (tablero[fila][columna] != tablero[fila - 1][columna + 1] && tablero[fila - 1][columna + 1] == tablero[fila - 2][columna + 2]
                    && tablero[fila][columna] == tablero[fila - 3][columna + 3] && tablero[fila][columna] != 0 && tablero[fila - 1][columna + 1] != 0) {
                tablero[fila - 1][columna + 1] = 0;
                tablero[fila - 2][columna + 2] = 0;
                capturadas += 2;
            }
        }
        return capturadas;
    }

    public static boolean comprobarLinea(int[][] tablero, int fila, int columna) {
        boolean cincoEnLinea = false;

        //1 compruebo si hay 5 en linea en la fila de la ultima posicion
        int[] arrayLinea = extraerFila(tablero, fila, columna);
        cincoEnLinea = comprobarCincoEnLinea(arrayLinea);
        //2 compruebo si hay 5 en linea en la columna de la ultima posicion si antes no se ha cumplido
        if (!cincoEnLinea) {
            arrayLinea = extraerColumna(tablero, fila, columna);
            cincoEnLinea = comprobarCincoEnLinea(arrayLinea);
        }
        //3 compruebo si hay 5 en linea en la diagonal "principal" de la ultima posicion si antes no se ha cumplido
        if (!cincoEnLinea) {
            arrayLinea = extraerDiagonalPrin(tablero, fila, columna);
            cincoEnLinea = comprobarCincoEnLinea(arrayLinea);
        }
        //4 compruebo si hay 5 en linea en la diagonal "secundaria" de la ultima posicion si antes no se ha cumplido
        if (!cincoEnLinea) {
            arrayLinea = extraerDiagonalSec(tablero, fila, columna);
            cincoEnLinea = comprobarCincoEnLinea(arrayLinea);
        }
        return cincoEnLinea;
    }

    //con esta funcion evito duplicar x4 veces el codigo en la funcion comprobarLinea
    public static boolean comprobarCincoEnLinea(int[] arrayLinea) {
        boolean cincoEnLinea = false;
        int contIguales = 1;

        for (int elemento = 0; elemento < arrayLinea.length - 1; elemento++) {
            if (cincoEnLinea) { //si ya hay cinco en linea no quiero que siga

            } else if (arrayLinea[elemento] == arrayLinea[elemento + 1] && arrayLinea[elemento] != 0) {
                contIguales++;
                cincoEnLinea = (contIguales == 5) ? true : false;
            } else {
                contIguales = 1;
            }
        }
        return cincoEnLinea;
    }

    //funcion que te devuelve un array con la fila de la ultima posicion introducida
    public static int[] extraerFila(int[][] tablero, int fila, int columna) {
        int[] filaArray = new int[tablero[fila].length];

        for (int columnaTabla = 0; columnaTabla < tablero[fila].length; columnaTabla++) {
            filaArray[columnaTabla] = tablero[fila][columnaTabla];
        }

        return filaArray;
    }

    //funcion que te devuelve un array con la columna de la ultima posicion introducida
    public static int[] extraerColumna(int[][] tablero, int fila, int columna) {
        int[] columnaArray = new int[tablero.length];

        for (int filaTabla = 0; filaTabla < columnaArray.length; filaTabla++) {
            columnaArray[filaTabla] = tablero[filaTabla][columna];
        }

        return columnaArray;
    }

    //funcion que te devuelve un array de longitud variable con la diagonal "principal" de la ultima posicion
    //se que me he complicado la vida al hacer la funcion tan compleja matematicamente pero me parece muy reutilizable
    public static int[] extraerDiagonalPrin(int[][] tablero, int fila, int columna) {
        int altura = tablero.length;
        int anchura = tablero[fila].length;

        //dependiendo de la posicion la longitud del la diagonal principal sera distinta
        int[] arrayDiagonal = new int[anchura - Math.abs(fila - columna)];
        int elemento = 0;

        //he tomado como posicion de referencia la fila=0, columna=0
        for (int diagonal = 1 - anchura; diagonal <= altura - 1; diagonal++) {
            for (int posVertical = Math.max(0, diagonal), posHorizontal = -Math.min(0, diagonal);
                    posVertical < altura && posHorizontal < anchura;
                    posVertical++, posHorizontal++) {
                if (posVertical - posHorizontal == diagonal && fila - columna == diagonal) {
                    arrayDiagonal[elemento] = tablero[posVertical][posHorizontal];
                    elemento++;
                }

            }
        }

        return arrayDiagonal;

    }

    //funcion que te devuelve un array de longitud variable con la diagonal "secundaria" de la ultima posicion
    //si la funcion anterior era compleja esta lo es el doble
    public static int[] extraerDiagonalSec(int[][] tablero, int fila, int columna) {
        int altura = tablero.length;
        int anchura = tablero[fila].length;
        int longitudDiagonal = 0;

        //dependiendo de la posicion la longitud del la diagonal secundaria sera distinta
        if (altura - fila + anchura - columna - 1 <= anchura) {
            longitudDiagonal = altura - fila + anchura - columna - 1;
        } else {
            longitudDiagonal = fila + columna + 1;
        }

        int[] arrayDiagonal = new int[longitudDiagonal];
        int elemento = 0;

        //he tomado como posicion de referencia la fila=0, columna=0
        if (altura - fila + anchura - columna - 1 <= anchura) {
            for (int diagonal = 1 - anchura; diagonal <= altura - 1; diagonal++) {
                for (int posVertical = Math.max((altura - 1), diagonal), posHorizontal = -Math.min((altura - 1), diagonal);
                        posVertical >= 0 && posHorizontal < anchura;
                        posVertical--, posHorizontal++) {
                    if (posVertical + posHorizontal == fila + columna) {
                        arrayDiagonal[elemento] = tablero[posVertical][posHorizontal];
                        elemento++;
                    }

                }
            }
        } else {
            for (int diagonal = 1 - anchura; diagonal <= altura - 1; diagonal++) {
                for (int posVertical = Math.min((altura - 1), diagonal), posHorizontal = -Math.min(0, diagonal);
                        posVertical >= 0 && posHorizontal < anchura;
                        posVertical--, posHorizontal++) {
                    if (posVertical + posHorizontal == fila + columna) {
                        arrayDiagonal[elemento] = tablero[posVertical][posHorizontal];
                        elemento++;
                    }

                }
            }
        }

        return arrayDiagonal;

    }

    public static boolean casillasLibres(int[][] tablero) {
        boolean isVacia = false;
        for (int[] fila : tablero) {
            for (int elemento : fila) {
                if (elemento == CASILLA_VACIA) {
                    isVacia = true;
                }
            }
        }

        return isVacia;
    }

    public static void mostrarTablero(int[][] tablero) {
        String fichaAPintar = "";

        for (int filaTablero = 0; filaTablero < tablero.length; filaTablero++) {
            System.out.print((" ---").repeat(tablero.length) + "\n");
            for (int columnaTablero = 0; columnaTablero < tablero[filaTablero].length; columnaTablero++) {
                fichaAPintar = sacarFicha(tablero, filaTablero, columnaTablero);
                construirCasilla(tablero, filaTablero, columnaTablero, fichaAPintar);
            }
        }
        System.out.print((" ---").repeat(tablero.length) + "\n");

    }

    public static final String RESALTAR_ROJO = "\u001B[31m";
    public static final String RESETEAR_COLOR = "\u001B[0m";

    public static void mostrarTablero(int[][] tablero, int fila, int columna) {
        String fichaAPintar = "";

        for (int filaTablero = 0; filaTablero < tablero.length; filaTablero++) {
            System.out.print((" ---").repeat(tablero.length) + "\n");
            for (int columnaTablero = 0; columnaTablero < tablero[filaTablero].length; columnaTablero++) {
                fichaAPintar = sacarFicha(tablero, filaTablero, columnaTablero);

                //lo unico que diferencia a las dos funciones mostrarTablero es esta linea de codigo que "resalta" la ficha de color rojo
                fichaAPintar = (fila == filaTablero && columna == columnaTablero) ? RESALTAR_ROJO + fichaAPintar + RESETEAR_COLOR : fichaAPintar;
                construirCasilla(tablero, filaTablero, columnaTablero, fichaAPintar);
            }
        }
        System.out.print((" ---").repeat(tablero.length) + "\n");
    }

    //con esta funcion evitamos duplicar codigo en ambas funciones mostrarTablero
    public static String sacarFicha(int[][] tablero, int filaTablero, int columnaTablero) {
        String fichaAPintar = "";

        switch (tablero[filaTablero][columnaTablero]) {
            case FICHA_CIRCULO:
                fichaAPintar = "O";
                break;
            case FICHA_EQUIS:
                fichaAPintar = "X";
                break;
            default:
                fichaAPintar = " ";
                break;
        }

        return fichaAPintar;
    }

    //con esta funcion tambien evitamos duplicar codigo en ambas funciones mostrarTablero
    public static void construirCasilla(int[][] tablero, int filaTablero, int columnaTablero, String fichaAPintar) {

        if (columnaTablero + 1 == tablero[filaTablero].length) {
            System.out.print(" " + fichaAPintar + " |\n");

        } else if (columnaTablero == 0) {
            System.out.print("| " + fichaAPintar + " |");

        } else {
            System.out.print(" " + fichaAPintar + " |");

        }

    }

}
