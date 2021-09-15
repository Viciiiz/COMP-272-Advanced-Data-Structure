import java.util.LinkedList;

public class ExtLinkedList <E> extends LinkedList {

    /**
     * Method to return the second half of the current Linked list
     * The time complexity of this algorithm should be O(n) because cloning is linear and the for loop
     * is linear as well. Which gives us 2n, which is O(n).
     * @return an ExtLinkedList object containing the second half of the current linked list
     */
    public ExtLinkedList <E> secondHalfList() {
        if (this.size()<2) return null;
        ExtLinkedList <E> thisList = (ExtLinkedList<E>) this.clone(); // clone() makes sure to keep the original list unchanged
        ExtLinkedList <E> extLinkedList = new ExtLinkedList<E>();
        int half = (int) Math.ceil(thisList.size()/2.0);
        for(int i = 0 ; i < this.size(); i++){
            thisList.pop();
            if(i >= half){
                extLinkedList.add(thisList.pop());
            }
        }
        return extLinkedList;
    }

    /**
     * Method to separate the element of the current linked list between odd and even index values.
     * The time complexity of this algorithm should be O(n) because clone() is linear
     * and the for loop is also linear. Therefore, we have 2n, which gives us O(n)
     * @return ExtLinkedList object containing the elements with odd values
     */
    public ExtLinkedList<E> oddList(){
        if (this.size()<2) return null;
        ExtLinkedList <E> thisList = (ExtLinkedList<E>) this.clone(); // clone() makes sure to keep the original list unchanged
        ExtLinkedList <E> odd = new ExtLinkedList<E>();
        for(int i = 0 ; i < this.size(); i++){
            if(i % 2 == 1){
                odd.add(thisList.pop());
            } else {
                thisList.pop();
            }
        }
        return odd;
    }

    /**
     * Method to separate the element of the current linked list between odd and even.
     * The time complexity of this algorithm should be O(n) because clone() is linear
     * and the for loop is also linear. Therefore, we have 2n, which gives us O(n)
     * @return
     */
    public ExtLinkedList<E> evenList(){
        if (this.size()<2) return null;
        ExtLinkedList <E> thisList = (ExtLinkedList<E>) this.clone(); // clone() makes sure to keep the original list unchanged
        ExtLinkedList <E> even = new ExtLinkedList<E>();
        for(int i = 0 ; i < this.size(); i++){
            if(i % 2 == 1){
                even.add(thisList.pop());
            } else {
                thisList.pop();
            }
        }
        return even;
    }
}
