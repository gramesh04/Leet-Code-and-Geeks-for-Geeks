class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }
    void backtrack(int[] nums, int i, List<Integer> cur) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);              
        backtrack(nums, i + 1, cur);
        cur.remove(cur.size() - 1);    
        backtrack(nums, i + 1, cur);
    }
}