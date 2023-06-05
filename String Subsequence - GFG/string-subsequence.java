//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            String S1 = in.readLine();
            String S2 = in.readLine();
            Solution ob = new Solution();
            System.out.println( ob.countWays(S1,S2) );
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countWays(String S1, String S2) { 
        // code here 
        int n=S1.length();
        int m=S2.length();
        return helper(S1,S2,n-1,m-1);
        
    }
    int helper(String s1, String s2, int i, int j){
        if(j==-1)return 1;
        if(i==-1)return 0;
        
        if(s1.charAt(i)==s2.charAt(j)){
            return helper(s1,s2,i-1,j-1)+helper(s1,s2,i-1,j);
        }
        else{
            return helper(s1,s2,i-1,j);
        }
    }
}