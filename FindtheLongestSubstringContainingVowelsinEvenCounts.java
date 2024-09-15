class Solution {
    public int findTheLongestSubstring(String s) {
         Map<Integer, Integer> maskToIndex = new HashMap<>();
        maskToIndex.put(0, -1);
        
        int maxLength = 0;
        int currentMask = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == 'a') {
                currentMask ^= 1 << 0;
            } else if (c == 'e') {
                currentMask ^= 1 << 1;
            } else if (c == 'i') {
                currentMask ^= 1 << 2;
            } else if (c == 'o') {
                currentMask ^= 1 << 3;
            } else if (c == 'u') {
                currentMask ^= 1 << 4;
            }
            
            if (maskToIndex.containsKey(currentMask)) {
                maxLength = Math.max(maxLength, i - maskToIndex.get(currentMask));
            } else {
                maskToIndex.put(currentMask, i);
            }
        }
        
        return maxLength;
    }
}