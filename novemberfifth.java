public class novemberfifth{

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static int findCycleIndex(Node head) {
        if (head == null || head.next == null) return -1;

        Node tortoise = head;
        Node hare = head;
        int index = 0;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) {
                hare = head;
                index = 0;
                while (hare != tortoise) {
                    hare = hare.next;
                    tortoise = tortoise.next;
                    index++;
                }
                return index;
            }
        }
        return -1;
    }

    public static Node mergeLinkedList(Node list1, Node list2){

        if(list1 == null && list2 == null){
            return null;
        }

        if(list2== null){
            return list1;
        }

        if(list1== null){
            return list2;
        }

        Node dummy = new Node(-1);
        Node tail = dummy; 

        while(list1!=null && list2!=null){
            if(list1.data < list2.data){
                tail.next = list1;
                list1 = list1.next;

            }
            else{
                tail.next = list2;
                list2 = list2.next;

            }
            tail = tail.next;
        }

        tail.next = list1!=null ? list1 : list2;


        return dummy.next;


    }
    
    public static Node removeNth(Node head, int n){
        if(n == 1){
            head = head.next;
        }
        Node current = head;
        int count = 1;
        while(current != null && current.next!=null){
            if(n == (count + 1)){
                current.next = current.next.next;
                break;
            }
            current = current.next;
            count++;
        }
        return head;
    }

    public static void showList(Node head){
        Node current = head;
        while(current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
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

        showList(removeNthFromEnd(a, 2));


    }
}