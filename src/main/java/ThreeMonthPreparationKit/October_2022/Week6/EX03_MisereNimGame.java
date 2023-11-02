/**
 * Player 1 get the change and select either 1 or entire pile of stones. Next, player 2 takes tune
 * and follow the same. Whoever picks the last pile will leave.
 *
 * Sample Input:
 * 2       T = 2
 * 2       s[] size n = 2
 * 1 1     s = [1, 1]
 * 3       s[] size n = 3
 * 2 1 3   s = [2, 1, 3]
 *
 * Sample Output:
 * First
 * Second
 */

/**
 * Pseudocode:
 *
 * 1. If number of piles are even then Player 1 will win always.
 * 2. If n is odd then check if any piles has more than 1 stone. If yes then P1 else P2.
 */

package ThreeMonthPreparationKit.October_2022.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EX03_MisereNimGame {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int testCases = Integer.parseInt(br.readLine());
            IntStream.range(0, testCases).forEach(i -> {
                try {
                    int n = Integer.parseInt(br.readLine());
                    List<Integer> inputList = Arrays.stream(br.readLine().split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                    System.out.println(ResultMisereNimGame.misereNim(inputList));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        catch (IOException e){
            System.out.println("IO Exception thrown");
        }
    }
}

class ResultMisereNimGame {

    public static String misereNim(List<Integer> s) {
        // Write your code here
        if(s.size() % 2 == 0)return "First";

        Optional<Integer> xor = s.stream().reduce((x, y) -> x^y);
        if(xor.isPresent()){
            if(xor.get() == 0)return "Second";
            else return "First";
        }
        return "Second";
    }

}
