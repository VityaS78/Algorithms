package lesson_7;

import java.util.LinkedList;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPaths(Graph g, int source) {
        if (source < 0) throw new IllegalArgumentException("Номер вершины не может быть щтрицательным");
        if (source >= g.vertexCount()) throw new IndexOutOfBoundsException();
        this.source = source;
        edgeTo = new int[g.vertexCount()];
        marked = new boolean[g.vertexCount()];
//        dfs(g, source);
        dfs(g);
    }

    private void dfs(Graph g) {
        LinkedList<int[]> stack = new LinkedList<>();
        LinkedList<int[]> temp = new LinkedList<>();
        int[] a = {0, source};
        stack.addFirst(a);
        int b;
        while (!stack.isEmpty()) {
            a = stack.removeFirst();
            b = a[1];
            if (!marked[b]) {
                marked[b] = true;
                edgeTo[b] = a[0];
                System.out.println(b + ":" + a[0]);
                for (int w : g.adjList(b)) {
                    int[] t = new int[2];
                    t[0] = b;
                    t[1] = w;
                    temp.addFirst(t);
                }
                while (!temp.isEmpty()) stack.addFirst(temp.removeFirst());
            }

        }
    }


    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adjList(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public boolean hasPathTo(int dist) {
        if (dist < 0) throw new IllegalArgumentException("Номер вершины не может быть щтрицательным");
        if (dist >= marked.length) throw new IndexOutOfBoundsException();
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) return null;
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
