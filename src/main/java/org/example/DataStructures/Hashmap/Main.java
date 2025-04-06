package org.example.DataStructures.Hashmap;

import org.example.DataStructures.Hashmap.OpenAddressing.DoubleHashing;
import org.example.DataStructures.Hashmap.OpenAddressing.QuadraticProbing;

public class Main {
    public static void main(String[] args) {

        // In case we are aware of the size of hashMap use open Addressing / linear probing instead of directChaininh
        // if there are frequent deletion operations to be performed in hashMap then use direct chaining.
        directChaining();
        
        linearProbing();

        quadraticProbing();

        doubleHashing();
    }
    private static void directChaining() {
        System.out.println("-----------------------------Direct Chaining--------------------------------");
        DirectChaining directChaining = new DirectChaining(13);
        directChaining.insertHashTable("The");
        directChaining.insertHashTable("quick");
        directChaining.insertHashTable("brown");
        directChaining.insertHashTable("fox");
        directChaining.insertHashTable("over");

        directChaining.displayHashtable();
        directChaining.searchHashtable("fox");
        directChaining.searchHashtable("ox");
        directChaining.deleteKeyInHashTable("fox");
        directChaining.displayHashtable();
    }
    private static void linearProbing() {
        System.out.println("----------------------Linear Probing---------------------");
        LinearProbing probing = new LinearProbing(13);
        probing.insertInHashTable("The");
        probing.insertInHashTable("quick");
        probing.insertInHashTable("brown");
        probing.insertInHashTable("fox");
        probing.insertInHashTable("over");
        probing.insertInHashTable("over1");
        probing.insertInHashTable("over2");
        probing.displayHashtable();
        probing.searchHashTable("fox");
        probing.searchHashTable("ox");
        probing.searchHashTable("over");
        probing.deleteKeyInHashTable("fox");
        probing.displayHashtable();
        probing.deleteKeyInHashTable("over1");
    }
    private static void quadraticProbing(){
        QuadraticProbing probing = new QuadraticProbing(13);
        System.out.println("----------------------Quadratic Probing---------------------");
        probing.insertInHashTable("The");
        probing.insertInHashTable("quick");
        probing.insertInHashTable("brown");
        probing.insertInHashTable("fox");
        probing.displayHashtable();
    }
    private static void doubleHashing(){
        DoubleHashing hashing = new DoubleHashing(13);
        System.out.println("----------------------Double Hashing--------------------");
        hashing.insertKeyInHashTable("The");
        hashing.insertKeyInHashTable("quick");
        hashing.insertKeyInHashTable("brown");
        hashing.insertKeyInHashTable("fox");
        hashing.displayHashtable();
        hashing.searchHashTable("fox");
    }


}
