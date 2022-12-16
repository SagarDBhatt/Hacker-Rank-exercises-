/**
 * The idea is to sort one array in ascending order and another array in descending order and if any index does not satisfy the condition a[i] + b[i] >= K then print “No”, else print “Yes”.
 *
 * Sample Input
 *
 * STDIN       Function
 * -----       --------
 * 2           q = 2
 * 3 10        A[] and B[] size n = 3, k = 10
 * 2 1 3       A = [2, 1, 3]
 * 7 8 9       B = [7, 8, 9]
 * 4 5         A[] and B[] size n = 4, k = 5
 * 1 2 2 1     A = [1, 2, 2, 1]
 * 3 3 3 4     B = [3, 3, 3, 4]
 *
 *
 * Sample Output
 *
 * YES
 * NO
 *
 * NOTE: We need to sort the first array in ascending order and 2nd array into descending order. Then take some of each element and the sum is less than k then yes i.e. a[0] + b[0] >= k for all the
 * elements then print YES.
 */

package ThreeMonthPreparationKit.October_2022.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX01_PermutingArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        String[] inputArray = bufferedReader.readLine().split(" ");
        int size = Integer.parseInt(inputArray[0]);
        int k = Integer.parseInt(inputArray[1]);

        List<Integer> listA = Stream.of(bufferedReader.readLine().split(" ")).map(a -> Integer.parseInt(a)).collect(Collectors.toList());
        List<Integer> listB = Stream.of(bufferedReader.readLine().split(" ")).map(a -> Integer.parseInt(a)).collect(Collectors.toList());

        System.out.println(Result.twoArrays(k,listA,listB));
    }
}

class Result {

    /*
     * Complete the 'twoArrays' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     *  3. INTEGER_ARRAY B
     */

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here

        //1. Sorting of List A in Ascending and B in descending
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());

        String flag = "YES";

        for(int i = 0; i < A.size(); i++){
            if( (A.get(i) + B.get(i)) < k )
                flag = "NO";
        }

        return flag;
    }

}
