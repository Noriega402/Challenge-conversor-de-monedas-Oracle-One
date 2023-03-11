package com.programacionuno.challengealura;

/**
 *
 * @author Daniel Noriega
 */
public class Moneda extends Object{
    private float dinero;
    private float conversor;
    private float valor;
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
    
    public float getValor(){
        return this.valor;
    }
    
    public void setValor(float valor){
        this.valor = valor;
    }
    
    public float getDinero(){
        return this.dinero;
    }
    
    public void setDinero(float dinero){
        this.dinero = dinero;
    }
    
    public float getConversor(){
        if(divide) this.conversor = Math.round((this.dinero/this.valor) * 100d);
        else this.conversor = this.dinero*this.valor;
        
        return this.conversor;
    }
    
    public void setConversor(float conversor){
        this.conversor = conversor;
    }
}
