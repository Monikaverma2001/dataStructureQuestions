//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minStep(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minStep(int n){
        //we have to find minimum steps
        //so, first priority is to divide the steps by 3
        //if it is not divisible by 3, then we minus 1 from step
        int step=0;
        while(n>1){
            //fist priority is to divide the steps by 3
            if(n%3==0){
                n = n/3;
                step++;
            }
            else{
                //if it is not divided,then we minus 1 from step
                n = n-1;
                step++;
            }
        }
        return step;
    }
}
