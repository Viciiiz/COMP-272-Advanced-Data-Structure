public class MyLinkedList<E> {

    Node<E> first;
    Node<E> last;
    int size;

    public MyLinkedList(){
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addFirst(E info) {
        Node<E> n = new Node<>();
        n.setInfo(info);
        if(isEmpty()) {
            last = n;
        } else {
            n.setNext(first);
            first.setPrev(n);
        }
        first = n;
        size++;
    }
}
