//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private static boolean palindrome(String str)
    {
        int i=0,j=str.length()-1;
        while(i<=j)
        {
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ArrayList<String> palindrome=new ArrayList<String>();
        ArrayList<ArrayList<String>>  result=new ArrayList<>();
        BackTrack(palindrome,result,S,0,"");
        return result;
    }
    private static void BackTrack(ArrayList<String> pal,ArrayList<ArrayList<String>>  result,String s,int index,String str)
    {
       str+=s.charAt(index);
       if(index==s.length()-1)
       {
           if(palindrome(str))
           {
               pal.add(str);
               result.add(new ArrayList<String>(pal));
               pal.remove(pal.size()-1);
           }
           return;
       }
       if(palindrome(str)&&str.length()>0)
       {
           pal.add(str);
           BackTrack(pal,result,s,index+1,"");
           pal.remove(pal.size()-1);
          
       }
       
       BackTrack(pal,result,s,index+1,str);
    }
};