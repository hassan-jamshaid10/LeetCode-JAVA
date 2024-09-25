class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
     int maxLength = 0;
        
        for (int num1 : arr1) {
            for (int num2 : arr2) {
                String str1 = String.valueOf(num1);
                String str2 = String.valueOf(num2);
                
                int commonPrefixLength = findCommonPrefixLength(str1, str2);
                
                maxLength = Math.max(maxLength, commonPrefixLength);
            }
        }
        
        return maxLength;
    }
    
    private static int findCommonPrefixLength(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return i;
            }
        }
        
        return minLength;
    }
}