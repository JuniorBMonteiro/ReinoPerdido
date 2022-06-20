package br.com.bmont;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private int arestasSize;
    private List<Vertice> vertices;

    public Grafo() {
        this.arestasSize = 0;
        this.vertices = new ArrayList<>();
    }

    public void addVertice(Vertice vertice) {
        this.vertices.add(vertice);
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void addAdjacente(Vertice v, int larguraCenario) {
        if (isParede(v)){
            return;
        }
        int posicao = (v.getPosicaoY() - 1) * larguraCenario + v.getPosicaoX() - 1;

        if (v.getPosicaoY() != 1) {
            Vertice superior = vertices.get(posicao - larguraCenario);
            if (!isParede(superior)) {
                v.addAdjacente(superior);
                superior.addAdjacente(v);
                arestasSize += 2;
            }
        }

        if (v.getPosicaoX() != 1) {
            Vertice esquerda = vertices.get(posicao - 1);
            if (!isParede(esquerda)) {
                v.addAdjacente(esquerda);
                esquerda.addAdjacente(v);
                arestasSize += 2;
            }
        }
    }

    private boolean isParede(Vertice v) {
        return v.getValor() == '#';
    }

    public Vertice getVertice(char valor) {
        return vertices.stream()
                .filter(e -> e.getValor() == valor)
                .findFirst()
                .orElse(null);
    }
}
