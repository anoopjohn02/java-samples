package anoop.test.sample;

//import javafx.util.Pair;

public class AutocompleteSystem {
    /*private TrieNode trie;
    private StringBuilder prefix;

    public class TrieNode{
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isWord;
        public Map<String, Integer> count = new HashMap();
    }

    private void addWords(String[] sentences, int[] times){
        this.trie = new TrieNode();
        int ti = 0;
        for(String s : sentences){
            int t = times[ti];
            addWord(s, t);
            ti++;
        }
    }

    private void addWord(String s, int t){
        TrieNode node = this.trie;
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(node.children.containsKey(c)){
                node = node.children.get(c);
            } else {
                TrieNode temp = new TrieNode();
                node.children.put(c, temp);
                node = temp;
            }
            int count = node.count.getOrDefault(s, t-1) + 1;
            node.count.put(s, count);
        }
        node.isWord = true;
    }

    private TrieNode getNode(String prefix){
        TrieNode node = this.trie;
        for(int i=0; i<prefix.length(); i++){
            Character c = prefix.charAt(i);
            if(node.children.containsKey(c)){
                node = node.children.get(c);
            } else {
                return null;
            }
        }
        return node;
    }


    public AutocompleteSystem(String[] sentences, int[] times) {
        prefix = new StringBuilder();
        addWords(sentences, times);
    }

    public List<String> input(char c) {
        if(c == '#'){
            addWord(prefix.toString(), 1);
            prefix = new StringBuilder();
            return new ArrayList<>();
        }

        prefix.append(c);
        TrieNode node = getNode(prefix.toString());
        if(node == null){
            return new ArrayList<>();
        }

        PriorityQueue<Pair<String, Integer>> q = new PriorityQueue<>(
                new Comparator<Pair<String, Integer>>(){
                    public int compare(Pair<String, Integer> a, Pair<String, Integer> b){
                        return a.getValue() == b.getValue() ?
                                a.getKey().compareTo(b.getKey()) :
                                b.getValue() - a.getValue();
                    }
                }
        );

        for(String s : node.count.keySet()){
            q.add(new Pair(s, node.count.get(s)));
        }

        List<String> result = new ArrayList<>();
        int i = 0;
        while(i<3 && !q.isEmpty()){
            result.add(q.poll().getKey());
            i++;
        }
        return result;
    }*/
}
