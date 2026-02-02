class Solution {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) for (int j = num2.length() - 1; j >= 0; j--) {
            int p = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res[i + j + 1];
            res[i + j + 1] = p % 10;
            res[i + j] += p / 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int v : res) if (sb.length() > 0 || v > 0) sb.append(v);
        return sb.toString();
    }
}
