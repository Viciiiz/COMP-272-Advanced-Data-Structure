package Selection;
/*
 * Find kth largest element in a collection
 */
import java.util.ArrayList;
import java.util.List;

public  class  Selection  <E  extends  Comparable<E>>   {
    int k;
    ArrayList<E> input  ;  //  this  holds  the  values  of  type  E  from  which  your  code  will  find  kth  largest.
    int size;

    // constructor
    public Selection(){
        input = new ArrayList<>();
        k = 0;
        size = 0;
    }

    /**
     * generate and return random int from 0 to max
     */
    public int randomInt(int max){
        return (int) (Math.random() * max);
    }



    //  algorithm  1  methods    --  implement  1B
    public E algo1B(List<E> sorter, int size, int k){
        //ystem.out.println(sorter);
        long startTime = System.currentTimeMillis();
        long totalTime;
        ArrayList<E> temp = new ArrayList<>(sorter);
        this.size = temp.size();
        ArrayList<E> temp2 = new ArrayList<>();
        for(int x = 0; x < size; x++){
            E val = temp.get(x);
            temp2.add(val);
        }
        int max;
        for (int i = 0; i < size -1; i++) {
            max = i;
            for (int j = i + 1; j < size; j++) {
                if (temp2.get(max).compareTo(temp2.get(j)) > 0) {
                    max = j;
                }
            }
            if (max != i) {
                E element = temp2.get(max);
                temp2.set(max , temp2.get(i));
                temp2.set(i, element);}
        }
        totalTime = System.currentTimeMillis() - startTime;
        System.out.println("algo 1B: ");
        System.out.println("\t- Time: "+totalTime + " ms");
        System.out.println("\t- " + k + "th largest number: " + temp2.get(temp2.size()-k) + "\n");
        return temp2.get(temp2.size()-k);
    }

    //  algorithm 2  methods   --  6A --  change  the  algorithm  to  do  kth  largest not kth  smallest  that  is described  here
    public E algo6A (List <E> list, int k){
        long startTime = System.currentTimeMillis();
        long totalTime;
        MaxHeap<E> maxHeap = new MaxHeap<E>();
        maxHeap.buildHeap(list);
        E result = null;
        for(int i = 0; i < k; i++){
            result = maxHeap.removeHeap();
        }
        totalTime = System.currentTimeMillis() - startTime;
        System.out.println("algo 6A: ");
        System.out.println("\t- Time: "+totalTime + " ms");
        System.out.println("\t- " + k + "th largest number: " + result + "\n");
        return result;
    }

    //  algorithm  3  methods  –  6B
    public E algo6B (List <E> list, int k){
        long startTime = System.currentTimeMillis();
        long totalTime;
        MinHeap<E> minHeap = new MinHeap<E>(k);
        // adding the first k elements
        for(int i = 0; i < k; i++){
            minHeap.insert(list.get(i));
        }
        // comparing each element to the current min of the heap. If new element is greater, remove min element
        // of min heap (i.e. remove root), and insert new element in the minHeap
        for(int i = k; i < list.size(); i++){
            if(list.get(i).compareTo(minHeap.getRoot()) > 0) {
                // remove root
                minHeap.remove();
                // add new element
                minHeap.insert(list.get(i));
            }
        }
        E result = minHeap.remove();
        totalTime = System.currentTimeMillis() - startTime;
        System.out.println("algo 6B: ");
        System.out.println("\t- Time: "+totalTime + " ms");
        System.out.println("\t- " + k + "th largest number: " + result + "\n");
        return result;
    }


    public static void main(String[] args) {
        Selection<Integer> selection = new Selection<Integer>();
        Selection<Integer> selection_1B = new Selection<Integer>();
        int testSize = 10000000;
        int testSize_1B = 100000;
        int k = 1000000; // kth largest element
        int k_1B = 1000;

        // populate arrayLists
        for(int i = 0; i < testSize; i++){
            selection.input.add(selection.randomInt(testSize));
        }
        for(int i = 0; i < testSize_1B; i++){
            selection_1B.input.add(selection.randomInt(testSize_1B));
        }

        // algo 1B:
        System.out.print("For " + testSize_1B + " elements and k = " + k_1B + ", ");
        selection.algo1B(selection_1B.input, selection_1B.input.size(), k_1B);

        // algo 6A:
        System.out.print("For " + testSize + " elements and k = " + k + ", ");
        selection.algo6A(selection.input, k);

        // algo 6B:
        System.out.print("For " + testSize + " elements and k = " + k + ", ");
        selection.algo6B(selection.input, k);


    }
}