 class Solution {
 	public int findJudge(int N, int[][] trust) {
 		int[] indegree = new int[N + 1];
 		int[] outdegree = new int[N + 1];
 		for(int[] t : trust){
 			indegree[t[1]]++;
 			outdegree[t[0]]++;
 		}
 		int res = -1;
 		for(int i = 1; i <= N; i++){
 			if(indegree[i] == N - 1 && outdegree[i] == 0){
 				if(res != -1) return -1;
 				else res = i;
 			}
 		}
 		return res;
 	}
 }