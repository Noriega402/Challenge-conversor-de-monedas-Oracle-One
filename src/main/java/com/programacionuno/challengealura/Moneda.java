/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacionuno.challengealura;

/**
 *
 * @author Daniel Noriega
 */
public class Moneda extends Object{
    private double dinero;
    private double conversor;
    private double valor;
    private boolean divide;
    
    public Moneda(){
        this.dinero = 0.00;
        this.conversor = 0.00;
        this.valor = 0.00;
        this.divide = true;
    }
    
    public boolean getIsDivide(){
        return this.divide;
    }
    
    public void setIsDivide(boolean dividir){
        this.divide = dividir;
    }
    
    public double getValor(){
        return this.valor;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    
    public double getDinero(){
        return this.dinero;
    }
    
    public void setDinero(double dinero){
        this.dinero = dinero;
    }
    
    public double getConversor(){
        if(divide) this.conversor = this.dinero/this.valor;
        else this.conversor = this.dinero*this.valor;
        
        return this.conversor;
    }
    
    public void setConversor(double conversor){
        this.conversor = conversor;
    }
}
