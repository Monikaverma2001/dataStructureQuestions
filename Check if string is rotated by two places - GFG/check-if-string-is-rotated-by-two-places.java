//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
        if(str1.length()>=2)
        {String shiftString = str1.substring(2,str1.length()) + str1.substring(0,2);
        String k =  str1.substring(str1.length()-2,str1.length())+str1.substring(0,str1.length()-2);
       // System.out.println(k);
        if(shiftString.equals(str2) || k.equals(str2)){
            return true;
        }
        else{
            return false;
        }}
        else{
            return str1.charAt(0)==str2.charAt(0);
        }
    }
    
}