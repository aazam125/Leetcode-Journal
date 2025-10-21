
import java.util.HashMap;

public class octobereighteen {
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> saw = new HashMap<>();
        for (int i =  0; i < nums.length; i++){
            int complement = target - nums[i];
            if (saw.containsKey(complement)){
                return new int[] {saw.get(complement), i};
            }
            saw.put(nums[i], i);
        }
        return new int[0];
    }

    public static int uniqueTwoSum(int[] nums, int target){
        HashMap<Integer,Integer> seen = new HashMap<>();
        HashMap<Integer,Integer> seenPair = new HashMap<>();
        int uniqueSolutions = 0;
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (seen.containsKey(complement)){
                if((!(seenPair.containsKey(nums[i]))) || (seenPair.get(nums[i]) != complement)){
                    seenPair.put(complement,nums[i]);
                    seenPair.put(nums[i], complement);
                    uniqueSolutions++;
                }
            }
            seen.put(nums[i], i);
        }
        return uniqueSolutions;
    }

    public static int[] zigzag(int[] nums){
        int[] solution = new int[nums.length-2];
        for (int i = 0; i < nums.length - 2; i++){
            if((nums[i] < nums[i+1] && nums[i+3]< nums[i+2]) || (nums[i] > nums[i+1] && nums[i+3] > nums[i+2])){
                solution[i] = 1;
            }
            else{
                solution[i] = 0;
            }

        }
        return solution;

    }

    public static int sumOfDigits(int n){
        int sum = 0;
        while(n > 10){
            int holder = n%10;
            sum+=holder;
            n = n/10;
        }
        sum+=n;
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 3,6, 5, 4};
        int target = 9;
        System.out.print(sumOfDigits(1234));
    }   
}
