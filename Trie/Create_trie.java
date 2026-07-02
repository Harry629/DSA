package DSA.Trie;


import java.util.*;

public class Create_trie{

    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        TrieNode(){
            for(int i=0;i<26;i++){
                children[i]= null;
            }
            isEndOfWord=false;
        }
    }

    static void insert(TrieNode root, String word){
        int n = word.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++){
            int idx = word.charAt(i)-'a';

            if(temp.children[idx] == null){
                temp.children[idx]= new TrieNode();
            }
            temp = temp.children[idx];
        }
        temp.isEndOfWord = true;
    }

    static boolean search (TrieNode root, String word){
        TrieNode temp = root;
        int n= word.length();

        for(int i=0;i<n;i++){
            int idx = word.charAt(i)- 'a';
            if(temp.children[idx] == null){
                return false;
            }
            temp = temp.children[idx];
        }
        return temp.isEndOfWord;
    }

    public static void main(String[] args){
        TrieNode root = new TrieNode();
        String word = "hi";
        insert(root, word);

        System.out.println("hi "+ search(root, "hi"));

    }   
}