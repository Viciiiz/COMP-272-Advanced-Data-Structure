// if the string input is made of zeros only, create a myBigInteger containing one 0
// if the string input is empty, create a myBigInteger containing one 0
// if the string input has leading zeros, remove them
// the input has to contain digits only and cannot be negative (no negative sign)

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
        // if string is empty, create a myBigInteger with a value of 0
        if (p.length() == 0) {
            bigI.addLast(0);
            return;
        }
        // if input is only composed of zeros
        if (allZero(p)) {
            bigI.addLast(0);
            return;
        }

        // remove leading zeros
        p = removeZero(p);
        // else
        try{
            for(int i = 0; i < p.length(); i++){
                int currentDigit = Integer.parseInt(Character.toString(p.charAt(i)));
                bigI.addLast(currentDigit);
            }
        } catch (Exception e){
            // if the input is not composed of digits only (example: 356774p3), throw exception
            System.out.println("Invalid input. Not numerical");
        }
    }

    // check if string input is only composed of zeros
    // return true if all zero
    public boolean allZero(String str){
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i)!= '0') return false;
        }
        return true;
    }

    // remove leading zeros from string input
    public String removeZero(String str){
        int index = 0;
        while (str.charAt(index) == '0'){
            if (str.length()>1) str = str.substring(1);
        }
        return str;
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
        if (thisValue.length() == 0) thisValue = thisValue.concat("0");
        if (otherValue.length() == 0) otherValue = otherValue.concat("0");

        int thisValueInt = Integer.parseInt(thisValue);
        int otherValueInt = Integer.parseInt(otherValue);
        // add the values
        int newValue = thisValueInt + otherValueInt;
        return new MyBigInteger(Integer.toString(newValue));
    }

    // returns true if and only if the two big integers are equal
    public boolean equals(Object other) {
        try {
            MyBigInteger other1 = (MyBigInteger) other;
            if (((MyBigInteger) other).bigI.equals(bigI)) return true;
        } catch (Exception e){
            try {
                throw new Exception("Not a MyBigInteger Object.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
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
