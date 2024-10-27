package com.github.youssfbr.conversor.aplicacao;

import com.github.youssfbr.conversor.dtos.ExchangeRate;
import com.github.youssfbr.conversor.utils.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        final Converter converter = new Converter();

        System.out.println("\nSeja bem-vindo ao Conversor de Moedas :)");

        int opcao = 0;
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
                System.out.println("Aplicação encerrada.");
                break;
            }

            // TODO Se opção <1 && > 7
            // TODO ng.IllegalStateException

            List<String> exchange  = switch (opcao) {
                case 1 -> new ArrayList<>(Arrays.asList("USD", "ARS"));
                case 2 -> new ArrayList<>(Arrays.asList("ARS", "USD"));
                case 3 ->  new ArrayList<>(Arrays.asList("USD", "BRL"));                                                     //converter.getConverter(); //.dolarToReal("USD") ;
                case 4 -> new ArrayList<>(Arrays.asList("BRL", "USD"));
                case 5 -> new ArrayList<>(Arrays.asList("USD", "COP"));
                case 6 -> new ArrayList<>(Arrays.asList("COP", "USD"));
                default -> throw new IllegalStateException("Opção " + opcao + " inválida");
            };

            System.out.print("\nDigite o valor que deseja converter: ");
            final double valor = sc.nextDouble();

            final ExchangeRate converter1 = converter.exchangeConverter(exchange.getFirst() , exchange.get(1) , valor);

            System.out.println("\nO valor de " + valor + " " + converter1);

            System.out.println("\n**************************************************************");

            System.out.print("\nDeseja fazer outra conversão? \nDigite qualquer tecla para continuar ou 'N' para sair! ");
            String next = sc.next();

            if (next.equalsIgnoreCase("n")) {
                sair();
                break;
            }

        }
        sc.close();
    }

    private static void sair() {
        System.out.println("\nObrigado por usar nosso sistema.");
    }

}
