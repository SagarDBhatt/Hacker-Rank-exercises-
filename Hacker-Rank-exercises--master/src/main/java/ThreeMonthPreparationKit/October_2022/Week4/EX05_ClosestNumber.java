/**
 * Sorting is useful as the first step in many different tasks. The most common task is to make finding things easier, but there are other uses as well. In this case, it will make it easier to determine which pair or pairs of elements have the smallest absolute difference between them.
 *
 * Example
 *
 * Sorted, . Several pairs have the minimum difference of : . Return the array .
 *
 * Note
 * As shown in the example, pairs may overlap.
 *
 * Given a list of unsorted integers, , find the pair of elements that have the smallest absolute difference between them. If there are multiple pairs, find them all.
 *
 * Function Description
 *
 * Complete the closestNumbers function in the editor below.
 *
 * closestNumbers has the following parameter(s):
 *
 * int arr[n]: an array of integers
 * Returns
 * - int[]: an array of integers as described
 *
 * Input Format
 *
 * The first line contains a single integer , the length of .
 * The second line contains  space-separated integers, .
 *
 * Constraints
 *
 * All  are unique in .
 * Output Format
 *
 * Sample Input 0
 *
 * 10
 * -20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854
 * Sample Output 0
 *
 * -20 30
 * Explanation 0
 * (30) - (-20) = 50, which is the smallest difference.
 *
 * Sample Input 1
 *
 * 12
 * -20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470
 * Sample Output 1
 *
 * -520 -470 -20 30
 * Explanation 1
 * (-470) - (-520) = 30 - (-20) = 50, which is the smallest difference.
 *
 * Sample Input 2
 *
 * 4
 * 5 4 3 2
 * Sample Output 2
 *
 * 2 3 3 4 4 5
 * Explanation 2
 * Here, the minimum difference is 1. Valid pairs are (2, 3), (3, 4), and (4, 5).
 */

/**
 * Sample input:
//10
//-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854
 *
 * Sample Output:
 * -20 30
 */
package ThreeMonthPreparationKit.October_2022.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EX05_ClosestNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        List<Integer> al = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultList = ResultCloseNumberPair.closestNumbers(al);

        resultList.stream().forEach(i -> System.out.print(i+ " "));
    }// EOF MAIN

}//EOF CLASS

class ResultCloseNumberPair {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here

        //1. Ascending sort the list.
        Collections.sort(arr);

        //2. Take the initial difference of first two elements.
        int difference = arr.get(1) - arr.get(0);

        //3. Create an empty array list to store the result. Initialize the arrayList with first 2 elements.
        List<Integer> resultList = new ArrayList<>();

        // 4. Find the minimum difference between 2 consecutive elements.
        for(int i = 0; i < arr.size() - 1; i++){
            if( (arr.get(i+1) - arr.get(i)) < difference){
                difference = arr.get(i+1) - arr.get(i);
            }
        }

        //4. Take the difference between 2 consecutive array elements. If the difference is less than initial element diff then update the minimum diff var and update the result diff.
        for(int i = 0; i < arr.size() - 1; i++){
            if( (arr.get(i+1) - arr.get(i)) == difference){
                resultList.add(arr.get(i));
                resultList.add(arr.get(i+1));
            }
        }

        return resultList;
    }

}