//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    
     ArrayList<ArrayList<Integer>> res=new ArrayList<>();
     ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        
        Collections.sort(A);
        helper(A,0,new ArrayList<>(),B);
        
        return res;
    }
    
    
     void helper(ArrayList<Integer> A,int start,ArrayList<Integer> temp,int B)
    {
        
        if(B==0 )
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=start;i<A.size();i++)
        {
           if(A.get(i)>B)return; //It is sorted if one value is greater than B all values infront of it will be greater
          if(i>0 && A.get(i)==A.get(i-1))continue; // To avoid same value repetition.
           
           temp.add(A.get(i));
           helper(A,i,temp,B-A.get(i));
           temp.remove(temp.size()-1);
        }

         
    }
}
    