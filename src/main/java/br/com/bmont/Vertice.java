package br.com.bmont;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private int posicaoX;
    private int posicaoY;
    private char valor;
    private List<Vertice> adjacentes;

    public Vertice(int posicaoX, int posicaoY, char valor) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.valor = valor;
        this.adjacentes = new ArrayList<>();
    }

    public int getPosicaoX() {
        return posicaoX;
    }
    public int getPosicaoY() {
        return posicaoY;
    }

    public char getValor() {
        return valor;
    }

    public void addAdjacente(Vertice adjacente) {
        this.adjacentes.add(adjacente);
    }

    public List<Vertice> getAdjacentes() {
        return adjacentes;
    }
}
