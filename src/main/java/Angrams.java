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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two strings");
        String a = scan.next();
        String b = scan.next();
        scan.close();

        if(isEqualLength(a,b)){
            System.out.println("Same length");
            if(isSameCharacters(a,b))
                System.out.println("Same characters (any order)");
            else
                System.out.println("No angrams");
        }



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
        //Initialize char array.
        char aChars[] = new char[a.length()];
        char bChars[] = new char[b.length()];
        boolean judge = false;

        //Convert String to Char array.
        aChars = a.toCharArray();
        bChars = b.toCharArray();

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
            if( Character.toLowerCase(aChars[i]) == Character.toLowerCase(bChars[i]))
               judge = true;

            else {
                judge = false;
                break;
            }
        }
        return judge;
    }
}//end of class
