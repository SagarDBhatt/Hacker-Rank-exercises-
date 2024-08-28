/**
 * Given an array of stick lengths, use  of them to construct a non-degenerate triangle with the maximum possible perimeter. Return an array of the lengths of its sides as  integers in non-decreasing order.
 *
 * If there are several valid triangles having the maximum perimeter:
 *
 * Choose the one with the longest maximum side.
 * If more than one has that maximum, choose from them the one with the longest minimum side.
 * If more than one has that maximum as well, print any one them.
 * If no non-degenerate triangle exists, return .
 *
 * Example
 *
 * The triplet  will not form a triangle. Neither will  or , so the problem is reduced to  and . The longer perimeter is .
 *
 * Function Description
 *
 * Complete the maximumPerimeterTriangle function in the editor below.
 *
 * maximumPerimeterTriangle has the following parameter(s):
 *
 * int sticks[n]: the lengths of sticks available
 * Returns
 *
 * int[3] or int[1]: the side lengths of the chosen triangle in non-decreasing order or -1
 * Input Format
 *
 * The first line contains single integer , the size of array .
 * The second line contains  space-separated integers , each a stick length.
 *
 * Constraints
 *
 * Explanation
 *
 * Sample Case 0:
 * There are  possible unique triangles:
 *
 * The second triangle has the largest perimeter, so we print its side lengths on a new line in non-decreasing order.
 *
 * Sample Case 1:
 * The triangle  is degenerate and thus can't be constructed, so we print -1 on a new line.
 *
 * Sample input:
 * 5
 * 1 1 1 3 3
 *
 * sample output:
 * 1 3 3
 */


package ThreeMonthPreparationKit.October_2022.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX06_MaxPerimeterTriangle {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> inputList = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> result = findMaxPerimiter.maximumPerimeterTriangle(inputList);

        result.stream().forEach(i -> System.out.print(i + " "));

    }//EOF MAIN

}//EOF CLASS

class findMaxPerimiter {

    /*
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        // Write your code here

//        Collections.sort(sticks, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });

        //APP 2:
        //Collections.sort(sticks, (Integer o1, Integer o2) -> {return o1 - o2;});

        //APP 3:
//        Collections.sort(sticks, (o1, o2) -> {return o1-o2;});

//        System.out.println(sticks);

        List<Integer> reverseList = sticks.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

       for(int i =0; i < reverseList.size()-2; i++){
           if(reverseList.get(i) < reverseList.get(i+1) + reverseList.get(i+2)){
               return List.of(reverseList.get(i+2), reverseList.get(i+1), reverseList.get(i));
           }
       }

        return List.of(-1);
    }

}//EOF CLASS
