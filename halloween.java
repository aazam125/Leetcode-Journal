public class halloween{

    public static class Node{
        int data;
        Node next;

        Node(){
            this.data = 0;
            this.next = null;
        }

        Node(int data){
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }


    public static boolean detectCycle(Node head){

        Node tortoise = head;
        Node hare = head;

        while(hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(tortoise == hare){
                return true;
            }
        }

        return false;
    }

    public static int findCycle(Node head){

        Node tortoise = head;
        Node hare = head;

        while(hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(tortoise == hare){
                return tortoise.data;
            }
        }

        return -1;
    }


    public static void main(String[] args){

        Node a = new Node(1);
        Node b = new Node(2);
        Node c= new Node(3);
        Node d = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = a;

        System.out.println(findCycle(a));


    }
}