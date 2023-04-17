//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

// Position this line where user code will be pasted.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            //            String line = br.readLine();
            //            String[] a2 = line.trim().split("\\s+");
            //            int n =Integer.parseInt(a2[0]);
            //            int k =Integer.parseInt(a2[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            // ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans = ob.sumoflength(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    long sumoflength(long arr[], int n) {
        int j=0;
       long ans=(long)0;
       Map<Long,Integer> m=new HashMap<>();
       
       for(int i=0;i<n;i++)
       {
           if(!m.containsKey(arr[i]))
           {
               m.put(arr[i],0);
           }
           m.put(arr[i],m.get(arr[i])+1);
          
           while(m.get(arr[i])>1)
           {
                m.put(arr[j],m.get(arr[j])-1);
               j++;
           }
           long x=(long)(i-j+1);
           ans+=(x*(x+1))/2;
       }
       return ans;
    }
}
//  int j=0;
//       int ans=0;
//       unordered_map<int,int>m;
//       for(int i=0;i<n;i++)
//       {
//           m[arr[i]]++;
//           while(m[arr[i]]>1)
//           {
//               m[arr[j]]--;
//               j++;
//           }
//           int x=i-j+1;
//           ans+=(x*(x+1))/2;
//       }
//       return ans;