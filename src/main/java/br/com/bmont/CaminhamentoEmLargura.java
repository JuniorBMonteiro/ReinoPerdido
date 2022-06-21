package br.com.bmont;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CaminhamentoEmLargura {
    private String maiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String minusculas = "abcdefghijklmnopqrstuvwxyz";
    private Grafo grafo;
    ArrayList<Vertice> chaves = new ArrayList<Vertice>();
    ArrayList<Vertice> portas = new ArrayList<Vertice>();

    public CaminhamentoEmLargura(Grafo grafo) {
        this.grafo = grafo;
    }

    public void busca(Vertice inicial) {
        Queue<Vertice> fila = new LinkedList<>();
        inicial.setMarcado(true);
        fila.add(inicial);
        int i = 1;
        while (!fila.isEmpty()) {
            Vertice atual = fila.poll();
            for (Vertice vertice : atual.getAdjacentes()) {
                if (!vertice.isMarcado()){
                    if (isPorta(vertice) && !isPermitido(vertice)) {
                        portas.add(vertice);
                    }else if (isPorta(vertice) && isPermitido(vertice)){
                        portas.add(vertice);
                        vertice.setMarcado(true);
                        i++;
                        fila.add(vertice);
                    } else {
                        if (isChave(vertice)){
                            List<Vertice> v = hasPorta(vertice);
                            if (!v.isEmpty()){
                                fila.addAll(v);
                            }
                            chaves.add(vertice);
                        }
                        vertice.setMarcado(true);
                        i++;
                        fila.add(vertice);
                    }
                }
            }
        }
        System.out.println(i);
    }

    private boolean isChave(Vertice v) {
        return minusculas.contains(String.valueOf(v.getValor()));
    }

    private boolean isPorta(Vertice v) {
        return maiusculas.contains(String.valueOf(v.getValor()));
    }

    private boolean isPermitido(Vertice porta){
        for (Vertice v : chaves){
            if (v.getValor() == Character.toLowerCase(porta.getValor())){
                return true;
            }
        }
        return false;
    }

    private List<Vertice> hasPorta(Vertice chave){
        List<Vertice> vertices = new ArrayList<>();
        for (Vertice v : portas){
            if (v.getValor() == Character.toUpperCase(chave.getValor())){
                vertices.add(v);
            }
        }
        return vertices;
    }
}
