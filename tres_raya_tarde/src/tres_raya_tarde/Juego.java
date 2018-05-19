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
 * @author Max
 * turnoJugador false->(jugador 2 'O'), true->(jugador 1 'X')
 */
public class Juego {

    BufferedReader br;

    private char[][] Tablero;
    private boolean turnoJugador = true;

    public Juego(BufferedReader _br) {
        br = _br;
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
        turnoJugador=!turnoJugador;   //cambio a jugador opuesto
    }

    public boolean escribirJugada(int posFila, int posCol) {
        boolean exito = true;
        if (Tablero[posFila][posCol] == ' ') {
            Tablero[posFila][posCol] = (turnoJugador == true)? 'X' : 'O';
        } else {
            exito = false;
            System.out.println("POSICION OCUPADA!!");
        }
        return exito;
    }
}
