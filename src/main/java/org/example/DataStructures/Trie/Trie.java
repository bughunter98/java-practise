package org.example.DataStructures.Trie;

// learnt from apnacollege youtube
public class Trie {

    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
        System.out.println("Trie has been created..");
    }

    public void insert(String word){
        TrieNode current = root;
        for (int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if (current.children[index]==null){
                // add new Node
                current.children[index]= new TrieNode();
            }
            if (i==word.length()-1){
                current.children[index].endOfstring=true;
            }
            current = current.children[index];
        }
        System.out.println("Successfully inserted "+word+" in trie");
    }

    public boolean search(String key){
        TrieNode current = root;
        for (int i=0;i<key.length();i++){
            int index = key.charAt(i)-'a';
            TrieNode node = current.children[index];
            if (node==null){
                // which means there is no node .. so return false
                return false;
            }
            if (i==key.length()-1 && !node.endOfstring){
                return false;
            }
            current = node;
        }
        return true;
    }

    /* word break problem.
    given an input string and a dictionary of words , find out if the  input String can be broken
    into a space-seperated sequence of dictionary words.*/

    public boolean wordBreakProblem(String key){
        if (key.isEmpty()){
            return true;
        }
        for (int i=1;i<=key.length();i++){
            String firstPart = key.substring(0,i);
            String secondPart = key.substring(i);
            if (search(firstPart) && wordBreakProblem(secondPart)){
                return true;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix){
        TrieNode current = root;
        for (int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i)-'a';
            if (current.children[index]==null){
                return false;
            }
            current = current.children[index];
        }
        return true;
    }


}
