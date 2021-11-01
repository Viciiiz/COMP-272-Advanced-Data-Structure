package hashset;

import java.util.*;
import java.security.*;
import java.io.*;

public class MyHashSet {

    int tableSize = 262127;
    ArrayList<LinkedList<String>> myHashSet;

    public MyHashSet () {
        myHashSet = new ArrayList<>();
        for(int i = 0 ; i < tableSize; i++){
            myHashSet.add(new LinkedList<String>());
        }
    }

    // first hash function
    public int hashCode(String s) {
        return Math.abs(s.hashCode())  %  tableSize;
    }

    // second hash function
    public  int  hash(Object  key)  {
        int  h;
        return  (key  == null)  ?  0  :  (h  = key.hashCode())  ^ (h  >>> 16);
    }

    // second hash function (continued)
    public int H(String s){
        return hash(s)%tableSize;
    }

    /**
     * Function to read dictionary file line by line - first question
     */
    public void readFileOne() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\adria\\IdeaProjects\\COMP 272\\Programs-3\\src\\hashset\\EnglishWordList.txt"));
            String line = reader.readLine();

            while (line != null) {
                int index = hashCode(line);
                myHashSet.get(index).add(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to read dictionary file line by line - second question
     */
    public void readFileTwo() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\adria\\IdeaProjects\\COMP 272\\Programs-3\\src\\hashset\\EnglishWordList.txt"));
            String line = reader.readLine();

            while (line != null) {
                int index = H(line);
                //myHashSet.get(index).add(line);
                System.out.println(index);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        MyHashSet myHashSet = new MyHashSet();
       // System.out.println(myHashSet.myHashSet.size());
        myHashSet.readFileTwo();
        //myHashSet.printElements();

    }

}
