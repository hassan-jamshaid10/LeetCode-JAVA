class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String reverse = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reverse;

        int[] kmpTable = buildKMPTable(combined);
        int longestPalindromicPrefixLength = kmpTable[kmpTable.length - 1];

        String toAdd = reverse.substring(0, reverse.length() - longestPalindromicPrefixLength);
        
        return toAdd + s;
    }

    private int[] buildKMPTable(String s) {
        int[] table = new int[s.length()];
        int j = 0; 

        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = table[j - 1]; 
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            table[i] = j; 
        }

        return table;
    } 
}