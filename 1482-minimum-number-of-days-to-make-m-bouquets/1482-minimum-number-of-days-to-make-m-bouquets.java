class Solution{
    public int minDays(int[] bloomDay,int m,int k){
        if((long)m*k>bloomDay.length)return -1;
        int l=Integer.MAX_VALUE,r=Integer.MIN_VALUE;
        for(int d:bloomDay){
            l=Math.min(l,d);
            r=Math.max(r,d);
        }
        while(l<r){
            int mid=l+(r-l)/2;
            int b=0,c=0;
            for(int d:bloomDay){
                if(d<=mid){
                    c++;
                    if(c==k){
                        b++;
                        c=0;
                    }
                }else c=0;
            }
            if(b>=m)r=mid;
            else l=mid+1;
        }
        return l;
    }
}