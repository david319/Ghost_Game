package Clases_Proyecto;

import java.util.Scanner;

import static Clases_Proyecto.Class_GhostGame.*;
import static Clases_Proyecto.Class_Player.*;

public class Class_Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Bienvenido al juego de Ghost");
        int menuI, menuP; //menu inicial y menu principal

        do { //Menu inicial
            System.out.print("""
                    Menu de Inicio
                    1. Login
                    2. Crear Player
                    3. Salir
                    Ingrese una opción:\t""");
            menuI = leer.nextInt();

            switch (menuI) { // Acciones del menu inicial
                case 1: //Login
                    System.out.println("Ingrese su nombre de usuario");
                    String user = leer.next();
                    System.out.println("Ingrese su contraseña");
                    String pass = leer.next();
                    verify_Player(user, pass); // Verifica si el usuario existe
                    if (verify_Player(user, pass)) { // Si el usuario existe
                        System.out.println("Bienvenido " + user);

                        do { //Menu principal
                            System.out.println("""
                                    Menu Principal
                                    1. Jugar Ghosts
                                    2. Configuración
                                    3. Reportes
                                    4. Mi Perfil
                                    5. Salir
                                    Ingrese una opción:\t""");
                            menuP = leer.nextInt();

                            switch (menuP) { // Acciones del menu principal
                                case 1: // Jugar
                                    setPlayer2();
                                    System.out.println("¡A jugar!");
                                    play_Game();
                                    break;

                                case 2: // Configuración
                                    int menuC; //Menu de configuración
                                    do { //Menu de configuración
                                        System.out.println("Configuraciones");
                                        System.out.println("""
                                                1. Dificultad
                                                2. Modo de juego
                                                3. Volver al menu principal
                                                Ingrese una opción:\t""");
                                        menuC = leer.nextInt();

                                        switch (menuC) { // Acciones del menu de configuración
                                            case 1: // Dificultad del juego
                                                System.out.println("""
                                                        Seleccione la dificultad
                                                        1. NORMAL – 8 fantasmas
                                                        2. EXPERT – 4 fantasmas
                                                        3. GENIUS – 2 fantasma
                                                        Ingrese una opción:\t""");
                                                int dificultad = leer.nextInt();
                                                Dificultad(dificultad); // Cambia la dificultad del juego
                                                break;

                                            case 2: // Modo de juego
                                                System.out.println("""
                                                        Seleccione el modo de juego
                                                        1. Aleatorio
                                                        2. Manual
                                                        Ingrese una opción:\t""");
                                                int modo = leer.nextInt();
                                                ModoG(modo); // Cambia el modo de juego
                                                break;

                                            case 3: // Volver al menu principal
                                                System.out.println("Volviendo al menu principal...");
                                                break;

                                        }
                                    } while (menuC != 3);
                                    break;
                                case 3:
                                    int menuR; //Menu de reportes
                                    do { //Menu de reportes
                                        System.out.println("""
                                                Reportes
                                                1. Reporte de los últimos 10 juegos
                                                2. Ranking de jugadores
                                                3. Volver al menu principal
                                                Ingrese una opción:\t""");
                                        menuR = leer.nextInt();

                                        switch (menuR) { // Acciones del menu de reportes
                                            case 1: // Reporte de los últimos 10 juegos
                                                System.out.println("Reporte de los últimos 10 juegos");
                                                reportes();
                                                break;
                                            case 2: // Ranking de jugadores
                                                System.out.println("Ranking de jugadores");
                                                Ranking();
                                                break;
                                            case 3: // Volver al menu principal
                                                System.out.println("Volviendo al menu principal...");
                                                break;
                                        }
                                    } while (menuR != 3);
                                    break;

                                case 4:
                                    int menuU; //Menu de usuarios
                                    do { //Menu de usuarios
                                        System.out.println("""
                                                Mi Perfil
                                                1. Ver mis datos
                                                2. cambiar Contraseña
                                                3. Eliminar mi cuenta
                                                4. Volver al menu principal
                                                Ingrese una opción:\t""");
                                        menuU = leer.nextInt();

                                        switch (menuU) { // Acciones del menu de usuarios
                                            case 1: // Ver mis datos
                                                Perfil();
                                                break;

                                            case 2: // Cambiar contraseña
                                                System.out.println("Ingrese su usuario:");
                                                String usuario = leer.next();
                                                System.out.println("Ingrese su contraseña:");
                                                String password = leer.next();
                                                cambiarC(usuario, password);
                                                break;

                                            case 3: // Eliminar mi cuenta
                                                System.out.println("Ingrese su usuario:");
                                                String usuario1 = leer.next();
                                                System.out.println("Ingrese su contraseña:");
                                                String password1 = leer.next();
                                                Delete_Player(usuario1, password1);
                                                break;

                                            case 4: // Volver al menu principal
                                                System.out.println("Volviendo al menu principal...");
                                                break;
                                        }
                                    } while (menuU != 4);
                                    break;

                                case 5:
                                    System.out.println("Cerrando sesión...");
                                    break;
                            }

                        } while (menuP != 5);

                    } else { // Si el usuario no existe, si la contraseña es incorrecta o si el usuario es incorrecto
                        System.out.println("Usuario o contraseña incorrectos");
                    }
                    break;

                case 2: // Registrarse
                    System.out.println("Ingrese el nombre de usuario:");
                    user = leer.next();
                    buscar_Player(user); // Busca si el usuario existe
                    Register_Player(user); // Si el usuario no existe, lo registra
                    break;

                case 3: // Salir
                    System.out.println("Gracias por Jugar...");
                    break;
            }

        } while (menuI != 3);
    }
}
