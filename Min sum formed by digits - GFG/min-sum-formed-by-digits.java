//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.minSum(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public static long minSum(int arr[], int n)
    {
        // Your code goes here
        Arrays.sort(arr,0,n);
        long num1=0,num2=0;
        long decimal=10;
        
       for(int i=0;i<n-1;i++)
       {
           num1=(num1*decimal)+(long)arr[i];
           num2=(num2*decimal)+(long)arr[i+1];
           
          //System.out.println(num1+" "+num2+" "+decimal+" "+arr[i]+" "+arr[i+1]);
          // decimal*=10;
           i++;
       }
       if(n%2!=0)
       {
          num1=(num1*decimal)+(long)arr[n-1];
          
       }
       return (num1+num2);
    }
}