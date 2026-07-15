class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int x : nums) {
            low = Math.max(low, x);
            high += x;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int parts = 1;
        int sum = 0;
        for (int x : nums) {
            if (sum + x > maxSum) {
                parts++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return parts <= k;
    }
}