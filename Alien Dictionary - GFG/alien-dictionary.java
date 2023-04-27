//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i =0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        
        Character map[]=new Character[K];
        //Map<Character,Integer> map=new HashMap<>();
        char start='a';
        for(int i=0;i<K;i++)
        {
            map[i]=start++;
           // System.out.println(map[i]);
          //  map.put(i,start++);
        }
        for(int i=1;i<N;i++)
        {
            String str1=dict[i-1];
            String str2=dict[i];
            int j=0;
            for(j=0;j<Math.min(str1.length(),str2.length());j++)
            {
                if(str1.charAt(j)!=str2.charAt(j))
                {
                    adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                    break;
                }
            }
           
            
        }
        int id[]=new int[K];
        for(int i=0;i<K;i++)
        {
            for(Integer j:adj.get(i))
            {
                ++id[j];
            }
        }
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<K;i++)
        {
            if(id[i]==0)
            
            
                q.offer(i);
        }
        String ans="";
        while(!q.isEmpty())
        {
            int cur=q.poll();
            ans+=map[cur];
            //System.out.println(ans);
            for(Integer j:adj.get(cur))
            {
                --id[j];
                if(id[j]==0)
                    q.offer(j);
            }
            
        }
        return ans;
    }
}