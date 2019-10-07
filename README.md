# Simple graph library

## Usage:
### Unidirected graph
```java
UniGraph<Integer> g = new UniGraph<>();
g.addVertex(1);
g.addVertex(2);
g.addEdge(1, 2);
// with weight
g.addEdge(1, 2, 0.5);
```
### Directed graph
```java
DiGraph<Integer> g = new DiGraph<>();
```

### Traversing vertices
```java
DiGraph<Integer> g = new DiGraph<>();
...
g.traverse(v -> {
    System.out.println(v);
    return v == stop_vertex ? false : true; 
});
```

### Getting a path
```java
DiGraph<Integer> g = new DiGraph<>();
List<Edge<Integer>> edges = g.getPath(start_vertex, goal_vertex, search_algorithm);
```

### Available search algorithms
* `ru.alx.graph.search.BreadthFirstSearch`
* `ru.alx.graph.search.UniformCostSearch`
* `ru.alx.graph.search.DepthFirstSearch`