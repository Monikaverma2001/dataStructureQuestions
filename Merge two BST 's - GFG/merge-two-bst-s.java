//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution T = new Solution();
            List<Integer> ans = T.merge(root1,root2);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
    
*/
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        ArrayList<Integer> lyst1=new ArrayList<Integer>();
        inorder(root1,lyst1);
        ArrayList<Integer> lyst2=new ArrayList<Integer>();
        inorder(root2,lyst2);
        ArrayList<Integer> ans=new ArrayList<Integer>();
        merge(lyst1,lyst2,ans);
        
        return ans;
    }
    private static void inorder(Node node,ArrayList<Integer> ans)
    {
        if(node==null)
            return;
            
        inorder(node.left,ans);
        ans.add(node.data);
        inorder(node.right,ans);
    }
    private static void merge(ArrayList<Integer> lyst1,ArrayList<Integer> lyst2,ArrayList<Integer> ans)
    {
        int i=0,j=0;
        while(i<lyst1.size()&&j<lyst2.size())
        {
            if(lyst1.get(i)<lyst2.get(j))
            {
                ans.add(lyst1.get(i));
                i++;
            }
            else
            {
                ans.add(lyst2.get(j));
                j++;
            }
        }
        while(i<lyst1.size())
        {
            
                ans.add(lyst1.get(i));
                i++;
            
        }
        while(j<lyst2.size())
        {
           ans.add(lyst2.get(j));
            j++;
          
        }
        
    }
}
