//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int sum=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            check(grid,vis,i,0,n,m);
        }
        for(int i=0;i<m;i++)
        {
            check(grid,vis,0,i,n,m);
        }
        for(int i=0;i<m;i++)
        {
            check(grid,vis,n-1,i,n,m);
        }
        for(int i=0;i<n;i++)
        {
            check(grid,vis,i,m-1,n,m);
        }
        for(int i=1;i<n-1;i++)
        {
            for(int j=1;j<m-1;j++)
            {
                if(vis[i][j]==false && grid[i][j]==1 )
                    sum++;
            }
        }
        return sum;
    }
    private static void check(int[][] g,boolean vis[][],int start,int end,int n,int m)
    {
        if(start<0 || end<0 || start==n || end==m || g[start][end]==0 || vis[start][end]==true)
            return;
        vis[start][end]=true;
        check(g,vis,start-1,end,n,m);
        check(g,vis,start+1,end,n,m);
        check(g,vis,start,end-1,n,m);
        check(g,vis,start,end+1,n,m);
    }
}