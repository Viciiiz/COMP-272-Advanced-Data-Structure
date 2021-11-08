package Selection;

// Min Heap in java

class MinHeap <E extends Comparable<E>> {

    private E[] Heap;
    private int size;
    private int maxsize;

    public E getRoot(){
        return Heap[FRONT];
    }

    // index of root
    private static final int FRONT = 1;

    public MinHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = (E[])new Comparable[this.maxsize + 1];
    }

    // index of parent
    private int parent(int pos) { return pos / 2; }

    // index of left child
    private int leftChild(int pos) { return (2 * pos); }

    // index of right child
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    // return true if node is a leaf node
    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size) return true;
        return false;
    }

    // method to swap two nodes of the heap
    private void swap(int fpos, int spos)
    {
        E tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // To heapify the node at pos
    private void minHeapify(int pos)
    {
        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (Heap[pos].compareTo(Heap[leftChild(pos)])> 0 || Heap[pos].compareTo(Heap[rightChild(pos)])>0) {
                    // Swap with the left child and heapify the left child
                    if (Heap[leftChild(pos)].compareTo(Heap[rightChild(pos)]) < 0) {
                        swap(pos, leftChild(pos));
                        minHeapify(leftChild(pos));
                    }
                    // Swap with the right child and heapify the right child
                    else {
                        swap(pos, rightChild(pos));
                        minHeapify(rightChild(pos));
                    }
            }
        }
    }

    // method to insert a node into the heap
    public void insert(E element)
    {
        if (size >= maxsize) {
            return;
        }

        Heap[++size] = element;
       // System.out.println(size);
        int current = size;
        while (Heap[parent(current)] != null && Heap[current].compareTo(Heap[parent(current)]) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // To print the contents of the heap
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                            + " LEFT CHILD : " + Heap[2 * i]
                            + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    // method to remove the minimum element from the heap (i.e. the root)
    public E remove()
    {
        E popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    // Main driver method
    public static void main(String[] arg)
    {
        System.out.println("The Min Heap is ");

        MinHeap minHeap = new MinHeap(15);

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.print();

        System.out.println("root = "+minHeap.getRoot());

        System.out.println("The Min val is " + minHeap.remove());
    }
}
