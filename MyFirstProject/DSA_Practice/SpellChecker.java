package DSA_Practice;

class TrieNode {
    TrieNode[] children;
    int endOfWord;

    TrieNode(){
        children = new TrieNode[26];
        endOfWord = 0;
    }
}

public class SpellChecker {
    private static void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int ch = word.charAt(i) - 'a';
            if(curr.children[ch] == null){
                curr.children[ch] = new TrieNode();
            }
            curr = curr.children[ch];
        }
        curr.endOfWord = 1;
    }

    private static int search(TrieNode root, String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int ch = word.charAt(i) - 'a';
            if(curr != null && curr.children[ch] == null){
                return 0;
            }
            curr = curr.children[ch];
        }
        return curr.endOfWord;
    }
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        String[] A = new String[]{"hat", "cat", "rat"};
        String[] B = new String[]{"cat", "ball"};

        for(int i = 0; i < A.length; i++) {
            insert(root, A[i]);
        }
        for(int i = 0; i < B.length; i++) {
            System.out.println(search(root, B[i]));
        }
    }
}
