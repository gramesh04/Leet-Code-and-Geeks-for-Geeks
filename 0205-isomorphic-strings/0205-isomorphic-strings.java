class Solution {
  public boolean isIsomorphic(String s, String t) {
    int[] sMap = new int[256], tMap = new int[256];
    for (int i = 0; i < s.length(); i++) {
        if (sMap[s.charAt(i)] != tMap[t.charAt(i)]) return false;
        sMap[s.charAt(i)] = tMap[t.charAt(i)] = i + 1;
    }
    return true;
}
}