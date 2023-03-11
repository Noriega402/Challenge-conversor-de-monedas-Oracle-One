package com.programacionuno.challengealura;

/**
 *
 * @author Daniel Noriega
 */
public class Temperatura {
    
    private double celcius;
    private double fahrenheit;
    private double kelvin;
    private double resultadoTemp;
    
    public Temperatura(){
        this.fahrenheit = 0;
        this.kelvin = 0;
        this.celcius = 0;
    }

    public double getCelcius() {
        return celcius;
    }

    public void setCelcius(double celcius) {
        this.celcius = celcius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double getKelvin() {
        return kelvin;
    }

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }

    public double getResultadoTemp() {
        return resultadoTemp;
    }

    public void setResultadoTemp(double resultadoTemp) {
        this.resultadoTemp = resultadoTemp;
    }
}

