import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class octobertwentyone {
    public static int countVowels(String myString){

            HashSet<Character> vowels = new HashSet<>();
            
            int total = 0;

            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');

            myString = myString.toLowerCase();

            for(int i=0; i < myString.length(); i++){
                if(vowels.contains(myString.charAt(i))){
                    total++;
                }
            }

            return total;

    }

    public static String reverseString(String myString){

        if(myString.length() == 0){
            return "";
        }

        String reversedMyString = "";

        int maxStringIndex = (myString.length() - 1);

        for (int i=maxStringIndex; i >=0; i--){
            reversedMyString+=myString.charAt(i);
        }

        return reversedMyString;
    }
    
    public static String reverseStringSimple(String myString){

        if(myString.length() == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder(myString);

        String reversed = sb.reverse().toString();

        return reversed;
    }

    public static String removeSpaces(String myString){
        if(myString.length() == 0){
            return "";
        }

        String noSpaces = "";

        for(int i=0; i<myString.length(); i++){
            if (myString.charAt(i) == ' '){
                continue;
            }
            else{
                noSpaces+=myString.charAt(i);
            }
        }
        
        return noSpaces;
    }

    public static void compareStrings(String s1, String s2){

        String[] arrayS1 = s1.split(",");
        String[] arrayS2 = s2.split(",");

        HashSet<String> setS1 = new HashSet<>();
        HashSet<String> setS2 = new HashSet<>();

        for(int i=0; i<arrayS1.length; i++){
            setS1.add(arrayS1[i].trim().toLowerCase());
        }

        for(int j=0; j<arrayS2.length; j++){
            setS2.add(arrayS2[j].trim().toLowerCase());
        } 

        HashSet<String> common = new HashSet<>(setS1);
        common.retainAll(setS2);

        HashSet<String> onlyInFirst = new HashSet<>(setS1);
        onlyInFirst.removeAll(setS2);

        HashSet<String> onlyInSecond = new HashSet<>(setS2);
        onlyInSecond.removeAll(setS1);

        System.out.println("common: " + common);
        System.out.println("only in first: " + onlyInFirst);
        System.out.println("only in second: " + onlyInSecond);
    }
    
    public static String simpleString(String s1, String s2){
        String newS1 = s1.toLowerCase().trim();
        String newS2 = s2.toLowerCase().trim();

        return newS1 + " " + newS2; 

    }


    public static List<String> editString(String[] s1) {
        List<String> solution = new ArrayList<>();

        for (int i = 0; i < s1.length; i++) {
            if (s1[i].length() <= 4) {
                solution.add(s1[i].toLowerCase());
            }
        }
        return solution;
    }

    public static Map<String, Integer> match(List<String> logs) {
        List<String[]> holder = new ArrayList<>();
        Map<String, Integer> successes = new HashMap<>();

        for (int i = 0; i < logs.size(); i++) {
            holder.add(logs.get(i).split(","));
        }

        for (int j = 0; j < holder.size(); j++) {
            String date = holder.get(j)[0];
            String status = holder.get(j)[2];
            if (status.equals("success")) {
                successes.put(date, successes.getOrDefault(date, 0) + 1);
            }
        }

        return successes;
    }

    public static Map<String, List<String>> anagram(List<String> wordsList){
        Map<String, List<String>> solution = new HashMap<>();

        for(int i=0; i < wordsList.size(); i++){
            char[] sorted = wordsList.get(i).toCharArray();
            Arrays.sort(sorted);
            sorted.
        }
    }

    



    public static void main(String[] args) {
        System.out.println(countVowels("Second Diner"));
        
        System.out.println(reverseString("Second Dinner"));

        System.out.println(reverseStringSimple("Second Dinner"));

        System.out.println(removeSpaces("ai ml engineer"));

        compareStrings("apple, banana, cherry", "banana, date, Apple");

        System.out.println(simpleString("Hello", "WORLD"));

        String[] myArray = {"adam","azam","likely","friend", "HI"};

        System.out.println(editString(new String[]{"Data", "AI", "Code", "Fun"}));

        List<String> logs = new ArrayList<>();

        logs.add("2025-10-21,user1,success");
        logs.add("2025-10-21,user2,fail");
        logs.add("2025-10-22,user1,success");

        System.out.println(match(logs));

    }
} 