//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java



class Solution{
        int celebrity(int m[][], int n){

        int ans=-1;

     for(int i=0; i<n; i++){

         int j=0;

         for(j=0; j<n; j++)if(m[i][j]==1)break;

            if(j==n){

                if(ans==-1)ans=i;

                else return -1;

            }

     }return ans;

    }
}



// class Solution
// { 
//     //Function to find if there is a celebrity in the party or not.
//     int celebrity(int arr[][], int n)
//     {
//     	// code here 
//     	int count=0;
//     	int index=-1;
//     	boolean vis[]=new boolean[n];
//     	for(int i=0;i<n;i++)
//     	{
//     	    for(int j=0;j<n;j++)
//     	    {
//     	        if(arr[i][j]==1&&vis[j]==false)
//     	        {
//     	            vis[j]=true;
//     	        if(check(n,j,arr))
//     	        {
//     	            index=j;
//     	           count++;
//     	        }
//     	        }
//     	    }
//     	}
//     	return count==1?index:-1;
//     }
//     private static boolean check(int n,int j,int[][] arr)
//     {
//       for(int d=0;d<n;d++)
//       {
//           if(d!=j)
//           if(arr[d][j]==0)
//             return false;
//       }
//       return true;
//     }
// }