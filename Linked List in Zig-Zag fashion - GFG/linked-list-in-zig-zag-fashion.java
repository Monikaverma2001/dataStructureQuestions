//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}

class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            Solution g = new Solution();
            printList(g.zigZag(head));
        }
    } 
}

// } Driver Code Ends


/*Node is as follows:

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
	public static Node zigZag(Node head){
        //add code here.
        
        //method 1 by sorting the linked list and swapp the elements
        //method 2 by swaping if condition not meet acc to the problem
        //we are doing by method 2
        if(head==null)
            return null;
            
        if(head.next==null)
            return head;
            
        Node cur=head;
        boolean flag=true;
        while(cur.next!=null)
        {
            if(flag)
            {
                if(cur.data>cur.next.data)
                {
                    int temp=cur.data;
                    cur.data=cur.next.data;
                    cur.next.data=temp;
                }
                flag=!flag;
            }
            else
            {
                if(cur.data<cur.next.data)
                {
                     int temp=cur.data;
                    cur.data=cur.next.data;
                    cur.next.data=temp;
                }
                flag=!flag;
            }
            cur=cur.next;
        }
        return head;
    }
}