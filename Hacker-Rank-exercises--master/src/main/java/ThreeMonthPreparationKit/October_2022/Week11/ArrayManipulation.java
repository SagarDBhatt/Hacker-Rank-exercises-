/**
 * Initialize the array with 0 values.
 * For a given query "a b k", iterate the array from index a to b inclusive and add "k" to each value.
 * Repeat the steps for each query and find the maximum value of the array.
 */

//SI
//5 3
//1 2 100
//2 5 100
//3 4 100

//SO
//200

package ThreeMonthPreparationKit.October_2022.Week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayManipulation {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int m = Integer.parseInt(inp[1]);

            List<List<Integer>> queries = new ArrayList<>();

            IntStream.range(0,m).forEach(i -> {
                try {
                    queries.add(
                            Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList())
                    );
                }catch (IOException e){
                    e.printStackTrace();
                }
            });

            System.out.println(ArrayManipulationResult.arrayManipulation(n, queries));

        }catch (IOException e){
            e.printStackTrace();
        }
    }//main
}//class

class ArrayManipulationResult {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        int[] arr = new int[n+1];

        //Put all zeros to the initial array.
        Arrays.stream(arr).forEach(i -> arr[i] = 0);

        for(List<Integer> query : queries){

            for(int i = query.get(0); i <= query.get(1); i++){
                arr[i] += query.get(2);
            }

        }

        //Find the max value of the array.
        int val = Arrays.stream(arr).max().getAsInt();

        return (long) val;
    }

}