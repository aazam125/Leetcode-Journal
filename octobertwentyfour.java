import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;


public class octobertwentyfour{

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> solutionMap = new HashMap<>();



        for(int i = 0; i < nums.length; i++){

            int complement = target - nums[i];
            if(solutionMap.containsKey(complement)){
                return new int[] {solutionMap.get(complement), i};
            }

            solutionMap.put(nums[i], i);
        }

        return new int[]{};
    }

    public static boolean checkDuplicate(int[] nums){
        HashSet<Integer> check = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!check.add(nums[i])){
                return true;
            }
        }
        return false;
    }


    public static int maxSubArray(int[] nums, int k){
        int currentSum = 0;
        int maxSum = 0;

        for(int i = 0; i < k ; i++){
            currentSum+=nums[i];
        }
        maxSum = currentSum;

        for(int j = k; j < nums.length; j++){
            currentSum-=nums[(j - k)];
            currentSum+=nums[j];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }

        return maxSum;
        
    }

    public static int[] twoPointer(int[] nums, int target){
        int left = 0;
        int right  = nums.length - 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[left] + nums[right] == target){
                return new int[]{left+1, right+1};
            }
            if(nums[left] + nums[right] < target){
                left++;
            }
            else if(nums[left] + nums[right] > target){
                right--;
            }
        }

        return new int[]{};

    }

    public static boolean isAnagram(String s, String t){

        HashMap<Character, Integer> sMap = new HashMap<>();

        HashMap<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(sMap.containsKey(s.charAt(i))){
                int old = sMap.get(s.charAt(i));
                sMap.put(s.charAt(i), old + 1);
            }
            else{
                sMap.put(s.charAt(i), 1);
            }
        }

        for(int i = 0; i < t.length(); i++){
            if(tMap.containsKey(t.charAt(i))){
                int old = tMap.get(t.charAt(i));
                tMap.put(t.charAt(i), old + 1);
            }
            else{
                tMap.put(t.charAt(i), 1);
            }
        }

        return sMap.equals(tMap);

    }

    public static boolean checkValid(String s){
        Stack<Character> holder = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                holder.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')'){
                if(holder.peek() == '('){
                    holder.pop();
                }
                else{
                    return false;
                }
            }
            else if (s.charAt(i) == ']'){
                if(holder.peek() == '['){
                    holder.pop();
                }
                else{
                    return false;
                }
            }
            else if (s.charAt(i) == '}'){
                if(holder.peek() == '{'){
                    holder.pop();
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
            
        }

        return true;
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int best = 0;

        for (int x : set) {
            if (!set.contains(x - 1)) {
                int cur = x;
                int len = 1;
                while (set.contains(cur + 1)) {
                    cur += 1;
                    len += 1;
                }
                if (len > best) best = len;
            }
        }

        return best;
    }


    public static int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);           
        int sum = 0, count = 0;

        for (int x : nums) {
            sum += x;
            count += freq.getOrDefault(sum - k, 0);
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    

    


    public static void main(String[] args){
        String s = "([{}])";
        System.out.println(checkValid(s));

    }
}