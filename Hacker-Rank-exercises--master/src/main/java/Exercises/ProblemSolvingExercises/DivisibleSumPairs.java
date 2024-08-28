/**
 * We are giving array. We need to find out the number of pairs (i,j) where i < j For which the sum (i+j) is divisible by k.
 * Return the integer number.
 */

package Exercises.ProblemSolvingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DivisibleSumPairs {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int k = Integer.parseInt(inp[1]);
            List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            int result = DivisibleSumPairsResult.divisibleSumPairs(n, k, list);
            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }

    }//main
}//class


class DivisibleSumPairsResult {

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // ** Sort the ArrayList.
        Collections.sort(ar, (o1, o2) -> o1 - o2);

        // ** Iterate the ArrayList and check the pairs for which the sum is divisible by k. Increment the counter.
        int result = 0;
        for(int i = 0; i < ar.size() - 1; i++){
            for(int j = i+1; j < ar.size(); j++){
                if( (ar.get(i) + ar.get(j)) % k == 0)result++;
            }
        }
        return result;
    }

}