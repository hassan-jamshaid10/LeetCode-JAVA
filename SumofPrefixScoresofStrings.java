class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }
    
  
    private void insertWord(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.count++;
        }
    }
    
    
    private int getPrefixScore(TrieNode root, String word) {
        TrieNode node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
                score += node.count; 
            } else {
                break;
            }
        }
        return score;
    }
    
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            insertWord(root, word);
        }
        
        int[] answer = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            answer[i] = getPrefixScore(root, words[i]);
        }
        
        return answer;
    }
}