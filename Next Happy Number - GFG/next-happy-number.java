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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
// The numbers that, when you repeatedly sum the squares of their digits, eventually result in 1 are known as "happy numbers." Let's find the numbers less than 10 that satisfy this condition:

// Starting with the number 1:

// 1^2 = 1
// Since we have already reached 1, the process stops here. 1 is a happy number.
// Starting with the number 2:

// 2^2 = 4
// 4^2 = 16
// 1^2 + 6^2 = 37
// 3^2 + 7^2 = 58
// 5^2 + 8^2 = 89
// 8^2 + 9^2 = 145
// 1^2 + 4^2 + 5^2 = 42
// 4^2 + 2^2 = 20
// 2^2 + 0^2 = 4
// Since we have reached 4 again, the process will continue in an infinite loop. 2 is not a happy number.
// Starting with the number 3:

// 3^2 = 9
// 9^2 = 81
// 8^2 + 1^2 = 65
// 6^2 + 5^2 = 61
// 6^2 + 1^2 = 37
// 3^2 + 7^2 = 58
// 5^2 + 8^2 = 89
// 8^2 + 9^2 = 145
// 1^2 + 4^2 + 5^2 = 42
// 4^2 + 2^2 = 20
// 2^2 + 0^2 = 4
// Since we have reached 4 again, the process will continue in an infinite loop. 3 is not a happy number.
// Starting with the number 4:

// 4^2 = 16
// 1^2 + 6^2 = 37
// 3^2 + 7^2 = 58
// 5^2 + 8^2 = 89
// 8^2 + 9^2 = 145
// 1^2 + 4^2 + 5^2 = 42
// 4^2 + 2^2 = 20
// 2^2 + 0^2 = 4
// Since we have reached 4 again, the process will continue in an infinite loop. 4 is not a happy number.
// Starting with the number 5:

// 5^2 = 25
// 2^2 + 5^2 = 29
// 2^2 + 9^2 = 85
// 8^2 + 5^2 = 89
// 8^2 + 9^2 = 145
// 1^2 + 4^2 + 5^2 = 42
// 4^2 + 2^2 = 20
// 2^2 + 0^2 = 4
// Since we have reached 4 again, the process will continue in an infinite loop. 5 is not a happy number.
// Starting with the number 6:

// 6^2 = 36
// 3^2 + 6^2 = 45
// 4^2 + 5^2 = 41
// 4^2 + 1^2 = 17
// 1^2 + 7^2 = 50
// 5^2 + 0^2 = 25
// 2^2 + 5^2 = 29
// 2^2 + 9^2 = 85
// 8^2 + 5^2 = 89
// 8^2 + 9^2 = 145
// 1^2 + 4^2 + 5^2 = 42
// 4^2 + 2^2 = 20
// 2^2 + 0^2 = 4
// Since we have reached 4 again, the process will continue in an infinite loop. 6 is not a happy number.
// Starting with the number 7:

// 7^2 = 49
// 4^2 + 9^2 = 97
// 9^2 + 7^2 = 130
// 1^2 + 3^2 + 0^2 = 10
// 1^2 + 0^2 = 1
// Since we have reached 1, the process stops here. 7 is a happy number.
// Starting with the number 8:

// 8^2 = 64
// 6^2 + 4^2 = 52
// 5^2 + 2^2 = 29
// 2^2 + 9^2 = 85
// 8^2 + 5^2 = 89
// 8^2 + 9^2 = 145
// 1^2 + 4^2 + 5^2 = 42
// 4^2 + 2^2 = 20
// 2^2 + 0^2 = 4
// Since we have reached 4 again, the process will continue in an infinite loop. 8 is not a happy number.
// Starting with the number 9:

// 9^2 = 81
// 8^2 + 1^2 = 65
// 6^2 + 5^2 = 61
// 6^2 + 1^2 = 37
// 3^2 + 7^2 = 58
// 5^2 + 8^2 = 89
// 8^2 + 9^2 = 145
// 1^2 + 4^2 + 5^2 = 42
// 4^2 + 2^2 = 20
// 2^2 + 0^2 = 4
// Since we have reached 4 again, the process will continue in an infinite loop. 9 is not a happy number.
// Based on this analysis, the numbers less than 10 that result in 1 when you repeatedly sum the squares of their digits are: 1 and 7.
class Solution{

      static boolean getHelp(int n){
        if(n==1 || n==7)   return true;
        if(n==2 || n==3 || n==4 || n ==5 || n == 6 || n ==8  || n == 9) return false;
        int sum = 0;
        while(n>0){
            int x = n%10;
            sum = sum + x*x;
            n = n/10;
        }
        return getHelp(sum);
    }

    static int nextHappy(int N){
        // code here
        while(true){
            N++;
            if(getHelp(N))   return N;
        }
    }
}