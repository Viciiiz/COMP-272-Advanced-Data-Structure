package Dataset;

import java.util.*;
public class Graph {

    int numVertex;
    int numEdge;
    ArrayList<ArrayList<Integer>> graph;

    public Graph () {
        numVertex =0;
        numEdge =0;
        graph = new ArrayList<>();
    }

    public Graph(int vertexCount) {
        numVertex=vertexCount;
        numEdge=0;
        graph = new ArrayList<>(numVertex);
        for (int i=0;i<numVertex;i++)
            graph.add(new ArrayList<>());
    }



    public ArrayList<Integer> getNeighbors(int u) {
        return graph.get(u);
    }

    public boolean edgePresent(int u, int v) {
        return (graph.get(u).contains(v));
    }

    public void addEdge(int u, int v) {
        // let's assume that the vertices are already created.
        if (u>=0 && u<numVertex && v>=0 && v<numVertex) {
            if (!edgePresent(u,v))
                graph.get(u).add(v);

            if (!edgePresent(v,u))
                graph.get(v).add(u);
            numEdge++;
        }
        else throw new IndexOutOfBoundsException();
    }

    // check if current subgraph is a tree
    boolean isTree(int v, boolean visited[], int parent)
    {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = graph.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                if (isTree(i, visited, v))
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }


}