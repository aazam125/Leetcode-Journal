
public class novembertenth{
    

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }


    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node addTwoNumbers(Node l1, Node l2){
        Node current1 = l1;
        Node current2 = l2;
        Node dummy = new Node(-1);
        Node add = dummy;

        int carry = 0;
        while(current1 != null || current2 != null){
            int sum = carry;
            if(current1 != null){
                sum += current1.data;
                current1 = current1.next;
            }
            else{
                sum += 0;
            }
            if(current2 != null){
                sum += current2.data;
                current2 = current2.next;


            }
            else{
                sum += 0;
            }

            carry = sum/10;
            sum = sum % 10;
            
            Node newNode = new Node(sum);
            add.next = newNode;
            add = add.next;
        }
        if(carry > 0){
            add.next = new Node(carry);
        }
        return dummy.next;

    }

    public static TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;

    }

    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
        
    }

    
        

    public static void printNodes(Node head){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main (String[] args){
        Node a = new Node(2);
        Node b = new Node(4);
        Node c = new Node(3);
        a.next = b;
        b.next = c;

        Node one = new Node(5);
        Node two = new Node(6);
        Node three = new Node(4);
        one.next = two;
        two.next = three;

        printNodes(addTwoNumbers(a, one));

    }
}