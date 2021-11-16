package Dataset;

import java.io.*;
import java.util.*;


public class Helper {

    int largestComponent;
    final int NODES_COUNT_EMAIL = 50515;
    final int NODES_COUNT_GRAPH = 1000000;
    final int EDGES_COUNT = 819306;
    private MyLinkedList<Integer>[] adj; //Adjacency Lists
    public MyLinkedList<Integer> queue;
    public Graph graph;
    int connected_components;
    int treeCount = 0;

    // constructor
    public Helper(){
        largestComponent = 0;
        connected_components = 0;
        adj = new MyLinkedList[NODES_COUNT_EMAIL];
        for (int i=0; i<NODES_COUNT_EMAIL; i++)
            adj[i] = new MyLinkedList<Integer>();
        queue = new MyLinkedList<Integer>();
        graph = new Graph(NODES_COUNT_EMAIL);
    }

    /**
     * Read Email-Enron.txt file and populate MyLinkedList[] adj
     */
    public void readFile(){
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\adria\\IdeaProjects\\COMP 272\\Programs-3\\src\\Dataset\\Email-Enron.txt"));
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                String[] currentLineArray = currentLine.split("\t");
                //graph.addEdge(Integer.parseInt(currentLineArray[0]), Integer.parseInt(currentLineArray[1]));
                adj[Integer.parseInt(currentLineArray[0])].addLast(Integer.parseInt(currentLineArray[1]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read Email-Enron.txt file and populate Graph graph
     */
    public void readFileGraph(){
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\adria\\IdeaProjects\\COMP 272\\Programs-3\\src\\Dataset\\Email-Enron.txt"));
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                String[] currentLineArray = currentLine.split("\t");
                //graph.addEdge(Integer.parseInt(currentLineArray[0]), Integer.parseInt(currentLineArray[1]));
                graph.addEdge(Integer.parseInt(currentLineArray[0]), Integer.parseInt(currentLineArray[1]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    // first algorithm: Using Depth First traversal
    void DFSHelper(int vertex, boolean[] nodes)
    {
        nodes[vertex] = true;
        int a = 0;

        for (int i = 0; i < adj[vertex].size(); i++)
        {
            a = adj[vertex].get(i);
            if (!nodes[a])
            {
                DFSHelper(a, nodes);
                connected_components++;
            }
        }

    }

    void DFS(int v)
    {
        connected_components = 0;
        boolean[] marked = new boolean[NODES_COUNT_EMAIL];
        DFSHelper(v, marked);
        connected_components++;
    }

    // Reading  the  edge  list  on the fly  and  determining which  connected components
    // they  go to by using sets  and  union  operation.
    void algo2(int n, int nodeCount){
        boolean[] nodes = new boolean[nodeCount];
        int a = 0;
        connected_components = 0;

        nodes[n]=true;
        queue.addLast(n);
        connected_components++;

        while (queue.size() != 0)
        {
            n = queue.removeFirst();
            MyLinkedList<Integer> currentList = new MyLinkedList<>();
            currentList = currentList.union(adj[n]);
            for (int i = 0; i < currentList.size(); i++)
            {
                a = currentList.get(i);
                if (!nodes[a])
                {
                    nodes[a] = true;
                    queue.addLast(a);
                    connected_components++;
                }
            }
        }
    }

    // third algorithm: Using Breadth first traversal
    void BFS(int n, int nodeCount){
        boolean nodes[] = new boolean[nodeCount];
        int a = 0;
        connected_components = 0;
        nodes[n]=true;
        queue.addLast(n);
        connected_components++;
        largestComponent = adj[0].size;
        while (queue.size() != 0)
        {
            n = queue.removeFirst();

            for (int i = 0; i < adj[n].size(); i++)
            {
                if(adj[n].size > largestComponent) largestComponent = adj[n].size;
                a = adj[n].get(i);
                if (!nodes[a])
                {
                    nodes[a] = true;
                    queue.addLast(a);
                    connected_components++;
                }
            }
        }
    }

    /**
     * check number of trees
     */
    public int countTrees(int vertex){
        int count = 0;
        boolean visited[] = new boolean[graph.numVertex];
        for (int i = 0; i < graph.numVertex; i++)
            visited[i] = false;
        for(int i = 1; i < graph.numVertex; i++){
            if (graph.isTree(i, visited, i-1))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.readFile();

        System.out.println("In Email-Enron.txt: ");

        //algorithm 1: BFS
        helper.connected_components = 0;
        helper.BFS(0, helper.NODES_COUNT_EMAIL);
        System.out.println("\t- Number of connected components using BFS = "+helper.connected_components);

        //algorithm 2
        helper.connected_components = 0;
        helper.algo2(0, helper.NODES_COUNT_EMAIL);
        System.out.println("\t- Number of connected components using algorithm 2 = "+helper.connected_components);

        //algorithm 3: DFS
        helper.connected_components = 0;
        helper.DFS(0);
        System.out.println("\t- Number of connected components using DFS = "+helper.connected_components);

        // get the largest component size
        System.out.println("\t- Largest component size = " + helper.largestComponent);

        // get number of trees
        Helper helper1 = new Helper();
        helper1.readFileGraph();
        System.out.println("\t- Number of trees: " + helper1.countTrees(0));

    }

}
