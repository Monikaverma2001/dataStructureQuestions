//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<List<String>> Anagrams(String[] strs) {
        List<List<String>> str=new ArrayList<List<String>>();
        boolean b[]=new boolean[strs.length];
        for(int i=0;i<strs.length;i++)
        {
            
            boolean f1=false;//list bni h
            List<String> val=new ArrayList<String>();
            if(!b[i]){
            val.add(strs[i]);
            f1=true;
            }
            
            for(int j=i+1;j<strs.length && b[i]==false;j++)
            {
                if(b[j]==false && isAnagram(strs[i],strs[j]))
                {
                    b[j]=true;
                    val.add(strs[j]);
                }
            }
            b[i]=true;
            if(f1 )
            str.add(val);
        }
        return str;
    }
     private static boolean isAnagram(String s1,String s2)
    {
        if(s1.length()!=s2.length())
        {
            return false;
        }
        int word[]=new int[26];
        
        for(int i=0;i<s1.length();i++)
        {
           ++ word[s1.charAt(i)-'a'];
           -- word[s2.charAt(i)-'a'];
        }
         for(int i=0;i<26;i++)
        {
          if(word[i]!=0)
          {
              return false;
          }
        }
        return true;
    }
}
