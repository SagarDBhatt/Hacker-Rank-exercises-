/*
        Input Format
        The first line contains a string denoting .
        The second line contains an integer denoting .

        Constraints
        consists of English alphabetic letters only (i.e., [a-zA-Z]).

        Output Format
        Return the respective lexicographically smallest and largest substrings as a single newline-separated string.

        Sample Input 0

        welcometojava
        3

        Sample Output 0

        ava
        wel*/

import java.util.Scanner;

public class JavaSubstringComparisons {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter String and number of ");
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        //System.out.println(getSmallestAndLargest(s, k));
        getSmallestAndLargest(s,k);
    }

    public static void getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String[] subString = new String[s.length()];

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for(int i=0;i<=s.length()-k;i++)
        {
            subString[i] = s.substring(i,i+k);
        }

        for(int j = 0; j <= s.length()-k; j++)
        {
            for(int m=j+1;m <= s.length()-k; m++ )
            {
                if(subString[j].compareTo(subString[m])>0)
                {
                    String temp = subString[j];
                    subString[j] = subString[m];
                    subString[m] = temp;
                }
            }

        }

        smallest = subString[0];
        largest=subString[s.length()-k];

        System.out.println(smallest + " - " + largest);
    }

}
