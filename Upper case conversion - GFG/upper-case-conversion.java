//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String str = br.readLine();
                    Solution ob = new Solution();
                    System.out.println(ob.transform(str));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String transform(String s)
    {
        // code here
        StringBuilder str=new StringBuilder();
        boolean b=false;
        String cur=Character.toString(s.charAt(0));
        cur=cur.toUpperCase();
        str.append(cur);
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            {
                b=true;
                str.append(s.charAt(i));
            }
            else
            {
                if(b)
                {
                    b=false;
                    cur=Character.toString(s.charAt(i));
                    cur=cur.toUpperCase();
                    str.append(cur);
                }
                else
                {
                    str.append(s.charAt(i));
                }
            }
        }
        return str.toString();
    }
}