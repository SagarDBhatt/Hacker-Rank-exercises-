/**
 * SubSequence is defined as the any sub-set of array. Not necessary in the same order.
 * SubArray is the subset of array that is in same order.
 *
 * Given an array find the maximum sum of sub-array and sub-sequence.
 */

//Sample Input:
//2
//4
//1 2 3 4
//6
//2 -1 2 3 4 -5

//Sample OP:

//10 10
//10 11

package ThreeMonthPreparationKit.October_2022.Week9;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximumSubArray {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int testcases = Integer.parseInt(br.readLine());
            IntStream.range(0,testcases).forEach(i -> {
                try{
                    int n = Integer.parseInt(br.readLine());
                    List<Integer> inpList =Arrays.stream(br.readLine().split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                    List<Integer> resultList = MaximumSubArrayResult.maxSubarray(inpList);

                    for(Integer j : resultList){
                        System.out.println(j);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            });
        }catch (IOException e){
            e.printStackTrace();
        }
    }//main

}//class

class MaximumSubArrayResult {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        // For SubArray. Iterate the array in 2 loops and find the Max sum. If the maxSum > tempSum then replace.
        int temp = getMaxSumOfSubArray(arr);

        // Create the ResultList and add the Sub-Array sum inside.
        List<Integer> resultList = new ArrayList<>();
        resultList.add(temp);
        int maxSumOfSubSeq = getMaxSumOfSubSequence(arr);
        resultList.add(maxSumOfSubSeq);

        return resultList;
    }//method

    public static int getMaxSumOfSubSequence(List<Integer> list){

        //Comparator is a functional interface. We can use Lambda expressions to define the only abstract method compare.
        Comparator comparator = (o1, o2) -> {
            return (int)o1 - (int) o2;
        };
        Collections.sort(list, comparator.reversed());

        return getMaxSumOfSubArray(list);

    }//methpd

    public static int getMaxSumOfSubArray(List<Integer> arr){
        int temp = arr.get(0);

        for(int i = 0; i < arr.size(); i ++){
            int sum = arr.get(i);
            if(sum > temp)temp = sum;
            for(int j = i+1; j < arr.size(); j++){
                sum += arr.get(j);
                if(sum > temp)temp = sum;
            }
        }
        return temp;
    }

}