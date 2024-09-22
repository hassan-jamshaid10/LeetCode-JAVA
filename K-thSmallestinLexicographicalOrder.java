class Solution {
    public int findKthNumber(int n, int k) {
   int current = 1;
        k--; 

        while (k > 0) {
            long count = getCount(current, n); 
            if (count <= k) {
                current++;
                k -= count;
            } else {
          
                current *= 10;
                k--; 
            }
        }

        return current;
    }

    private long getCount(int prefix, int n) {
        long count = 0;
        long current = prefix;
        long next = prefix + 1;
        while (current <= n) {
            count += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        return count;
    }
}