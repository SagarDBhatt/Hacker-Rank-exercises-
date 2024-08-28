/**
 * Sample Input:
 * 11
 * middle-Outz
 * 2
 *
 * Sample Output:
 * okffng-Qwvb
 *
 * PROBLEM EXPLANATION:
 * Shift Each character by 2 (k=2) places to get the encrypted string. If the character is ended then start from the beginning.
 * Special characters should not be changed.
 *
 * PSEUDO CODE:
 * 1. Read the count - length of string. Read the string.
 * 2. Convert the string to Character Array.
 * 3. Loop over each Character and get the index/ASCII of it. Then add the shifting character (k=2).
 *      3.1: Validation: If the characters ASCII value is NOT within the limit of the a-z then do not shift the value. Put the exact same character.
 *      3.2: if the value is going over the ASCII limit then start over.
 * 4. Convert the character array to string and return the string.
 *
 */


package ThreeMonthPreparationKit.October_2022.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX09_CaeserCipher {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            int strLen = Integer.parseInt(br.readLine());
            String inputStr = br.readLine();
            int k = Integer.parseInt(br.readLine());
            System.out.println(CaeserCipher.getCipheredString(inputStr, k));
        }
        catch(IOException e){
            System.out.println("ReadLine func error -- " + e.getMessage());
        }

    }
}

class CaeserCipher{
    protected static String getCipheredString(String s, int shift){

        char[] charArray = new char[s.length()];
        for(int i =0; i < s.length(); i++){
            if(((int)s.charAt(i) >= 97 && (int)s.charAt(i) <= 122)){
                if((int) s.charAt(i) + shift > 122){
                    int diff = ((int) s.charAt(i) + shift - 122);
                    if(diff > 26)diff %= 26;
                    if(diff == 0 )charArray[i] =  (char) (122);
                    else charArray[i] =  (char) (96 + diff);
                }
                else {
                    charArray[i] = (char) ((int) s.charAt(i) + shift);
                }
            }
            else if(((int)s.charAt(i) >= 65 && (int)s.charAt(i) <= 90)){
                if((int) s.charAt(i) + shift > 90){
                    int diff = ((int) s.charAt(i) + shift - 90);
                    if(diff > 26)diff %= 26;
                    if(diff == 0 )charArray[i] =  (char) (90);
                    else charArray[i] =  (char) (64 + diff);

                }
                else {
                    charArray[i] = (char) ((int) s.charAt(i) + shift);
                }
            }
            else{
                charArray[i] =  s.charAt(i);
            }
        }
        return String.valueOf(charArray);
    }
}
