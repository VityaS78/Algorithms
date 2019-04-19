package lesson_7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 7);
        graph.addEdge(2, 9);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 0);
        graph.addEdge(3, 7);
        graph.addEdge(4, 0);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(6, 3);
        graph.addEdge(6, 8);
        graph.addEdge(7, 8);
        graph.addEdge(7, 9);
        graph.addEdge(8, 1);
        graph.addEdge(9, 3);
        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 1);
        System.out.println(bfp.hasPathTo(5));
        System.out.println(bfp.pathTo(5));
        System.out.println(bfp.distTo(5));

    }
}
