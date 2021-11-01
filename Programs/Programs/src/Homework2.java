import java.util.LinkedList;

public class Homework2 {

    /**
     * 3.    Write a Java program  with  a method that  given a  String p, an int  k,
     * and a  char  c,  returns  a  String with the  kth character replaced by c.
     * Of  course, 0<=k<=p.length()-1,  otherwise raise an  exception  or  error.
     * @param p
     * @param k int between 0 and p.length
     * @param c character that will replace char at index k
     * @return  a  String with the  kth character replaced by c
     * @throws Exception
     */
    public  String replaceChar(String p, int  k,  char  c) throws Exception {
        if (k >= p.length()) throw new Exception("Error: the int entered is greater than the length of the string.");
        String output = "";
        for(int i = 0; i < p.length(); i++){
            if (i == k){
                output = output.concat(Character.toString(c));
            } else {
                output = output.concat(Character.toString(p.charAt(i)));
            }
        }
        return output;
    }

    /**
     * 4.
     *      (i)  For  the code segment  below  estimate the
     *      time-complexity in the  big-oh notation.
     *
     * for  (int i=0; i<  n; i++)
     *      for  (int j=0; j*j <n;j++)
     *          System.out.println (i+j+k);
     *
     *      Answer: the first for loop is linear (O(n)) and the second for loop appears to be logarithmic (O(log(n)).
     *      The time-complexity of this code is O(n.log(n)).
     *
     *      (ii) For  the  following functions  that  represent  the  run-time  complexities  of algorithms,
     *       obtain the  run-time  complexity  in big-Oh notation:
     *              i.  F(n)=(10+2n)(n2+nlog3n) Solution: O(n^3) because it is the function that grows faster.
     *              ii.  F(n)=n0.5+log10n+log(log(n)) Solution: O(n) Because it is the fastest growing function.
     */


    public void rowSums(int [] [] arr){
        for (int i = 0; i < arr.length; i++){
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++){
                sum += arr[i][j];
            }
            if ((i == arr.length - 1)) {
                System.out.println(sum);
            } else {
                System.out.print(sum + ", ");
            }
        }
    }

    public void columnMins(int [] [] arr){
        int column_number = arr[0].length;
        for (int i = 0; i < column_number; i++){
            int min = arr[0][i];
            for (int j = 0; j < arr.length; j++){
                if(arr[j][i] < min) min = arr[j][i];
            }
            if ((i == column_number - 1)) {
                System.out.println(min);
            } else {
                System.out.print(min + ", ");
            }
        }
    }

    // 6
    public void linkedListSum(LinkedList<Integer> linkedList){
        if (linkedList.size() == 0) {
            System.out.println("0");
            return;
        }
        int sum = 0;
        for (int i = 0; i < linkedList.size(); i++){
            sum+= linkedList.get(i);
            if (i == linkedList.size()-1) System.out.println(sum);
            else System.out.print(sum + ", ");
        }
    }

    // 7
    public void linkedListSumReversed(LinkedList<Integer> linkedList){
        if (linkedList.size() == 0) {
            System.out.println("0");
            return;
        }
        int sum = 0;
        for (int i = linkedList.size()-1; i>=0; i--){
            sum+= linkedList.get(i);
            if (i == 0) System.out.println(sum);
            else System.out.print(sum + ", ");
        }
    }

    //8
    public void sortTwoLinkedLists(LinkedList<String> linkedList1, LinkedList<String> linkedList2){
        LinkedList<String> result = new LinkedList<>();
        int list1Size = linkedList1.size();
        int list2Size = linkedList2.size();
        int list1Index = 0;
        int list2Index = 0;
        if (list1Size == 0 && list2Size == 0) {
            System.out.println("Nothing to compare. Both lists are empty.");
            return;
        }
        while(list1Size > 0 || list2Size > 0){
            if (list1Size == 0 && list2Size != 0){
                while (list2Size!=0){
                    result.add(linkedList2.get(list2Index));
                    list2Index++;
                    list2Size--;
                }
            } else if (list2Size == 0 && list1Size != 0){
                while (list1Size != 0){
                    result.add(linkedList1.get(list1Index));
                    list1Index++;
                    list1Size--;
                }
            } else {
                if (linkedList1.get(list1Index).compareTo(linkedList2.get(list2Index)) >= 0) {
                    result.add(linkedList2.get(list2Index));
                    list2Index++;
                    list2Size--;
                } else {
                    result.add(linkedList1.get(list1Index));
                    list1Index++;
                    list1Size--;
                }
            }
        }
        System.out.println(result);
    }

    //9
    public void uniquePair(int[] arr, int k){
        if (k == 0) {
            System.out.println("Difference cannot be 0");
            return;
        }
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i]-arr[j]==k && arr[i]>arr[j]){
                    System.out.print("(" + arr[i] + "," + arr[j] + "), ");
                }
            }
        }
        System.out.println();
    }


    public static void main(String[] args) throws Exception {
        int[][] a = {{3,2,5},{1,0,4},{5,6,7}};
        Homework2 homework2 = new Homework2();
        homework2.rowSums(a);
        homework2.columnMins(a);
        System.out.println(homework2.replaceChar("alpha", 3, 't'));

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(9);
        linkedList.add(3);
        linkedList.add(15);
        linkedList.add(22);
        homework2.linkedListSum(linkedList);
        homework2.linkedListSumReversed(linkedList);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        homework2.linkedListSum(linkedList2);
        homework2.linkedListSumReversed(linkedList2);

        LinkedList<String> alpha = new LinkedList<>();
        alpha.add("cat");
        alpha.add("cucumber");
        alpha.add("fun");
        alpha.add("zoom");

        LinkedList<String> beta = new LinkedList<>();
        beta.add("catch");
        beta.add("cucumber");
        beta.add("yolo");
        beta.add("zoo");

        homework2.sortTwoLinkedLists(alpha, beta);

        int [] pair = new int[] {1,4,9,12,6,15,5,13,17};
        homework2.uniquePair(pair, 3);

    }
}
