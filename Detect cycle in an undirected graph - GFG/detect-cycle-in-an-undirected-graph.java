//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair<L, R> {
    L left;
    R right;

    Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && bfs(adj, i, -1, visited)) // call for each node (not joined graph)
                return true;
        }
        return false;
    }
       private boolean bfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean[] visited) {
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        visited[node] = true;
        que.offer(new Pair(node, parent));
        while (!que.isEmpty()) {
            node = que.peek().left;
            parent = que.peek().right;
            que.poll();
            for (int child : adj.get(node)) {
                if (parent == child)
                    continue;
                if (visited[child])
                    return true;
                visited[child] = true;
                que.offer(new Pair(child, node));
            }
        }
        return false;
    }
}