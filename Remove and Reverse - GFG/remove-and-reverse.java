//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
          
            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeReverse(S); 
            System.out.println(ans);
        }
    } 
} 

// } Driver Code Ends
//User function Template for Java

class Solution 
{  
    String removeReverse(String S) 
    { 
        Map<Character, Integer> map=new HashMap<>();
        int i=0;
        int j=S.length()-1;
        boolean rev=false;
        
        HashSet<Integer> remove = new HashSet<>();
        
        //make freq map
        for(int k=0; k<S.length(); k++){
            char ch=S.charAt(k);
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        while(i < j){
            char first=S.charAt(i);
            char last=S.charAt(j);
            
            if(!rev){
                //dec freq and remove
                if(map.get(first) > 1){
                    map.put(first, map.get(first) - 1);
                    remove.add(i);
                    rev=!rev;
                }
                i++;
            }
            else{
                //dec freq and remove
                if(map.get(last) > 1){
                    map.put(last, map.get(last) - 1);
                    remove.add(j);
                    rev=!rev;
                }
                j--;
            }
        }
        
        //make res
        StringBuilder sb=new StringBuilder();
        
        for(int k=0; k<S.length(); k++){
            if(!remove.contains(k)){
                //add into res
                sb.append(S.charAt(k));
            }
        }
        
        if(rev==true){
            sb.reverse();
        }
        
        return sb.toString();
    }
} 



//{ Driver Code Starts.

// } Driver Code Ends