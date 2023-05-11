//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean[] vis = new boolean[adj.size()];
        int[] dist = new int[adj.size()];
        
        for(int i =0; i< dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[S] = 0;
        Pair p = new Pair(S,dist[S]);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(p);
        
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(vis[curr.node] != true){
                vis[curr.node] = true;
                for(int i =0; i< adj.get(curr.node).size(); i++){
                    int neighbour = adj.get(curr.node).get(i).get(0);
                    int weight  = adj.get(curr.node).get(i).get(1);
                    if(dist[neighbour] > dist[curr.node] + weight){
                        dist[neighbour] = dist[curr.node] + weight;
                    }
                    pq.add(new Pair(neighbour, dist[neighbour]));
                }
            }
        }
        return dist;
        
        
        
    }
}
public class Pair implements Comparable<Pair>{
    int node;
    int dist;
    
    public Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Pair p2){
        return this.dist - p2.dist;
    }
}