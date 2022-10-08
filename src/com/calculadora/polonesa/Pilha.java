package com.calculadora.polonesa;

public class Pilha<T> {

    private No topo; // topo do pilha
    private int contador; // numero de elementos na pilha

    public Pilha() {
        topo = null;
        contador = 0;
    }

    public boolean vazio() {
        return topo == null;
    }

    public void push(T valor) {
        // valor do topo da pilha
        topo = new No(valor, topo);
        contador++;
    }
    public T pop() {
        // se a pilha é vazia
        if (vazio()) {
            throw new IllegalArgumentException("Pilha vazia.");
            // se a pilha não é vazia
        } else {
            // pega o valor no topo da pilha
            T objeto = busca();
            topo = topo.proximo;
            contador--;
            return objeto;
        }
    }

    public T busca() {
        // se a pilha é vazia
        if (vazio()) {
            throw new IllegalArgumentException("Pilha vazia.");
            // se a pilha não é vazia
        } else {
            // retorna o valor no topo da pilha
            return topo.valor;
        }
    }


    public int tamanho() {
        return contador;
    }

    private class No {
        T valor; // valor do nó criado
        No proximo;

        No(T valor, No proximo) {
            this.valor = valor;
            this.proximo = proximo;
        }
    }
}
