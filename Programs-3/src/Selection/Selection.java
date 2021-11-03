package Selection;
/*
 * Find kth largest element in a collection
 */
import java.util.ArrayList;

public  class  Selection  <E  extends  Comparable<E>>   {
    int k;
    ArrayList<E> input  ;  //  this  holds  the  values  of  type  E  from  which  your  code  will  find  kth  largest.

    // constructor
    public Selection(){
        input = new ArrayList<>();
        k = 0;
    }

    /**
     * generate and return random int from 0 to max
     */
    public int randomInt(int max){
        return (int) (Math.random() * max);
    }



    //  algorithm  1  methods    --  implement  1B

    //  algorithm 2  methods   --  6A --  change  the  algorithm  to  do  kth  largest not kth  smallest  that  is described  here

    //  algorithm  3  methods  –  6B

    public static void main(String[] args) {
        Selection<Integer> selection;

    }
}