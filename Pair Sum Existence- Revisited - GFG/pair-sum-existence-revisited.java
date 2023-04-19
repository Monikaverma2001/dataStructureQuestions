//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
            int sum = sc.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.sumExists(arr,n,sum)); // prints the required result with new line
        }
    }
}


// } Driver Code Ends


//User function Template for Java

/* Helper class containing sumExists function
arr[]: array eleemnts
n: size of the array
sum: to check if pair having this sum
*/
class Geeks
{
    // function to check if any pair having specified sum
    // and return 1 if so, else 0
    public static int sumExists(int arr[], int n, int sum)
    {
        // your code here
         Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            if(set.contains(sum-arr[i]))
            {
                return 1;
            }
            set.add(arr[i]);
        }
        return 0;
    }
    
}