package org.example.DataStructures.Hashmap.OpenAddressing;

import java.util.ArrayList;

public class DoubleHashing {
    String[] hashTable;
    int usedCellNumber;

    public DoubleHashing(int size){
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
            insertKeyInHashTable(s1);
        }

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

    private int addAllDigitsTogeather(int sum){
        int value =0;
        while (sum>0){
            value = sum%10;
            sum = sum/10;
        }
        return value;
    }

    public int secondHashFunction(String str , int M){
        char ch[] ;
        ch = str.toCharArray();
        int sum=0;
        for (int i=0;i<ch.length;i++){
            sum+=ch[i];
        }
        while (sum>hashTable.length){
            sum = addAllDigitsTogeather(sum);
        }
        return sum%M;
    }
    public void insertKeyInHashTable(String word){
        double loadFactor = getLoadFactor();
        if (loadFactor>0.75){
            reHashKeys(word);
        }
        else {
            int x = modASCIIHashFunction(word,hashTable.length); // first hash function
            int y = secondHashFunction(word,hashTable.length); // second hash function

            for (int i=0;i<hashTable.length;i++){
                int newIndex = x+(i*y)% hashTable.length;
                if (hashTable[newIndex]==null){
                    hashTable[newIndex] = word;
                    System.out.println("Value :"+word+" Inserted at location : "+newIndex);
                    break;

                }
                else {
                    System.out.println(newIndex+" is occupied . Try in next possible Index..");
                }
            }
        }
        usedCellNumber++;
    }
    public boolean searchHashTable(String word){
        int index1 = modASCIIHashFunction(word,hashTable.length); // first hash function
        int index2 = secondHashFunction(word,hashTable.length); // second hash function
        for (int i = 0;i<hashTable.length;i++){
            int newIndex = index1 + (i * index2) %hashTable.length;
            if (hashTable[newIndex]!=null && hashTable[newIndex].equalsIgnoreCase(word)){
                System.out.println(word+" Found in hastable at location "+newIndex);
                return true;
            }
        }
        System.out.println(word+" Not Found in hastable");
        return false;
    }

    public void deleteKeyInHashTable(String word){
        int index1 = modASCIIHashFunction(word,hashTable.length); // first hash function
        int index2 = secondHashFunction(word,hashTable.length); // second hash function
        for (int i = 0;i<hashTable.length;i++){
            int newIndex = index1 + (i * index2) %hashTable.length;
            if (hashTable[newIndex]!=null && hashTable[newIndex].equalsIgnoreCase(word)){
                hashTable[newIndex] = null;
                System.out.println("Deleted "+word+" from index :"+newIndex);
                return;
            }
        }
        System.out.println(word+" Not Found in hastable .. cannot delete");
    }
}
