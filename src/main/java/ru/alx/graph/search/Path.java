package ru.alx.graph.search;

import ru.alx.graph.Edge;

import java.util.ArrayList;
import java.util.List;

/**
 * Temporary stores path during search
 * @param <V> user type for vertex
 */
class Path<V> {
    V vertex;
    List<Edge<V>> edges;
    double totalWeight;

    Path(V vertex, List<Edge<V>> edges, double totalWeight) {
        this.vertex = vertex;
        this.edges = edges;
        this.totalWeight = totalWeight;
    }

    Path<V> add(Edge<V> edge) {
        List<Edge<V>> list = new ArrayList<>(this.edges);
        list.add(edge);
        return new Path<V>(edge.getTarget(), list, totalWeight + edge.getWeight());
    }
}
