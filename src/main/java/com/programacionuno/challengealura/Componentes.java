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

    public void terminarPrograma() {
        int terminar = JOptionPane.showConfirmDialog(null, "¿Deseas finalizar el programa?", "Finalizar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (terminar == 0){
            JOptionPane.showMessageDialog(null, "Programa finalizado", "Finalizado", 0, check);
            System.exit(0);
        }
        else menu();
    }

    public void menu() {
        String titulo = "CONVERSOR ALURA CHALLENGE";
        String mensaje = "Selecciona una opcion";
        String[] opciones = {"Convertir Moneda", "Convertir temperatura", "Convertir medidas de longitud"}; //opciones

        String n = (String) JOptionPane.showInputDialog(null, mensaje,
                titulo, JOptionPane.QUESTION_MESSAGE, icon, opciones, opciones[0]);

        if (n == null) {
            terminarPrograma();
        } else {
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
    }

    public void mostarConversion(float valor, int titulo, String tMoneda, boolean opcion) {
        boolean validar = true;
        Moneda cambio = new Moneda();
        double resultado;
        float dinero;
        cambio.setValor(valor);
        cambio.setIsDivide(opcion);

        do {
            try {
                dinero = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite el monto", conversiones[titulo], 1));
                cambio.setDinero(dinero);
                resultado = cambio.getConversor();
                JOptionPane.showMessageDialog(null, "Tienes " + resultado + tMoneda, conversiones[titulo], 0, icon);
                validar = false;
                terminarPrograma();
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor debe ser un numero...", "Error", 0, error);
            }catch(NullPointerException e){
                int regresar = JOptionPane.showConfirmDialog(null, "¿Deseas regresar al submenu?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if(regresar == 0){
                    validar = false;
                    menuMonedas();
                }
            }
        } while (validar);
        
        terminarPrograma();
    }

    public void regresarMenuPrincipal() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres regresar al menu principal?", "Regresar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        if (opcion == 0) menu();
        else menuMonedas();
    }
    
    public void continuarPrograma(){
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea continuar con el programa?", "Continuar Programa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(opcion == 0) menu();
        else{
            JOptionPane.showMessageDialog(null, "Programa terminado", "Terminado", 0, check);
            System.exit(0);
        }
    }

    public void menuMonedas() {
        String titulo = "Conversion de Moneda";
        String mensaje = "Selecciona un tipo de conversion de moneda";

        String opciones = (String) JOptionPane.showInputDialog(null, mensaje, titulo,
                JOptionPane.QUESTION_MESSAGE, coin, conversiones, conversiones[0]);
        if (opciones == null) {
            regresarMenuPrincipal();
        } else {
            switch (opciones) {
                case "Quetzal a Dolar":
                    mostarConversion(0.1280f, 0, " dolares", true);
                    break;
                case "Quetzal a Euro":
                    mostarConversion(0.1204f, 1, " euros", false);
                    break;
                case "Quetzal a Libra":
                    mostarConversion(0.1063f, 2, " libras", false);
                    break;
                case "Quetzal a Yen":
                    mostarConversion(17.3798f, 3, " yenes", false);
                    break;
                case "Quetzal a Won Coreano":
                    mostarConversion(165.97f, 4, " wones", false);
                    break;
                case "Quetzal a Pesos Mexicanos":
                    mostarConversion(2.30f, 5, " pesos mexicanos", false);
                    break;
                case "Dolar a Quetzal":
                    mostarConversion(7.8147f, 6, " quetzales", false);
                    break;
                case "Euro a Quetzal":
                    mostarConversion(8.3191f, 7, " quetzales", false);
                    break;
                case "Libra a Quetzal":
                    mostarConversion(9.4060f, 8, " quetzales", false);
                    break;
                case "Yen a Quetzal":
                    mostarConversion(0.05753f, 9, " quetzales", false);
                    break;
                case "Won Coreano a Quetzal":
                    mostarConversion(0.006025f, 10, " quetzales", false);
                    break;
                case "Pesos mexicanos a Quetzal":
                    mostarConversion(0.4348f, 11, " quetzales", false);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", 2, error);
            }
        }
    }          
}
