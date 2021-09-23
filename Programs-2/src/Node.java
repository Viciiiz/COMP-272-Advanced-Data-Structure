
public class Node <E>{

    Node<E> left;
    Node<E> right;
    Node<E> parent;
    E  label;

    public Node(Node<E> le, Node<E> ri, Node<E> pa){
        left=le;
        right=ri;
        parent=pa;


    }

    public Node(E val){
        left=null;
        right=null;
        parent=null;
        label=val;


    }

    public Node(){
        left=null;
        right=null;
        parent=null;
        label=null;


    }

    public void addLeft(Node<E> le) {
        left=le;
        le.addParent(this);


    }

    public void addRight(Node<E> ri) {

        right=ri;
        ri.addParent(this);
    }

    public void addParent(Node<E> pa){
        parent=pa;

    }

    public void setLabel(E val){
        label=val;

    }

    public E getLabel() {
        return label;


    }

    public Node<E> getLeft(){
        return left;

    }
    public Node<E> getRight(){
        return right;

    }





}