//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int n, k;
            n = Integer.parseInt(S1[0]);
            k = Integer.parseInt(S1[1]);
            int[] nums = new int[n];
            for(int i = 0; i < S2.length; i++)
                nums[i] = Integer.parseInt(S2[i]);
            Solution ob = new Solution();
            int ans = ob.TotalPairs(nums, k);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalPairs(int[] nums, int k)
    {
        // Code here 
        int i = 0;
        int j = 1;
        int count = 0;
        Arrays.sort(nums);//3
        //1i 1 2 2 3j 3 3 4 4 9
           while(i<nums.length-1 && j<nums.length){
            if(i==j)j++;
            if(i!=j && (nums[j]-nums[i]==k)){
                count++;
                while(i<nums.length-1 && j<nums.length-1 && nums[j]==nums[j+1])
                    j++;
                j++;
                while(i<nums.length-1 && j<nums.length&&nums[i]==nums[i+1])
                    i++;
                i++;
            }
            else if(i<nums.length-1 && j<nums.length&&nums[j]-nums[i]<k){
                while(i<nums.length-1 && j<nums.length-1 &&nums[j]==nums[j+1])
                    j++;
                j++;
            }
            else{
                while(i<nums.length-1 && j<nums.length&&nums[i]==nums[i+1])
                    i++;
                i++;
            }
        }

        return count;
    }
}