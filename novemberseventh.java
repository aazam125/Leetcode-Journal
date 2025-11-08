public class novemberseventh{

    public static class Node{

        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }



    public static void reorderList(Node head) {
        if (head == null || head.next == null) return;

    
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        Node second = slow.next;
        slow.next = null;                 
        Node prev = null, cur = second;
        while (cur != null) {
            Node nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        second = prev;                    

        
        Node first = head;
        while (second != null) {
            Node t1 = first.next;
            Node t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }
 

    public static void printList(Node head){
        Node current = head;
        while(current!= null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args){

        Node a = new Node(0);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        
        printList(a);
        reorderList(a);
        printList(a);

        
        

    }

}