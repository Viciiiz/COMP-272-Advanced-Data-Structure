package WeightedEdge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Helper {

    ArrayList<WeightedEdge> weightedEdges;
    ArrayList<WeightedEdge> MST;
    double sumWeights;
    int numberOfNodes = 50515;
    int sum;

    public Helper(){
        weightedEdges = new ArrayList<>();
        MST = new ArrayList<>();
        sumWeights = 0;
        sum = 0;
    }

    /**
     * read files to populate graph
     */
    public void readFile(){
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\adria\\IdeaProjects\\COMP 272\\Programs-3\\src\\WeightedEdge\\artist_edges.txt"));
            Scanner scanner2 = new Scanner(new File("C:\\Users\\adria\\IdeaProjects\\COMP 272\\Programs-3\\src\\WeightedEdge\\Weights.txt"));

            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                String[] currentLineArray = currentLine.split("\t");
                String currentWeight = null;
                currentWeight = scanner2.nextLine();
                assert currentWeight != null;
                weightedEdges.add(new WeightedEdge(Integer.parseInt(currentLineArray[0]), Integer.parseInt(currentLineArray[1]), Double.parseDouble(currentWeight)));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<WeightedEdge> Kruskal(ArrayList<WeightedEdge> G){
        // sort
        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>(weightedEdges);
        ArrayList<WeightedEdge> sortedWeight = new ArrayList<>();
        for(int i = 0; i < pq.size(); i++){
            WeightedEdge current = pq.poll();
            sortedWeight.add(new WeightedEdge(current.v1, current.v2, current.weight));
        }
        int curr = 0;
        while (MST.size() < numberOfNodes-1){
            WeightedEdge e = sortedWeight.get(curr);
            e.v1 = find3(sortedWeight, e.v1);
            e.v2 = find3(sortedWeight, e.v2);
            if(e.v1 != e.v2){
                merge3(sortedWeight, e.v1, e.v2);
                MST.add(new WeightedEdge(e.v1, e.v2, e.weight));
            }
        }
        return MST;
    }

    public void kruskalDriver(){
        ArrayList<WeightedEdge> arr = Kruskal(weightedEdges);
        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>(weightedEdges);
        ArrayList<WeightedEdge> sortedWeight = new ArrayList<>();
        for(int i = 0; i < pq.size(); i++){
            WeightedEdge current = pq.poll();
            sortedWeight.add(new WeightedEdge(current.v1, current.v2, current.weight));
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int currentIndex = 0;
        for(int i = 0; i < sortedWeight.size(); i++){
            int min = (int) sortedWeight.get(i).weight;
            if(sortedWeight.get(i).v1 == currentIndex){
                if(sortedWeight.get(i).weight < min) min = (int) sortedWeight.get(i).weight;
            } else {
                temp.add(min);
                currentIndex++;
            }
        }
        for(int i: temp) sum += i;

    }

    public int find3(ArrayList<WeightedEdge> arr, int x){
        double r = x;
        double i, j;
       // while(arr.get((int)r).getWeight()!=r) r = arr.get((int)r).getWeight();
        i = x;
        while (i!=r) {
            j = arr.get((int)i).getWeight();
            arr.get((int)i).weight = r;
            i = j;
        }
        return (int) r;
    }

    public void merge3(ArrayList<WeightedEdge> arr, int a, int b){
        if(arr.get(a).v1 == arr.get(b).v1) {
            arr.get(a).v1 = arr.get(a).v1 + 1;
            arr.get(b).weight = a;
        } else {
            if (arr.get(a).v1 > arr.get(b).v1) {
                arr.get(b).weight = a;
            } else {
                arr.get(a).weight = b;
            }
        }
    }

    public long weightSum(ArrayList<WeightedEdge> arr){
        long sum = 0;
        for (int i = 0; i < arr.size(); i++){
            sum+= arr.get(i).getWeight();
        }
        return sum;
    }

    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.readFile();

        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>(helper.weightedEdges);
        System.out.println(pq.poll());

        System.out.println(helper.weightSum(helper.Kruskal(helper.weightedEdges)));
        helper.kruskalDriver();
        System.out.println("Sum of the weights of the MST equal to: " + helper.sum);
    }

}
