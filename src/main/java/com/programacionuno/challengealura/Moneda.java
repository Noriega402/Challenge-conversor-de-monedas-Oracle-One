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
        this.dinero = 0;
        this.conversor = 0;
        this.valor = 0;
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
    
    public void setConversor(float conversor){
        this.conversor = conversor;
    }
}
