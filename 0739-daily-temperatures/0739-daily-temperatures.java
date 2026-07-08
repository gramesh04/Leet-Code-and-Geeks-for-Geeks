/*
Approach:

1. I used a stack to store indices of temperatures.
2. For each temperature, I removed smaller temperatures from the stack.
3. While removing, I calculated the days needed to get a warmer temperature.
4. Then I added the current index to the stack.
5. Remaining indices have no warmer temperature ahead, so their answer is 0.

Time Complexity: O(n)
Space Complexity: O(n)
*/


class Solution{
    public int[] dailyTemperatures(int[] temperatures){
    int n=temperatures.length;
    int[] ans=new int[n];
    Stack<Integer> st=new Stack<>();
    for(int i=0;i<n;i++){
        while(!st.isEmpty()&&temperatures[i]>temperatures[st.peek()]){
        int idx=st.pop();
        ans[idx]=i-idx;
}
    st.push(i);
}
    return ans;
}
}