package ru.alx.graph;

import ru.alx.graph.search.GraphSearchAlgorithm;

import java.util.List;
import java.util.function.Function;

public interface Graph<V> {
    /**
     * Adds a vertex to the graph
     * @return false - if graph already contains vertex
     */
    boolean addVertex(V vertex);

    /**
     * Adds new edge between two vertices
     */
    void addEdge(V a, V b);
    void addEdge(V a, V b, double weight);

    /**
     * Performs the given action for each vertex in this graph
     * @param action user function that takes vertex object and returns boolean
     *                (if it returns false then process will stop)
     */
    void traverse(Function<V, Boolean> action);

    /**
     * Returns a list of edges between two vertices
     * @param source source vertex
     * @param goal vertex to build path to
     * @param searchAlg search algorithm implementation
     * @return list with edges or empty list if there is no path
     */
    List<Edge<V>> getPath(V source, V goal, GraphSearchAlgorithm<V> searchAlg);
}
