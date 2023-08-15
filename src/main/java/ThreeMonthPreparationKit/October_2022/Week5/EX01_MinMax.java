/**
 * Given an array of size N -> find the unfairness of the array.
 * Given value K. Create the pairs of K values in such a way that we find the minimum unfairness.
 *
 * I/P:
 * 10
 * 4
 * 1
 * 2
 * 3
 * 4
 * 10
 * 20
 * 30
 * 40
 * 100
 * 200
 *
 * O/P:
 * 3
 *
 * Pseudo code:
 * 1. Sort the array in ascending.
 * 2. Create the pair with first k elements. We should get n-k+1 pairs.
 * 3. Find the difference of each pair. Take the temp counter and assign the minimum difference to it.
 */

//10
//4
//1
//2
//3
//4
//10
//20
//30
//40
//100
//200
package ThreeMonthPreparationKit.October_2022.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX01_MinMax {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

//        List<Integer> arryList = Stream.of(br.readLine().split(" "))
//                .map(obj -> Integer.parseInt(obj))
//                .collect(Collectors.toList());

        List<Integer> arryList = IntStream.range(0,n).mapToObj(i -> {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = findMinMaxClass.maxMin(k, arryList);
        System.out.println(result);

    }//EOF main
}//EOF class

class findMinMaxClass{
    public static int maxMin(int k, List<Integer> arr){
        int diff = Integer.MAX_VALUE;
        Collections.sort(arr);
        for(int i = 0; i < arr.size()-k+1; i++){
            int i1 = arr.get(i+k-1) - arr.get(i);
            if(i1 < diff){
                diff = i1;
            }
        }

//        for(int i = 0; i < arr.size()-k; i++){
//            List<Integer> tempList = new ArrayList<>();
//            IntStream.range(i,i+k).forEach(j -> tempList.add(arr.get(j)));
//            int i1 = Collections.max(tempList) - Collections.min(tempList);
//            if(i1 < diff){
//                diff = i1;
//            }
//        }
        return  diff;
    }

//    public static int findMinDiff(List<Integer> arrList){
//        return Collections.max(arrList) - Collections.min(arrList);
//    }
}
