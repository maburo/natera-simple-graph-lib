package ru.alx.graph.search;

import ru.alx.graph.Edge;

import java.util.*;
import java.util.function.Function;

public class UniformCostSearch<V> implements GraphSearchAlgorithm<V> {

    public List<Edge<V>> find(V source, V goal, Function<V, Collection<Edge<V>>> adjSupplier) {
        Set<V> visited = new HashSet<>();
        Queue<Path<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.totalWeight));
        queue.add(new Path<V>(source, Collections.emptyList(), 0));

        while (!queue.isEmpty()) {
            Path<V> path = queue.poll();

            if (!visited.add(path.vertex)) {
                continue;
            }

            if (path.vertex == goal) {
                return path.edges;
            }

            for (Edge<V> edge : adjSupplier.apply(path.vertex)) {
                Path<V> newPath = path.add(edge);
                queue.add(newPath);
            }
        }

        return Collections.emptyList();
    }
}
