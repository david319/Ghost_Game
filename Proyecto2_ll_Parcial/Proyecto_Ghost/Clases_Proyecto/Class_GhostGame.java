package Clases_Proyecto;

import java.lang.System;
import java.util.Objects;
import java.util.Scanner;

import static Clases_Proyecto.Class_Player.*;

public class Class_GhostGame {

    private static final Scanner leer = new Scanner(System.in);

    // Atributos/Variables
    private static int dificultad = 1;
    private static int modoJ = 1;
    private static boolean gameOver = false;
    private static boolean piezaValida1 = false;
    private static boolean piezaValida2 = false;
    private static final String[][] tablero = new String[6][6];


    // Inicializar tablero
    public static void inicializarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {
                    tablero[i][j] = "[   ]";
                }
            }
        }
    }

    // Mostrar tablero
    public static void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
        }
    }

    // Verificar si el jugador 1 ha salido del castillo
    public static void verify_win1(int fila1, int columna1) { // Verificar si el jugador 1 ha salido del castillo
        if (Objects.equals(tablero[fila1][columna1], tablero[5][5])) { // Verificar si el jugador 1 ha ido a esas coordenadas
            System.out.println(obtenerPlayer1() + " ha ganado al salir del castillo!");
            add_Reporte(obtenerPlayer1(), " Ganó al salir del castillo!");
            add_puntos(obtenerPlayer1(), 100);
            gameOver = true;
        } else if (Objects.equals(tablero[fila1][columna1], tablero[5][0])) { // Verificar si el jugador 1 ha ido a esas coordenadas
            System.out.println(obtenerPlayer1() + " ha ganado al salir del castillo!");
            add_Reporte(obtenerPlayer1(), " Ganó al salir del castillo!");
            add_puntos(obtenerPlayer1(), 100);
            gameOver = true;
        }
    }

    // Verificar si el jugador 2 ha salido del castillo
    public static void verify_win2(int fila2, int columna2) { // Verificar si el jugador 2 ha salido del castillo
        if (Objects.equals(tablero[fila2][columna2], tablero[0][0])) { // Verificar si el jugador 2 ha ido a esas coordenadas
            System.out.println(obtenerPlayer2() + " ha ganado al salir del castillo!");
            add_Reporte(obtenerPlayer2(), " Ganó al salir del castillo!");
            add_puntos(obtenerPlayer2(), 100);
            gameOver = true;
        } else if (Objects.equals(tablero[fila2][columna2], tablero[0][5])) { // Verificar si el jugador 2 ha ido a esas coordenadas
            System.out.println(obtenerPlayer2() + " ha ganado al salir del castillo!");
            add_Reporte(obtenerPlayer2(), " Ganó al salir del castillo!");
            add_puntos(obtenerPlayer2(), 100);
            gameOver = true;
        }
    }

    // Dificultad del juego
    public static void Dificultad(int dificultad) { // Dificultad del juego
        Class_GhostGame.dificultad = dificultad;
    }

    // Modo de juego
    public static void ModoG(int modo) { // Modo de juego
        Class_GhostGame.modoJ = modo;
    }

    // Empieza el juego
    public static void play_Game() {
        //Piezas(Fantasmas)
        String ghost1 = "[ 👻 ]", ghost2 = "[ 👻 ]", ghost3 = "[ 👻 ]", ghost4 = "[ 👻 ]"; // Fantasmas del jugador 1
        String ghostBad1 = "[ 👻 ]", ghostBad2 = "[ 👻 ]", ghostBad3 = "[ 👻 ]", ghostBad4 = "[ 👻 ]"; // Fantasmas malos del jugador 1
        String ghost5 = "[ 👻 ]", ghost6 = "[ 👻 ]", ghost7 = "[ 👻 ]", ghost8 = "[ 👻 ]"; // Fantasmas del jugador 2
        String ghostBad5 = "[ 👻 ]", ghostBad6 = "[ 👻 ]", ghostBad7 = "[ 👻 ]", ghostBad8 = "[ 👻 ]"; // Fantasmas malos del jugador 2

        // variables
        int goodGhosts = 8, badGhosts = 8; // Cantidad de fantasmas buenos y malos del jugador 1
        int goodGhosts2 = 8, badGhosts2 = 8; // Cantidad de fantasmas buenos y malos del jugador 2
        int contadorGhost = 8; // Contador de fantasmas del jugador 1 en modo aleatorio
        int contadorGhost2 = 8; // Contador de fantasmas del jugador 2 en modo aleatorio
        int countGhost = 4; // Contador de fantasmas de los a inicializar en modo manual y dificultad default

        // Inicializar tablero
        inicializarTablero();

        if (dificultad == 2) { // Dificultad 2
            countGhost = 2;
        } else if (dificultad == 3) { // Dificultad 3
            countGhost = 1;
        }


        if (modoJ == 1 ) { // Modo aleatorio
            for (int i = 0; i <= countGhost; i++) { // Inicializar fantasmas del jugador 1
                int fila = (int) (Math.random() * 5); // Fila
                int columna = (int) (Math.random() * 5); // Columna
                if (fila == 0 || fila == 1 && columna > 0 && columna < 5) { // Verificar si la fila es 0 o 1 y la columna es mayor a 0 y menor a 5
                    if (Objects.equals(tablero[fila][columna], "[   ]") && i == 1) { // Verificar si la casilla está vacía y el contador es 1
                        tablero[fila][columna] = Math.random() * 2 < 2 ? ghost1 : ghostBad1; // Inicializar fantasma 1
                        contadorGhost++; // Aumentar contador
                    } else if (Objects.equals(tablero[fila][columna], "[   ]") && i == 2) { // Verificar si la casilla está vacía y el contador es 2
                        tablero[fila][columna] = Math.random() * 2 < 2 ? ghost2 : ghostBad2; // Inicializar fantasmas del jugador 1
                        contadorGhost++; // Aumentar contador
                    } else if (Objects.equals(tablero[fila][columna], "[   ]") && i == 3) { // Verificar si la casilla está vacía y el contador es 3
                        tablero[fila][columna] = Math.random()* 2 < 2 ? ghost3 : ghostBad3; // Inicializar fantasmas del jugador 1
                        contadorGhost++; // Aumentar contador
                    } else if (Objects.equals(tablero[fila][columna], "[   ]") && i == 4) { // Verificar si la casilla está vacía y el contador es 4
                        tablero[fila][columna] = Math.random() * 2 < 2 ? ghost4 : ghostBad4; // Inicializar fantasmas del jugador 1
                        contadorGhost++; // Aumentar contador
                    }
                } else { // Si la fila es diferente de 0 a 1 o la columna es diferente de 0 a 4
                    i--; // Disminuye el contador
                }
            }

            for (int i = 0; i <= countGhost; i++) { // Inicializar fantasmas del jugador 2
                int fila = (int) (Math.random() * 5); // Fila
                int columna = (int) (Math.random() * 5); // Columna
                if (fila == 5 || fila == 4 && columna > 0 && columna < 5) { // Verificar si la fila es 5 o 4 y la columna es mayor a 0 y menor a 5
                    if (Objects.equals(tablero[fila][columna], "[   ]") && i == 1) { // Verificar si la casilla está vacía y el contador es 1
                        tablero[fila][columna] = Math.random() * 2 < 2 ? ghost5 : ghostBad5; // Inicializar fantasmas del jugador 2
                        contadorGhost2++; // Aumentar contador
                    } else if (Objects.equals(tablero[fila][columna], "[   ]") && i == 2) { // Verificar si la casilla está vacía y el contador es 2
                        tablero[fila][columna] = Math.random() * 2 < 2 ? ghost6 : ghostBad6; // Inicializar fantasmas del jugador 2
                        contadorGhost2++; // Aumentar contador
                    } else if (Objects.equals(tablero[fila][columna], "[   ]") && i == 3) { // Verificar si la casilla está vacía y el contador es 3
                        tablero[fila][columna] = Math.random() * 2 < 2 ? ghost7 : ghostBad7; // Inicializar fantasmas del jugador 2
                        contadorGhost2++; // Aumentar contador
                    } else if (Objects.equals(tablero[fila][columna], "[   ]") && i == 4) { // Verificar si la casilla está vacía y el contador es 4
                        tablero[fila][columna] = Math.random() * 2 < 2 ? ghost8 : ghostBad8; // Inicializar fantasmas del jugador 2
                    }
                } else { // Si la fila es diferente de 5 a 4 o la columna es diferente de 0 a 4
                    i--; // Disminuye el contador
                }
            }

        } else if (modoJ == 2) { // Modo manual
            goodGhosts = 0; // Inicializar contador de fantasmas del jugador 1
            badGhosts = 0; // Inicializar contador de fantasmas del jugador 1
            // El jugador elige donde colocar la pieza
            System.out.println("\nJugador " + obtenerPlayer1() + " elige donde colocar las piezas");
            for (int i = 0; i < countGhost; i++) {
                System.out.println("Ingrese en que posición desea colocar las fantasmas buenos tiene " + countGhost +
                        "\n(Posiciones validas entre fila 0 a columna 4 y fila 1 a columna 4)");
                System.out.println("Ingrese la fila: ");
                int fila = leer.nextInt();
                System.out.println("Ingrese la columna: ");
                int columna = leer.nextInt();
                if (fila >= 0 && fila <= 1 && columna > 0 && columna <= 4) { // Verificar si la fila es mayor a 0 y menor a 1 y la columna es mayor a 0 y menor a 4
                    if (tablero[fila][columna].equals("[   ]") && i == 0) { // Verificar si la casilla está vacía y el contador es 0
                        tablero[fila][columna] = ghost1; // Inicializar fantasmas del jugador 1
                        goodGhosts++; // Aumentar contador
                    } else if (tablero[fila][columna].contains("[   ]") && i == 1) { // Verificar si la casilla está vacía y el contador es 1
                        tablero[fila][columna] = ghost2; // Inicializar fantasmas del jugador 1
                        goodGhosts++; // Aumentar contador
                    } else if (tablero[fila][columna].contains("[   ]") && i == 2) { // Verificar si la casilla está vacía y el contador es 2
                        tablero[fila][columna] = ghost3; // Inicializar fantasmas del jugador 1
                        goodGhosts++; // Aumentar contador
                    } else if (tablero[fila][columna].equals("[   ]") && i == 3) { // Verificar si la casilla está vacía y el contador es 3
                        tablero[fila][columna] = ghost4; // Inicializar fantasmas del jugador 1
                        goodGhosts++; // Aumentar contador
                    } else { // Si la casilla no está vacía
                        System.out.println("Posición no valida, intente nuevamente");
                        i--; // Disminuye el contador
                    }
                } else { // Si la fila es diferente de 0 a 1 o la columna es diferente de 0 a 4
                    System.out.println("Posición no valida, intente nuevamente");
                    i--;
                }
            }

            // Mostrar tablero
            mostrarTablero();

            for (int i = 0; i < countGhost; i++) { // Ciclo para colocar los fantasmas malos
                System.out.println("\nIngrese en que posición desea colocar las fantasmas malos tiene " + countGhost +
                        "\n(Posiciones validas entre fila 0 a columna 4 y fila 1 a columna 4)");
                System.out.println("Ingrese la fila: ");
                int filaB = leer.nextInt();
                System.out.println("Ingrese la columna: ");
                int columnaB = leer.nextInt();
                if (filaB >= 0 && filaB <= 1 && columnaB > 0 && columnaB <= 4) { // Verificar si la fila es mayor a 0 y menor a 1 y la columna es mayor a 0 y menor a 4
                    if (tablero[filaB][columnaB].contains("[   ]")) { // Verificar si la casilla está vacía
                        tablero[filaB][columnaB] = ghostBad1; // Inicializar fantasmas del jugador 2
                        badGhosts++; // Aumentar contador
                    } else if (tablero[filaB][columnaB].contains("[   ]") && i == 1) { // Verificar si la casilla está vacía y el contador es 1
                        tablero[filaB][columnaB] = ghostBad2; // Inicializar fantasmas del jugador 2
                        badGhosts++; // Aumentar contador
                    } else if (tablero[filaB][columnaB].contains("[   ]") && i == 2) { // Verificar si la casilla está vacía y el contador es 2
                        tablero[filaB][columnaB] = ghostBad3; // Inicializar fantasmas del jugador 2
                        badGhosts++; // Aumentar contador
                    } else if (tablero[filaB][columnaB].contains("[   ]") && i == 3) { // Verificar si la casilla está vacía y el contador es 3
                        tablero[filaB][columnaB] = ghostBad4; // Inicializar fantasmas del jugador 2
                        badGhosts++; // Aumentar contador
                    } else { // Si la casilla no está vacía
                        System.out.println("Posición no valida, intente nuevamente");
                        i--; // Disminuye el contador
                    }
                } else { // Si la fila es diferente de 0 a 1 o la columna es diferente de 0 a 4
                    System.out.println("Posición no valida, intente nuevamente");
                    i--; // Disminuye el contador
                }
            }

            // Mostrar tablero
            mostrarTablero();

            goodGhosts2 = 0; // Inicializar contador de fantasmas del jugador 2
            badGhosts2 = 0; // Inicializar contador de fantasmas malos del jugador 2
            System.out.println("\nJugador " + obtenerPlayer2() + " elige donde colocar las piezas");
            for (int i = 0; i < countGhost; i++) {
                System.out.println("Ingrese en que posición desea colocar las fantasmas buenos tiene " + countGhost +
                        "\n(Posiciones validas entre fila 4 a columna 4 y fila 5 a columna 4)");
                System.out.println("Ingrese la fila:");
                int filaG = leer.nextInt();
                System.out.println("Ingrese la columna:");
                int columnaG = leer.nextInt();
                if (filaG >= 4 && filaG <= 5 && columnaG > 0 && columnaG <= 4) {
                    if (tablero[filaG][columnaG].equals("[   ]")) {
                        tablero[filaG][columnaG] = ghost5;
                        goodGhosts2++;
                    } else if (tablero[filaG][columnaG].equals("[   ]") && i == 1) {
                        tablero[filaG][columnaG] = ghost6;
                        goodGhosts2++;
                    } else if (tablero[filaG][columnaG].equals("[   ]") && i == 2) {
                        tablero[filaG][columnaG] = ghost7;
                        goodGhosts2++;
                    } else if (tablero[filaG][columnaG].equals("[   ]") && i == 3) {
                        tablero[filaG][columnaG] = ghost8;
                        goodGhosts2++;
                    } else {
                        System.out.println("Posición no valida, intente nuevamente");
                        i--;
                    }
                } else {
                    System.out.println("Posición no valida, intente nuevamente");
                    i--;
                }
            }

            for (int i = 0; i < countGhost; i++) {
                System.out.println("\nIngrese en que posición desea colocar las fantasmas malos tiene " + countGhost +
                        "\n(Posiciones validas entre fila 4 a columna 4 y fila 5 a columna 4)");
                System.out.println("Ingrese la fila: ");
                int fila = leer.nextInt();
                System.out.println("Ingrese la columna: ");
                int columna = leer.nextInt();
                if (fila >= 4 && fila <= 5 && columna > 0 && columna <= 4) {
                    if (tablero[fila][columna].equals("[   ]")) {
                        tablero[fila][columna] = ghostBad5;
                        badGhosts2++;
                    } else if (tablero[fila][columna].equals("[   ]") && i == 1) {
                        tablero[fila][columna] = ghostBad6;
                        badGhosts2++;
                    } else if (tablero[fila][columna].equals("[   ]") && i == 2) {
                        tablero[fila][columna] = ghostBad7;
                        badGhosts2++;
                    } else if (tablero[fila][columna].equals("[   ]") && i == 3) {
                        tablero[fila][columna] = ghostBad8;
                        badGhosts2++;
                    } else {
                        System.out.println("Posición no valida, intente nuevamente");
                        i--;
                    }
                } else {
                    System.out.println("Posición no valida, intente nuevamente");
                    i--;
                }
            }
        }

        // Mostrar tablero
        mostrarTablero();

        // jugar
        int turno = 0;
        do {
            if (turno % 2 == 0) { // Jugador 1
                System.out.println("\nTurno de: " + obtenerPlayer1()); // Mostrar jugador 1
            } else { // Jugador 2
                System.out.println("\nTurno de: " + obtenerPlayer2()); // Mostrar jugador 2
            }
            System.out.println("Ingrese la pieza que desea mover: ");
            System.out.println("Fila: ");
            int fila = leer.nextInt();
            System.out.println("Columna: ");
            int columna = leer.nextInt();

            if (turno % 2 == 0) { // Jugador 1
                if (Objects.equals(tablero[fila][columna], ghost1) || Objects.equals(tablero[fila][columna], ghostBad1)) { // Si es fantasma 1
                    piezaValida1 = true; // Se puede mover
                } else if (Objects.equals(tablero[fila][columna], ghost2) || Objects.equals(tablero[fila][columna], ghostBad2)) { // Si es fantasma 2
                    piezaValida1 = true; // Se puede mover
                } else if (Objects.equals(tablero[fila][columna], ghost3) || Objects.equals(tablero[fila][columna], ghostBad3)) { // Si es fantasma 3
                    piezaValida1 = true; // Se puede mover
                } else if (Objects.equals(tablero[fila][columna], ghost4) || Objects.equals(tablero[fila][columna], ghostBad4)) { // Si es fantasma 4
                    piezaValida1 = true; // Se puede mover
                } else { // Si no es ninguno de los fantasmas
                    System.out.println("\nLa pieza ingresada no es valida.");
                }
            } else { // Jugador 2
                if (Objects.equals(tablero[fila][columna], ghost5) || Objects.equals(tablero[fila][columna], ghostBad5)) { // Si es fantasma 5
                    piezaValida2 = true; // Se puede mover
                } else if (Objects.equals(tablero[fila][columna], ghost6) || Objects.equals(tablero[fila][columna], ghostBad6)) { // Si es fantasma 6
                    piezaValida2 = true;
                } else if (Objects.equals(tablero[fila][columna], ghost7) || Objects.equals(tablero[fila][columna], ghostBad7)) { // Si es fantasma 7
                    piezaValida2 = true;
                } else if (Objects.equals(tablero[fila][columna], ghost8) || Objects.equals(tablero[fila][columna], ghostBad8)) { // Si es fantasma 8
                    piezaValida2 = true;
                } else { // Si no es ninguno de los fantasmas
                    System.out.println("\nLa pieza ingresada no es valida");
                }
            }

            if (piezaValida1) { // Si la pieza es valida
                System.out.println("Ingrese la fila a la que desea mover: ");
                int fila2 = leer.nextInt();
                System.out.println("Ingrese la columna a la que desea mover: ");
                int columna2 = leer.nextInt();
                if (Objects.equals(tablero[fila2][columna2], "[   ]")) { // Si la posición está vacía
                    tablero[fila2][columna2] = tablero[fila][columna]; // Mover pieza
                    tablero[fila][columna] = "[   ]"; // Vaciar posición
                    verify_win1(fila2, columna2); // Verificar si gano
                    turno++; // Aumentar turno
                } else if (Objects.equals(tablero[fila2][columna2], ghost5) || Objects.equals(tablero[fila2][columna2], ghost6) || Objects.equals(tablero[fila2][columna2], ghost7) || Objects.equals(tablero[fila2][columna2], ghost8)) {
                    System.out.println(obtenerPlayer1() + " le comió un fantasma bueno a " + obtenerPlayer2()); // Se comió un fantasma bueno del rival
                    tablero[fila2][columna2] = tablero[fila][columna]; // Mover pieza
                    tablero[fila][columna] = "[   ]"; // Vaciar posición
                    goodGhosts2--; // Disminuir cantidad de fantasmas buenos del jugador 2
                    contadorGhost2--; // Disminuir cantidad de fantasmas del jugador 2
                    turno++; // Aumentar turno
                    add_Reporte(obtenerPlayer1(), "Le comió un fantasma a " + obtenerPlayer2()); // Agregar reporte
                } else if (Objects.equals(tablero[fila2][columna2], ghostBad5) || Objects.equals(tablero[fila2][columna2], ghostBad6) || Objects.equals(tablero[fila2][columna2], ghostBad7) || Objects.equals(tablero[fila2][columna2], ghostBad8)) {
                    System.out.println(obtenerPlayer1() + " le comió un fantasma malo a " + obtenerPlayer2()); // Se comió un fantasma malo del rival
                    tablero[fila2][columna2] = tablero[fila][columna]; // Mover pieza
                    tablero[fila][columna] = "[   ]"; // Vaciar posición
                    badGhosts2--; // Disminuir cantidad de fantasmas malos del jugador 2
                    contadorGhost2--; // Disminuir cantidad de fantasmas del jugador 2
                    turno++; // Aumentar turno
                    add_Reporte(obtenerPlayer1(), "Le comió un fantasma malo a " + obtenerPlayer2()); // Agregar reporte
                } else { // Si está ocupada por un fantasma del mismo jugador
                    System.out.println("\nLa casilla esta ocupada, intente nuevamente."); // No se puede mover
                    turno--; // Disminuir turno
                }
                // verificar si un jugador ha salido del castillo
                verify_win1(fila2, columna2); // Verificar si gano
                verify_win2(fila2, columna2); // Verificar si gano

                // mostrar tablero
                mostrarTablero();

                piezaValida1 = false;
            } else if (piezaValida2) { // Si la pieza es valida
                System.out.println("Ingrese la fila a la que desea mover: ");
                int fila2 = leer.nextInt();
                System.out.println("Ingrese la columna a la que desea mover: ");
                int columna2 = leer.nextInt();
                if (Objects.equals(tablero[fila2][columna2], "[   ]")) { // Si la posición está vacía
                    tablero[fila2][columna2] = tablero[fila][columna]; // Mover pieza
                    tablero[fila][columna] = "[   ]"; // Vaciar posición
                    turno++; // Aumentar turno
                    verify_win2(fila2, columna2); // Verificar si gano
                } else if (Objects.equals(tablero[fila2][columna2], ghost1) || Objects.equals(tablero[fila2][columna2], ghost2) || Objects.equals(tablero[fila2][columna2], ghost3) || Objects.equals(tablero[fila2][columna2], ghost4)) {
                    System.out.println(obtenerPlayer2() + " le comió un fantasma a " + obtenerPlayer1()); // Se comió un fantasma del rival
                    tablero[fila2][columna2] = tablero[fila][columna]; // Mover pieza
                    tablero[fila][columna] = "[   ]"; // Vaciar posición
                    goodGhosts--; // Disminuir cantidad de fantasmas buenos del jugador 1
                    contadorGhost--; // Disminuir cantidad de fantasmas del jugador 1
                    turno++; // Aumentar turno
                    add_Reporte(obtenerPlayer2(), "Le comió un fantasma a " + obtenerPlayer1());
                } else if (Objects.equals(tablero[fila2][columna2], ghostBad1) || Objects.equals(tablero[fila2][columna2], ghostBad2) || Objects.equals(tablero[fila2][columna2], ghostBad3) || Objects.equals(tablero[fila2][columna2], ghostBad4)) {
                    System.out.println(obtenerPlayer2() + " le comió un fantasma malo " + obtenerPlayer1()); // Se comió un fantasma malo del rival
                    tablero[fila2][columna2] = tablero[fila][columna]; // Mover pieza
                    tablero[fila][columna] = "[   ]"; // Vaciar posición
                    badGhosts--; // Disminuir cantidad de fantasmas malos del jugador 1
                    contadorGhost--; // Disminuir cantidad de fantasmas del jugador 1
                    turno++; // Aumentar turno
                    add_Reporte(obtenerPlayer2(), "Le comió un fantasma malo a " + obtenerPlayer1()); // Agregar reporte
                } else { // Si está ocupada por un fantasma del mismo jugador
                    System.out.println("\nLa casilla esta ocupada, intente nuevamente.");
                    turno--; // Disminuir turno
                }
                piezaValida2 = false;

                // Mostrar tablero
                mostrarTablero();

                // ganar al comerse todos los fantasmas buenos o malos del rival en modo manual
                if (badGhosts == 0) { // Si el jugador 1 no tiene fantasmas malos
                    System.out.println("\n" + obtenerPlayer2() + " se ha comido todos los fantasmas malos del rival y ha ganado!");
                    add_Reporte(obtenerPlayer2(), " Ganó al comerse todos los fantasmas buenos del rival!");
                    add_puntos(obtenerPlayer2(), 100);
                    gameOver = true;
                } else if (goodGhosts == 0) { // Si el jugador 1 no tiene fantasmas buenos
                    System.out.println("\n" + obtenerPlayer2() + " se ha comido todos los fantasmas buenos del rival y ha ganado!");
                    add_Reporte(obtenerPlayer2(), " Ganó al comerse todos los fantasmas buenos del rival!");
                    add_puntos(obtenerPlayer2(), 100);
                    gameOver = true;
                }

                if (badGhosts2 == 0) { // Si el jugador 2 no tiene fantasmas malos
                    System.out.println("\n" + obtenerPlayer1() + " se ha comido todos los fantasmas malos del rival y ha ganado!");
                    add_Reporte(obtenerPlayer1(), " Ganó al comerse todos los fantasmas buenos del rival!");
                    add_puntos(obtenerPlayer1(), 100);
                    gameOver = true;
                } else if (goodGhosts2 == 0) { // Si el jugador 2 no tiene fantasmas buenos
                    System.out.println("\n" + obtenerPlayer1() + " se ha comido todos los fantasmas buenos del rival y ha ganado!");
                    add_Reporte(obtenerPlayer1(), " Ganó al comerse todos los fantasmas buenos del rival!");
                    add_puntos(obtenerPlayer1(), 100);
                    gameOver = true;
                }
            }

            if (contadorGhost == 0) { // Si el jugador 1 no tiene fantasmas
                System.out.println("\n" + obtenerPlayer1() + " se ha comido todos los fantasmas del rival y ha ganado!");
                add_Reporte(obtenerPlayer1(), " Ganó al comerse todos los fantasmas del rival!");
                add_puntos(obtenerPlayer1(), 100);
                gameOver = true;
            } else if (contadorGhost2 == 0) { // Si el jugador 2 no tiene fantasmas
                System.out.println("\n" + obtenerPlayer2() + " se ha comido todos los fantasmas del rival y ha ganado!");
                add_Reporte(obtenerPlayer2(), " Ganó al comerse todos los fantasmas del rival!");
                add_puntos(obtenerPlayer2(), 100);
                gameOver = true;
            }

            // ganar al comerse todos los fantasmas buenos o malos del rival en modo aleatorio
            if (contadorGhost == 0) { // Si el jugador 1 no tiene fantasmas malos
                System.out.println("\n" + obtenerPlayer2() + " se ha comido todos los fantasmas del rival y ha ganado!");
                add_Reporte(obtenerPlayer2(), " Ganó al comerse todos los fantasmas del rival!");
                add_puntos(obtenerPlayer2(), 100);
                gameOver = true;
            } else if (contadorGhost2 == 0) { // Si el jugador 2 no tiene fantasmas buenos
                System.out.println("\n" + obtenerPlayer1() + " se ha comido todos los fantasmas del rival y ha ganado!");
                add_Reporte(obtenerPlayer1(), " Ganó al comerse todos los fantasmas del rival!");
                add_puntos(obtenerPlayer1(), 100);
                gameOver = true;
            }
        } while (!gameOver);
    }
}