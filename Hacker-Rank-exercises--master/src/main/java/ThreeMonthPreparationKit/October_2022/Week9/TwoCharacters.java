/**
 * Given a String, find out the longest string with only 2 characters alternatively available.
 * Ex: String S = 'beabeefeab'
 *
 * Now, remove all instances of character 'e' will give us: s= babfab
 * Now, remove all instance of character 'f' will give us: s= babab
 *
 * This is the longest String with only 2 alternating characters. Return the length of the String.
 *
 * Sample Input:
 * 10
 * beabeefeab
 *
 * Sample output:
 * 5
 */

//10
//beabeefeab

package ThreeMonthPreparationKit.October_2022.Week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class TwoCharacters {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int n = Integer.parseInt(br.readLine());
            String S = br.readLine();
            System.out.println(SolutionTwoAlternatingCharacters.alternate(S));
        }catch (Exception e){
            e.printStackTrace();
        }

    }//main
}//end of class

class SolutionTwoAlternatingCharacters {

    public static int alternate(String s) {
        // Convert the String into Unique Characters ArrayList or HashSet

//        Set<Character> st = new LinkedHashSet<>();
//        List<List<Character>> pairs = new ArrayList<>();
//        for(Character c : s.toCharArray()){
//            if(!pairs.contains(c)){
//                List<Character> newList = new ArrayList<>();
//                newList.add(c)
//            }
//        }
//
//
//        for(int i = 0; i < st.size()-2; i++){
//
//        }
//        for(Character c : s.toCharArray()){
//
//        }
//
//        System.out.println(st.toString());
        int longestLength = 0;

        if(isValidString(s))return s.length();

        //1. Get the unique list of characters.
        List<List<Character>> charList = new ArrayList<>();

        for(int i = 0; i < s.length()-2; i++){
            for(int j = i+1; j < s.length()-1; j++){
                List<Character> inList = new ArrayList<>();
                if(s.charAt(i) == s.charAt(j))continue;
                inList.add(s.charAt(i));
                inList.add(s.charAt(j));
                if(charList.contains(inList))continue;
                charList.add(inList);
            }
        }
        System.out.println(charList);

        //2 Iterate each character of the list and remove from the string.
        // New String should be made using only 2 characters,
        for(List<Character> c : charList){
            String newString = "";

            for(Character chs : s.toCharArray()){
//                if(c.get(0) == chs || c.get(1) == chs)continue;
//                newString = newString.concat(String.valueOf(chs));
                if(c.get(0) == chs || c.get(1) == chs)newString = newString.concat(String.valueOf(chs));
            }
            System.out.println(newString);
            if(isValidString(newString)){
                int length = newString.length();
                if(length > longestLength)longestLength = length;
                System.out.println(longestLength);
            }
        }

        return longestLength;
    }

    public static boolean isValidString(String str){
        for(int i = 0; i < str.length()-2; i++){
            if(str.charAt(i) == str.charAt(i+1) || str.charAt(i) != str.charAt(i+2))return false;
        }
        return true;
    }

}//end of class