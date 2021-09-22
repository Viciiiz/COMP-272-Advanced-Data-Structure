

public class MyBigInteger{

    MyLinkedList<Integer> bigI;

    public MyBigInteger () {

        bigI =new MyLinkedList<>();
    }

    // takes a numerically valued String p and stores it one digit at a time in the linked list
    // example, MyBigInteger("383023322") will store the integer 383023322 in the linked list 
    // one digit per node. 
    public MyBigInteger(String p) {


    }

    //add(..) adds this MyBigInteger to other MyBigInteger and returns the sum as a MyBigInteger
    // the original Big Integers don't change.
    public MyBigInteger add(MyBigInteger other) {

        return null;
    }

    // returns true if and only if the two big integers are equal
    public boolean equals(Object other) {
        return false;
    }
    // returns true if and only if this MyBigInteger is less than other MyBigInteger

    public boolean lessThan(MyBigInteger other) {
        return false;
    }
}
