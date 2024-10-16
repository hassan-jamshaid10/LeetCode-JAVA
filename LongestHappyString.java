class Solution {
    static class CharCount {
        int count;
        char letter;
        
        CharCount(int count, char letter) {
            this.count = count;
            this.letter = letter;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharCount> pq = new PriorityQueue<>((x, y) -> y.count - x.count);
        
        if (a > 0) pq.offer(new CharCount(a, 'a'));
        if (b > 0) pq.offer(new CharCount(b, 'b'));
        if (c > 0) pq.offer(new CharCount(c, 'c'));
        
        StringBuilder result = new StringBuilder();
        
        while (!pq.isEmpty()) {
            CharCount first = pq.poll();
            
 
            int length = result.length();
            if (length >= 2 && result.charAt(length - 1) == first.letter && result.charAt(length - 2) == first.letter) {
              
                if (pq.isEmpty()) {
                  
                    break;
                }
                
                CharCount second = pq.poll();
                result.append(second.letter);
                second.count--;
                
                if (second.count > 0) {
                    pq.offer(second);
                }
                
                pq.offer(first);
            } else {
                result.append(first.letter);
                first.count--;
                
                if (first.count > 0) {
                    pq.offer(first);
                }
            }
        }
        
        return result.toString();
    }
}