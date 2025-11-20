
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;


public class novemberseventeenth{

    static class TreeNode{

        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;


        }

        
    }


    public static boolean findNodeIterativeBfs(TreeNode head, TreeNode target){

            Queue<TreeNode> holderTreeNodes = new LinkedList<>();

            holderTreeNodes.add(head);

            while(!holderTreeNodes.isEmpty()){

                TreeNode current = holderTreeNodes.poll();

                if(current == target){
                    return true;
                }

                if(current.left != null){
                    holderTreeNodes.add(current.left);
                }

                if(current.right != null){
                    holderTreeNodes.add(current.right);
                }

            }

            return false;

    }


    public static boolean findNodeRecusiveBfs(TreeNode head, TreeNode target){

        if(head == null){
            return false;
        }

        Queue<TreeNode> holder = new LinkedList<>();

        holder.add(head);

        return helperFindRecursiveBfs(target, holder);

    }
 



    private static boolean helperFindRecursiveBfs(TreeNode target, Queue<TreeNode> holder){

        if(holder.isEmpty()){
            return false;
        }

        TreeNode current = holder.poll();

        if(current == target){
            return true;
        }

        if(current.left != null){
            holder.add(current.left);
        }

        if(current.right != null){
            holder.add(current.right);
        }


       return helperFindRecursiveBfs(target, holder);


    }

    public static boolean findNodeIterativeDfs(TreeNode head, TreeNode target){

        Stack<TreeNode> holder = new Stack<TreeNode>();

        holder.add(head);


        while(!holder.isEmpty()){
             TreeNode current = holder.pop();

             if(current == target){
                return true;
             }

             if(current.right != null){
                holder.push(current.right);
             }

             if(current.left != null){
                holder.push(current.left);
             }

        }

        return false;
        
    }

    public static boolean findNodeRecursiveDfs(TreeNode head, TreeNode target){
        if(head == null){
            return false;
        }

        Stack<TreeNode> holder = new Stack<>();

        holder.push(head);

        return helperNodeRecursiveDfs(target, holder);
    }


    public static boolean helperNodeRecursiveDfs(TreeNode target, Stack<TreeNode> holder){
        if(holder.isEmpty()){
            return false;
        }

        TreeNode current = holder.pop();

        if(current == target){
            return true;
        }

        if(current.right != null){
            holder.push(current.right);
        }

        if(current.left != null){
            holder.push(current.left);
        }

        return helperNodeRecursiveDfs(target, holder);
    }

    public static boolean SimplefindNodeRecursiveDfs(TreeNode head, TreeNode target) {
        if (head == null) return false;
        if (head == target) return true;

        return findNodeRecursiveDfs(head.left, target) || findNodeRecursiveDfs(head.right, target);
    }

    public static int findSumofTree(TreeNode head){
        if(head == null){
            return 0;
        }
        
        return head.data + findSumofTree(head.left) + findSumofTree(head.right);
    }


    public static int findMinVal(TreeNode head){

        Queue<TreeNode> holder = new LinkedList<>();

        int minVal = head.data;
        holder.add(head);

        while(!holder.isEmpty()){
            TreeNode current = holder.poll();

            if(current.data < minVal){
                minVal = current.data;
            }

            if(current.left != null){
                holder.add(current.left);
            }

            if(current.right != null){
                holder.add(current.right);
            }
        }

        return minVal;

    }

    public static TreeNode invertTree(TreeNode head){

        Queue<TreeNode> holder = new LinkedList<>();


        holder.add(head);

        while(!holder.isEmpty()){
            TreeNode current = holder.poll();

            TreeNode temp = current.right;
            current.right = current.left;
            current.left = temp;



            if(current.right != null){
                holder.add(current.right);
            }

            if(current.left != null){
                holder.add(current.left);
            }
            
        }


        return head;

    }

    public static int[] beforeInvertTree(TreeNode head){

        if(head == null){
            return new int[]{};

        }

        Queue<TreeNode> holder = new LinkedList<>();
        ArrayList<Integer> preSolution = new ArrayList<>();

        holder.add(head);

        while(!holder.isEmpty()){
            TreeNode current = holder.poll();
            preSolution.add(current.data);

            if(current.left != null){
                holder.add(current.left);
            }

            if(current.right != null){
                holder.add(current.right);
            }
            
        }

        int[] solution = new int[preSolution.size()];

        for(int i = 0; i < preSolution.size(); i++){
            solution[i] = preSolution.get(i);
        }

        return solution;

    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            
            char lChar = s.charAt(left);
            char rChar = s.charAt(right);

            if(!Character.isLetterOrDigit(lChar)){
                left++;
                continue;
            }

            if(!Character.isLetterOrDigit(rChar)){
                right--;
                continue;
            }

            if(Character.toLowerCase(lChar) != Character.toLowerCase(rChar)){
                return false;
            }

            left++;
            right--;
        }

        return true;
        
    }


    public static int countPairs(int[] nums, int k) {
    int numPairs = 0;
    HashMap<Integer, Integer> holder = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        int complement = k - nums[i];

        if (holder.containsKey(complement)) {
            numPairs += holder.get(complement);
        }

        holder.put(nums[i], holder.getOrDefault(nums[i], 0) + 1);
    }

    return numPairs;
}







    




    public static void main(String [] args){

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);

        TreeNode wildCard = new TreeNode(10101);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        int[] nums = {3,3,3};

        System.out.println(countPairs(nums,6));



        




    }
}