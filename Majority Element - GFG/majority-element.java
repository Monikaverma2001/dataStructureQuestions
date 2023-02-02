//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        int cur=-1;
        int count=0;
        for(int i=0;i<size;i++)
        {
            if(count==0)
            {
                cur=a[i];
                count=1;
            }
            else
            {
                if(cur==a[i])
                    count++;
                else
                    count--;
            }
        }
        int n=0;
        for(int i=0;i<size;i++)
        {
            if(cur==a[i])
                n++;
        }
        return n>size/2?cur:-1;
    }
}