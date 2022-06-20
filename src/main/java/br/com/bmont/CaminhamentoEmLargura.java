package br.com.bmont;

import java.util.ArrayList;
import java.util.List;

public class CaminhamentoEmLargura {
    private String maiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String minusculas = "abcdefghijklmnopqrstuvwxyz";
    private Grafo grafo;
    private ArrayList<Vertice> marcados = new ArrayList<Vertice>();
    ArrayList<Vertice> chaves = new ArrayList<Vertice>();
    ArrayList<Vertice> portas = new ArrayList<Vertice>();

    public CaminhamentoEmLargura(Grafo grafo) {
        this.grafo = grafo;
    }

    public void busca(Vertice inicial) {
        ArrayList<Vertice> fila = new ArrayList<Vertice>();
        Vertice atual = inicial;
        marcados.add(atual);
        fila.add(atual);
        while (fila.size() > 0) {
            Vertice visitado = fila.get(0);

            for (int i = 0; i < visitado.getAdjacentes().size(); i++) {
                Vertice proximo = visitado.getAdjacentes().get(i);
                if (!marcados.contains(proximo)){
                    if (isPorta(proximo) && !isPermitido(proximo)) {
                        portas.add(proximo);
                    }else if (isPorta(proximo) && isPermitido(proximo)){
                        portas.add(proximo);
                        marcados.add(proximo);
                        fila.add(proximo);
                    } else {
                        if (isChave(proximo)){
                            List<Vertice> v = hasPorta(proximo);
                            if (!v.isEmpty()){
                                fila.addAll(v);
                            }
                            chaves.add(proximo);
                        }
                        marcados.add(proximo);
                        fila.add(proximo);
                    }
                }
            }
            fila.remove(0);
        }
        System.out.println(marcados.size());
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
