package br.com.bmont;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class In {
    private int larguraCenario = 0;
    private Grafo grafo;

    public In(Grafo grafo) {
        this.grafo = grafo;
    }

    public void leArquivo(String filePath) {
        Path path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String line = null;
            int posicaoX = 0;
            int posicaoY = 0;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char valor = line.charAt(i);
                    Vertice vertice = new Vertice(valor);
                    grafo.addVertice(vertice);
                    grafo.addAdjacente(vertice, posicaoX, posicaoY, line.length());
                    posicaoX++;
                }
                posicaoX = 0;
                posicaoY++;
            }
        }catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
    }
}
