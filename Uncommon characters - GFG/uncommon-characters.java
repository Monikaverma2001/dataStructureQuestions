//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    String UncommonChars(String A, String B)
    {
        int count1[]= new int[26];
        int count2[]=new int[26];
        
        for(int i=0;i<A.length();i++){
            count1[A.charAt(i)-'a']++;
        }
        
        for(int i=0;i<B.length();i++){
            count2[B.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<26;i++){
            if((count1[i]==0 && count2[i]!=0) || (count1[i]!=0 && count2[i]==0)){
                sb.append((char)('a'+i));
            }
        }
        return (sb.length()==0) ? "-1" : sb.toString();
        
    }
}

