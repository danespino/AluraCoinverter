import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int printMenu = 1, convertMode, chosenOption;
        String keyPair, exitConfirmation;
        try (Scanner keyInput = new Scanner(System.in)) {
            while(printMenu != 0) {
                System.out.println("Bienvenido a AluraCoinverter\nMenu:\n1- Convertir Pares de Monedas\n0 - Salir");
                chosenOption = keyInput.nextInt();
                switch (chosenOption) {
                    case 1 -> {
                        convertMode = 1;
                        keyInput.nextLine();    // This fixes the missing line generating the error by consuming the char missing
                        while (convertMode == 1) {
                            System.out.println("Entre el par que desea convertir Ej:(USD/EUR)");
                            keyPair = keyInput.nextLine();
                            switch (keyPair) {
                                case "USD/EUR", "EUR/USD", "EUR/MXN", "USD/MXN" -> System.out.println("Conversion realizada.\n");
                                default -> System.out.println("Par ingresado no reconocido.\n");
                            }
                            System.out.println("Desea realizar otra conversión? Ingresa (no/n/N) para salir al menu principal, otra tecla para continuar.\n");
                            exitConfirmation = keyInput.nextLine().trim().toLowerCase();
                            if (exitConfirmation.equals("no") || exitConfirmation.equals("n")) {
                                convertMode = 0;
                            }
                        }
                    }
                    case 0 -> {
                        System.out.println("\nSaliendo del Programa. Gracias por utilizar AluraCoinverter");
                        printMenu = 0;
                    }
                    default -> System.out.println("Opción ingresada no válida\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
