

public class MyBigInteger{

    MyLinkedList<Integer> bigI;

    public MyBigInteger () {

        bigI =new MyLinkedList<>();
    }

    // takes a numerically valued String p and stores it one digit at a time in the linked list
    // example, MyBigInteger("383023322") will store the integer 383023322 in the linked list 
    // one digit per node. 
    public MyBigInteger(String p) {
        bigI =new MyLinkedList<>();
        try{
            for(int i = 0; i < p.length(); i++){
                int currentDigit = Integer.parseInt(Character.toString(p.charAt(i)));
                bigI.addLast(currentDigit);
            }
        } catch (Exception e){
            // if the input is not composed of digits only (example: 356774p3), throw exception
            System.out.println("Invalid input");
        }
    }

    //add(..) adds this MyBigInteger to other MyBigInteger and returns the sum as a MyBigInteger
    // the original Big Integers don't change.
    public MyBigInteger add(MyBigInteger other) {
        String thisValue = "";
        String otherValue = "";
        // get the values inside each list
        for (int i = 0; i < bigI.size; i++){
            thisValue = thisValue.concat(bigI.get(i).toString());
        }
        for (int i = 0; i < other.bigI.size; i++){
            otherValue = otherValue.concat(other.bigI.get(i).toString());
        }
        // convert the values to int
        int thisValueInt = Integer.parseInt(thisValue);
        int otherValueInt = Integer.parseInt(otherValue);
        // add the values
        int newValue = thisValueInt + otherValueInt;
        return new MyBigInteger(Integer.toString(newValue));
    }

    // returns true if and only if the two big integers are equal
    public boolean equals(Object other) {
        MyBigInteger other1 = (MyBigInteger) other;
        if(((MyBigInteger) other).bigI.equals(bigI)) return true;
        return false;
    }

    // returns true if and only if this MyBigInteger is less than other MyBigInteger
    public boolean lessThan(MyBigInteger other) {
        if (bigI.size < other.bigI.size) return true;
        String thisValue = "";
        String otherValue = "";
        // get the values inside each list
        for (int i = 0; i < bigI.size; i++){
            thisValue = thisValue.concat(bigI.get(i).toString());
        }
        for (int i = 0; i < other.bigI.size; i++){
            otherValue = otherValue.concat(other.bigI.get(i).toString());
        }
        // convert the values to int
        int thisValueInt = Integer.parseInt(thisValue);
        int otherValueInt = Integer.parseInt(otherValue);
        return thisValueInt < otherValueInt;
    }

}
