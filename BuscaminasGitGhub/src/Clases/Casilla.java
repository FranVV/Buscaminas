/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author alumno
 */
public class Casilla {
    private boolean mina;
    private boolean blanca;
    private boolean bandera;
    private boolean visible;
    private int numero;

    public Casilla() {
        mina= false;
        blanca=true;
        bandera=false;
        visible=false;
        numero=0;
    }

    public Casilla(boolean mina, boolean blanca, boolean bandera, boolean visible, int numero) {
        this.mina = mina;
        this.blanca = blanca;
        this.bandera = bandera;
        this.visible = visible;
        this.numero = numero;
    }

    
    @Override
    public String toString() {
        return "Casilla{" + "mina=" + isMina() + ", blanca=" + isBlanca() + ", bandera=" + isBandera() + ", visible=" + isVisible() + ", numero=" + getNumero() + '}';
    }

    /**
     * @return the mina
     */
    public boolean isMina() {
        return mina;
    }

    /**
     * @param mina the mina to set
     */
    public void setMina(boolean mina) {
        this.mina = mina;
    }

    /**
     * @return the blanca
     */
    public boolean isBlanca() {
        return blanca;
    }

    /**
     * @param blanca the blanca to set
     */
    public void setBlanca(boolean blanca) {
        this.blanca = blanca;
    }

    /**
     * @return the bandera
     */
    public boolean isBandera() {
        return bandera;
    }

    /**
     * @param bandera the bandera to set
     */
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
