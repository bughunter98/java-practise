package org.example.DataStructures.Hashmap;

import java.util.LinkedList;

public class DirectChaining {
    LinkedList<String>[] hashtable;
    int maxChainSize = 5;

    DirectChaining(int sizeOfArray){
        hashtable = new LinkedList[sizeOfArray];
    }

    public int modASCIIHashFunction(String word , int m){
        int sum=0;
        for (int i=0;i<word.length();i++){
            sum+=word.charAt(i);
        }
        return sum%m;
    }

    public void insertHashTable(String word){
        int newIndex = modASCIIHashFunction(word,hashtable.length);

        if (hashtable[newIndex]==null){
            // which means there is no data in that index. we create new linkedlist and insert data
            hashtable[newIndex] = new LinkedList<>();
            hashtable[newIndex].add(word);
        }
        else {
            hashtable[newIndex].add(word);
        }
    }
    // displaying hashtable

    public void displayHashtable(){
        if (hashtable==null){
            System.out.println("Hashtable is empty.");
            return;
        }
        else {
            System.out.println("\n---------Hashtable----------\n");
            for (int i=0;i<hashtable.length;i++){
                System.out.println("Index : "+i+" , Value : "+hashtable[i]);
            }
        }
    }

    public boolean searchHashtable(String word){
        int newIndex = modASCIIHashFunction(word,hashtable.length);
        if (hashtable[newIndex]!=null && hashtable[newIndex].contains(word)){
            System.out.println(word+" Found in Hashtable at location :"+newIndex);
            return true;
        }
        else {
            System.out.println(word+" not found in Hashtable..");
            return false;
        }
    }

    public void deleteKeyInHashTable(String word){
        int newIndex = modASCIIHashFunction(word,hashtable.length);
        boolean result = searchHashtable(word);
        if (result){
            hashtable[newIndex].remove(word);
            System.out.println("Deleted "+word+" successfully from hashtable");
        }
        else {
            System.out.println("Word not present to perform deletion..");
        }
    }
}
