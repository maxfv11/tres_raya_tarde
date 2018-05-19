/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tres_raya_tarde;

import java.util.Arrays;

/**
 *
 * @author Max
 */
public class Juego {

    private char[][] Tablero;
    private boolean turnoJugador1 = true;

    public Juego() {
    }

    public void NuevaPartida() {
        turnoJugador1 = true;
        Tablero = new char[3][3];
        //llenar tablero espacios
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                Tablero[f][c]='X';
            }
        }
    }
    public void DibujarTablero(){
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(Tablero[f][c]);
                if (c==2) {
                    System.out.println("");
                }
            }
        }
    }
}
