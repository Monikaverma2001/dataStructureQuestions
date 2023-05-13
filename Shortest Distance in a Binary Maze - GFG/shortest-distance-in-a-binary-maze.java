//{ Driver Code Starts
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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

//DFS which donot give us efficient solution because we have to check each possible path put each efforts again and again
// class Solution {

//     int shortestPath(int[][] grid, int[] source, int[] destination) {

//         // Your code here
//         int distance[][]=new int[][];
//         for(int i=0;i<grid.length;i++)
//             Arrays.fill(distance[i],Integer.MAX_VALUE);
//         boolean vis[][]=new boolean[grid.length][grid[0].length];
//         int dis[]=new int[1];
//         dis[0]=Integer.MAX_VALUE;
//         shortestPath(grid, source[0],source[1], destination,dis,vis,0,distance);
//         return dis[0]==Integer.MAX_VALUE?-1:dis[0];
//     }
//     void shortestPath(int[][] grid, int i,int j, int[] destination,int dis[],boolean[][] vis,int cur) {
//         if(i<0 || j<0 || i==grid.length || j==grid[0].length|| grid[i][j]==0|| vis[i][j]==true)
//         {
//             return ;
//         }
//         if(i==destination[0] && j==destination[1])
//         {
//             dis[0]=Math.min(dis[0],cur);
//             return;
//         }
//         vis[i][j]=true;
        
//       shortestPath(grid, i+1,j, destination,dis,vis,cur+1);
//       shortestPath(grid, i,j+1, destination,dis,vis,cur+1);
//       shortestPath(grid, i-1,j, destination,dis,vis,cur+1);
//       shortestPath(grid, i,j-1, destination,dis,vis,cur+1);
//       vis[i][j]=false;
//     }
// }


// User function Template for Java
// class pair{
//     int dis,i,j;
//     pair(int d,int index, int job)
//     {
//         dis=d;
//         i=index;
//         j=job;
//     }
// }
// class Solution {

//     int shortestPath(int[][] grid, int[] source, int[] destination) {

//         // Your code here
//           if(grid[source[0]][source[1]]==0) {

//             return -1;

//         }
//         Queue<pair>q=new ArrayDeque<>();
//         int dist[][]=new int[grid.length][grid[0].length];
//         for(int i=0;i<grid.length;i++)
//         {
//             Arrays.fill(dist[i],Integer.MAX_VALUE);
//         }
//         int n=grid.length;
//         int m=grid[0].length;
//         boolean [][]vis=new boolean[n][m];
//         dist[source[0]][source[1]]=0;
//         if(source[0]==destination[0]&&source[1]==destination[1])
//             return dist[source[0]][source[1]];
            
//         q.offer(new pair(0,source[0],source[1]));
      
//         while(!q.isEmpty())
//         {
//             pair cur=q.remove();
//             if(cur.i==destination[0]&&cur.j==destination[1])
//                 return dist[cur.i][cur.j];
//             if(vis[cur.i][cur.j])
//                 continue;
//                 vis[cur.i][cur.j]=true;
//             if(cur.i+1<n && !vis[cur.i+1][cur.j] && grid[cur.i+1][cur.j]==1)
//             {
//                 q.offer(new pair(cur.dis+1,cur.i+1,cur.j));
//                 vis[cur.i+1][cur.j]=true;
//                 dist[cur.i+1][cur.j]=Math.min(cur.dis+1,dist[cur.i+1][cur.j]);
//             }
//             if(cur.i-1>=0 && !vis[cur.i-1][cur.j]&& grid[cur.i-1][cur.j]==1)
//             {
//                 q.offer(new pair(cur.dis+1,cur.i-1,cur.j));
//                 vis[cur.i-1][cur.j]=true;
//                 dist[cur.i-1][cur.j]=Math.min(cur.dis+1,dist[cur.i-1][cur.j]);
//             }
//             if(cur.j+1<m && !vis[cur.i][cur.j+1]&&grid[cur.i][cur.j+1]==1)
//             {
//                 q.offer(new pair(cur.dis+1,cur.i,cur.j+1));
//                 vis[cur.i][cur.j+1]=true;
//                 dist[cur.i][cur.j+1]=Math.min(cur.dis+1,dist[cur.i][cur.j+1]);
//             }
//             if(cur.j-1>=0 && !vis[cur.i][cur.j-1]&&grid[cur.i][cur.j-1]==1)
//             {
//                 q.offer(new pair(cur.dis+1,cur.i,cur.j-1));
//                 vis[cur.i][cur.j-1]=true;
//                 dist[cur.i][cur.j-1]=Math.min(cur.dis+1,dist[cur.i][cur.j-1]);
//             }
//         }
//         return -1;
//     }
// }





 class Pair{
    int a, b, c;
    Pair(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
}

class Solution {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
    int[][] temp=new int[grid.length][grid[0].length];
        Queue<Pair> st1=new LinkedList<>();
        st1.add(new Pair(source[0],source[1],1));
        temp[source[0]][source[1]]=-1;

        if(source[0]==destination[0]  && source[1]==destination[1])return 0;
        while(!st1.isEmpty()){
            Pair pp=st1.peek();
            int a=pp.a;
            int b=pp.b;
            int c=pp.c;

            int[][] arr={{1,0},{-1,0},{0,1},{0,-1}};
            for(int i=0; i<4; i++){
                int A=a+arr[i][0];
                int B=b+arr[i][1];

                if(A>=0 && B>=0 && B<grid[0].length && A<grid.length && grid[A][B]==1&& temp[A][B]!=-1){
                    st1.add(new Pair(A,B,c+1));
                    temp[A][B]=-1;
                    if(destination[0]==A && destination[1]==B){
                        return c;
                    }
                }
            }
            st1.remove();
        }
        return -1;
    }
}






