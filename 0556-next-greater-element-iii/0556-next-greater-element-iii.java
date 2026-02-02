class Solution {
    public int nextGreaterElement(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int i = s.length - 2, j = s.length - 1;

        while (i >= 0 && s[i] >= s[i + 1]) i--;
        if (i < 0) return -1;

        while (s[j] <= s[i]) j--;
        
        char tmp = s[i]; s[i] = s[j]; s[j] = tmp;
        
        for (int l = i + 1, r = s.length - 1; l < r; l++, r--) {
            tmp = s[l]; s[l] = s[r]; s[r] = tmp;
        }

        long res = Long.parseLong(new String(s));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
}
