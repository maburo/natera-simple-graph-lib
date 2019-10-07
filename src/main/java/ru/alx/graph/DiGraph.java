package ru.alx.graph;

/**
 * Directed graph
 * @param <V> vertex type
 */
public class DiGraph<V> extends AbstractGraph<V> {
    @Override
    public void addEdge(V a, V b) {
        createEdge(a, b, 0);
    }

    @Override
    public void addEdge(V a, V b, double weight) {
        createEdge(a, b, weight);
    }
}
