package com.programacionuno.challengealura;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Daniel Noriega
 */
public class Menus {

    Iconos icon = new Iconos();

    String[] conversiones = {"Quetzal a Dolar", "Quetzal a Euro", "Quetzal a Libra", "Quetzal a Yen",
        "Quetzal a Won Coreano", "Quetzal a Pesos Mexicanos", "Dolar a Quetzal", "Euro a Quetzal",
        "Libra a Quetzal", "Yen a Quetzal", "Won Coreano a Quetzal", "Pesos Mexicanos a Quetzal"};

    String[] conversionTemp = {"Kelvin a Celcius", "Kelvin a Fahrenheit", "Fahrenheit a Celcius",
        "Fahrenheit a Kelvin", "Celcius a Kelvin", "Celcius a Fahrenheit"};

    String[] conversionMedida = {"mts a mm", "mts a cm", "mts a km",
        "mts a plg", "cm a mm", "cm a mts", "cm a km", "cm a plg",
        "km a mm", "km a cm", "km a mts", "km a plg"
    };

    public void terminarPrograma() {
        int terminar = JOptionPane.showConfirmDialog(null, "¿Deseas finalizar el programa?", "Finalizar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (terminar == 0) {
            JOptionPane.showMessageDialog(null, "Programa finalizado", "Finalizado", 0, icon.check);
            System.exit(0);
        } else {
            menu();
        }
    }

    public void regresarMenuPrincipal(int tipoMenu) {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres regresar al menu principal?", "Regresar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon.icon);
        if (opcion == 0) {
            menu();
        }

