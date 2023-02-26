//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        // code here
        
        int firstsum = 0;
        int secondsum = 0;
        int thirdsum = 0;
        
        for( int i=0 ; i<S1.length ; i++){
            firstsum+=S1[i];
        }
        for( int i=0 ; i<S2.length ; i++){
            secondsum+=S2[i];
        }
        for( int i=0 ; i<S3.length ; i++){
            thirdsum+=S3[i];
        }
        
        int maxsum=0;
        
        int tops1 = 0;
        int tops2 = 0;
        int tops3 = 0;
        while( (firstsum>0 && secondsum>0) && thirdsum>0 ){
            
            int min = Math.min( firstsum , Math.min( secondsum , thirdsum));
            
            while( firstsum > min ){
                firstsum-=S1[tops1];
                tops1+=1;
            }
            
            while( secondsum > min ){
                secondsum-=S2[tops2];
                tops2+=1;
            }
            
            while( thirdsum > min ){
                thirdsum-=S3[tops3];
                tops3+=1;
            }
            
            if( firstsum == secondsum && secondsum == thirdsum ){
                maxsum = firstsum;
                break;
            }
        }
        
        return maxsum;
    }
}