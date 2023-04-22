//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class pair{
    int v, wt;
    
    pair(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
}
class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < m; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            adj.get(a).add(b);
            adj.get(b).add(a);
            
        }
        
        int dis[] = new int[n];
        for(int i = 0 ; i < n; i++){
            dis[i] = (int)1e9;
        }
        
        Queue<pair> pq = new LinkedList<>();
        pq.add(new pair(src, 0));
        dis[src] = 0;
        
        while(!pq.isEmpty()){
            int first = pq.peek().v;
            int sec = pq.peek().wt;
            
            pq.remove();
            
            for(int it : adj.get(first)){
                if(dis[it]  > sec+1){
                   
                    pq.add(new pair(it, sec+1));
                    dis[it] = sec+1;
                }
            }
        }
     for(int i = 0 ; i < n; i++){
        if(dis[i] == 1e9)
        dis[i] = -1;
    }
        return dis;
    }
}