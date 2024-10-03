class Solution {
    public int minSubarray(int[] nums, int p) {
       long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        long remainder = totalSum % p;
        if (remainder == 0) {
            return 0;
        }

        HashMap<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, -1);

        long prefixSum = 0;
        int minLength = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % p;

            long target = (prefixSum - remainder + p) % p;

            if (prefixMap.containsKey(target)) {
                int subarrayLength = i - prefixMap.get(target);
                minLength = Math.min(minLength, subarrayLength);
            }

            prefixMap.put(prefixSum, i);
        }

        return minLength == nums.length ? -1 : minLength;
    }
}