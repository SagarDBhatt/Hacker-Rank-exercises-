package CodingInteview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        String s1 = "praveen";
        String s2 = "venkatee";

        getCommonCharacters(s1, s2);
    }// main

    public static void getCommonCharacters(String s1, String s2){
        //Find the matching character. Need to print all the matching characters with duplication.

        // Create the array with list of characters. When matched, remove the character.
        List<Character> characterList = new ArrayList<>();
        for(Character c: s2.toCharArray())characterList.add(c);

        for(char c : s1.toCharArray()){
            if(characterList.contains(c)){
                System.out.println(c);
                characterList.remove(characterList.indexOf(c));
            }
        }
    }
}



