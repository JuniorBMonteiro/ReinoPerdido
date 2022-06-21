package br.com.bmont;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private char valor;
    private List<Vertice> adjacentes;
    private boolean isMarcado;

    public Vertice(char valor) {
        this.valor = valor;
        this.adjacentes = new ArrayList<>();
        this.isMarcado = false;
    }

    public boolean isMarcado() {
        return isMarcado;
    }

    public void setMarcado(boolean marcado) {
        this.isMarcado = marcado;
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
