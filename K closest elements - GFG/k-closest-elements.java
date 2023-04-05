//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        int i=0;
        for(i=0;i<n-1;i++)
        {
            if(arr[i]>=x)
                break;
        }
        int ans[]=new int[k];
        int j=i-1,m=i;
        if(arr[i]==x)
        {
            
            m+=1;
        }
        int index=0;
        while(j>=0&&m<=n-1&&index<k)
        {
            if(j>=0&&m<=n-1)
            {
                int a=Math.abs(arr[j]-x);
                int b=Math.abs(arr[m]-x);
                if(a<b)
                {
                    ans[index]=arr[j];
                    j--;
                }
                else
                {
                    ans[index]=arr[m];
                    m++;
                }
                index++;
            }
        }
        while(index<k&&j>=0)
        {
             ans[index]=arr[j];
                j--;
                index++;
        }
         while(index<k&&m<n)
        {
             ans[index]=arr[m];
               m++;
                index++;
        }
        return ans;
    }
}
