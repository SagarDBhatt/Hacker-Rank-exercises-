package EasyLevel;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.Scanner;

/*
Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies. For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.

        Complete the function in the editor. If  and  are case-insensitive anagrams, print "Anagrams"; otherwise, print "Not Anagrams" instead.

        Input Format

        The first line contains a string denoting .
        The second line contains a string denoting .

        Constraints

        Strings  and  consist of English alphabetic characters.
        The comparison should NOT be case sensitive.
        Output Format

        Print "Anagrams" if  and  are case-insensitive anagrams of each other; otherwise, print "Not Anagrams" instead.

        Sample Input 0

        anagram
        margana
        Sample Output 0

        Anagrams
        Explanation 0

        Character	Frequency: anagram	Frequency: margana
        A or a	3	3
        G or g	1	1
        N or n	1	1
        M or m	1	1
        R or r	1	1
        The two strings contain all the same letters in the same frequencies, so we print "Anagrams".

        Sample Input 1

        anagramm
        marganaa
        Sample Output 1

        Not Anagrams
        Explanation 1

        Character	Frequency: anagramm	Frequency: marganaa
        A or a	3	4
        G or g	1	1
        N or n	1	1
        M or m	2	1
        R or r	1	1
        The two strings don't contain the same number of a's and m's, so we print "Not Anagrams".

*/
public class Angrams {
    static char aChars[];
    static char bChars[];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two strings");
        String a = scan.next();
        String b = scan.next();
        scan.close();

       if(isEqualLength(a,b) && isSameCharacters(a,b) && calcFreq(a,b)){
           System.out.println("Anagrams");
       }
       else
           System.out.println("Not Anagrams");



/*        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );*/

    }//end of main()

    public static boolean isEqualLength(String a, String b){
        if(a.length() == b.length())
            return true;
        else
            return false;
    }

    public static boolean isSameCharacters(String a, String b){
        /*//Initialize char array.
        char[] aChars = new char[a.length()];
        char[] bChars = new char[b.length()];


        //Convert String to Char array.
        aChars = a.toCharArray();
        bChars = b.toCharArray();*/

        //4 lines Code -> 2 Lines code. Save 2 line.
        aChars = a.toCharArray();
        bChars = b.toCharArray();
        boolean judge = false;

        //Converting char array into lower case for comparison
        for(int i=0; i<a.length();i++){
            aChars[i] = Character.toLowerCase(aChars[i]);
            bChars[i] = Character.toLowerCase(bChars[i]);
        }

        //Sort Char arrays
        Arrays.sort(aChars);
        Arrays.sort(bChars);

        //Identify if both strings has same character.
        for(int i = 0; i < a.length(); i++){
            if( aChars[i] == bChars[i])
               judge = true;

            else {
                judge = false;
                break;
            }
        }
        return judge;
    }

    public static boolean calcFreq(String a, String b){

        int[] freqA = new int[a.length()];
        int[] freqB = new int[b.length()];
        boolean cond = false;

        for( int i = 0; i < aChars.length; i++) {
            freqA[i] = 1;

            for(int j = i+1; j < aChars.length; j++){
                if(aChars[i] == aChars[j]){
                 freqA[i] += 1;
                 aChars[j] = '0';
                }
            }
        }

        for( int i = 0; i < bChars.length; i++) {
            freqB[i] = 1;

            for(int j = i+1; j < bChars.length; j++){
                if(bChars[i] == bChars[j]){
                    freqB[i] += 1;
                    bChars[j] = '0';
                }
            }
        }

        for(int i=0;i<freqA.length;i++)
        {
            if(aChars[i] != '0' && bChars[i] != 0){
                if(aChars[i] == bChars[i]) {
                    cond = true;
                }
            }
        }
        return cond;
    }

}//end of class
