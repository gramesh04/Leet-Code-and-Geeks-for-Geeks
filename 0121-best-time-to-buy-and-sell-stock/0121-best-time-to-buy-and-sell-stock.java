class Solution{
    public int maxProfit(int[] prices){
        int m=prices[0],p=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<m)m=prices[i];
            else p=Math.max(p,prices[i]-m);
        }
        return p;
    }
}