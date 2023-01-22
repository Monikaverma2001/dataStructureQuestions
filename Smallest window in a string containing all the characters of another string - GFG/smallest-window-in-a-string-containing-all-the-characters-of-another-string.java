//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends
class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
     public static String smallestWindow(String s, String p){
        HashMap<Character,Integer> h=new HashMap<>();
        for(int i=0; i<p.length(); i++){
            char c=p.charAt(i);
            if(!h.containsKey(c))
            h.put(c,1);
            else
            h.put(c,h.get(c)+1);
        }
        HashMap<Character,Integer> m=new HashMap<>();
        int c=0; int j=0; String ans=s;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            //acquire--m
            if(h.containsKey(ch))
            {
                if(!m.containsKey(ch)){
                    m.put(ch,1);
                }else{
                    m.put(ch,m.get(ch)+1);
                }
                if(h.get(ch)==m.get(ch))
                    c++;
            }
            if(c==h.size()){//release
            while( !h.containsKey(s.charAt(j)) || h.get(s.charAt(j))<m.get(s.charAt(j))){
               char cc=s.charAt(j);
                if(m.containsKey(cc)){
                    m.put(cc,m.get(cc)-1);
                }
                j++;
                // System.out.println(ans.length()+" "+(i-j+1));
                if(ans.length()>i-j+1)
                    ans=s.substring(j,i+1);
                }
                if(ans.length()>i-j+1)
                    ans=s.substring(j,i+1);
            }
        }
        if(c!=h.size())
                return "-1";
        return ans;
        }
}