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

    public Juego( int numMinas, int numFilas, int numColumnas) {
        this.tablero = new Tablero(numFilas, numColumnas, numMinas);
        this.numMinas = numMinas;
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
    }

    
    public  void configurarJuego() {
      Scanner leer = new Scanner(System.in);
        System.out.println("Dime el numero de Minas");
        numMinas = leer.nextInt();
        System.out.println("Dime el numero de Filas");
        numFilas = leer.nextInt();
        System.out.println("Dime el numero de Columnas");
        numColumnas = leer.nextInt();
    }
    public  void iniciarJuego() {
      tablero= new Tablero(numFilas, numColumnas);
      tablero.insertarMinas(numMinas);
    }
    public  void juegar() {
      Scanner leer = new Scanner(System.in);
        int f,c;
        boolean bandera= true;
        mostrarTablero();
        while (bandera) {  
            switch(elegirOpcion()){
                case 1://Descubrir
                    System.out.println("Dime la Fila");
                    f=leer.nextInt();
                    System.out.println("Dime la Columna");
                    c=leer.nextInt();
                 break;
                 case 2://Poner bandera
                     System.out.println("Dime la Fila");
                    f=leer.nextInt();
                    System.out.println("Dime la Columna");
                    c=leer.nextInt();
                 break;
                 case 3://Quitar bandera
                     System.out.println("Dime la Fila");
                    f=leer.nextInt();
                    System.out.println("Dime la Columna");
                    c=leer.nextInt();
                 break;
                 case 4://Salir
                     System.out.println("Has salido del programa");
                     bandera= false;
                 break;
            }
        }
        
    }
    private  void mostrarTablero() {
     tablero.imprimirPrueba();
    }
    private boolean cordenadasCorectas(int fila, int columna) {
        if(fila<0 && fila>numFilas && columna<0 && columna>numColumnas && tablero.getCasilla(fila, columna)){
        return false;
        }
     return true;
    }
     private int elegirOpcion() {
        int menu=0;
        if(menu>=0&&menu<5){
            Scanner leer = new Scanner(System.in);
            System.out.println("***************************");
            System.out.println("Elija el tipo de operacion");
            System.out.println("1-Descubrir");
            System.out.println("2-Poner Bandera");
            System.out.println("3-Quitar Bandera");
            System.out.println("4-Salir");
            System.out.println("***************************");
            menu=leer.nextInt();
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
