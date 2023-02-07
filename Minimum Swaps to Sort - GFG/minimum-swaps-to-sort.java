//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
       int arr[]=new int[nums.length];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],i);
        for(int i=0;i<nums.length;i++)
            arr[i]=nums[i];
        Arrays.sort(nums);
       
        int j=nums.length-1;
        int count=0;
        //17 5 6 7 9 14 16 3 18
       for(int i=0;i<=j;i++)
        {
            if(map.get(nums[i])==i)
                continue;
            else
            {
                int temp=map.get(nums[i]);
                int t=nums[i];
                nums[i]=nums[temp];
                nums[temp]=t;
                count++;
                
                i--;
            }
            
           
        }
        return count;
    }
}