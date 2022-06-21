package br.com.bmont;

public class App {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        In in = new In(grafo);
        in.leArquivo("src/main/resources/caso01.txt");
        CaminhamentoEmLargura caminhamentoEmLargura = new CaminhamentoEmLargura(grafo);
        Vertice v = grafo.getVertice('3');
        caminhamentoEmLargura.busca(v);
    }
}
