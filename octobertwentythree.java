import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class octobertwentythree{

    public static List<List<Integer>> uniquePairs(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> used = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                int small = Math.min(num, complement);
                int big = Math.max(num, complement);
                String key = small + "," + big;
                if (!used.contains(key)) {
                    result.add(Arrays.asList(small, big));
                    used.add(key);
                }
            }
            seen.add(num);
        }

        return result;
    }

    public static String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        if (result.length() > 0) {
            return result.toString();
        } else {
            return "/";
        }
    }

    public static String removeSpaces(String s){
        StringBuilder noSpace = new StringBuilder();
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                noSpace.append(s.charAt(i));
            }
        }

        return noSpace.toString();
    }

    public static String reverseString(String s){
        StringBuilder original = new StringBuilder(s);

        original.reverse();

        return original.toString();
    }


    public static String weridReverse(String s){
        String[] sArray = s.split(" ");

        int i = 0;
        int j = (sArray.length - 1) - i;
        while(i != j ){

            String temp = sArray[i];
            sArray[i] = sArray[j];
            sArray[j] = temp;
            i++;
            j--;
        }

        return String.join(" ", sArray);
    }


    public static String oddReverse(String s){
        if (s.length() == 0){
            return "";
        }

        String[] sArray = s.split(" ");

        for(int i = 0; i < sArray.length; i++){
            StringBuilder reversedString = new StringBuilder(sArray[i]);
            reversedString.reverse();
            sArray[i] = reversedString.toString();
        }

        String solution = String.join(" ", sArray);

        return solution;


    }

    public static String compress(String s){

        StringBuilder solution = new StringBuilder();

        if(s.length() == 0){
            return "";
        }

        Stack<Character> holder = new Stack<>();

        int total = 0;

        for(int i = 0; i < s.length(); i++){
            if(i == 0 || holder.peek() == s.charAt(i)){
                holder.push(s.charAt(i));
                total++;
            }
            else{ 
                solution.append(holder.peek() + "" + total);
                holder.push(s.charAt(i));
                total = 1;
            }
        }

        solution.append(holder.peek() + "" + total);

        if (s.length() < solution.toString().length()){
            return s;
        }
        else{
            return solution.toString();
        }

    }

    // think how to handle, flag [ ] 

    



    public static void main(String[] args){
        int [] nums = {3,3,3,3};
        int target = 6;
        System.out.println(uniquePairs(nums,target));

        System.out.println(removeSpaces("h e l l o"));

        System.out.println(reverseString("Hello"));
        System.out.println(weridReverse("I love code"));

        System.out.println(oddReverse("I love code"));

        System.out.println(compress("aaabbc"));
    }
}

