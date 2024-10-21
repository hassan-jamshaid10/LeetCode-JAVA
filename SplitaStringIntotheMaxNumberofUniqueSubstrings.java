class Solution {
     public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, Set<String> seen) {
        if (start == s.length()) {
            return 0;
        }

        int maxSplits = 0;

        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            
            if (!seen.contains(substring)) {
                seen.add(substring);
                
                int splits = 1 + backtrack(s, i, seen);
                maxSplits = Math.max(maxSplits, splits);
                
                seen.remove(substring);
            }
        }

        return maxSplits;
    }
}