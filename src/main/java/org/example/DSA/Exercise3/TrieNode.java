package org.example.DSA.Exercise3;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        pCrawl.isEndOfWord = true;
    }

    boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    List<String> autocomplete(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode pCrawl = root;

        for (int level = 0; level < prefix.length(); level++) {
            int index = prefix.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                return results;

            pCrawl = pCrawl.children[index];
        }

        collectAllWords(pCrawl, prefix, results);
        return results;
    }

    void collectAllWords(TrieNode node, String prefix, List<String> results) {
        if (node.isEndOfWord)
            results.add(prefix);

        for (char c = 'a'; c <= 'z'; c++) {
            TrieNode child = node.children[c - 'a'];
            if (child != null)
                collectAllWords(child, prefix + c, results);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("hello");
        trie.insert("hell");
        trie.insert("heaven");
        trie.insert("heavy");

        System.out.println("Search for 'hello': " + trie.search("hello"));
        System.out.println("Search for 'hell': " + trie.search("hell"));
        System.out.println("Search for 'he': " + trie.search("he"));

        List<String> completions = trie.autocomplete("he");
        System.out.println("Autocomplete for 'he': " + completions);
    }
}

