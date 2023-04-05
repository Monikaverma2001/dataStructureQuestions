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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class pair{

    int row;

    int col;

    int tm ;

    pair(int row, int col, int tm){

        this.row=row;

        this.col=col;

        this.tm =tm;

    }

}

class Solution

{

    //Function to find minimum time required to rot all oranges. 

    public int orangesRotting(int[][] grid)

    {

         Queue<pair> q = new LinkedList<>();

        int [][] vis= new int[grid.length][grid[0].length];

        for(int i =0; i<grid.length; i++){

            for(int j =0; j<grid[0].length; j++){

                if(grid[i][j]==2){

                    vis[i][j]=2;

                    q.add(new pair(i,j,0));

                }

            }

        }

        int tm =0; // to find time max 

        int [] delrow={-1,1,0,0};

        int [] delcol ={0,0,-1,1};

        while(q.size()>0){

            int row=q.peek().row;

            int col = q.peek().col;

            int t = q.peek().tm;

             tm =Math.max(tm,t);

            q.remove();

            for(int i =0;i<4; i++){

                int newrow=row+delrow[i];

                int newcol =col+delcol[i];

                if(newrow>=0 && newcol>=0 && newrow<grid.length && newcol<grid[0].length

                && vis[newrow][newcol]!=2 && grid[newrow][newcol]==1 ){

                    q.add(new pair(newrow,newcol,t+1));

                    vis[newrow][newcol]=2;

                }

                

            }

        }

        for(int i =0; i<grid.length; i++){

            for(int j =0; j<grid[0].length; j++){

                if(grid[i][j]==1 && vis[i][j]!=2){

                    return -1;

                }

            }

        }

       return tm; 

    }

}