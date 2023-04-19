//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
   {
       boolean visited[]=new boolean[N];
     ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
     for(int i=0;i<N;i++)
      arr.add(new ArrayList<>());
      for(int i=0;i<N;i++)
      {
          for(int j=0;j<N;j++)
          {
              Arrays.fill(visited,false);
              dfs(graph,i,visited);
              if(visited[j]==true)
              arr.get(i).add(j,1);
              else
              arr.get(i).add(j,0);
          }
      }
       return arr;
   }
   void dfs(int [][]graph,int s,boolean visited[])
   {
       visited[s]=true;
       for(int i=0;i<graph.length;i++)
       {
        if(graph[s][i]==1)
        {
            if(visited[i]==false)
            dfs(graph,i,visited); 
        }
       }
   }
}