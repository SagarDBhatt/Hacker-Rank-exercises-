/**
 * Given 2 strings, delete the characters to find out the maximum length of equal strings.
 */


//SI
//HARRY
//SALLY

//SO
//2

//Exp: The longest string that can be formed by deleting zero or more characters from  HARRY and SALLY is AY, whose length is 2.

package ThreeMonthPreparationKit.October_2022.Week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CommonChild {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = br.readLine();
            String s2 = br.readLine();

            System.out.println(CommonChileResult.commonChild(s1,s2));
        }catch (IOException e){
            e.printStackTrace();
        }
    }//main

}//class

class CommonChileResult {

    public static int commonChild(String s1, String s2) {
        char c1;
        char c2;
        int max;

        int n = s1.length();
        int[][] memo = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j ++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                }
                else {
                    c1 = s1.charAt(i - 1);
                    c2 = s2.charAt(j - 1);

                    if (c1 != c2) {
                        max = Math.max(memo[i - 1][j], memo[i][j - 1]);
                        memo[i][j] = max;
                    }
                    else {
                        memo[i][j] = memo[i - 1][j - 1] + 1;
                    }
                }
            }
        }
        return memo[n][n];
    }

}
