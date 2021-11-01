public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    public BinarySearchTree() {
        size = 0;
        root = null;
    }
    public BinarySearchTree(E val) {
        root = new Node(val);
        size = 1;
    }

    // returns true if BST has val else false.
    public boolean contains (E val) {
        if(isEmpty()) return false;
        if(size == 1) return root.getInfo().compareTo(val)==0;
        Boolean found = false;
        Node <E> currentNode = root;
        while(!found){
            if(currentNode.getInfo().compareTo(val)==0) found = true; // if current node's value is equal to val
            if(currentNode.getInfo().compareTo(val)<0) { // if current node's value is smaller than the val, go right
                if(currentNode.getRight() == null) break; // if right node is null, value not found and break loop
                else currentNode = currentNode.getRight();
            } else { // if current node's value is greater than the val, go right
                if(currentNode.getLeft() == null) break; // if  node is null, value not found and break loop
                else currentNode = currentNode.getLeft();
            }
        }
        return found;
    }

    // inserts val at the right place satisfying search tree properties, should handle if the tree is empty
    // if value is already there then don't insert it again
    public void insert(E val) {
        if(isEmpty()) { // if empty tree, create root
            root = new Node<>(val);
            size = 1;
            return;
        }
        Node <E> currentNode = root;
        Node <E> nodeToInsert = new Node<>(val);
        Boolean foundPlace = false;
        while(!foundPlace){
            if(nodeToInsert.getInfo().compareTo(currentNode.getInfo())==0) foundPlace = true; // if same value, don't do anything
            else if (nodeToInsert.getInfo().compareTo(currentNode.getInfo()) < 0) { // if value to insert is smaller than current node, go left
                if(currentNode.getLeft() == null) { // if place is null, insert node there
                    currentNode.addLeft(nodeToInsert);
                    nodeToInsert.addParent(currentNode);
                    size++;
                    foundPlace = true;
                } else { // if place is not null, that node becomes the current node
                    currentNode = currentNode.getLeft();
                }
            } else { // if value to insert is greater than current node
                if(currentNode.getRight() == null) { // if place is null, insert node there
                    currentNode.addRight(nodeToInsert);
                    nodeToInsert.addParent(currentNode);
                    size++;
                    foundPlace = true;
                } else { // if place is not null, that node becomes the current node
                    currentNode = currentNode.getRight();
                }
            }
        }

    }

    // returns the minimum value stored in the tree
    public E findMin() {
        if(isEmpty()) return null;
        Node<E> currentNode = root;
        while(currentNode.getLeft()!=null){
            currentNode = currentNode.getLeft();
        }
        return currentNode.getInfo();
    }

    // returns the maximum value stored in the tree
    public E findMax() {
        if(isEmpty()) return null;
        Node<E> currentNode = root;
        while(currentNode.getRight()!=null){
            currentNode = currentNode.getRight();
        }
        return currentNode.getInfo();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bt= new BinarySearchTree<>();
        bt.insert(5);
        bt.insert(10);
        bt.insert(3);
        bt.insert(20);
        bt.insert(8);
        bt.insert(4);
        System.out.println(bt.findMax());
        System.out.println(bt.findMin());
    }


}