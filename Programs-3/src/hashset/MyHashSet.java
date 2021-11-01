package hashset;

import java.util.*;
import java.security.*;
import java.io.*;

public class MyHashSet {

 //   int tableSize = 262127;
 //   int tableSize3 = 262144;
    ArrayList<LinkedList<String>> myHashSet;

    public MyHashSet (int tableSize) {
        myHashSet = new ArrayList<>();
        for(int i = 0 ; i < tableSize; i++){
            myHashSet.add(new LinkedList<String>());
        }
    }

    // first hash function
    public int hashCode(String s) {
        return Math.abs(s.hashCode())  %  262127;
    }

    // second hash function
    public  int  hash(Object  key)  {
        int  h;
        return  (key  == null)  ?  0  :  (h  = key.hashCode())  ^ (h  >>> 16);
    }

    // second hash function (continued)
    public int H(String s){
        return hash(s)%262127;
    }

    // third hash function
    public  int  hashCode3(String  s) {
        byte[] sb=s.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] key=md.digest(sb);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BitSet bs = BitSet.valueOf(sb);
        // using the BitSet  bs, you will extract 18 bits based on the
        // get() method of BitSet.  The 18 bits are extracted at the first
        // 18 prime numbers  2,  7,17,29,41,53,67,79,97,107,127,139,157, 173,191,  199,227,239.   Put the bits together in that
        // order to form an integer and return it.
        // That will be the hash
        // value of the key that you can use in the table of size 2^18.
        return Math.abs(s.hashCode()%262144);
    }

    /**
     * Function to read dictionary file line by line - first question
     */
    public void readFileOne() {
        BufferedReader reader;
        long startTime = System.currentTimeMillis();
        long totalTime;
        int lineNumber = 0;
        int listNumber = 0;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\adria\\IdeaProjects\\COMP 272\\Programs-3\\src\\hashset\\EnglishWordList.txt"));
            String line = reader.readLine();

            while (line != null) {
                lineNumber++;
                int index = hashCode(line);
                myHashSet.get(index).add(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listNumber = getListLength();
        totalTime = System.currentTimeMillis() - startTime;
        System.out.println("For hash 1: ");
        System.out.println("Time: "+totalTime);
        int collisionNumber = lineNumber - listNumber;
        System.out.println("Number of collisions: " + collisionNumber);
        System.out.println("Average size of list: " + averageSize());
        System.out.println();
    }

    /**
     * Function to read dictionary file line by line - second question
     */
    public void readFileTwo() {
        long startTime = System.currentTimeMillis();
        long totalTime;
        int lineNumber = 0;
        int listNumber = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\adria\\IdeaProjects\\COMP 272\\Programs-3\\src\\hashset\\EnglishWordList.txt"));
            String line = reader.readLine();

            while (line != null) {
                lineNumber++;
                int index = Math.abs(H(line));
                myHashSet.get(index).add(line);
                //System.out.println(index);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listNumber = getListLength();
        totalTime = System.currentTimeMillis() - startTime;
        System.out.println("For hash 2: ");
        System.out.println("Time: "+totalTime);
        int collisionNumber = lineNumber - listNumber;
        System.out.println("Number of collisions: " + collisionNumber);
        System.out.println("Average size of list: " + averageSize());
        System.out.println();
    }

    /**
     * Function to read dictionary file line by line - third question
     */
    public void readFileThree() {
        long startTime = System.currentTimeMillis();
        long totalTime;
        int lineNumber = 0;
        int listNumber = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\adria\\IdeaProjects\\COMP 272\\Programs-3\\src\\hashset\\EnglishWordList.txt"));
            String line = reader.readLine();

            while (line != null) {
                lineNumber++;
                int index = hashCode3(line);
                myHashSet.get(index).add(line);
                //System.out.println(index);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listNumber = getListLength();
        totalTime = System.currentTimeMillis() - startTime;
        System.out.println("For hash 3: ");
        System.out.println("Time: "+totalTime);
        int collisionNumber = lineNumber - listNumber;
        System.out.println("Number of collisions: " + collisionNumber);
        System.out.println("Average size of list: " + averageSize());
        System.out.println();
    }

    /**
     * function to get the number of filled list
     */
    int getListLength(){
        int result = 0;
        for(int i = 0; i < myHashSet.size(); i++){
            if(myHashSet.get(i).size()>0) {
                result++;
            }
        }
        return result;
    }

    /**
     * function to get the average size of the linked lists
     */
    double averageSize() {
        double result = 0;
        int count = 0;
        for(int i = 0; i < myHashSet.size(); i++){
            if(myHashSet.get(i).size()>0) {
                result+=myHashSet.get(i).size();
                count++;
            }
        }
        return result/count;
    }

    /**
     * function to print all the elements of each linked list of the arraylist
     */
    void printElements() {
        for (int i = 0; i < myHashSet.size(); i++) {
            System.out.println("Index:" + i);
            for (int j = 0; j < myHashSet.get(i).size(); j++) {
                System.out.print(myHashSet.get(i).get(j) + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int tableSize1 = 262127;
        int tableSize3 = 262144;
        MyHashSet myHashSet = new MyHashSet(tableSize1);
        MyHashSet myHashSet2 = new MyHashSet(tableSize1);
        MyHashSet myHashSet3 = new MyHashSet(tableSize3);

        myHashSet.readFileOne();
        myHashSet2.readFileTwo();
        myHashSet3.readFileThree();
    }

}
