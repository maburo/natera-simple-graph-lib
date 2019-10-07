package ru.alx.graph.search;

import ru.alx.graph.Edge;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
 * Search algorithm
 * @param <V> user type for vertex
 */
public interface GraphSearchAlgorithm<V> {
    /**
     * Executes search on a graph. If there is no path between source and goal vertices or
     * there is no souch vertices then returns empty list.
     * @param source start position for search on the graph
     * @param goal end position
     * @param adjSupplier function that returns a list with adjacent edges for specific vertex
     * @return a list with edges from source to goal
     */
    List<Edge<V>> find(V source, V goal, Function<V, Collection<Edge<V>>> adjSupplier);
}
