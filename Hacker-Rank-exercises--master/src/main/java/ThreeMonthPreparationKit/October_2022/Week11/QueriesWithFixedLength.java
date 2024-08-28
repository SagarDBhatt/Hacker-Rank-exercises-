/**
 * Given the array, we need to create the sub-arrays and find the max value of each sub-array.
 * and make another array. Then find the min of the newly created array and print the ans.
 */

//SI
//5 5
//1 2 3 4 5
//1
//2
//3
//4
//5

//SO
//1
//2
//3
//4
//5

package ThreeMonthPreparationKit.October_2022.Week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QueriesWithFixedLength {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int k = Integer.parseInt(inp[1]);

            List<Integer> arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> queries = new ArrayList<>();
            IntStream.range(0,k).forEach(i -> {
                try {
                    queries.add(Integer.parseInt(br.readLine()));
                }catch (IOException e){
                    e.printStackTrace();
                }
            });

            //System.out.println(QueriesWithFixedLengthResult.solve(arr,queries));
            QueriesWithFixedLengthResult.solve(arr,queries).stream().forEach(i -> System.out.println(i));
            QueriesWithFixedLengthResult.solve(arr,queries).forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }
    }//main
}//class

class QueriesWithFixedLengthResult {

    /**
     * Version 1 of the solution:
     */
//    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
//        // Sort the collection
//        //Collections.sort(arr,(o1,o2) -> {return o1 - o2;});
//
//        //Create the groups of queries and make the new list with the max values.
//        List<Integer> maxGroups = new ArrayList<>();
//        List<Integer> resultArr = new ArrayList<>();
//        queries.stream().forEach(q -> {
//            maxGroups.add(Collections.max(arr.subList(0,q)));
//            List<Integer> intermediateList = new ArrayList<>();
//            for(int i = 0; i <= arr.size()-q; i++){
//                for(int j = 0; j < q; j++){
//                    intermediateList.add(arr.get(i+j));
//                }
//                //maxGroups.add(Collections.max(intermediateList));
//                maxGroups.add(Collections.max(intermediateList));
//                intermediateList.clear();
//            }
//            resultArr.add(Collections.min(maxGroups));
//            maxGroups.clear();
//        });
//
//        return resultArr;
//    }

    /**
     * Version 2 of the solution
     */
    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            int max = Collections.max(arr.subList(0, q));
            int min = max;
            for (int i = q; i < arr.size(); i++) {
                if (arr.get(i) > max)
                    max = arr.get(i);
                else if (arr.get(i - q) == max)
                    max = Collections.max(arr.subList(i - q + 1, i + 1));
                min = Math.min(min, max);
            }
            result.add(min);
        }
        return result;
    }

}