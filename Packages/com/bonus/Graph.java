package com.bonus;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph class
 */
public class Graph {
    List<Node> nodes;
    List<Edge> edges;

    public Graph(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addNode(int x, int y, int stroke) {
        this.nodes.add(new Node(x, y, stroke));
    }

    public void addEdge(Node source, Node destination, int stroke) {
        this.edges.add(new Edge(source, destination, stroke));
    }

    public void deleteNode(Node node) {
        this.nodes.remove(node);
        List<Edge> edgesToRemove = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource() == node || edge.getDestination() == node) {
                edgesToRemove.add(edge);
            }
        }
        edges.removeAll(edgesToRemove);
    }
}
