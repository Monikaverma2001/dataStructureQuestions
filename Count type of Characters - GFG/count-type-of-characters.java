//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		int[] res = new Sol().count (s);
    		
    		for (int i = 0; i < 4; i++)
    		    System.out.println (res[i]);
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int[] count (String s)
    {
        // your code here      
        int ans[]=new int[4];
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
                ++ans[1];
            else if(s.charAt(i)>='A' && s.charAt(i)<='Z')
                ++ans[0];
            else if(s.charAt(i)>='0' && s.charAt(i)<='9')
                ++ans[2];
            else 
                ++ans[3];
        }
        return ans;
    }
}