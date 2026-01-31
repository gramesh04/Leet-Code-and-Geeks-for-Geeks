class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 1, j = 0; i < n;) {
            if (s.charAt(i) == s.charAt(j)) {
                arr[i++] = ++j;
            } else if (j > 0) {
                j = arr[j - 1];
            } else {
                arr[i++] = 0;
            }
        }
        int len = arr[n - 1];
        return len > 0 && n % (n - len) == 0;
    }
}
