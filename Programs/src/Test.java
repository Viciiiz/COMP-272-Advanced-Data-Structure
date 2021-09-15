import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        LinkedList <Integer> alpha = (LinkedList<Integer>) linkedList.clone();

        alpha.add(4);

        System.out.println(linkedList);
        System.out.println(alpha);
    }
}
