//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Solution
{
       Node lastNode(Node head)
    {
        
        Node tmp=head;
        while(tmp.next!=null)
        {
            tmp=tmp.next;
        }
        return tmp;
    }
    Node mergeKList(Node[]arr,int K)
    {
        if(arr.length==1)
          return arr[0];
        Node head=arr[0];
        Node tmp=lastNode(head);
        
        for(int i=1;i<arr.length;i++)
        {
            Node head1=arr[i];
            tmp.next=head1;
            tmp=lastNode(head1);
        }
        ArrayList<Integer>l=new ArrayList<>();
        tmp=head;
        while(tmp!=null)
        {
            l.add(tmp.data);
            tmp=tmp.next;
        }
        Collections.sort(l);
       
          tmp=head;
        for(int i=0;i<l.size();i++)
        {
            tmp.data=l.get(i);
            tmp=tmp.next;
        }
        
        return head;
        
    }
}
