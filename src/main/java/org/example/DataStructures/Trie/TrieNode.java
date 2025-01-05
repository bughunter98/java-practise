package org.example.DataStructures.Trie;

public class TrieNode {
    TrieNode[] children;
    boolean endOfstring;

    public TrieNode(){
        children = new TrieNode[26];
        endOfstring=false;
    }
}
