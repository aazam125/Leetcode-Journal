
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class octovertwentynine{

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
    
    public static int prefixSum(int[] nums, int target){

        HashMap<Integer, Integer> frequency = new HashMap<>();
        
        int count = 0;
        int curr_prefix_sum = 0;

        frequency.put(0, 1);
        

        for(int i = 0; i < nums.length; i++){
            curr_prefix_sum+=nums[i];
            if(frequency.containsKey(curr_prefix_sum - target)){
                count+=frequency.get(curr_prefix_sum - target);
            }

            if(frequency.containsKey(curr_prefix_sum)){
                frequency.put(curr_prefix_sum, frequency.getOrDefault(curr_prefix_sum, 0) + 1);
            }
            else{
                frequency.put(curr_prefix_sum, 1);
            }
        
        }

        return count;
    }

    public static int[][] merge(int[][] intervals){

        if(intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        ArrayList<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

        for(int[] interval: intervals){
            if(current[1] >= interval[0]){
                current[1] = Math.max(current[1], interval[1]);
            }
            else{
                result.add(current);
                current = interval;
            }
        }
        result.add(current);

        return result.toArray(new int[result.size()][]);

    }

    public static int findIndex(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = (left + right)/2;

            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;

    }

    public static int searchInsertPostion(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                return left;
            }
        }

        return left;
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }




    public static void main(String[] args){

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        

        System.out.println(reverseLinkedList(a));

    }
}