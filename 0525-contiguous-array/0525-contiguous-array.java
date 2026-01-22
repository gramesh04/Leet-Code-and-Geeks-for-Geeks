class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] map = new int[2 * n + 1];
        java.util.Arrays.fill(map, -2);
        map[n] = -1;
        
        int maxLen = 0;
        int count = n;

























        
        
        for (int i = 0; i < n; i++) {
            count += (nums[i] << 1) - 1;
            if (map[count] >= -1) {
                maxLen = Math.max(maxLen, i - map[count]);
            } else {
                map[count] = i;
            }
        }
        
        return maxLen;
    }
}