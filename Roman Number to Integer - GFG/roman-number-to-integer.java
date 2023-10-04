//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
        int arr[]={1,5,10,50,100,500,1000};
        char[] c={'I','V','X','L','C','D','M'};
         Map<Character,Integer> map=new HashMap<>();
         for(int i=0;i<7;i++)
         {
             map.put(c[i],arr[i]);
         }
        int targetIdx = str.length()-1; 
        
        int decimalValue = map.get(str.charAt(targetIdx--));
        for(int curr, next; targetIdx >=0; targetIdx--)
        {
            curr = map.get(str.charAt(targetIdx));
            next = map.get(str.charAt(targetIdx+1));
            
            decimalValue += curr < next ? (-curr) : curr;
        }
        
        return decimalValue;
    }
}