package com.calculadora.polonesa;

import java.util.Scanner;

public class CalculadoraPolonesa {

    public static void main(String[] args) {
        apresentacao();
        getExpressao();
    }

    public static void apresentacao() {
        System.out.println("\nCalculadora Polonesa!\n\n" + "Entre com os operandos seguido pelos operadores ");
    }

    public static void getExpressao() {
        String expressao;
        boolean expressaoValida;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("calculo: ");
            expressao = sc.nextLine();
            expressaoValida = !expressao.equals("");
            if (expressaoValida) {
                calculaExpressao(expressao);
            }
        } while (expressaoValida);
        sc.close();
    }

    public static void calculaExpressao(String expressao) {
        RPN calcular = new RPN(expressao);
        System.out.println(calcular.getResultado());
    }

}
