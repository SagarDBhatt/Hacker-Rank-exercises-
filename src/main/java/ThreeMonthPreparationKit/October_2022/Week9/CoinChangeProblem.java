//Given the coin number N, and available change of coins;
// find the maximum ways, we can make the number N using
// given demonination of coins.

//Sample input:
//4 3
//1 2 3

//Sample Output:
//4

package ThreeMonthPreparationKit.October_2022.Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CoinChangeProblem {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine().split(" ")[0]);

            List<Long> coins = Arrays.stream(br.readLine().split(" "))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());

            System.out.println(CoinChangeProblemResult.getWays(n, coins));

        }catch (IOException e){
            e.printStackTrace();
        }
    }//main
}//class

class CoinChangeProblemResult {

    public static long getWays(int n, List<Long> c) {
        // Write your code here
        int k = c.size();
        //make a table to save info of problem after being broken down
        //it should have k rows of denomination
        //and n + 1 columns of calculating sum (+1 as it includes 0) (broken-down sums from 0 to n)
        //there should always be 1 way to make a sum of 0 for every kinds of denomination
        //: which is using no coin, this will be the base of our algorithm

        //the first row is calculated differently, as we only need to check if the sum (**)
        //  could be evenly divided by the first denomination

        //each of the remaining rows will take
        //  the combination numbers of the previous row
        //  + value of combination numbers of current row's
        //        [current sum - current denomination] column

        //for example, with sum of 4 and denomination of 2, you already found 1 way of
        //  combination to make the sum
        //  now with the sum of 4 and adding in denomination of 3 (2 and 3 coins)
        //  first take the combinations of deno 2, which is ****1 and
        //  take current sum - current deno (4 - 3) = 1;
        //  on the same row of current deno, lookback at sum of 1, we see number ****0
        //  so numbers of combination to have sum of 4 with deno 2 and 3 is 1 + 0 = 1 (****)
        //
        //With minor notes that with columns that have deno > sum; just take the value of
        //the above row (***)

        //      0   1   2   3   4   5   6
        // 2    1   0   1   0   1   0   1      (**)
        // 3    1   0   1   1   1   1   2      (****)
        //                             (*)

        //the final answer should be at the southeast corner of the table (*)

        //table to save broken-down steps, which have k rows and n + 1 columns
        long[][] breakDown = new long[k][n + 1];

        for (int i = 0; i < k; i ++) {

            long deno = c.get(i);

            for (int j = 0; j < n + 1; j ++) {
                //j is current sum
                //(**)
                if (i == 0 && j % deno == 0) {
                    breakDown[i][j] = 1;
                }
                else if (i == 0) {
                    breakDown[i][j] = 0;
                }
                //(***)
                else if (deno > j) {
                    breakDown[i][j] = breakDown[i - 1][j];
                }
                //(****)
                else {
                    long prevRowVal = breakDown[i - 1][j];
                    long checkBackSameRow = breakDown[i][j - (int) deno];
                    breakDown[i][j] = prevRowVal + checkBackSameRow;
                }
            }
        }
        //(*)
        return breakDown[k - 1][n];
    }

}