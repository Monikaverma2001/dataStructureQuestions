//{ Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here	
	int sum=0;
	for(int i=0;i<n;i++)
	{
	    sum+=a[i];
	}
	if(k==1)
	    return true;
	    
	if(sum%k!=0)
	    return false;
	    
	 boolean vis[]=new boolean[n];
	 
	 return part(a,n,k,vis,sum/k,sum/k);
	    
    }
    private static boolean part(int a[],int n,int k,boolean[] vis,int sum,int s)
    {
        if(k==0)
            return true;
            
        if(s==0)
        {
            return part(a,n,k-1,vis,sum,sum);
        }
            
        if(s<0)
            return false;
            
        for(int i=0;i<n;i++)
        {
            if(vis[i]==false)
            {
                vis[i]=true;
                
                if(part(a,n,k,vis,sum,s-a[i]))
                    return true;
                    
                vis[i]=false;
            }
        }
        
        return false;
    }
    
}
