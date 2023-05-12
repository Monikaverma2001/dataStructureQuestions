//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Pair implements Comparable<Pair>{
    int src;
    int wt;
    
    public Pair(int src, int wt){
        this.src = src;
        this.wt = wt;
    }
    public int compareTo(Pair pair){
        return this.wt - pair.wt;
    }

}

class Node{
    
    int dest;
    int cost;
    
    public Node(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
    
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        int memo[] = new int[n+1];
        int distance[] = new int[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= n ; i++){
            graph.add(new ArrayList<Node>());
        }
        
        for(int arr[] : edges){
            graph.get(arr[0]).add(new Node(arr[1], arr[2]));
            graph.get(arr[1]).add(new Node(arr[0], arr[2]));
        }
        
        for(int j = 0; j <= n; j++){
            memo[j] = j;
            distance[j] = (int)1e8;
        }
     
        pq.add(new Pair(1, 0));
        distance[1] = 0;
        
        //getting the shortest cost to reach the path
        while(pq.size() > 0 ){
            
            Pair pair = pq.remove();
            int src = pair.src;
            int wt = pair.wt;
            
            ArrayList<Node> list = graph.get(src);
            for(Node node : list){
                int dest = node.dest;
                int cost = node.cost;
                if(wt + cost < distance[dest]){
                    distance[dest] = wt + cost;
                    memo[dest] = src;
                    pq.add(new Pair(dest, distance[dest]));
                }
            }
            
        }
            
        List<Integer> ans = new ArrayList<>();
        int temp = (int)1e8;
        if(distance[n] == temp){
            ans.add(-1);
            return ans;
        }
        int lastVertex = n;
        ans.add(n);
        while(memo[lastVertex] != 1){
            ans.add(memo[lastVertex]);
            lastVertex = memo[lastVertex];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;  
    }
}