/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tres_raya_tarde;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Max
 */
public class Tres_raya_tarde {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;

        Juego j1 = new Juego();
        j1.NuevaPartida();
        j1.DibujarTablero();
        while (salir != true) {
            
        }

    }

}
