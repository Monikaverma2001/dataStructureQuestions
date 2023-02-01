//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    static void presmallest(int arr[],int a[],int n)
	{
		Stack<Integer> s=new Stack<>();
		for(int i=0;i<n;i++)
		{
			while(!s.isEmpty() && arr[s.peek()]>=arr[i])
			{
				s.pop();
			}
			if(s.isEmpty())
			{
				a[i]=-1;
			}
			else
			{
				a[i]=s.peek();
			}
			s.push(i);
		}
	}
	static void nextsmallest(int arr[],int a[],int n)
	{
		Stack<Integer> s=new Stack<>();
		for(int i=n-1;i>=0;i--)
		{
			while(!s.isEmpty() && arr[s.peek()]>=arr[i])
			{
				s.pop();
			}
			if(s.isEmpty())
			{
				a[i]=n;
			}
			else
			{
				a[i]=s.peek();
			}
			s.push(i);
		}
	}
    static int area(int[] arr,int n)
    {
        int ps[]=new int[n];
		int ns[]=new int[n];
		presmallest(arr,ps,n);
		nextsmallest(arr,ns,n);
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
		//System.out.println(ps[i]+" "+ns[i]+" "+arr[i]);
			
			int area=(ns[i]-ps[i]-1)*arr[i];
			max=Math.max(max, area);
		}
		return max;
    }
    public int maxArea(int arr[][], int n, int m) {
        // add code here.
        int max=-1;
        int a[]=new int[m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]!=0)
                    a[j]+=arr[i][j];
                else
                    a[j]=0;
                  // System.out.print(a[j]+" "); 
            }
            // System.out.println(); 
            max=Math.max(max,area(a,m));
        }
        return max;
    }
}