package br.com.bmont;

public class Bag {
    private Node first;
    private int size;

    private static class Node{
        private Vertice vertice;
        private Node next;
    }

    public Bag() {
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void add(Vertice vertice) {
        Node oldfirst = first;
        first = new Node();
        first.vertice = vertice;
        first.next = oldfirst;
        size++;
    }
}
