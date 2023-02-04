//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[] a = new int[n], b = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine[i]);
            }

            ArrayList<Integer> ans = new Solution().findSum(a, b);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    private static void reverse(int arr[])
    {
        int i=0;
        int j=arr.length-1;
        while(i<j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
            
        }
    }
    ArrayList<Integer> findSum(int a[], int b[]) {
        // code here
int ans[]=new int[Math.max(a.length,b.length)];
        int carry=0;
        reverse(a);
        reverse(b);
        for(int i=0;i<Math.max(a.length,b.length);i++)
        {
            int v1=0,v2=0;
            if(i<a.length)
            {
                v1=a[i];
            }
            if(i<b.length)
            {
                v2=b[i];
            }
            int v=v1+v2+carry;
             carry=v/10;
            v=v%10;
            ans[i]=v;
        }
       
        ArrayList<Integer> arr=new ArrayList<>();
         if(carry>0)
        {
          arr.add(carry);
        }
        reverse(ans);
        for(int i=0;i<ans.length;i++)
        {
            arr.add(ans[i]);
        }
        return arr;
    }
}