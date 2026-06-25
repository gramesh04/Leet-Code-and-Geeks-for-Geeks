class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length() != t.length()){
        return false;
       
       } 
       else{
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        return Arrays.equals(tchar,schar);
       }
    }
}