/**
 * Given string is valid if all the characters in the string is appeared exactly same time. For eg: aabb is valid because all the characters are appreared 2 times.
 *
 * Also, if we remove just a single character and makes all the other characters' freq matched then also it is valid string.
 *
 * SI:
 * abcdefghhgfedecba // Here, all the characters are 2 times except 'e' which is 3 times. Thus, by removing a single character 'e', all the other characters are matched frequency 2.
 *
 * SO:
 * YES
 */


package ThreeMonthPreparationKit.October_2022.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EX4_SherlockandValidString {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            String s = br.readLine();
            System.out.println(ResultSherlockValidString.isValid(s));
        }catch(IOException e){
            e.printStackTrace();
        }
    }//end main

}//class

class ResultSherlockValidString {
    //Leaned the corner case algorithm from 'studyalgorithm.com"
    public static String isValid(String s) {

        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int freq = charFreqMap.getOrDefault(c, 0);
            charFreqMap.put(c, ++freq);
        }

        int[] arr = new int[charFreqMap.size()];
        int idx = 0;
        for (Map.Entry<Character, Integer> characterIntegerEntry : charFreqMap.entrySet()) {
            arr[idx++] = characterIntegerEntry.getValue();
        }
        Arrays.sort(arr);

        if (charFreqMap.size() == 1) return "YES";

        int first = arr[0];
        int second = arr[1];
        int secondLast = arr[arr.length - 2];
        int last = arr[arr.length - 1];

        // If first and last are same, then all frequencies are same
        if (first == last) return "YES";

        // If first is 1, and all other characters have 1 frequency
        if (first == 1 && second == last) return "YES";

        // If all are same and last character has just 1 extra count
        if (first == second && second == secondLast && secondLast == (last - 1)) return "YES";

        // Else invalid string
        return "NO";
    }

//    public static String isValid(String s) {
//        // Write your code here
//
//        //Convert the String to Character array and find the frequency of each char.
//        Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
//        for(Character c : s.toCharArray()){
//            freqMap.put(c, freqMap.getOrDefault(c,0) + 1);
//        }
//
//        int n = freqMap.get(s.charAt(0));
//
//        //Case: validate if freq of all the characters are the same.
//        // OR is only 2 characters with the distinct values.
//        if(isAllCharactersAreSameFreq(freqMap) || isRemoveAnyCharAdjustFreq(freqMap, n))return "YES";
//
//        return "NO";
//    }//end isValid
//
//    public static boolean isAllCharactersAreSameFreq(Map<Character, Integer> map){
//        long distinctCount = map.values().stream().distinct().count();
//        if(distinctCount > 1)return false;
//        return true;
//    }//end method
//
//    public static boolean isRemoveAnyCharAdjustFreq(Map<Character, Integer> map, Integer n){
//        Set<Integer> setFreq = new HashSet<Integer>(map.values());
//        int freqN = Collections.frequency(map.values(), n);
//        for(Integer i : setFreq){
//            int f = Collections.frequency(map.values(), i);
//            if(Math.abs(freqN - f) > 1)return false;
//        }
//        return true;
//    }

}//class