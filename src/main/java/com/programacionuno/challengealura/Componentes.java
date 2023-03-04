/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacionuno.challengealura;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Noriega
 */
public class Componentes {

    ImageIcon coin = new ImageIcon("src/images/coinsTwo.png"); //agregar imagen
    ImageIcon icon = new ImageIcon("src/images/coinsOne.png"); //agregar imagen
    ImageIcon error = new ImageIcon("src/images/error.png"); //agregar imagen
    ImageIcon temp = new ImageIcon("src/images/temperatura.png"); //agregar imagen
    ImageIcon medida = new ImageIcon("src/images/medida.png"); //agregar imagen
    ImageIcon check = new ImageIcon("src/images/check.png"); //agregar imagen
    String[] conversiones = {"Quetzal a Dolar", "Quetzal a Euro", "Quetzal a Libra", "Quetzal a Yen",
        "Quetzal a Won Coreano", "Quetzal a Pesos Mexicanos", "Dolar a Quetzal", "Euro a Quetzal",
        "Libra a Quetzal", "Yen a Quetzal", "Won Coreano a Quetzal", "Pesos Mexicanos a Quetzal"};

    public void menu() {
        String titulo = "CONVERSOR ALURA CHALLENGE";
        String mensaje = "Selecciona una opcion";
        String[] opciones = {"Convertir Moneda", "Convertir temperatura", "Convertir medidas de longitud"}; //opciones

        String n = (String) JOptionPane.showInputDialog(null, mensaje,
                titulo, JOptionPane.QUESTION_MESSAGE, icon, opciones, opciones[0]);

        switch (n) {
            case "Convertir Moneda":
                JOptionPane.showMessageDialog(null, "Elegiste convertir moneda", titulo, 1, coin);
                menuMonedas();
                break;
            case "Convertir temperatura":
                JOptionPane.showMessageDialog(null, "Elegiste convertir temperatura", titulo, 0, temp);
                break;
            case "Convertir medidas de longitud":
                JOptionPane.showMessageDialog(null, "Elegiste convertir medidas", titulo, JOptionPane.QUESTION_MESSAGE, medida);
                break;
            default:
                throw new AssertionError("Error al seleccionar una opcion");
        }
    }

    public void mostarConversion(double valor, int titulo, String tMoneda, boolean opcion) {
        Moneda cambio = new Moneda();
        double resultado, dinero;
        cambio.setValor(valor);
        cambio.setIsDivide(opcion);
        dinero = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el monto", conversiones[titulo], 1));
        cambio.setDinero(dinero);
        resultado = cambio.getConversor();
        JOptionPane.showMessageDialog(null, "Tienes " + resultado + tMoneda, conversiones[titulo], 0, icon);
    }

    public void menuMonedas() {
        String titulo = "Conversion de Moneda";
        String mensaje = "Selecciona un tipo de conversion de moneda";

        String opciones = (String) JOptionPane.showInputDialog(null, mensaje, titulo,
                JOptionPane.QUESTION_MESSAGE, coin, conversiones, conversiones[0]);
        System.out.println(opciones);

        switch (opciones) {
            case "Quetzal a Dolar":
                mostarConversion(0.1280, 0, " dolares", true);
                break;
            case "Quetzal a Euro":
                mostarConversion(0.1204, 1, " euros", false);
                break;
            case "Quetzal a Libra":
                mostarConversion(0.1063, 2, " libras", false);
                break;
            case "Quetzal a Yen":
                mostarConversion(17.3798, 3, " yenes", false);
                break;
            case "Quetzal a Won Coreano":
                mostarConversion(165.97, 4, " wones", false);
                break;
            case "Quetzal a Pesos Mexicanos":
                mostarConversion(2.30, 5, " pesos mexicanos", false);
                break;
            case "Dolar a Quetzal":
                mostarConversion(7.8147, 6, " quetzales", false);
                break;
            case "Euro a Quetzal":
                mostarConversion(8.3191, 7, " quetzales", false);
                break;
            case "Libra a Quetzal":
                mostarConversion(9.4060, 8, " quetzales", false);
                break;
            case "Yen a Quetzal":
                mostarConversion(0.05753, 9, " quetzales", false);
                break;
            case "Won Coreano a Quetzal":
                mostarConversion(0.006025,10, " quetzales", false);
                break;
            case "Pesos mexicanos a Quetzal":
                mostarConversion(0.4348,11, " quetzales", false);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", 2, error);
                throw new AssertionError("Error de opcion");
        }
    }
}
