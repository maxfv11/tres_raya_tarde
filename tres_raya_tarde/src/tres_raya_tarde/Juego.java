/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tres_raya_tarde;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Max turnoJugador false->(jugador 2 'O'), true->(jugador 1 'X')
 */
public class Juego {

    BufferedReader br;

    private char[][] Tablero;
    private boolean turnoJugador = true;
    private boolean partidaFinalizada = false;

    public Juego(BufferedReader _br) {
        br = _br;
    }

    public char getFichaJugador() {
        return (turnoJugador == true) ? 'X' : 'O';
    }

    public void NuevaPartida() {
        turnoJugador = true;
        Tablero = new char[3][3];
        //llenar tablero espacios
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                Tablero[f][c] = ' ';
            }
        }
    }

    public void DibujarTablero() {
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(Tablero[f][c]);
                if (c == 2) {
                    System.out.println("");
                }
            }
        }
    }

    public void PedirJugada() throws IOException {
        if (turnoJugador == true) {
            System.out.println("Jugador 1 (X)");
        } else {
            System.out.println("Jugador 2 (O)");
        }

        System.out.println("En qué fila quieres la ficha?");
        String cadena = br.readLine();
        int posFila = Integer.parseInt(cadena);
        posFila--;
        System.out.println("En qué columna quieres la ficha?");
        String cadena2 = br.readLine();
        int posCol = Integer.parseInt(cadena2);
        posCol--;

        boolean jugadaConExito = escribirJugada(posFila, posCol);
        while (jugadaConExito == false) {
            System.out.println("En qué fila quieres la ficha?");
            cadena = br.readLine();
            posFila = Integer.parseInt(cadena);
            posFila--;
            System.out.println("En qué columna quieres la ficha?");
            cadena2 = br.readLine();
            posCol = Integer.parseInt(cadena2);
            posCol--;

            jugadaConExito = escribirJugada(posFila, posCol);
        }

    }

    public void cambioTurno() {
        turnoJugador = !turnoJugador;   //cambio a jugador opuesto
    }

    public boolean escribirJugada(int posFila, int posCol) {
        boolean exito = true;
        if (posFila >= 0 && posCol >= 0 && posFila <= 2 && posCol <= 2) {
            if (Tablero[posFila][posCol] == ' ') {
                Tablero[posFila][posCol] = (turnoJugador == true) ? 'X' : 'O';
            } else {
                exito = false;
                System.out.println("POSICION OCUPADA!!");
            }
        } else {
            exito = false;
            System.out.println("POSICION ESCRITA FUERA DE RANGO");
        }

        return exito;
    }

    public boolean esVictoria() {
        char fichaJugador = getFichaJugador();
        int contadorFicha = 0;
        boolean victoria = false;
        //victoria per files
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                if (Tablero[f][c] == fichaJugador) {
                    contadorFicha++;
                }
            }
            if (contadorFicha == 3) {
                victoria = true;
            }
            contadorFicha = 0;
        }

        //victoria per columnes
        for (int c = 0; c < 3; c++) {
            for (int f = 0; f < 3; f++) {
                if (Tablero[f][c] == fichaJugador) {
                    contadorFicha++;
                }
            }
            if (contadorFicha == 3) {
                victoria = true;
            }
            contadorFicha = 0;
        }
        //victoria diagonal
        if (Tablero[0][0] == fichaJugador && Tablero[1][1] == fichaJugador && Tablero[2][2] == fichaJugador) {
            victoria = true;
        }
        if (Tablero[0][2] == fichaJugador && Tablero[1][1] == fichaJugador && Tablero[2][0] == fichaJugador) {
            victoria = true;
        }
        return victoria;
    }

    public boolean tableroLleno() {
        boolean estaLleno = true;
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                if (Tablero[f][c] == ' ') {
                    estaLleno = false;
                }
            }
        }
        return estaLleno;
    }

    public int getJugadorActual() {
        int jugador;
        if (turnoJugador) {
            jugador = 1;
        } else {
            jugador = 2;
        }
        return jugador;
    }
}
