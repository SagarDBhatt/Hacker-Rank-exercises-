/**
 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. Given an integer, , rotate the array that many steps left and return the result.
 *
 * Example
 *
 *
 * After  rotations, .
 *
 * Function Description
 *
 * Complete the rotateLeft function in the editor below.
 *
 * rotateLeft has the following parameters:
 *
 * int d: the amount to rotate by
 * int arr[n]: the array to rotate
 * Returns
 *
 * int[n]: the rotated array
 * Input Format
 *
 * The first line contains two space-separated integers that denote , the number of integers, and , the number of left rotations to perform.
 * The second line contains  space-separated integers that describe .
 *
 * Constraints
 *
 * Sample Input
 *
 * 5 4
 * 1 2 3 4 5
 * Sample Output
 *
 * 5 1 2 3 4
 * Explanation
 *
 * To perform  left rotations, the array undergoes the following sequence of changes:
 */

/**
 * Sample Input:
 * 5 4
 * 1 2 3 4 5
 *
 * Sample Output:
 * 5 1 2 3 4
 */

package ThreeMonthPreparationKit.October_2022.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex02_LeftRotation {

    public static void main(String[] args) {
        try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            List<Integer> arr = Arrays.stream(br.readLine().split(" ")).map(obj -> Integer.parseInt(obj)).collect(Collectors.toList());
            int size = arr.get(0);
            int moveLeft = arr.get(1);

        List<Integer> inputArray = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = ResultLeftRotate.rotateLeft(moveLeft, inputArray);

        result.stream().forEach(i -> System.out.print(i + " "));

        }
         catch (IOException e) {
            e.printStackTrace();
        }
    }//EOF MAIN
}//EOF CLASS

class ResultLeftRotate{
    public static List<Integer> rotateLeft(int d, List<Integer> arr){

        IntStream.range(0, d).forEach(i -> { arr.add(arr.get(0)); arr.remove(0); });

        return arr;
    }
}