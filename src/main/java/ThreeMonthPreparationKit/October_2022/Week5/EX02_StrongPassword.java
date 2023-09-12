/**
 * Pseudocode:
 *
 * 1. Convert the string to Character array. Create a counter var & initialize to 0.
 * 2. Validate at least 1 digit. - Character.isDigit().
 * 3. Perform the step 2 for lower characters.
 * 4. Perform the step 3 for Upper character.
 * 5. Create an array with the initial accepted value of the special characters.
 *     5.1 Validate if the iterated characters contains the in the list.
 * 6. if len + counter < 6 then counter += 6 -len;
 *
 * PseudoCode 2:
 *   1. Create the Regex to validate if the string has atleast 1 lowecase. If not then increase the counter by 1.
 *   2. Same for Upper case, digit and special characters.
 *   3. Validate the String len + counter >= 6 then return counter. Else return 6 - (len + counter)
 */



package ThreeMonthPreparationKit.October_2022.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX02_StrongPassword {

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String inputPassword  = br.readLine();

        int result = PasswordChecker.findMinCharForStrongPwd(inputPassword);
        System.out.println(result);
    }//main

}//class

class PasswordChecker{

    public static int findMinCharForStrongPwd(String pwd){
        int counter = 0;

        Pattern isDigit = Pattern.compile("^.*[0-9]+.*$");
        Matcher isDigitMatched = isDigit.matcher(pwd);
        if(!isDigitMatched.find())counter++;

        Pattern isUpperCase = Pattern.compile("^.*[A-Z]+.*$");
        Matcher isUpperCaseMatcher = isUpperCase.matcher(pwd);
        if(!isUpperCaseMatcher.find())counter++;

        Pattern isLowerCase = Pattern.compile("^.*[a-z]+.*$");
        Matcher isLowerCaseMatcher = isLowerCase.matcher(pwd);
        if(!isLowerCaseMatcher.find())counter++;

        Pattern isSpecialCharacter = Pattern.compile("^.*[!@#$%^&*()\\-+]+.*$");
        Matcher isSpecialCharacterMatched = isSpecialCharacter.matcher(pwd);
        if(!isSpecialCharacterMatched.find())counter++;

        if(pwd.length() + counter < 6)counter += 6 - (pwd.length() + counter);

        return counter;
    }

//    public static int findMinCharForStrongPwd(String pwd){
//        char[] inputCharArray = pwd.toCharArray();
//        String specialString = "!@#$%^&*()-+";
//        Pattern isNotDigitPattern = Pattern.compile("^.*[0-9]+.*$");
//        Matcher isNotDigitMatcher = isNotDigitPattern.matcher(pwd);
//
//        Pattern isNotAlphbetPattern = Pattern.compile("^.*[a-z]+.*$");
//        Matcher isNotAlphaberMatcher = isNotAlphbetPattern.matcher(pwd);
//
//        Pattern isNotAlphbetPattern2 = Pattern.compile("^.*[A-Z]+.*$");
//        Matcher isNotAlphaberMatcher2 = isNotAlphbetPattern2.matcher(pwd);
//
//        Pattern specialCharPattern = Pattern.compile("^.*[!@#$%^&*()-+]+.*$");
//        Matcher specialCharMatcher = specialCharPattern.matcher(pwd);
//
//        int counter = 0;
//
//        for(char a : inputCharArray){
//            if(Character.isUpperCase(a) || Character.isLowerCase(a) || Character.isDigit(a)){
//                continue;
//            }
//            else if(specialString.contains(String.valueOf(a))){
//                continue;
//            }
//            else{
//                counter++;
//            }
//        }
//        if(!isNotDigitMatcher.find())counter++;
//        if(!isNotAlphaberMatcher.find())counter++;
//        if(!isNotAlphaberMatcher2.find())counter++;
//        if(!specialCharMatcher.find())counter++;
//
//        if(pwd.length() + counter < 6) counter += 6 - (pwd.length()+counter);
//        return counter;
//    }
}