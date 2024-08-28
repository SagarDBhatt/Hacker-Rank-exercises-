package EasyLevel;

import java.util.Scanner;

public class JavaSubstringComparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String[] subString = new String[s.length()];
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        for(int i = 0; i <= s.length() - k; i++){
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
        largest = subString[s.length() - k];

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}