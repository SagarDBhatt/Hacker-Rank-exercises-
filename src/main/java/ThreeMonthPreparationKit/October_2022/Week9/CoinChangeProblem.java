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


        return 0L;

    }

}