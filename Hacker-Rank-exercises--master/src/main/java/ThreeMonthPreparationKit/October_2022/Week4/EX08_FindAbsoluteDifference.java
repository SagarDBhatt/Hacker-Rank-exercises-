/**
 * PROBLEM STATEMENT:
 * The absolute difference is the positive difference between two values  and , is written  or  and they are equal. If  and , . Given an array of integers, find the minimum absolute difference between any two elements in the array.
 *
 * Example.
 *
 * There are  pairs of numbers:  and . The absolute differences for these pairs are ,  and . The minimum absolute difference is .
 *
 * Function Description
 *
 * Complete the minimumAbsoluteDifference function in the editor below. It should return an integer that represents the minimum absolute difference between any pair of elements.
 *
 * minimumAbsoluteDifference has the following parameter(s):
 *
 * int arr[n]: an array of integers
 * Returns
 *
 * int: the minimum absolute difference found
 * Input Format
 *
 * The first line contains a single integer , the size of .
 * The second line contains  space-separated integers, .
 *
 * Constraints
 *
 * ========
 *
 * I?P:
 * 3
 * 3 -7 0
 *
 * O/P:
 * 3
 *
 * Input:
 * 10
 * -59 -36 -13 1 -53 -92 -2 -96 -54 75
 *
 * Output:
 * 1
 *
 */

package ThreeMonthPreparationKit.October_2022.Week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX08_FindAbsoluteDifference {

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            List<Integer> listOfInteger = new ArrayList<Integer>(n);
            listOfInteger = Stream.of(br.readLine().split(" ")).map(Integer::parseInt)
                    .collect(Collectors.toList());
            int result = AbsoluteDifference.findAbsoluteDifference(listOfInteger);
            System.out.println(result);
        }
        catch(Exception e){
            System.out.println("Exception encountered " + e.getMessage());
        }


    }// EOF main

}// end of class

class AbsoluteDifference{

    public static int findAbsoluteDifference(List<Integer> ls){
        ls.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        int diff = ls.get(1) - ls.get(0);
        if(diff < 0)diff += (diff* (-2));
        int temp = 0;

        for(int i =0; i < ls.size() -1; i++){
            temp = ls.get(i+1) - ls.get(i);
            if(temp < 0)temp += (temp * -2);
            if(temp < diff)diff = temp;
        }
        return diff;
    }// end of method

}//end of class

