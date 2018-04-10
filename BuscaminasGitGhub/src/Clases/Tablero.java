/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Random;

/**
 *
 * @author alumno
 */
public class Tablero {

    private int numFilas;
    private int numColumnas;
    private int numMinas;
    private Casilla[][] mTabla;

    public Tablero(int numFilas, int numColumnas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = 0;
        this.mTabla = new Casilla[numFilas][numColumnas];
        for (int i = 0; i < mTabla.length; i++) {
            for (int j = 0; j < mTabla[i].length; j++) {
                mTabla[i][j]=new Casilla();
            }
        }
    }

    public Tablero(int numFilas, int numColumnas, int numMinas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;
        this.mTabla = new Casilla[numFilas][numColumnas];
    }

    public void insertarMinas(int minas) {
        Random f = new Random();
        int fila, col;
        while (minas > 0) {
            fila = f.nextInt(numFilas);
            col = f.nextInt(numColumnas);
            if (!mTabla[fila][col].isMina()) {
                mTabla[fila][col].setMina(true);
                minas--;
            }

        }
    }

    public void imprimirPrueba() {
        imprimirLineas();
        for (int i = 0; i < numFilas; i++) {
            System.out.print(i);

            for (int j = 0; j < numColumnas; j++) {
                if (mTabla[i][j].isMina()){
                    System.out.print(" M ");
                }else{
                    System.out.print(" . ");
                }
                
            }
            System.out.print(i);
            System.out.println("");
            ;
        }
        imprimirLineas();
    }

    public void imprimirLineas() {
        for (int i = 0; i < numFilas; i++) {
            if (i == 0) {
                System.out.print(" ");
            }
            System.out.print(" " + i + " ");
        }
        System.out.println(" ");
    }
    public Casilla getcasilla(int fila, int columna) {
        Casilla desCasilla = new Casilla();
        if(mTabla[fila][columna].isBlanca()){
            //mTabla[fila][columna]=new;
        }
        
        
        return desCasilla;
    }

    public int calcularNumeroMinasCasilla(int fila, int columna) {
        int n = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i>=0 && i<numFilas && j>=0 && j<numColumnas) {
                    if (mTabla[i][j].isMina()) {
                        n++;
                    }
                }

            }
        }
        return n;
    }

    @Override
    public String toString() {
        return "Tablero{" + "numFilas=" + getNumFilas() + ", numColumnas=" + getNumColumnas() + ", numMinas=" + getNumMinas() + ", mTabla=" + getmTabla() + '}';
    }

    /**
     * @return the numFilas
     */
    public int getNumFilas() {
        return numFilas;
    }

    /**
     * @param numFilas the numFilas to set
     */
    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

    /**
     * @return the numColumnas
     */
    public int getNumColumnas() {
        return numColumnas;
    }

    /**
     * @param numColumnas the numColumnas to set
     */
    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }

    /**
     * @return the numMinas
     */
    public int getNumMinas() {
        return numMinas;
    }

    /**
     * @param numMinas the numMinas to set
     */
    public void setNumMinas(int numMinas) {
        this.numMinas = numMinas;
    }

    /**
     * @return the mTabla
     */
    public Casilla[][] getmTabla() {
        return mTabla;
    }

    /**
     * @param mTabla the mTabla to set
     */
    public void setmTabla(Casilla[][] mTabla) {
        this.mTabla = mTabla;
    }

}
