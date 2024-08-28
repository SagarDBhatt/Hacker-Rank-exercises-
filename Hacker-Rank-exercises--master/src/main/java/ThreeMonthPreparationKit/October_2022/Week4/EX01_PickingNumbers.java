/**
 * Given an array of integers, find the longest subarray where the absolute difference between any two elements is less than or equal to .
 *
 * Example
 *
 *
 * There are two subarrays meeting the criterion:  and . The maximum length subarray has  elements.
 *
 * Function Description
 *
 * Complete the pickingNumbers function in the editor below.
 *
 * pickingNumbers has the following parameter(s):
 *
 * int a[n]: an array of integers
 * Returns
 *
 * int: the length of the longest subarray that meets the criterion
 * Input Format
 *
 * The first line contains a single integer , the size of the array .
 * The second line contains  space-separated integers, each an .
 *
 * Constraints
 *
 * The answer will be .
 */
/**
 * Input:
 6
 4 6 5 3 3 1

 Output:
 3
 */


package ThreeMonthPreparationKit.October_2022.Week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ResultPickingupNumber {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int counter = 1;

        for(int i = 0; i < a.size() - 1; i++){
            int temp = 1;
            for(int j = i+1; j < a.size(); j++){
                if( a.get(i) - a.get(j) == 0 || a.get(i) - a.get(j) == 1 || a.get(i) - a.get(j) == -1){
                    temp++;
                }
                else{
                    temp=1;
                    break;
                }
                if(temp > counter)
                    counter = temp;
            }
        }//EOF I

        return counter;
    }

}