//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int color[]=new int[n];
        return col(graph,m,n,color,0);
    }
    private static boolean col(boolean graph[][],int m,int n,int[] color,int index){
        if(index>=n)
            return true;
            
        for(int i=1;i<=m;i++)
        {
            if(possible(graph,m,n,color,index,i))
            {
                color[index]=i;
                if(col(graph,m,n,color,index+1))
                {
                    return true;
                }
                else
                color[index]=0;
            }
           
        }
        return false;
    }
    private static boolean possible(boolean graph[][],int m,int n,int[] color,int index,int col)
    {
        for(int i=0;i<n;i++)
        {
            if(graph[index][i]==true)
            {
                if(color[i]==col)
                    return false;
            }
        }
        return true;
    }
}