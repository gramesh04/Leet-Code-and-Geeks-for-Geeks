class Solution {
    public boolean isPalindrome(String s) {
       StringBuilder sb = new StringBuilder();
       for(int i =0;i<s.length();i++){
        char ch = Character.toLowerCase(s.charAt(i));
        if(Character.isLetterOrDigit(ch)){
            sb.append(ch);
        }
       }
       String o = sb.toString();
       String r = new StringBuilder(o).reverse().toString();
    
        return o.equals(r);
    }
}