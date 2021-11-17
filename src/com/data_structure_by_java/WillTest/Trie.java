package com.data_structure_by_java.WillTest;

public class Trie {

    public static void main(String[] args) {
        TrieNode trieNode = new TrieNode();

        Trie trie = new Trie();
        trie.add("goodbye");

        String  word =  "good";
        if(trie.search(word))
            System.out.println(word+" is in the trie.");
        else
            System.out.println(word+" is not in the trie");

        if(trie.startWith(word))
            System.out.println(word+" is a prefix in the trie.");
        else
            System.out.println(word+" is not a prefix in the trie");
    }


    private TrieNode root;

    // define constructor for the trie
    public Trie(){
        this.root = null;
    }


    private static class TrieNode{
        TrieNode[] next;
        boolean isEnd;

        // define the constructor
        public TrieNode(){
            this.next = new TrieNode[26];
            isEnd = false;
        }
    }


    public void add(String word){
        if(root == null)
            root = new TrieNode();

        TrieNode temp = this.root;

        int wordLength = word.length();

        for (int i = 0; i < wordLength; i++) {
            if(temp.next[word.charAt(i)-'a'] == null)
                temp.next[word.charAt(i) - 'a'] =  new TrieNode();
            temp = temp.next[word.charAt(i)-'a'];
        }
        temp.isEnd = true;
    }

    public boolean search(String word){
        if(root == null)
            return false;
        TrieNode temp = root;
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            int charIndex = word.charAt(i) - 'a';
            if(temp.next[charIndex] == null)
                return false;
            temp = temp.next[charIndex];
        }

        return temp.isEnd == true;
    }

    public boolean startWith(String prefix){
        if(root == null)
            return false;
        TrieNode temp = root;
        int wordLength = prefix.length();
        for (int i = 0; i < wordLength; i++) {
            int charIndex = prefix.charAt(i) - 'a';
            if(temp.next[charIndex] == null)
                return false;
            temp = temp.next[charIndex];
        }

        return true;
    }


}
