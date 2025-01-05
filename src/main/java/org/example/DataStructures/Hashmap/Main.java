package org.example.DataStructures.Hashmap;

public class Main {
    public static void main(String[] args) {
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
}
