package com.bonus;

/**
 * Edge class: an edge of graph
 */
public class Edge {
    private Node source;
    private Node destination;
    private int stroke;

    public Edge(Node source, Node destination, int stroke) {
        this.source = source;
        this.destination = destination;
        this.stroke = stroke;
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public int getStroke() {
        return stroke;
    }
}
