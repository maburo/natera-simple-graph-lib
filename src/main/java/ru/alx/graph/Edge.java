package ru.alx.graph;

/**
 * Simple edge implementation
 * Weight parameter is optional, by default equals to 0
 * @param <V>
 */
public class Edge<V> {
    private final V source;
    private final V target;
    private final double weight;

    public Edge(V source, V target) {
        this.source = source;
        this.target = target;
        this.weight = 0;
    }

    public Edge(V source, V target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public V getSource() {
        return source;
    }

    public V getTarget() {
        return target;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " -> " + target + " (" + weight + ")";
    }
}