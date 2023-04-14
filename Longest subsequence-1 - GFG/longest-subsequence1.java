//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubsequence(N, A));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubsequence(int N, int arr[])
    {
        // code here
        Map<Integer,Integer> map=new HashMap<>();
        int max=1;
        for(int i=0;i<N;i++)
        {
            int len=1;
            if(map.containsKey(arr[i]-1))
            len=Math.max(len,map.get(arr[i]-1)+1);
            if(map.containsKey(arr[i]+1))
            len=Math.max(len,map.get(arr[i]+1)+1);
            
             map.put(arr[i],len);
            max=Math.max(max,len);
        }
        return max;
    }
}