class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode(){
        children = new int[26];
        isEndOfWord = false;
    }
}

class Trie{
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public void search(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                found = false;
            }
            node = node.children[index];
        }

        if(isEndOfWord && found){
            System.out.print("found");
        }
    }
}