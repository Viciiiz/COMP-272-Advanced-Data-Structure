public class MyLinkedList<E> {

    Node<E> first;
    Node<E> last;
    int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E info) {
        Node<E> n = new Node<>();
        n.setInfo(info);
        if (isEmpty()) {
            last = n;
        } else {
            n.setNext(first);
            first.setPrev(n);
        }
        first = n;
        size++;
    }

    public E removeFirst() {
        if (!isEmpty()) {
            E val = first.getInfo();
            if (size > 1) {
                first.getNext().setPrev(null);
                first = first.getNext();
            } else if (size == 1) {
                first = null;
                last = null;
            }
            size--;
            return val;
        }
        System.out.println("List is empty!");
        return null;
    }

    public E removeLast() {
        if (!isEmpty()) {
            E val = last.getInfo();
            if (size > 1) {
                last.getPrev().setNext(null);
                last = last.getNext();
            } else if (size == 1) {
                first = null;
                last = null;
            }
            size--;
            return val;
        }
        System.out.println("List is empty!");
        return null;
    }

    public E remove(int k) {
        Node<E> currentNode = first;
        E val = null;
        if ((k >= 0) && (k < size)) {
            if (k == 0) {
                removeFirst();
                val = first.getInfo();
            } else if (k == size - 1) {
                removeLast();
                val = last.getInfo();
            } else {
                for (int i = 0; i < k; i++) {
                    currentNode = currentNode.getNext();
                }
                currentNode.getPrev().setNext(currentNode.getNext());
                currentNode.getNext().setPrev(currentNode.getPrev());
                val = currentNode.getInfo();
                currentNode = null;
            }
        }
        return val;
    }
}
