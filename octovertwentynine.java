
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class octovertwentynine{
    
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

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        for(int[] interval: intervals){
            if(interval[0] <= newInterval[1]){
                
            }
        }

    }

    public static void main(String[] args){
        int[] nums = {3,4,7,-7,7};
        int target = 7;

        System.out.println(prefixSum(nums, target));

    }
}