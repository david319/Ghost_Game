package Clases_Proyecto;

public class Player {

    // Atributos
    private final String Nombre;
    private String password;
    private int Puntos;

    // Constructor
    public Player(String name, String password) {
        this.Nombre = name;
        this.password = password;
        this.Puntos = 0;
    }

    // Setters
    public void setPassword(String password) {
        this.password = password;
    }

    public void setPuntos(int score) {
        this.Puntos = score;
    }

    // Getters
    public String getNombre() {
        return Nombre;
    }

    public String getPassword() {
        return password;
    }

    public int getPuntos() {
        return Puntos;
    }

    // Métodos
    public String toString() {
        return "Nombre: " + Nombre + "\n" + "Puntuación: " + Puntos;
    }
}
