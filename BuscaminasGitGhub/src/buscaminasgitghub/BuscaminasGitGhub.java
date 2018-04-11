/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminasgitghub;

import Clases.Juego;
import Clases.Tablero;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class BuscaminasGitGhub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.configurarJuego();
        juego.iniciarJuego();
        juego.juegar();
        
    }
    
}
