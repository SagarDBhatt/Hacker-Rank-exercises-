/**
 * Declare a 2-dimensional array, , of  empty arrays. All arrays are zero indexed.
 * Declare an integer, , and initialize it to .
 *
 * There are  types of queries, given as an array of strings for you to parse:
 *
 * Query: 1 x y
 * Let .
 * Append the integer  to .
 * Query: 2 x y
 * Let .
 * Assign the value  to .
 * Store the new value of  to an answers array.
 */

/**
 * Input:
 * 2 5
 * 1 0 5
 * 1 1 7
 * 1 0 3
 * 2 1 0
 * 2 1 1
 *
 * Output:
 * 7
 * 3
 */

package ThreeMonthPreparationKit.October_2022.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX03_DynamicArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int q = Integer.parseInt(firstLine[1]);

        List<Integer> query = new ArrayList<>();
        List<List<Integer>> queries = new ArrayList<List<Integer>>();

        IntStream.range(0, q).forEach(i -> {
            try{
                queries.add(
                        Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList())
                );
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });
//        System.out.println(queries);

        List<Integer> result = DynamicArrayClass.dynamicArray(n, queries);
//        System.out.println(result);

        for(Integer i : result){
            System.out.println(i);
        }
    }
}

class DynamicArrayClass {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        // Declare a 2-dimensional array, arr, of n empty arrays.
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        // Declare an integer, lastAnswer, and initialize it to 0.
        int lastAnswer = 0;
        // answers array.
        List<Integer> answers = new ArrayList<>();
        for (List<Integer> query : queries) {
            // There are types of queries ie (type, x, y) and not type times y
            int type = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            int idx = ((x ^ lastAnswer) % n);
            if (type == 1) {
                arr.get(idx).add(y);
            }
            if (type == 2) {
                lastAnswer = arr.get(idx).get(y % arr.get(idx).size());
                answers.add(lastAnswer);
            }
        }
        // returns the results of each type 2 query in the order they are presented
        return answers;

    }

}