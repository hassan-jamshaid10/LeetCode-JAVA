<<<<<<< HEAD
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
          int n = s.length();
        int[] dp = new int[n + 1];
        
        Set<String> dictSet = new HashSet<>();
        for (String word : dictionary) {
            dictSet.add(word);
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (dictSet.contains(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }
=======
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
          int n = s.length();
        int[] dp = new int[n + 1];
        
        Set<String> dictSet = new HashSet<>();
        for (String word : dictionary) {
            dictSet.add(word);
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (dictSet.contains(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }
>>>>>>> 3a6ff4bfe94bfe6fe752e591c60ab44bf7152046
}