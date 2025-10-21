import java.util.Arrays;
import java.util.HashMap;

public class octobersixteen {

    public static int numTimes(int[] nums, int target) {
        int numOfTarget = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                numOfTarget++;
            }
        }
        return numOfTarget;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }
            seen.put(nums[i], i);
        }
        return new int[0];
    }

    public static boolean containsDuplicate(int[] nums){
        HashMap<Integer, Integer> check = new HashMap<>();
        if (nums.length < 2){
            return false;
        }
        for (int i = 0; i < nums.length; i++){
            if (check.containsKey(nums[i])){
                return true;
            }
            check.put(nums[i], nums[i]);
        }
        return false;

    }

    public static boolean validAnagram(String s, String t){
        HashMap<Character, Integer> holder = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            holder.put(s.charAt(i), holder.getOrDefault(s.charAt(i),0)+1);
        }
        for (int j = 0; j < t.length(); j++ ){
            if (holder.containsKey(t.charAt(j))){
                int newCount = holder.get(t.charAt(j)) - 1;
                holder.put(t.charAt(j), newCount);
                if (holder.get(t.charAt(j)) == 0){
                    holder.remove(t.charAt(j));
                }
            }
            else{
                return false;
            }
        }
        if (holder.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1};
        int target1 = 5;
        System.out.println(Arrays.toString(twoSum(nums1, target1)));

        int[] nums2 = {3, 3};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2))); 

        int[] nums3 = {1, 2, 3};
        int target3 = 100;
        System.out.println(Arrays.toString(twoSum(nums3, target3)));

        int[] nums4 = {1,2,3,4,4};
        System.out.println(containsDuplicate(nums4));

        String s = "food";
        String t = "doof";
        System.out.println(validAnagram(s,t));
    }
}
