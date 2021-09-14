public class Node<E> {

    E info;
    Node <E> prev;
    Node <E> next;

    public Node () {
        info = null;
        prev = null;
        next = null;
    }

    public void setNext(Node<E> n){
        next = n;
    }

    public void setPrev(Node<E> p){
        prev = p;
    }

    public void setInfo(E i){
        info = i;
    }
}
