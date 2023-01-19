//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String s){
        int[] a=new int[256];
        int max=0;
        int count=0;
        Arrays.fill(a,-1);
        for(int i=0;i<s.length();i++)
            {
                if(a[s.charAt(i)-' ']!=-1)
                {
                    if(i-a[s.charAt(i)-' ']<=count)
                        count=i-a[s.charAt(i)-' '];
                    else
                        count++;
                }
                else
                {
                    count++;
                }
                a[s.charAt(i)-' ']=i;
                max=Math.max(count,max);
            }
         return max; 
    }
}