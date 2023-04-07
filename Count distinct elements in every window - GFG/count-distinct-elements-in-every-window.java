//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        // code here
        ArrayList<Integer> ans=new ArrayList<Integer>();
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<k;i++)
        {
            if(!map.containsKey(arr[i]))
            {
                count++;
                map.put(arr[i],1);
            }
            else
            {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        ans.add(count);
        int j=0;
        
        for(int i=k;i<n;i++)
        {
            map.put(arr[j],map.get(arr[j])-1);
            
            if(map.get(arr[j])==0)
            {
                count--;
            }
           
            if(map.containsKey(arr[i])&&map.get(arr[i])>=1)
            {
                
                map.put(arr[i],map.get(arr[i])+1);
            }
            else
            {
                count++;   
                map.put(arr[i],1);
            }
            j++;
           
            ans.add(count);
            
        }
        return ans;
    }
}

