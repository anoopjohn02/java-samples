package anoop.test.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixWordSearch {
    private TrieNode trie;
    private char[][] board;
    List<String> res = new ArrayList<>();
    public class TrieNode{
        public Map<Character, TrieNode> children = new HashMap<>();
        public String word;
    }

    private void buildTrieNode(String[] words){
        this.trie = new TrieNode();
        for(String word : words){
            TrieNode node = this.trie;
            for(int i=0; i<word.length(); i++){
                if(node.children.containsKey(word.charAt(i))){
                    node = node.children.get(word.charAt(i));
                } else {
                    TrieNode temp = new TrieNode();
                    node.children.put(word.charAt(i), temp);
                    node = temp;
                }
            }
            node.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        this.board = board;
        buildTrieNode(words);

        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[r].length; c++){
                search(r, c, trie);
            }
        }
        return res;
    }

    private void search(int row, int col, TrieNode root){

        Character letter = this.board[row][col];
        TrieNode curr = root.children.getOrDefault(letter, null);
        if(curr == null){
            return;
        }
        if(curr.word != null){
            res.add(curr.word);
            curr.word = null;
        }

        board[row][col]='#';

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir:dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow < 0 || newRow == board.length
                    || newCol < 0 || newCol == board[0].length
                    || board[newRow][newCol] == '#'){
                continue;
            }
            search(newRow, newCol, curr);
        }
        board[row][col]=letter;

    }
}
