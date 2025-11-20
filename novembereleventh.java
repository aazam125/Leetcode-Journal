import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class novembereleventh{
    

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int[] dfsIteration(TreeNode root){

        if(root == null){
            return new int[0];
        }

        Stack<TreeNode> holder = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();


        holder.push(root);

        while(!holder.isEmpty()){
            TreeNode current = holder.pop();
            result.add(current.data);


            if(current.right != null){
                holder.push(current.right);
            }

            if(current.left != null){
                holder.push(current.left);
            }
            
        }

        int[] solution = result.stream().mapToInt(Integer::intValue).toArray();
        return solution;

    }

    public static int[] dfsRecursive(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        dfsHelper(root, result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfsHelper(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return;
        result.add(node.data);
        dfsHelper(node.left, result);
        dfsHelper(node.right, result);
    }

    public static int[] bfsInteration(TreeNode root){

        Queue<TreeNode> order = new LinkedList<>();
        ArrayList<Integer> listSolution = new ArrayList<>();

        order.add(root);

        while(!order.isEmpty()){
            TreeNode current = order.poll();
            listSolution.add(current.data);

            if(current.left != null){
                order.add(current.left);
            }

            if(current.right != null){
                order.add(current.right);
            }
        }

        int[] solution = listSolution.stream().mapToInt(Integer::intValue).toArray();
        return solution;
    

        
    }

    public static int[] bfsRecursive(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return new int[0];

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        bfsHelper(queue, result);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void bfsHelper(Queue<TreeNode> queue, ArrayList<Integer> result) {
        if (queue.isEmpty()) return;

        TreeNode current = queue.poll();
        result.add(current.data);

        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);

        bfsHelper(queue, result); 
    }









    
    

    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(findNode(a, 5));
       

    }
}