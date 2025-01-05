package org.example.DataStructures.Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"the","a","there","their","any"};
        for (int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }
        System.out.println(trie.search("the")); // true
        System.out.println(trie.search("a"));//true
        System.out.println(trie.search("thee"));//false
        System.out.println(trie.search("ther"));//false
        System.out.println(trie.search("there"));//true
        System.out.println(trie.wordBreakProblem("thethereany"));//true
        System.out.println(trie.search("ther"));
        System.out.println(trie.startsWith("ther"));

    }
}