        if (tipoMenu == 0) {
            menuMonedas();
        }
        if (tipoMenu == 1) {
            menuTemperatura();
        }
    }

    public void continuarPrograma() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea continuar con el programa?", "Continuar Programa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == 0) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null, "Programa terminado", "Terminado", 0, icon.check);
            System.exit(0);
        }
    }

    public void menu() {
        String titulo = "CONVERSOR ALURA CHALLENGE";
        String mensaje = "Selecciona una opcion";
        String[] opciones = {"Convertir Moneda", "Convertir temperatura", "Convertir medidas de longitud"}; //opciones

        String n = (String) JOptionPane.showInputDialog(null, mensaje,
                titulo, JOptionPane.QUESTION_MESSAGE, icon.icon, opciones, opciones[0]);

        if (n == null) {
            terminarPrograma();
        } else {
            switch (n) {
                case "Convertir Moneda":
                    JOptionPane.showMessageDialog(null, "Elegiste convertir moneda", titulo, 1, icon.coin);
                    menuMonedas();
                    break;
                case "Convertir temperatura":
                    JOptionPane.showMessageDialog(null, "Elegiste convertir temperatura", titulo, 0, icon.temp);
                    menuTemperatura();
                    break;
                case "Convertir medidas de longitud":
                    JOptionPane.showMessageDialog(null, "Elegiste convertir medidas", titulo, JOptionPane.QUESTION_MESSAGE, icon.medida);
                    menuMedidas();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ocurrio un error en el programa", "Error", 0, icon.error);
            }
        }
    }

    public void cambioTemperatura(int index, String title) {
        boolean validar = true;

        do {
            try {
                int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el monto", conversionTemp[index], 1));
                conversionTemp(index, valor, title);
                validar = false;
            } catch (NullPointerException e) {
                int regresar = JOptionPane.showConfirmDialog(null, "¿Deseas regresar al submenu?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (regresar == 0) {
                    validar = false;
                    menuTemperatura();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El valor debe ser un numero...", "Error", 0, icon.error);
            }
        } while (validar);

        terminarPrograma();
    }

    public void conversionTemp(int index, double valor, String title) {
        Temperatura temp = new Temperatura();
        double process;

        switch (index) {
            case 0:
                temp.setKelvin(valor);
                process = temp.getKelvin() - 273.15;
                temp.setResultadoTemp(process);
                JOptionPane.showMessageDialog(null, "La temperatura es de " + temp.getResultadoTemp() + " Celcius", title, 0, icon.temp);
                break;
            case 1:
                temp.setKelvin(valor);
                process = ((temp.getKelvin() * 9) / 5) - 459.67;
                temp.setResultadoTemp(process);
                JOptionPane.showMessageDialog(null, "La temperatura es de " + temp.getResultadoTemp() + " Fahrenheit", title, 0, icon.temp);
                break;
            case 2:
                temp.setFahrenheit(valor);
                process = ((temp.getFahrenheit() - 32) * 5) / 9;
                temp.setResultadoTemp(process);
                JOptionPane.showMessageDialog(null, "La temperatura es de " + temp.getResultadoTemp() + " Celcius", title, 0, icon.temp);
                break;
            case 3:
                temp.setFahrenheit(valor);
                process = ((5 * (temp.getFahrenheit() - 32)) / 9) + 273.15;
                temp.setResultadoTemp(process);
                JOptionPane.showMessageDialog(null, "La temperatura es de " + temp.getResultadoTemp() + " Kelvin", title, 0, icon.temp);
                break;
            case 4:
                temp.setCelcius(valor);
                process = temp.getCelcius() + 273.15;
                temp.setResultadoTemp(process);
                JOptionPane.showMessageDialog(null, "La temperatura es de " + temp.getResultadoTemp() + " Kelvin", title, 0, icon.temp);
                break;
            case 5:
                temp.setCelcius(valor);
                process = ((9 * temp.getCelcius()) / 5) + 32;
                temp.setResultadoTemp(process);
                JOptionPane.showMessageDialog(null, "La temperatura es de " + temp.getResultadoTemp() + " Fahrenheit", title, 0, icon.temp);
                break;
            default:
                throw new AssertionError();
        }
    }

    public void menuTemperatura() {
        String titulo = "Conversion de Temperatura";
        String mensaje = "Selecciona un tipo de conversion de temperatura";

        String opciones = (String) JOptionPane.showInputDialog(null, mensaje, titulo, 0, icon.temp,
                conversionTemp, conversionTemp[0]);
        if (opciones == null) {
            regresarMenuPrincipal(1);
        } else {
            switch (opciones) {
                case "Kelvin a Celcius":
                    cambioTemperatura(0, titulo);
                    break;
                case "Kelvin a Fahrenheit":
                    cambioTemperatura(1, titulo);
                    break;
                case "Fahrenheit a Celcius":
                    cambioTemperatura(2, titulo);
                    break;
                case "Fahrenheit a Kelvin":
                    cambioTemperatura(3, titulo);
                    break;
                case "Celcius a Kelvin":
                    cambioTemperatura(4, titulo);
                    break;
                case "Celcius a Fahrenheit":
                    cambioTemperatura(5, titulo);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", 0, icon.error);
            }
        }
    }

    public void mostarConversion(double valor, int titulo, String tMoneda, boolean opcion) {
        boolean validar = true;
        Moneda cambio = new Moneda();
        double resultado, dinero;
        cambio.setValor(valor);
        cambio.setIsDivide(opcion);

        do {
            try {
                dinero = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el monto", conversiones[titulo], 1));
                cambio.setDinero(dinero);
                resultado = cambio.getConversor();
                JOptionPane.showMessageDialog(null, "Tienes " + resultado + tMoneda, conversiones[titulo], 0, icon.icon);
                validar = false;
                terminarPrograma();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El valor debe ser un numero...", "Error", 0, icon.error);
            } catch (NullPointerException e) {
                int regresar = JOptionPane.showConfirmDialog(null, "¿Deseas regresar al submenu?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (regresar == 0) {
                    validar = false;
                    menuMonedas();
                }
            }
        } while (validar);

        terminarPrograma();
    }

    public void menuMonedas() {
        String titulo = "Conversion de Moneda";
        String mensaje = "Selecciona un tipo de conversion de moneda";

        String opciones = (String) JOptionPane.showInputDialog(null, mensaje, titulo,
                JOptionPane.QUESTION_MESSAGE, icon.coin, conversiones, conversiones[0]);
        if (opciones == null) {
            regresarMenuPrincipal(0);
        } else {
            switch (opciones) {
                case "Quetzal a Dolar":
                    mostarConversion(0.1280, 0, " dolares", false);
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
                    mostarConversion(169.551, 4, " wones", false);
                    break;
                case "Quetzal a Pesos Mexicanos":
                    mostarConversion(2.372, 5, " pesos mexicanos", false);
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
                    mostarConversion(0.006025, 10, " quetzales", false);
                    break;
                case "Pesos Mexicanos a Quetzal":
                    mostarConversion(0.4348, 11, " quetzales", false);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", 2, icon.error);
            }
        }
    }

    public void convertirLongitud(int index, boolean dividir, double conversion, String valor) {
        Longitudes longitud = new Longitudes();
        double medida, resultado;
        boolean validar = true;
        longitud.setDivisible(dividir);
        do {
            try {
                medida = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite la medida", conversionMedida[index], 1));
                longitud.setMedida(medida);
                longitud.setResultadoMedida(longitud.getMedida(), conversion);
                resultado = longitud.getResultadoMedida();
                JOptionPane.showMessageDialog(null, "Son " + resultado + valor, conversionMedida[index], 0, icon.icon);
                validar = false;
                terminarPrograma();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El valor debe ser un numero...", "Error", 0, icon.error);
            } catch (NullPointerException e) {
                int regresar = JOptionPane.showConfirmDialog(null, "¿Deseas regresar al submenu?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (regresar == 0) {
                    validar = false;
                    menuMedidas();
                }
            }
        } while (validar);
        
        terminarPrograma();
    }

    public void menuMedidas() {
        String titulo = "Conversion de Longitud";
        String mensaje = "Selecciona un tipo de conversion de medida de longitud";
        String opciones = (String) JOptionPane.showInputDialog(null, mensaje, titulo,
                JOptionPane.QUESTION_MESSAGE, icon.coin, conversionMedida, conversionMedida[0]);
        if (opciones == null) {
            regresarMenuPrincipal(0);
        } else {
            System.out.println(opciones);
            switch (opciones) {
                case "mts a mm":
                    convertirLongitud(0, false, 1000, " milimetros");
                    break;
                case "mts a cm":
                    convertirLongitud(1, false, 100, " centimetros");
                    break;
                case "mts a km":
                    convertirLongitud(2, true, 1000, " kilometros");
                    break;
                case "mts a plg":
                    convertirLongitud(3, false, 39.37, " pulgadas");
                    break;
                case "cm a mm":
                    convertirLongitud(4, false, 10, " milimetros");
                    break;
                case "cm a mts":
                    convertirLongitud(5, true, 0.01, " metros");
                    break;
                case "cm a km":
                    convertirLongitud(6, true, 100000, " kilomemtros");
                    break;
                case "cm a plg":
                    convertirLongitud(7, true, 0.3937, " pulgadas");
                    break;
                case "km a mm":
                    convertirLongitud(8, false, 1000000, " milimetros");
                    break;
                case "km a cm":
                    convertirLongitud(9, false, 100000, " centimetros");
                    break;
                case "km a mts":
                    convertirLongitud(10, false, 1000, " metros");
                    break;
                case "km a plg":
                    convertirLongitud(11, false, 39370.08, " pulgadas");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ocurrio un error de opcion", "Error", 0, icon.error);
            }
        }
    }
}
