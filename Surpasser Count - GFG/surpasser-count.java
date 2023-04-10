//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            int[] ans = new Solution().findSurpasser(arr, n);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution

{

    int[] findSurpasser(int[] arr, int n) 

    {

        // code here

        int ans[] = new int[n];

        int x=n-2;

        ArrayList<Integer> list = new ArrayList<>();

        list.add(arr[n-1]);

        for(int i=n-2; i>=0; i--)

        {

            int idx  = dfs(list,arr[i],0,list.size()-1);

            list.add(idx,arr[i]);

            ans[x] = idx;

            x--;

        }

        return ans;

    }

    int dfs(ArrayList<Integer> list,int key,int l,int h)

    {

        if(l<=h)

        {

            int mid = l+(h-l)/2;

            if(list.get(mid)>=key)

            return dfs(list,key,mid+1,h);

            else

            return dfs(list,key,l,mid-1);

        }

        return l;

    }

 

}
