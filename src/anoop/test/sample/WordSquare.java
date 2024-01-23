package anoop.test.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordSquare {
    String[] words;
    TrieNode trie;
    List<List<String>> result = null;

    public class TrieNode{
        public Map<Character, TrieNode> children = new HashMap<>();
        public List<Integer> words = new ArrayList<>();
    }

    public List<List<String>> wordSquares(String[] words) {
        result = new ArrayList();
        this.words = words;
        buildTrieNode();

        for(String word : words){
            LinkedList<String> squares = new LinkedList();
            squares.addLast(word);
            backTracking(1, squares);
        }
        return result;
    }

    private void backTracking(int step, LinkedList<String> squares){
        if(step == words[0].length()){
            result.add((List<String>)squares.clone());
            return;
        }

        StringBuilder prefix = new StringBuilder();
        for(String word : squares){
            prefix.append(word.charAt(step));
        }

        for(Integer i : getWords(prefix.toString())){
            squares.addLast(words[i]);
            backTracking(step+1, squares);
            squares.removeLast();
        }

    }

    private void buildTrieNode(){
        trie = new TrieNode();
        for(int wi=0; wi<words.length; wi++){
            String word = words[wi];
            TrieNode node = trie;
            for(int i=0; i<word.length(); i++){
                Character c = word.charAt(i);
                if(node.children.containsKey(c)){
                    node = node.children.get(c);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(c, newNode);
                    node = newNode;
                }
                node.words.add(wi);
            }
        }
    }

    private List<Integer> getWords(String prefix){
        TrieNode node = trie;
        for(int i=0; i<prefix.length(); i++){
            Character c = prefix.charAt(i);
            if(node.children.containsKey(c)){
                node = node.children.get(c);
            } else {
                return new ArrayList<>();
            }
        }
        return node.words;
    }
}
