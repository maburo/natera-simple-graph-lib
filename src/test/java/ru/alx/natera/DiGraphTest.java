package ru.alx.natera;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.alx.graph.DiGraph;
import ru.alx.graph.Edge;
import ru.alx.graph.search.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class DiGraphTest {
    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void testDiGraph() {
        DiGraph<Integer> g = new DiGraph<>();

        ex.expect(IllegalStateException.class);
        ex.expectMessage("Graph doesn't contain vertices: [1, 2]");
        g.addEdge(1, 2);

        Assert.assertTrue(g.addVertex(1));
        Assert.assertFalse(g.addVertex(1));
        Assert.assertTrue(g.addVertex(2));
        Assert.assertFalse(g.addVertex(2));
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        g.addVertex(8);
        g.addVertex(9);
        g.addVertex(10);

        g.addEdge(1, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(3, 8);
        g.addEdge(8, 9);

        List<Edge<Integer>> path = g.getPath(1, 9, new DepthFirstSearch<>());
        ArrayList<Edge<Integer>> expected = new ArrayList<>();
        expected.add(new Edge<>(1, 3));
        expected.add(new Edge<>(3, 8));
        expected.add(new Edge<>(8, 9));

        List<Edge<Integer>> pathReverse = g.getPath(9, 1, new DepthFirstSearch<>());
        ArrayList<Edge<Integer>> expectedReverse = new ArrayList<>();
        expectedReverse.add(new Edge<>(9, 8));
        expectedReverse.add(new Edge<>(8, 3));
        expectedReverse.add(new Edge<>(3, 1));

        Assert.assertTrue(Util.checkEdgeListsEquality(expected, path));
        Assert.assertTrue(Util.checkEdgeListsEquality(expectedReverse, pathReverse));
        Assert.assertTrue(g.getPath(1, 10, new DepthFirstSearch<>()).isEmpty());
    }
}
