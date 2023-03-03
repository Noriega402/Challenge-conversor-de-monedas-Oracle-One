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

    public void menu() {
        String titulo = "CONVERSOR ALURA CHALLENGE";
        String mensaje = "Selecciona una opcion";
        String[] opciones = {"Convertir Moneda", "Convertir temperatura", "Convertir medidas de longitud"}; //opciones

        String n = (String) JOptionPane.showInputDialog(null, mensaje,
                titulo, JOptionPane.QUESTION_MESSAGE, icon, opciones, opciones[0]);

        switch (n) {
            case "Convertir Moneda":
                JOptionPane.showMessageDialog(null, "Elegiste convertir moneda", titulo, 1, coin);
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

    public void menuMonedas() {
        String titulo = "Conversion de Moneda";
        String mensaje = "Selecciona un tipo de conversion de moneda";
        String[] conversiones = {"Quetzal a Dolar", "Quetzal a Euro", "Quetzal a Libra", "Quetzal a Yen",
            "Quetzal a Won Coreano", "Quetzal a Pesos Mexicanos", "Dolar a Quetzal", "Euro a Quetzal",
            "Libra a Quetzal", "Yen a Quetzal", "Won Coreano a Quetzal", "Pesos Mexicanos a Quetzal"};

        String opciones = (String) JOptionPane.showInputDialog(null, mensaje, titulo,
                JOptionPane.QUESTION_MESSAGE, coin, conversiones, conversiones[0]);
        switch (opciones) {
            case "":
                
                break;
            default:
                throw new AssertionError("Error de opcion...");
        }
    }
}
