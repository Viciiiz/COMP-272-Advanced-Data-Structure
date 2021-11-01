import java.util.*;

public class ExtLinkedList <E> extends LinkedList {

    /**
     * Method to return the second half of the current Linked list
     * The time complexity of this algorithm should be O(n) because cloning is linear and the for loop
     * is linear as well. Which gives us 2n, which is O(n).
     * @return an ExtLinkedList object containing the second half of the current linked list
     */
    public ExtLinkedList <E> secondHalfList() {
        if (this.size()<2) return null;
        ArrayList <E> thisList = cloneLinkedList();
        ExtLinkedList <E> extLinkedList = new ExtLinkedList<E>();
        int half = (int) Math.ceil(thisList.size()/2.0);
        for(int i = 0 ; i < this.size(); i++){
            if (i >= half){
                extLinkedList.add(thisList.get(i));
            }

        }
        return extLinkedList;
    }

    // from the provided example
    public ArrayList<E> cloneLinkedList()  {
        ArrayList<E> al  = new  ArrayList<E>();
        ListIterator<E> li =  this.listIterator();
        while  (li.hasNext()) al.add(li.next());
        return  al;
    }

    /**
     * Method to separate the element of the current linked list between odd and even index values.
     * The time complexity of this algorithm should be O(n) because clone() is linear
     * and the for loop is also linear. Therefore, we have 2n, which gives us O(n)
     * @return ExtLinkedList object containing the elements with odd values
     */
    public ExtLinkedList<E> oddList(){
        if (this.size()<1) return null;
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
        if (this.size()<1) return null;
        ExtLinkedList <E> thisList = (ExtLinkedList<E>) this.clone(); // clone() makes sure to keep the original list unchanged
        ExtLinkedList <E> even = new ExtLinkedList<E>();
        for(int i = 0 ; i < this.size(); i++){
            if(i % 2 == 0){
                even.add(thisList.pop());
            } else {
                thisList.pop();
            }
        }
        return even;
    }

    public static void main(String[] args) {
        ExtLinkedList<Integer> extLinkedList = new ExtLinkedList<>();
        extLinkedList.add(1);
        extLinkedList.add(2);
        extLinkedList.add(6);
        extLinkedList.add(10);
        extLinkedList.add(17);
        extLinkedList.add(13);

        System.out.println(extLinkedList.evenList());
        System.out.println(extLinkedList.oddList());
        System.out.println(extLinkedList.secondHalfList());
        System.out.println(extLinkedList);

    }
}
