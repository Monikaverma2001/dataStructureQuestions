class Solution
{
    Node compute(Node head)
    {
        // your code here
         if(head == null || head.next == null){

        return head;

    }
        head=reverse(head);
        head= comput(head);
        return reverse(head);
     
    }
    
    private static Node comput(Node head)
    {
       
        Node cur=head;
      
       
       while(cur.next!=null)
       {
          if(cur.next.data>=cur.data)
           {
              cur=cur.next;
           }
           
           else
           {
              cur.next=cur.next.next;
           }
          
       }
       
       return head;
    }
    
    private static Node reverse(Node head)
    {
        if(head == null || head.next == null){

        return head;

    }
        Node prev=null;
        Node cur=head;
        while(cur!=null)
        {
            Node temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
}
