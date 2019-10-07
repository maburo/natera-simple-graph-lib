package ru.alx.natera;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.alx.graph.UndirectedGraph;
import ru.alx.graph.Edge;
import ru.alx.graph.search.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class UniGraphTest {

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void testUniGraph() {
        UndirectedGraph<String> g = new UndirectedGraph<>();

        Assert.assertTrue(g.addVertex("s"));
        Assert.assertFalse(g.addVertex("s"));
        Assert.assertTrue(g.addVertex("a"));
        Assert.assertFalse(g.addVertex("a"));
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("d");
        g.addVertex("e");
        g.addVertex("f");
        g.addVertex("h");
        g.addVertex("i");
        g.addVertex("g");

        g.addEdge("s", "a");
        g.addEdge("s", "a");
        g.addEdge("s", "b");
        g.addEdge("s", "b");
        g.addEdge("a", "c");
        g.addEdge("a", "d");
        g.addEdge("b", "e");
        g.addEdge("b", "f");
        g.addEdge("b", "h");
        g.addEdge("h", "g");

        List<Edge<String>> path = g.getPath("s", "g", new DepthFirstSearch<>());
        ArrayList<Edge<String>> expected = new ArrayList<>();
        expected.add(new Edge<>("s", "b"));
        expected.add(new Edge<>("b", "h"));
        expected.add(new Edge<>("h", "g"));

        List<Edge<String>> pathReverse = g.getPath("g", "s", new DepthFirstSearch<>());
        ArrayList<Edge<String>> expectedReverse = new ArrayList<>();
        expectedReverse.add(new Edge<>("g", "h"));
        expectedReverse.add(new Edge<>("h", "b"));
        expectedReverse.add(new Edge<>("b", "s"));

        Assert.assertTrue(Util.checkEdgeListsEquality(expected, path));
        Assert.assertTrue(Util.checkEdgeListsEquality(expectedReverse, pathReverse));
        Assert.assertTrue(g.getPath("s", "x", new DepthFirstSearch<>()).isEmpty());
    }

    @Test
    public void testEmptyGraph() {
        UndirectedGraph<Integer> g = new UndirectedGraph<>();
        List<Edge<Integer>> path = g.getPath(0, 1, new DepthFirstSearch<>());
        Assert.assertTrue(path.isEmpty());

        g.traverse(v -> true);
    }

    @Test
    public void testAddEdgeException() {
        ex.expect(IllegalStateException.class);
        ex.expectMessage("Graph doesn't contain vertices: [1, 2]");
        UndirectedGraph<Integer> g = new UndirectedGraph<>();
        g.addEdge(1, 2);
    }
}
