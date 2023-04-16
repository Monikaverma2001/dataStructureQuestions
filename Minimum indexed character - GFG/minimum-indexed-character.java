//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to find the minimum indexed character.
    public static int minIndexChar(String str, String patt)
    {
        // Your code here
        int ans=Integer.MAX_VALUE;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            if(!map.containsKey(str.charAt(i)))
            {
                map.put(str.charAt(i),i);
            }
        }
        for(int i=0;i<patt.length();i++)
        {
            if(map.containsKey(patt.charAt(i)))
            {
                ans=Math.min(ans,map.get(patt.charAt(i)));
                
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    t--;
		    
		    String s1=sc.next();
		    String s2=sc.next();
		    
		    int res = new Solution().minIndexChar(s1, s2);
		    System.out.println(res);
		}
	}
}

// } Driver Code Ends