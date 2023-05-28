//{ Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}

class GFG
{
    public static void makeLoop(Node head, Node tail, int x){
        if (x == 0) return;
        
        Node curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;
        
        tail.next = curr;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, tail, pos);
            
            Solution x = new Solution();
            System.out.println( x.countNodesinLoop(head) );
        }
    }
}

// } Driver Code Ends


/*

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

//Function should return the length of the loop in LL.
class Solution
{
    //Function to find the length of a loop in the linked list.
     public static Node startNodeCycle(Node head) 
    {
        Node fastPtr = head;
        Node slowPtr = head;
        while(fastPtr != null && fastPtr.next != null)
        {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr==fastPtr) 
                return getStartNode(slowPtr,head);
        }
        return null;
    }
    public static Node getStartNode(Node slowPtr,Node head)
    {
        Node temp =head;
        while(temp!=slowPtr)
        {
            slowPtr=slowPtr.next;
            temp=temp.next;
        }
        return temp;
    }
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        Node slowPtr = startNodeCycle(head);
        if(slowPtr==null) return 0;
        Node temp = slowPtr.next;
        int count =0;
        while(temp!=slowPtr)
        {
            
            count ++;
            temp=temp.next;
        }
        return count+1;
    }
}