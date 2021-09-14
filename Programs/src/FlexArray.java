public class FlexArray
{
    int [] array;
    private int size;
    private final int capacity;
    public FlexArray()
    {
        capacity=10;
        size=0;
        array=new int[10];
    }
    public FlexArray(int maxEntries) {

        capacity=maxEntries;
        size=0;
        array=new int[capacity];

    }

    public void add(int val) {
        if (size<capacity) {
            array[size]=val;
            size++;
        }
        else System.out.println("Array is full, cannot add any more values");

    }

    public int set(int val, int location) {
        if (location>=0 && location<size){
            int num= get(location);
            array[location]=val;
            return num;
        }
        else throw new ArrayIndexOutOfBoundsException();
    }

    public int get(int location) {
        if (location>=0 && location<size){
            return array[location];
        }
        else throw new ArrayIndexOutOfBoundsException();
    }


}