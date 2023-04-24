//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair {
    int row;
    int col;
    int time;
    public Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution
{   

    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {   
        boolean visited[][] = new boolean[N][N];
        int chess[][] = new int[N][N];
        int initrow = KnightPos[0]-1;
        int initcol = KnightPos[1]-1;
        int tarrow = TargetPos[0]-1;
        int tarcol = TargetPos[1]-1;
        
        if(initrow == tarrow && initcol == tarcol) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        
        int [] deltarow ={-2, -1, 1, 2, -2, -1, 1, 2};
        int [] deltacol={-1, -2, -2, -1, 1, 2, 2, 1};
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(initrow, initcol, 0));
        visited[initrow][initcol] = true;
        while(q.isEmpty() == false) {
            int row = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().time;
            if(row == tarrow && col == tarcol) {
                res = Math.min(res, time);  
            }
            q.remove();
            
            for(int i=0; i<8; i++) {
                int nrow = row + deltarow[i];
                int ncol = col + deltacol[i];
                if(nrow>= 0 && nrow<N && ncol>= 0 && ncol<N && visited[nrow][ncol] == false) {
                    visited[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol, time+1));
                }
            }
        }
        
        return res;
    }
}

// class Solution
// {
//     class pair{
//         int i,j,step;
//         pair(int sr,int sc,int s)
//         {
//             i=sr;
//             j=sc;
//             step=s;
//         }
//     }
//     //Function to find out minimum steps Knight needs to reach target position.
//     public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
//     {
//         // Code here
//         Queue<pair> q=new ArrayDeque<>();
//         q.offer(new pair(KnightPos[0]-1,KnightPos[1]-1,0));
//         boolean[][] vis=new boolean[N][N];
//         vis[KnightPos[0]-1][KnightPos[1]-1]=true;
//         int min=Integer.MAX_VALUE;
        
//         while(!q.isEmpty())
//         {
//             int i=q.peek().i;
//             int j=q.peek().j;
//             int step=q.peek().step;
            
//              if(i==TargetPos[0]-1 && j==TargetPos[1]-1)
//                 min=Math.min(min,step);
                
//             q.remove();
            
//             if(i-2>=0 && j-1>=0 && vis[i-2][j-1]==false)
//             {
//                 vis[i-2][j-1]=true;
//                 q.offer(new pair(i-2,j-1,step+1));
//             }
//             if(i-2>=0 && j+1<N && !vis[i-2][j+1])
//             {
//                 vis[i-2][j+1]=true;
//                 q.offer(new pair(i-2,j+1,step+1));
//             }
            
//             if(j+2<N && i+1<N && !vis[j+2][i+1])
//             {
//                 vis[j+2][i+1]=true;
//                 q.offer(new pair(j+2,i+1,step+1));
//             }
//             if(j+2<N && i-1>=0 && !vis[j+2][i-1])
//             {
//                 vis[j+2][i-1]=true;
//                 q.offer(new pair(j+2,i-1,step+1));
//             }
            
//             if(i+2<N && j+1<N && !vis[i+2][j+1])
//             {
//                 vis[i+2][j+1]=true;
//                 q.offer(new pair(i+2,j+1,step+1));
//             }
//             if(i+2<N && j-1>=0 && !vis[i+2][j-1])
//             {
//                 vis[i+2][j-1]=true;
//                 q.offer(new pair(i+2,j-1,step+1));
//             }
            
//             if(j-2>=0 && i-1>=0 && !vis[j-2][i-1])
//             {
//                 vis[j-2][i-1]=true;
//                 q.offer(new pair(j-2,i-1,step+1));
//             }
//             if(j-2>=0&& i+1<N && !vis[j-2][i+1])
//             {
//                 vis[j-2][i+1]=true;
//                 q.offer(new pair(j-2,i+1,step+1));
//             }
            
            
             
//         }
//         return min;
//     }
// }