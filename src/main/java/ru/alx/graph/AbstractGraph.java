package ru.alx.graph;

import ru.alx.graph.search.GraphSearchAlgorithm;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;

abstract class AbstractGraph<V> implements Graph<V> {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<V, List<Edge<V>>> vertices = new HashMap<>();

    @Override
    public boolean addVertex(V vertex) {
        lock.writeLock().lock();

        try {
            if (vertices.containsKey(vertex)) {
                return false;
            }

            vertices.put(vertex, new ArrayList<>());
            return true;
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * creates edge between two vertices
     * @throws IllegalStateException if graph doesn't contains any of them
     */
    void createEdge(V a, V b, double weight) {
        lock.writeLock().lock();

        try {
            boolean hasA = vertices.containsKey(a);
            boolean hasB = vertices.containsKey(b);
            if (!hasA || !hasB) {
                StringJoiner sj = new StringJoiner(", ", "Graph doesn't contain vertices: [", "]");
                if (!hasA) sj.add(a.toString());
                if (!hasB) sj.add(b.toString());
                throw new IllegalStateException(sj.toString());
            }

            vertices.get(a).add(new Edge<>(a, b, weight));
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void traverse(Function<V, Boolean> action) {
        lock.readLock().lock();

        try {
            for (V v : vertices.keySet()) {
                if (!action.apply(v)) break;
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Edge<V>> getPath(V source, V goal, GraphSearchAlgorithm<V> searchAlg) {
        lock.readLock().lock();

        try {
            if (!vertices.containsKey(source) || !vertices.containsKey(goal)) {
                return Collections.emptyList();
            }

            return searchAlg.find(source, goal, v -> vertices.getOrDefault(v, Collections.emptyList()));
        } finally {
            lock.readLock().unlock();
        }
    }
}
