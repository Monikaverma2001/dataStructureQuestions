//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}
// } Driver Code Ends



class Solution
{
    //Function to find the largest number after k swaps.
    String max="";
    public  String findMaximumNum(String str, int k)
        {
         
         char[] arr=str.toCharArray();
         max=str;
          
         int n=arr.length;
         helper(0,k,arr,n);
         
         return max;
        }
        
        
     void helper(int swapcount,int k,char[] arr,int n)
        {
         
            if(swapcount==k)
                return ;

            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(arr[i]<arr[j]){   
                    swap(arr,i,j);
                    
                    if(String.valueOf(arr).compareTo(max)>0)
                    max=String.valueOf(arr);
                    
                    helper(swapcount+1,k,arr,n);
                    swap(arr,j,i);
                    }
                }
            }
            
        }
        
        
    void swap(char[] arr,int i,int j)
        {
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        
        
        
}