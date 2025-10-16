public class octobersixteen {
   public static int numTimes(int[] nums, int target){
    int numOfTarget = 0;
    for (int i = 0; i < nums.length; i++){
        if (nums[i] == target){
            numOfTarget++;
        }
    }
    return numOfTarget;
   }
}