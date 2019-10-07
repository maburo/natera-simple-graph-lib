package ru.alx.graph.search;

import ru.alx.graph.Edge;

import java.util.*;
import java.util.function.Function;

/**
 * Depth first search implementation
 */
public class DepthFirstSearch<V> implements GraphSearchAlgorithm<V> {

    public List<Edge<V>> find(V source, V goal, Function<V, Collection<Edge<V>>> adjSupplier) {
        Set<V> visited = new HashSet<>();
        Deque<Path<V>> queue = new ArrayDeque<>();
        queue.add(new Path<V>(source, Collections.emptyList(), 0));

        while (!queue.isEmpty()) {
            Path<V> path = queue.pop();

            if (!visited.add(path.vertex)) {
                continue;
            }

            if (path.vertex == goal) {
                return path.edges;
            }

            for (Edge<V> edge : adjSupplier.apply(path.vertex)) {
                Path<V> newPath = path.add(edge);
                queue.push(newPath);
            }
        }

        return Collections.emptyList();
    }
}
