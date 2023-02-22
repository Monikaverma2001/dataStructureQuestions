//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{
    boolean dfs(ArrayList<ArrayList<Integer>> graph,int src,int count,int N, boolean [] visited){
        //if we traverse all the vertex then count must be equal to number of vertices(N)
        if(count==N){
            return true;
        }
        //mark the visited
        visited[src]=true;
        //call for their neighbours
        for(int nbr:graph.get(src)){
            if(visited[nbr]==false){
                //if any nbr has a hamiltonian path then we return true
                boolean ans = dfs(graph,nbr,count+1,N,visited);
                if(ans) return true;
            }
        }
        //for another path
        visited[src]=false;
        //no any nbr has a hamiltonian path then we return false
        return false;
    }
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0;i<=N;i++)graph.add(new ArrayList<>());
        for(ArrayList<Integer> list : Edges){
            int u = list.get(0);
            int v = list.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        //to track the record of visited vertices
        boolean [] visited = new boolean[N+1];
        for(int i=1;i<N;i++){
            boolean ans = dfs(graph,i,1,N,visited);
            if(ans)return true;
        }
        return false;
    }
} 
 