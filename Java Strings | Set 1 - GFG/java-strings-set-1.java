//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine();
            String S2 = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.conRevstr(S1, S2));
        }
    }
}

// } Driver Code Ends


// User function template for Java

class Solution {
    static String conRevstr(String s1, String s2) {
        // code here
        return rev(s1+s2);
    }
    private static String rev(String s){
        StringBuilder str=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
        {
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}