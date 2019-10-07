package ru.alx.graph;

/**
 * Undirected graph
 * @param <V> vertex type
 */
public class UndirectedGraph<V> extends AbstractGraph<V> {
    @Override
    public void addEdge(V a, V b) {
        createEdge(a, b, 0);
        createEdge(b, a, 0);
    }

    @Override
    public void addEdge(V a, V b, double weight) {
        createEdge(a, b, weight);
        createEdge(b, a, weight);
    }
}
