/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import javax.swing.JButton;

/**
 *
 * @author diemo
 */
public class Jugador {
    private String nombre;
    private int index;
    public JButton refButton;
    private int casillaActual = 1;
    private boolean activoTubo = false;
    private boolean esPerdedor = false;
    private boolean Carcel = false;
    private boolean CanMove = true;
    private int Timeinjail = 0;
    private int dado;
    
    public Jugador(String nombre, int index, JButton refButton) {
        this.nombre = nombre;
        this.index = index;
        this.refButton = refButton;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public JButton getRefButton() {
        return refButton;
    }

    public void setRefButton(JButton refButton) {
        this.refButton = refButton;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    public void setCasillaActual(int casillaActual) {
        this.casillaActual = casillaActual;
    }
    
    public void setActivoTubo(boolean tubo) {
        this.activoTubo = tubo;
    }
    
    public boolean getActivoTubo() {
        return this.activoTubo;
    }

    public boolean isEsGanador() {
        return esPerdedor;
    }

    public void setEsGanador(boolean esGanador) {
        this.esPerdedor = esGanador;
    }
    public boolean isCarcel() {
        return Carcel;
    }

    public void setCarcel(boolean Carcel) {
        this.Carcel = Carcel;
    }

    public boolean isCanMove() {
        return CanMove;
    }

    public void setCanMove(boolean CanMove) {
        this.CanMove = CanMove;
    }

    public int getTimeinjail() {
        return Timeinjail;
    }

    public void setTimeinjail(int Timeinjail) {
        this.Timeinjail = Timeinjail;
    }
    
    public void setTimeinjail(){
        this.Timeinjail++;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }
    
    
    public void avanzarCasillaActual(int avance) {
        this.casillaActual += avance;
        
        // para devolverse si no llegó al final exacto
        if (casillaActual > 27) {
            casillaActual = 28 - (casillaActual - 28);
            // esto hace que se devuelva las X casillas restantes del tiro de dado
        }
        
    }
}
