package Selection;


import java.util.*;
public class MaxHeap<E extends Comparable<E>> extends ArrayList<E>   {

    ArrayList<E> arrayList;
    // construct an empty Heap using ArrayList
    // with root at index 0.
    // don't use binary tree for implementing the heap.
    public MaxHeap(){
        arrayList = new ArrayList<>();
    }
    // returns max value
    public E findMax() {
        if(arrayList.size()==0) return null;
        return arrayList.get(0);
    }

    // adds a new value to the heap at the end of the Heap and
    // adjusts values up to the root to ensure Max heap property is satisfied.
    // parent of node at i is given by the formula (i-1)/2
    // throw appropriate exception
    public void addHeap(E val) {
        try {
            if (arrayList.size() == 0){
                arrayList.add(val);
                return;
            }
            arrayList.add(val);
            int currentIndex = arrayList.size()-1;
            boolean foundPlace = false;
            while((currentIndex - 1) / 2 >= 0 && !foundPlace){
                // if inserted value is smaller or equals to parent's value, return;
                if(arrayList.get((currentIndex - 1) / 2).compareTo(arrayList.get(currentIndex)) >= 0) {
                    foundPlace = true;
                }
                else{ // if inserted value is bigger, swap with parents
                    // index of parent is (i - 1) / 2
                    E temp = arrayList.get(currentIndex);
                    arrayList.set(currentIndex, arrayList.get((currentIndex - 1) / 2));
                    arrayList.set((currentIndex - 1) / 2, temp);
                    currentIndex = (currentIndex - 1) / 2;
                }
            }
        } catch (Exception E){
            System.out.println("You can't add an element of a different type to the heap. ");
        }

    }

    //returns the max value at the root of the heap by swapping the last value
    // and percolating the value down from the root to preserve max heap property
    // children of node at i are given by the formula 2i+1,2i+2, to not exceed the
    // bounds of the Heap index, namely, 0 ... size()-1.
    // throw appropriate exception
    public E removeHeap() {
        // if heap is empty
        if(arrayList.size() == 0) return null;
        E valueToReturn = arrayList.get(0);
        arrayList.set(0, arrayList.get(arrayList.size()-1));
        arrayList.remove(arrayList.size()-1);
        boolean placeFound = false;
        int maxSize = arrayList.size()-1;
        int currentIndex = 0;
        while(2*currentIndex+1 <= maxSize && !placeFound){
            // if current node has 2 children
            if (2 * currentIndex + 2 <= maxSize){
                E temp;
                // if current node is greater than the two children, found place
                if(arrayList.get(currentIndex).compareTo(arrayList.get(2 * currentIndex +  2)) > 0 &&
                        arrayList.get(currentIndex).compareTo(arrayList.get(2 * currentIndex +  1)) > 0){
                    placeFound = true;
                }

                // if right child greater than left, swap current node with right child
                else if(arrayList.get(2 * currentIndex +  2).compareTo(arrayList.get(2 * currentIndex + 1)) >= 0){
                    temp = arrayList.get(2 * currentIndex +  2);
                    arrayList.set(2 * currentIndex +  2, arrayList.get(currentIndex));
                    arrayList.set(currentIndex, temp);
                    currentIndex = 2 * currentIndex +  2;
                } else { // if left child is greater than right child, swap current node with left child
                    temp = arrayList.get(2 * currentIndex +  1);
                    arrayList.set(2 * currentIndex +  1, arrayList.get(currentIndex));
                    arrayList.set(currentIndex, temp);
                    currentIndex = 2 * currentIndex +  1;
                }
            } else if (2 * currentIndex + 1 == maxSize){ // if current node has only one child
                // if current node greater than child, place found
                if(arrayList.get(currentIndex).compareTo(arrayList.get(2*currentIndex+1)) > 0) {
                    placeFound = true;
                }
                else { // else swap
                    E temp = arrayList.get(currentIndex);
                    arrayList.set(currentIndex, arrayList.get(2*currentIndex+1));
                    arrayList.set(2*currentIndex+1, temp);
                    placeFound = true;
                }
            }
        }
        return valueToReturn;
    }

    // takes a list of items E and builds the heap and then prints
    // decreasing values of E with calls to removeHeap().
    public void heapSort(List<E> list){
        buildHeap(list);
        System.out.println("sorted: ");
        int size = arrayList.size();
        for(int i = 0; i < size; i++) System.out.print(removeHeap() + "  ");
        System.out.println();
    }

    // merges the other maxheap with this maxheap to produce a new maxHeap.
    public void heapMerge(MaxHeap<E> other){
        int size = other.arrayList.size();
        for(int i = 0; i < size; i++){
            addHeap(other.arrayList.get(i));
        }
    }

    //takes a list of items E and builds the heap by calls to addHeap(..)
    public void buildHeap(List<E> list) {
        for (E e : list) {
            addHeap(e);
        }
    }

}