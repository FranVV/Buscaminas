/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Juego {

    private Tablero tablero;
    private int numMinas;
    private int numFilas;
    private int numColumnas;

    public Juego() {
        this.tablero = new Tablero(numFilas, numColumnas, numMinas);
        this.numMinas = 0;
        this.numFilas = 0;
        this.numColumnas = 0;
    }

    public Juego(int numMinas, int numFilas, int numColumnas) {
        this.tablero = new Tablero(numFilas, numColumnas, numMinas);
        this.numMinas = numMinas;
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
    }

    public void configurarJuego() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Dime el numero de Minas");
        numMinas = leer.nextInt();
        System.out.println("Dime el numero de Filas");
        numFilas = leer.nextInt();
        System.out.println("Dime el numero de Columnas");
        numColumnas = leer.nextInt();
    }

    public void iniciarJuego() {
        tablero = new Tablero(numFilas, numColumnas);
        tablero.insertarMinas(numMinas);
        tablero.calcularTablero();
    }

    public void juegar() {
        Scanner leer = new Scanner(System.in);
        int f, c;
        boolean bandera = true;
        tablero.imprimirSolucion();
        mostrarTablero();
        while (bandera) {
            System.out.println("Dime la Fila");
            f = leer.nextInt();
            System.out.println("Dime la Columna");
            c = leer.nextInt();
            switch (elegirOpcion()) {
                case 1://Descubrir
                    
                    if(cordenadasCorectas(f, c) && descubrirCasilla(f, c)){
                        descubrirBanco(f, c);
                        mostrarTablero();
                    }
                    
                    break;
                case 2://Poner bandera
                    if(cordenadasCorectas(f, c)){
                       ponerBandera(f, c);
                       mostrarTablero();
                       bandera = !partidaGanada();
                    }
                    break;
                case 3://Quitar bandera
                    tablero.getCasilla(f, c).setVisible(false);
                     if(cordenadasCorectas(f, c)){
                       quitarBandera(f, c);
                       mostrarTablero();
                       bandera = !partidaGanada();
                    }
                    break;
                case 4://Salir
                    System.out.println("Has salido del programa");
                    bandera = false;
                    break;
            }
            
        }

    }

    private void mostrarTablero() {
        tablero.imprimirPrueba();
    }

    private boolean cordenadasCorectas(int fila, int columna) {
        if (fila >= 0 && fila < numFilas && columna >= 0 && columna < numColumnas && !tablero.getCasilla(fila, columna).isVisible()) {
            return true;
        }else{
            return false;
        }
        
    }

    private void acabarJuegoMina() {
        System.out.println("Juego Finalizado has pisado una mina");
        tablero.imprimirSolucion();
    }

    private boolean descubrirCasilla(int fila, int columna) {
        if (!tablero.getCasilla(fila, columna).isMina()) {
            tablero.getCasilla(fila, columna).setVisible(true);
            return true;
        } else {
            acabarJuegoMina();
            return false;
        }
    }
    
    private boolean ponerBandera(int fila, int columna) {
        if (!tablero.getCasilla(fila, columna).isBandera()) {
            tablero.getCasilla(fila, columna).setVisible(true);
            tablero.getCasilla(fila, columna).setBandera(true);
            return true;
        } 
            return false;
        
    }
    private boolean quitarBandera(int fila, int columna) {
        if (tablero.getCasilla(fila, columna).isBandera()) {
            tablero.getCasilla(fila, columna).setBandera(false);
            return true;
        } 
            return false;
        
    }

   
    private void descubrirBanco(int fila, int columna) {
        for (int i = fila-1; i <=fila+1; i++) {
            for (int j = columna-1; j <=columna+1; j++) {
                if (cordenadasCorectas(i, j)&& tablero.getCasilla(fila,columna).isBlanca()&&tablero.getCasilla(i,j).isBlanca()) {
                    tablero.getCasilla(i, j).setVisible(true);
                    descubrirBanco(i, j);
                }
            }
        }
        
    }
//repasar
    private boolean partidaGanada() {
        int contador = 0;
        
         for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                if (!(tablero.getCasilla(i, j).isBandera() == tablero.getCasilla(i, j).isMina())) {
                    return false;
                }
            }
        }
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                if (tablero.getCasilla(i, j).isMina() &&  tablero.getCasilla(i, j).isBandera()) {
                    contador++;
                }
            }
        }
        
        if(contador==numMinas){
            return true;
        }else{
            return false;
        }
        

    }

    private int elegirOpcion() {
        int menu = 0;
        if (menu >= 0 && menu < 5) {
            Scanner leer = new Scanner(System.in);
            System.out.println("***************************");
            System.out.println("Elija el tipo de operacion");
            System.out.println("1-Descubrir");
            System.out.println("2-Poner Bandera");
            System.out.println("3-Quitar Bandera");
            System.out.println("4-Salir");
            System.out.println("***************************");
            menu = leer.nextInt();
        }
        return menu;
    }

    @Override
    public String toString() {
        return "Juego{" + "tablero=" + getTablero() + ", numMinas=" + getNumMinas() + ", numFilas=" + getNumFilas() + ", numColumnas=" + getNumColumnas() + '}';
    }

    /**
     * @return the tablero
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * @param tablero the tablero to set
     */
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
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

}
