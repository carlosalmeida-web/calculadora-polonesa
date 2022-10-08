package com.calculadora.polonesa;

import java.util.Scanner;
import java.util.EnumMap;

public class RPN {

    private enum Operador {
        SOMAR, SUBTRAIR, MULTIPLICAR, DIVIDIR
    }
    private double resultado;
    private Pilha<Double> pilhaOperando; // pilha que vai guardar os operandos
    private Scanner scanExpressao;
    private EnumMap<Operador, Character> operadorMap;

    public RPN(String expressao) {
        criaEnumMap();
        pilhaOperando = new Pilha<>();
        scanExpressao = new Scanner(expressao);
        // captura o resultado da expressao
        resultado = avalia();
    }

    public double getResultado() {
        return resultado;
    }


    //inicializa o enummap
    private void criaEnumMap() {
        operadorMap = new EnumMap<>(Operador.class);
        operadorMap.put(Operador.SOMAR, '+');
        operadorMap.put(Operador.SUBTRAIR, '-');
        operadorMap.put(Operador.MULTIPLICAR, '*');
        operadorMap.put(Operador.DIVIDIR, '/');
    }

    //avalia a expressao
    private double avalia() {
        while (scanExpressao.hasNext()) {
            populaPilhaOperandok();
            if (pilhaOperando.tamanho() == 1 && scanExpressao.hasNext()) {
                throw new IllegalArgumentException("Muitos operadores!");
                // se a pilha tiver no minino dois operados ela vai ser avaliada
            } else if (pilhaOperando.tamanho() >= 2) {
                // avalia o calculo
                executaCalculo(pilhaOperando.pop(), pilhaOperando.pop(),
                        scanExpressao.next().charAt(0));
            }
        }
        scanExpressao.close();
        if (pilhaOperando.tamanho() > 1) {
            throw new IllegalArgumentException("Poucos operadores!");
        }
        // o valor restando na pilha é a resposta para a expressao
        return pilhaOperando.pop();
    }


    //popula a pilha com os operados, que serão todos do tipo double.
    private void populaPilhaOperandok() {
        while (scanExpressao.hasNextDouble()) {
            pilhaOperando.push(scanExpressao.nextDouble());
        }
    }
    private void executaCalculo(double direita, double esquerda,
                                    char operador) {
        if (operador == operadorMap.get(Operador.SOMAR)) {
            pilhaOperando.push(esquerda + direita);
        } else if (operador == operadorMap.get(Operador.SUBTRAIR)) {
            pilhaOperando.push(esquerda - direita);
        } else if (operador == operadorMap.get(Operador.MULTIPLICAR)) {
            pilhaOperando.push(esquerda * direita);
        } else if (operador == operadorMap.get(Operador.DIVIDIR)) {
            pilhaOperando.push(esquerda / direita);
        } else {
            throw new IllegalArgumentException("Operador inválido: " +
                    operador);
        }
    }
}
