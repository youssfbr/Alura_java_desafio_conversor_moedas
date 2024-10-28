package com.github.youssfbr.conversor.aplicacao;

import com.github.youssfbr.conversor.dtos.ExchangeRate;
import com.github.youssfbr.conversor.utils.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        int opcao = 0;
        List<String> exchange = new ArrayList<>();
        final Scanner sc = new Scanner(System.in);
        final Converter converter = new Converter();

        System.out.println("\nSeja bem-vindo ao Conversor de Moedas :)");

        while (opcao != 7) {

            System.out.println("""
                                        
                    Escolha uma opção válida:
                                                
                    1) Dólar => Peso argentino (ARS)
                    2) Peso argentino => Dólar
                    3) Dólar => Real brasileiro
                    4) Real brasileiro => Dólar \s
                    5) Dólar => Peso colombiano (COP)
                    6) Peso colombiano => Dólar\s
                    7) Sair  
                    """
            );

            opcao = sc.nextInt();

            if (opcao == 7) {
                exit();
                System.out.println("\nAplicação encerrada.");
                break;
            }

            try {
                exchange = switch (opcao) {
                    case 1 -> new ArrayList<>(Arrays.asList("USD" , "ARS"));
                    case 2 -> new ArrayList<>(Arrays.asList("ARS" , "USD"));
                    case 3 -> new ArrayList<>(Arrays.asList("USD" , "BRL"));
                    case 4 -> new ArrayList<>(Arrays.asList("BRL" , "USD"));
                    case 5 -> new ArrayList<>(Arrays.asList("USD" , "COP"));
                    case 6 -> new ArrayList<>(Arrays.asList("COP" , "USD"));
                    default -> throw new IllegalStateException("Opção " + opcao + " inválida");
                };
            } catch (Exception e) {
                System.out.println(e.getMessage());

                final boolean result = newCurrencyConversion();
                if (!result) break;
            }

            if (opcao >= 1 && opcao < 7) {

                try {
                    System.out.print("\nDigite o valor que deseja converter: ");
                    final double valor = sc.nextDouble();

                    final ExchangeRate converter1 = converter.exchangeConverter(exchange.getFirst() , exchange.get(1) , valor);

                    System.out.println("\nO valor de " + valor + " " + converter1);

                    System.out.println("\n**************************************************************");

                    final boolean b = newCurrencyConversion();
                    if (!b) break;
                } catch (Exception e) {
                    System.out.println("\nErro interno. Contate o suporte tecnico.");
                    break;
                }

            }
        }
        sc.close();
    }

    private static void exit() {
        System.out.println("\nObrigado por usar nosso sistema.");
    }

    private static boolean newCurrencyConversion() {

        final Scanner sc = new Scanner(System.in);

        System.out.print("\nDeseja fazer outra conversão? \nDigite qualquer tecla para continuar ou 'N' para sair! ");
        String next = sc.next();

        if (next.equalsIgnoreCase("n")) {
            exit();
            return false;
        }
        return true;
    }

}
