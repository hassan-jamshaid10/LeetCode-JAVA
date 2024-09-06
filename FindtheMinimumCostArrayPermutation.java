class Solution {
    public int[] findPermutation(int[] nums) {
      int n = nums.length;
        int[] perm = new int[n];
        int[] bestPerm = new int[n];
        int minScore = Integer.MAX_VALUE;
      
        List<int[]> permutations = new LinkedList<>();
        generatePermutations(new int[n], new boolean[n], permutations, 0);
        
        for (int[] p : permutations) {
            int score = calculateScore(p, nums);
            if (score < minScore || (score == minScore && compare(p, bestPerm) < 0)) {
                minScore = score;
                bestPerm = p;
            }
        }
        
        return bestPerm;
    }

    private void generatePermutations(int[] perm, boolean[] used, List<int[]> result, int index) {
        if (index == perm.length) {
            result.add(perm.clone());
            return;
        }
        
        for (int i = 0; i < perm.length; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[index] = i;
                generatePermutations(perm, used, result, index + 1);
                used[i] = false;
            }
        }
    }

    private int calculateScore(int[] perm, int[] nums) {
        int score = 0;
        int n = perm.length;
        for (int i = 0; i < n; i++) {
            score += Math.abs(perm[i] - nums[perm[(i + 1) % n]]);
        }
        return score;
    }

    private int compare(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return a[i] - b[i];
            }
        }
        return 0;
    }
}