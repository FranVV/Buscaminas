/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminasgitghub;

import Clases.Tablero;

/**
 *
 * @author alumno
 */
public class BuscaminasGitGhub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tablero t = new Tablero(3, 3);
        t.insertarMinas(3);
        System.out.println(t.calcularNumeroMinasCasilla(0, 0));
        t.imprimirPrueba();
    }
    
}
