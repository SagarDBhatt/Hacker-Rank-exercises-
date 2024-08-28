/**
 *
 *Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 *
 * For example, the square matrix  is shown below:
 *
 * 1 2 3
 * 4 5 6
 * 9 8 9
 * The left-to-right diagonal = . The right to left diagonal = . Their absolute difference is .
 *
 * Function description
 *
 * Complete the  function in the editor below.
 *
 * diagonalDifference takes the following parameter:
 *
 * int arr[n][m]: an array of integers
 * Return
 *
 * int: the absolute diagonal difference
 * Input Format
 *
 * The first line contains a single integer, , the number of rows and columns in the square matrix .
 * Each of the next  lines describes a row, , and consists of  space-separated integers .
 *
 * Constraints
 *
 * Output Format
 *
 * Return the absolute difference between the sums of the matrix's two diagonals as a single integer.
 *
 * Sample Input
 *
 * 3
 * 11 2 4
 * 4 5 6
 * 10 8 -12
 * Sample Output
 *
 * 15
 * Explanation
 *
 * The primary diagonal is:
 *
 * 11
 *    5
 *      -12
 * Sum across the primary diagonal: 11 + 5 - 12 = 4
 *
 * The secondary diagonal is:
 *
 *      4
 *    5
 * 10
 * Sum across the secondary diagonal: 4 + 5 + 10 = 19
 * Difference: |4 - 19| = 15
 *
 * Note: |x| is the absolute value of x
 *
 */

package ThreeMonthPreparationKit.October_2022.Week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX04_DiagonalDifference {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n=0;
        try{
            n = Integer.parseInt(bufferedReader.readLine());
        }
        catch (Exception e){
            System.out.println("Reading the number from a line is throwing exception. Exception is == \n" + e.getMessage());
        }

        List<List<Integer>> finalIntList = new ArrayList<>();

        try{
            for(int i=0;i<n;i++){
                List<Integer> temp = Stream.of(bufferedReader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                finalIntList.add(temp);
            }
        }
        catch (Exception e){
            System.out.println("Reading the input in For loop is throwing the error");
        }
       //System.out.println(finalIntList);
        int result = ResultDiagonalDifference.diagonalDifference(finalIntList);

    }//EOF Main
}//EOF class

class ResultDiagonalDifference {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        int y1=0,y2=0;
        // Write your code here
        for(int i =0; i<arr.size();i++){
            //System.out.println(arr.get(i));
            for(int j =0; j < arr.get(i).size();j++){
                if(i==j) {
                    y1 += arr.get(i).get(j);
                    y2 += arr.get(i).get((arr.size()-1) - j);
                }
            }//EOF FOR J
        }//EOF FOR I
//        System.out.println(y1); //GOOD
//        System.out.println(y2);
        if(y1-y2 > 0)
            return y1-y2;
        else
            return y2-y1;
    }

}