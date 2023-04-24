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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int[][] ans=new int[image.length][image[0].length];
        boolean[][] vis=new boolean[image.length][image[0].length];
        int color=image[sr][sc];
        for(int i=0;i<image.length;i++)
        {
            for(int j=0;j<image[0].length;j++)
            {
                if(vis[i][j]==false && image[i][j]==color && i==sr&&j==sc)
                {
                
                    dfs(ans,i,j,vis,image,image[i][j],newColor);
                }
               
            }
        }
        for(int i=0;i<image.length;i++)
        {
            for(int j=0;j<image[0].length;j++)
            {
                if(vis[i][j]==false)
                {
                
                    ans[i][j]=image[i][j];
                }
               
            }
        }
        
        return ans;
    }
    private void dfs(int ans[][],int i,int j,boolean[][] vis,int[][] image,int c,int n)
    {
        if(i<0 || j<0|| i==image.length|| j==image[0].length || image[i][j]!= c || vis[i][j]==true)
            return ;
            
        vis[i][j]=true;
        ans[i][j]=n;
            
        dfs(ans,i+1,j,vis,image,c,n);
        dfs(ans,i,j+1,vis,image,c,n);
        dfs(ans,i-1,j,vis,image,c,n);
        dfs(ans,i,j-1,vis,image,c,n);
    }
}