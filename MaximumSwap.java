class Solution {
    public int maximumSwap(int num) {
        
    char[] digits = Integer.toString(num).toCharArray();
        int[] lastSeen = new int[10]; 

     
        for (int i = 0; i < digits.length; i++) {
            lastSeen[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (lastSeen[d] > i) { 
                    char temp = digits[i];
                    digits[i] = digits[lastSeen[d]];
                    digits[lastSeen[d]] = temp;
                    
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }
}