/**
 * You are choreographing a circus show with various animals. For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).
 *
 * The first kangaroo starts at location  and moves at a rate of  meters per jump.
 * The second kangaroo starts at location  and moves at a rate of  meters per jump.
 * You have to figure out a way to get both kangaroos at the same location at the same time as part of the show. If it is possible, return YES, otherwise return NO.
 *
 * Example
 *
 *
 *
 *
 * After one jump, they are both at , (, ), so the answer is YES.
 *
 * Function Description
 *
 * Complete the function kangaroo in the editor below.
 *
 * kangaroo has the following parameter(s):
 *
 * int x1, int v1: starting position and jump distance for kangaroo 1
 * int x2, int v2: starting position and jump distance for kangaroo 2
 * Returns
 *
 * string: either YES or NO
 * Input Format
 *
 * A single line of four space-separated integers denoting the respective values of , , , and .
 *
 * Constraints
 */

/**
 * Sample Input:
 * 0 3 4 2
 *
 * Sample Output:
 * YES / NO
 */
package ThreeMonthPreparationKit.October_2022.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex04_NumberLineJumps {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> inputList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int x1 = inputList.get(0);
        int v1 = inputList.get(1);
        int x2 = inputList.get(2);
        int v2 = inputList.get(3);

        System.out.println(ResultKangaroo.kangaroo(x1,v1,x2,v2));

    }//EOF MAIN
}//EOF CLASS

class ResultKangaroo {

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        if( (x1 < x2 && v1 < v2) || (x1 > x2 && v1 > v2) || v1 == v2 )
            return "NO";

        if( (x2-x1)%(v1-v2) ==0 )
            return "YES";
        else
            return "NO";

    }

}