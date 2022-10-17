/**
 * Given an array of integers and a positive integer , determine the number of  pairs where  and  +  is divisible by .
 *
 * Example
 *
 *
 *
 * Three pairs meet the criteria:  and .
 *
 * Function Description
 *
 * Complete the divisibleSumPairs function in the editor below.
 *
 * divisibleSumPairs has the following parameter(s):
 *
 * int n: the length of array
 * int ar[n]: an array of integers
 * int k: the integer divisor
 * Returns
 * - int: the number of pairs
 *
 * Input Format
 *
 * The first line contains  space-separated integers,  and .
 * The second line contains  space-separated integers, each a value of .
 *
 * Constraints
 *
 * Sample Input
 *
 * STDIN           Function
 * -----           --------
 * 6 3             n = 6, k = 3
 * 1 3 2 6 1 2     ar = [1, 3, 2, 6, 1, 2]
 * Sample Output
 *
 *  5
 * Explanation
 *
 * Here are the  valid pairs when :
 */


package ThreeMonthPreparationKit.October_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Week1_06_Divisible_sum_pairs {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> inputVal = Stream.of(bufferedReader.readLine().split(" ")).map(obj -> Integer.parseInt(obj)).collect(Collectors.toList());
        int arraySize = inputVal.get(0);
        int divisible = inputVal.get(1);

        List<Integer> inputList = Stream.of(bufferedReader.readLine().split(" ")).map(obj -> Integer.parseInt(obj)).collect(Collectors.toList());

        Solution1.findNumberOfDivisiblePairs(inputList, divisible);

    }//EOF MAIN
}//EOF CLASS

class Solution1{
    public static void findNumberOfDivisiblePairs(List<Integer> inputList, int divisible){
        int counter = 0;

        for(int i = 0; i < inputList.size()-1; i++){
            for(int j = i+1; j < inputList.size(); j++){
                int sumPairs = inputList.get(i) + inputList.get(j);
                if(sumPairs % divisible == 0){
                    counter++;
                }
            }//EOF LOOP J
        }//EOF LOO I

        System.out.println(counter);
    }
}
