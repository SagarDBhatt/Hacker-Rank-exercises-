/**
 * Your task is to implement a function that validates the correctness of a String.
 *
 * Requirements
 * Implement a function named stringValidator that:
 *
 * takes a String as an argument;
 * returns a bool as follows:
 * True if the String meets all the requirements;
 * False if it fails to meet all the requirements.
 * The requirements for the String are as follows:
 *
 * it should be a minimum of six characters;
 * it should be a maximum of 15 characters;
 * it should contain at least two digits;
 * digits should not be adjacent to one another:
 * invalid: 'bq34', '34bq', 'b34q',
 * valid: 'b3q4', '3bq4', '3b4q';
 * it should contain at least one lowercase letter;
 * it should contain at least one capital letter;
 * it should contain exactly one character from the following list: [$, %, >];
 * each character can occur a maximum of once.
 * Assumptions
 * You can assume that the function always receives a String as an argument.
 * Hints
 * A and a are not the same character.
 * Your solution will be evaluated based on its correctness; performance and coding style will not be assessed.
 * Available packages/libraries
 * Dart 2.13
 * Examples
 * The function stringValidator should work as illustrated by the following examples:
 *
 * stringValidator('A5i8%b') == true;
 * stringValidator('A5i8%ba4I<') == true;
 * stringValidator('1AaBbCcDdEeFf6%') == true;
 * stringValidator('A3a1>0') == true;
 *
 * // text is shorter than six characters
 * stringValidator('A5i8%') == false;
 *
 * // text is longer than 15 characters
 * stringValidator('A5i8%bcdefghijKLm3aBC0GCJI') == false;
 *
 * // text contains fewer than two digits
 * stringValidator('AbcDEFGHIJ%') == false;
 *
 * // digits are not separated
 * stringValidator('AbcDEFG345HIJ%') == false;
 *
 * // text does not contain any lowercase letter
 * stringValidator('ABCDEFG3HIJ%7') == false;
 *
 * // text does not contain any capital letter
 * stringValidator('abcdefg3hij$7') == false;
 *
 * // text does not contain any character from the list [$, %, >]
 * stringValidator('ABcdefg3hij7') == false;
 *
 * // text contains more than one character from the list [$, %, >]
 * stringValidator('ABcdefg3h%ij7$') == false;
 *
 * // the same character occurs more than once
 * stringValidator('AABcdefg3hij7') == false;
 */


package Miscallaneous.JavaRandomHackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringValidator {
    public static void main(String[] args) {

        System.out.println(StringValidatorResult.stringValidator("A5i8%b"));
        System.out.println(StringValidatorResult.stringValidator("A5i8%ba4I<"));
        System.out.println(StringValidatorResult.stringValidator("1AaBbCcDdEeFf6%"));
        System.out.println(StringValidatorResult.stringValidator("A3a1>0"));
        System.out.println("-----------------------");
        System.out.println(StringValidatorResult.stringValidator("AAbcDEG345HIJ%"));
        System.out.println(StringValidatorResult.stringValidator("b34q"));
        System.out.println(StringValidatorResult.stringValidator("AbcDEFG345HIJ%"));
        System.out.println(StringValidatorResult.stringValidator("AABcdefg3hij7"));
        System.out.println(StringValidatorResult.stringValidator("ABcdefg3h%ij7$"));
        System.out.println(StringValidatorResult.stringValidator("ABcdefg3hij7"));
        System.out.println(StringValidatorResult.stringValidator("ABCDEFG3HIJ%7"));
        System.out.println(StringValidatorResult.stringValidator("AbcDEFGHIJ%"));

    }//main
}//class

class StringValidatorResult{
    public static boolean stringValidator(String s){

        // Validate the string with few requirements:
        // 1. It should be min of 6 characters and Max of 15 characters.
        if(s.length() < 6 || s.length() > 15)return false;

        // 2. Contains at least 2 digits.
        int digitCounter = 0;

        // 3. Digits should not be adjacent to each other.
        // 4. it should contain at least one lowercase letter;
        boolean isLowerCaseLetter = false;

        //5. it should contain at least one capital letter;
        boolean isUpperCaseLetter = false;

        //6. $, %, > atleast one character.
        List<Character> characterList = new ArrayList<>(List.of('$', '%', '>'));
        boolean isSpecialCharacter = false;

        //7. each character can occur a maximum of once.
        Set<Character> characterSet = new HashSet<Character>();

        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i)))digitCounter++;
            if(i != 0 && Character.isDigit(s.charAt(i)) && Character.isDigit(s.charAt(i-1)))return false;
            if(Character.isLowerCase(s.charAt(i)))isLowerCaseLetter=true;
            if(Character.isUpperCase(s.charAt(i)))isUpperCaseLetter=true;
            if(characterList.contains(s.charAt(i)))isSpecialCharacter=true;

            if(characterSet.contains(s.charAt(i)))return false;
            else characterSet.add(s.charAt(i));
        }

        // Check if the digitCounter is at least 2 or more. Else return false.
        if(digitCounter < 2)return false;

        if(!isLowerCaseLetter || !isUpperCaseLetter || !isSpecialCharacter)return false;

        return true;
    }//end of method
}//end of class
