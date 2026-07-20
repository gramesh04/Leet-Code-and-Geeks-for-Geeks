class Solution{
    public int findCircleNum(int[][] a){
        int b=a.length,c=0;
        boolean[] d=new boolean[b];
        for(int e=0;e<b;e++){
            if(!d[e]){
                f(a,d,e,b);
                c++;
            }
        }
        return c;
    }
    void f(int[][] a,boolean[] b,int c,int d){
        b[c]=true;
        for(int e=0;e<d;e++){
            if(a[c][e]==1&&!b[e])f(a,b,e,d);
        }
    }
}