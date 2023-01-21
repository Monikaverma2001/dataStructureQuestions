//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    //55,6
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        int i=N-1;
        for(i=N-2;i>=0;i--)
        {
           if(arr[i+1]>arr[i])
           {
               break;
           }
        }
        int d=N-1;
         if(i>=0){
        while(d>i)
        {
            if(arr[i]<arr[d])
            {
                int temp=arr[i];
                arr[i]=arr[d];
                arr[d]=temp;
               break;
            }
            d--;
           
        }
        i++;
       d=N-1;
        reverse(arr,i,d);
         }
       else
            reverse(arr,0,N-1);
        // if(d==i)
        // {
        //     Arrays.sort(arr);
        // }
        List<Integer> lyst=new ArrayList<>();
        for(int k=0;k<N;k++)
        {
            lyst.add(arr[k]);
        }
        return lyst;
    }
    private static void reverse(int[] arr,int s,int n)
    {
        int i=s;
        int d=n;
        while(i<d)
        {
            int temp=arr[i];
                arr[i]=arr[d];
                arr[d]=temp;
                i++;
                d--;
        }
    }
}