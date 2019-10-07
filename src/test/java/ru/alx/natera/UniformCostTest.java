package ru.alx.natera;

import org.junit.Assert;
import org.junit.Test;
import ru.alx.graph.Edge;
import ru.alx.graph.UndirectedGraph;
import ru.alx.graph.search.UniformCostSearch;

import java.util.ArrayList;
import java.util.List;

public class UniformCostTest {

    @Test
    public void test() {
        UndirectedGraph<String> g = new UndirectedGraph<>();
        g.addVertex("s");
        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("d");
        g.addVertex("g");

        g.addEdge("s", "a", 1);
        g.addEdge("a", "b", 2);
        g.addEdge("b", "g", 3);

        g.addEdge("s", "c", 1);
        g.addEdge("c", "d", 2);
        g.addEdge("d", "g", 2);

        g.addEdge("s", "g", 10);


        List<Edge<String>> path = g.getPath("s", "g", new UniformCostSearch<>());

        List<Edge<String>> expected = new ArrayList<>();
        expected.add(new Edge<>("s", "c", 1));
        expected.add(new Edge<>("c", "d", 2));
        expected.add(new Edge<>("d", "g", 2));
        Assert.assertTrue(Util.checkEdgeListsEquality(expected, path));
    }
}
