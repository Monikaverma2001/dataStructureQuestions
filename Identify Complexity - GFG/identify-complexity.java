//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            obj.TimeComplexity(n);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static void TimeComplexity(int n) {
        switch(n)
        {
            case 1:
                {
                    System.out.println("logn");
                    break;
                }
            case 2:
                {
                    System.out.println("nlogn");
                    break;
                }
            case 3:
                {
                    System.out.println("n^2");
                    break;
                }
            case 4:
               {
                    System.out.println("n^2");
                    break;
                }
        }
    }
}
        
