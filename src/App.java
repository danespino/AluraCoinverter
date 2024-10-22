import com.danespi.aluracoinverter.AluraCoinverterClass;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int printMenu = 1, convertMode, chosenOption;
        double depositAmount, withdrawAmount;
        String keyPair, exitConfirmation, getWithdrawConf, userName = null;
        AluraCoinverterClass AccountOperation = new AluraCoinverterClass();

        try (Scanner keyInput = new Scanner(System.in)) {
            while(printMenu != 0) {
                if(userName == null) {
                    System.out.println("Bienvenido a AluraCoinverter. Identificate antes de continuar.\nIntroduce tu nombre:");
                    userName = keyInput.nextLine();
                }
                if(!userName.equals("")){ 
                    System.out.println("\n\nBienvenido al Sistema AluraCoinverter.\nAccediendo a tus datos "+ userName +"\nMenu:\n" +
                                                "1 - Realizar depósito\n" + //
                                                "2 - Consultar Balance\n" + //
                                                "3 - Realizar retiro\n" + //
                                                "4 - Convertir Pares de Monedas\n" +
                                                "0 - Salir");

                    chosenOption = keyInput.nextInt();
                    switch (chosenOption) {
                        case 1 -> {
                            convertMode = 1;
                            exitConfirmation = "";
                            while(convertMode == 1) {
                                System.out.println("Ingresa la cantidad a depositar:");
                                depositAmount = keyInput.nextDouble();
                                if(depositAmount > 0) {
                                    keyInput.nextLine();
                                    System.out.println("Estas seguro que deseas depositar $" + depositAmount + " ?");
                                    exitConfirmation = keyInput.nextLine().trim().toLowerCase();
                                    if (exitConfirmation.equals("yes") || exitConfirmation.equals("y")) {
                                        convertMode = 0;
                                        double totalBBalance = AccountOperation.getTotalBalance();
                                        double totalABalance = AccountOperation.depositAmount(depositAmount);
                                        System.out.println("Depósito realizado con éxito. Saldo de la Cuenta antes de la Operación: $ "+ totalBBalance +"\n Balance:$ "+ totalABalance);    
                                    }
                                } else {
                                    System.out.println("La cantidad a depositar debe ser mayor a 0\nIntentalo más tarde\n");
                                }
                            }
                        }
                        case 2 -> {
                            convertMode = 2;
                            exitConfirmation = "";
                            while(convertMode == 2) {
                                keyInput.nextLine();
                                double totalBalance = AccountOperation.getTotalBalance();
                                System.out.println("Tu saldo actual es: $" + totalBalance);
                                System.out.println("Desea realizar otra operación? Ingresa (no/n/N) para salir al menu principal, otra tecla para continuar.\n");
                                exitConfirmation = keyInput.nextLine().trim().toLowerCase();
                                if (exitConfirmation.equals("no") || exitConfirmation.equals("n")) {
                                    convertMode = 0;
                                }
                            }
                        }
                        case 3 -> {
                            convertMode = 3;
                            exitConfirmation = "";
                            while(convertMode == 3) {
                                keyInput.nextLine();
                                System.out.println("Ingresa la cantidad a retirar:");
                                withdrawAmount = keyInput.nextDouble();
                                double totalBalance = AccountOperation.getTotalBalance();
                                if(withdrawAmount > 0 && withdrawAmount <= totalBalance) {
                                    System.out.println("Comprobando fondos en cuenta bancaria... COMPROBADO\n\n");
                                    keyInput.nextLine();
                                    System.out.println("Estas seguro que deseas retirar $" + withdrawAmount + " ?\n");
                                    getWithdrawConf = keyInput.nextLine().trim().toLowerCase();
                                    if (getWithdrawConf.equals("yes") || getWithdrawConf.equals("y")) {
                                        AccountOperation.withdrawAmount(withdrawAmount);
                                        double finalBalance = AccountOperation.getTotalBalance();
                                        System.out.println("Retiro realizado con éxito por "+ withdrawAmount +". Saldo de la Cuenta antes de la Operación: $ "+ finalBalance +"\n");
                                    } else {
                                        System.out.println("Debes confirmar la operación antes de continuar\nIntentalo más tarde\n");
                                    }

                                    System.out.println("Desea realizar otra operación? Ingresa (no/n/N) para salir al menu principal, otra tecla para continuar.\n");
                                    exitConfirmation = keyInput.nextLine().trim().toLowerCase();
                                    if (exitConfirmation.equals("no") || exitConfirmation.equals("n")) {
                                        convertMode = 0;
                                    }
                                } else {
                                    System.out.println("La cantidad a retirar debe ser mayor a 0 y menor o igual al saldo de la cuenta\nIntentalo más tarde\n");
                                    convertMode = 0;
                                }
                            }
                        }
                        case 4 -> {
                            convertMode = 4;
                            exitConfirmation = "";
                            keyInput.nextLine();    // This fixes the missing line generating the error by consuming the char missing
                            while (convertMode == 4) {
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
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
