/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 *
 * Example
 *
 * The minimum sum is  and the maximum sum is . The function prints
 *
 * 16 24
 * Function Description
 *
 * Complete the miniMaxSum function in the editor below.
 *
 * miniMaxSum has the following parameter(s):
 *
 * arr: an array of  integers
 * Print
 *
 * Print two space-separated integers on one line: the minimum sum and the maximum sum of  of  elements.
 *
 * Input Format
 *
 * A single line of five space-separated integers.
 *
 * Constraints
 *
 *
 * Output Format
 *
 * Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)
 *
 * Sample Input
 *
 * 1 2 3 4 5
 * Sample Output
 *
 * 10 14
 * Explanation
 *
 * The numbers are , , , , and . Calculate the following sums using four of the five integers:
 *
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Hints: Beware of integer overflow! Use 64-bit Integer.
 *
 * Need help to get started? Try the Solve Me First problem
 */


package ThreeMonthPreparationKit.October_2022.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Week1__Mini_Max_Sum {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str_array = br.readLine().split(" ");
        List<Integer> list = Arrays.asList(str_array).stream().map(obj -> Integer.parseInt(obj)).collect(Collectors.toList());

        MiniMaxSum.findMiniMaxSum(list);
    }

}

class MiniMaxSum{

    public static void findMiniMaxSum(List<Integer> integerList){
        List<Integer> sortedList = integerList.stream().sorted().collect(Collectors.toList());
        BigInteger minimumSum = new BigInteger(String.valueOf(0));
        BigInteger maxSum = new BigInteger(String.valueOf(0));

        for(int i = 0; i < sortedList.size()-1; i++){
            minimumSum = minimumSum.add(BigInteger.valueOf(Long.parseLong(sortedList.get(i).toString()))) ;
        }
        for(int i = 1; i < sortedList.size(); i++){
            maxSum = maxSum.add(BigInteger.valueOf(Long.parseLong(sortedList.get(i).toString()))) ;
        }
        System.out.println(minimumSum + " " + maxSum);
    }

}
