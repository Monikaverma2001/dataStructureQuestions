//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int N=sc.nextInt();
                    String S=sc.next();
                        
                    Solution obj = new Solution();
                    
                    
                    System.out.println(obj.CountPS(S,N));
                    
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountPS(String s, int N)
    {
         int count=0;
        for(int i=0;i<N;i++)
        {
           
           // System.out.println(s.substring(i,i+1));
            for(int j=i+1;j<s.length();j++)
            {
                
                 if(ispalindrome(s,i,j))
                {
                   // System.out.println(s.substring(i,j+1));
                     count++;
                }
            }
        }
       return count;
    }
        private static boolean ispalindrome(String s,int start,int end)
    {
        int i=start;
        int j=end;
       // System.out.println(s.substring(i,j+1));
        while(i<=j)
        {
            //System.out.println(s.charAt(i)+" "+s.charAt(j));
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}