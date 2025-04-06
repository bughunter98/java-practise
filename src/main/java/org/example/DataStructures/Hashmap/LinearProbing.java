package org.example.DataStructures.Hashmap;

import java.util.ArrayList;

// Linear probing --> creating double the size of array
public class LinearProbing {
    String[] hashTable;
    int usedCellNumber;

    public LinearProbing(int size){
        hashTable = new String[size];
        usedCellNumber=0;
    }

    public int modASCIIHashFunction(String word , int M){
        char[] ch;
        ch = word.toCharArray();
        int sum=0;
        for (int i=0;i<word.length();i++){
            sum+=ch[i];
        }
        return sum%M;
    }

    public double getLoadFactor(){
        // this comes from java documentation..
        // if this value is > 0.75 we need to create new hashtable because this affects the performance.
        // so we need to have extra empty cells to make our hashtable perform better.
        return usedCellNumber * 1.0 / hashTable.length;
    }

    // rehash means we are going to create the new hashtable with size 2x..and we are going to insert
    // all the elements from the current hashtable to the new hashtable.
    public void reHashKeys(String newWord){
        // as we are re initialising the array in case of rehashing we need to keep this zero.
        // only at the time of insertion only we need to update the value by 1.
        usedCellNumber=0;
        // we are going to create temporary array list and add all the current hashTable data into the temp arrayList
        ArrayList<String> data = new ArrayList<>();
        for (String s : hashTable) {
            if (s != null) {
                data.add(s);
            }
            // we do reHashing when we add some element into hashTable right ??
            // so this is the newWord that we are adding
            data.add(newWord);
        }
            // re initialize the hashTable with new size;
        hashTable = new String[2*hashTable.length];

        // after increasing the size of hashTable again we need to add back the elements from temp ArrayList to hashTable;

        for (String s1 : data){
            // Insert in hashTable
            insertInHashTable(s1);
        }

    }

    public void insertInHashTable(String word){
        double loadFactor = getLoadFactor();
        if (loadFactor>=0.75){
            reHashKeys(word);
        }
        else {
            int getIndexToInserInHashTable = modASCIIHashFunction(word,hashTable.length);
            // after getting the index we add our word into the hashTable at that index.
            // if empty only add at that index .
            // else we need to add at the next available index.
            for (int i=getIndexToInserInHashTable;i<hashTable.length;i++){
                int newIndex = i % hashTable.length;
                if (hashTable[newIndex]==null){
                    hashTable[newIndex] = word;
                    System.out.println("Word :"+word+" Successfully inserted at location : "+newIndex);
                    break;
                }
                else {
                    System.out.println(newIndex +" is already occupied , we are trying to insert at next available index");
                }
            }
        }
        usedCellNumber++;
    }
    public void displayHashtable(){
        if (hashTable==null){
            System.out.println("Hashtable is empty.");
            return;
        }
        else {
            System.out.println("\n---------Hashtable----------\n");
            for (int i=0;i<hashTable.length;i++){
                System.out.println("Index : "+i+" , Value : "+hashTable[i]);
            }
        }
    }

    public boolean searchHashTable(String word){
        int index = modASCIIHashFunction(word,hashTable.length);
        for (int i = index;i<hashTable.length;i++){
            int newIndex = i%hashTable.length;
            if (hashTable[newIndex]!=null && hashTable[newIndex].equalsIgnoreCase(word)){
                System.out.println(word+" Found in hastable at location "+newIndex);
                return true;
            }
        }
        System.out.println(word+" Not Found in hastable");
        return false;
    }

    public void deleteKeyInHashTable(String word){
        int index = modASCIIHashFunction(word,hashTable.length);
        for (int i = index;i<hashTable.length;i++){
            int newIndex = i%hashTable.length;
            if (hashTable[newIndex]!=null && hashTable[newIndex].equalsIgnoreCase(word)){
                hashTable[newIndex] = null;
                System.out.println("Deleted "+word+" from index :"+newIndex);
                return;
            }
        }
        System.out.println(word+" Not Found in hastable .. cannot delete");
    }

}

