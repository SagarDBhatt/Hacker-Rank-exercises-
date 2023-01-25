/**
 * In this challenge, the task is to debug the existing code to successfully execute all provided test files.
 *
 * Given an array of  distinct integers, transform the array into a zig zag sequence by permuting the array elements. A sequence will be called a zig zag sequence if the first  elements in the sequence are in increasing order and the last  elements are in decreasing order, where . You need to find the lexicographically smallest zig zag sequence of the given array.
 *
 * Example.
 *
 *
 * Now if we permute the array as , the result is a zig zag sequence.
 *
 * Debug the given function findZigZagSequence to return the appropriate zig zag sequence for the given input array.
 *
 * Note: You can modify at most three lines in the given code. You cannot add or remove lines of code.
 *
 * To restore the original code, click on the icon to the right of the language selector.
 *
 * Input Format
 *
 * The first line contains  the number of test cases. The first line of each test case contains an integer , denoting the number of array elements. The next line of the test case contains  elements of array .
 *
 * Constraints
 *
 *
 *  ( is always odd)
 *
 * Output Format
 *
 * For each test cases, print the elements of the transformed zig zag sequence in a single line.
 *
 * Sample INP:
 * 1
 * 7
 * 1 2 3 4 5 6 7
 *
 * Sample OUT:
 * 1 2 3 7 6 5 4
 */

package ThreeMonthPreparationKit.October_2022.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EX07_ZigZagSequence {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while(testCases >= 1){
            int n = Integer.parseInt(br.readLine());
            List<Integer> inputList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            findZigZagSeq(inputList);
            testCases--;
        }
    }//EOF MAIN

    private static void findZigZagSeq(List<Integer> list){
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());

        int middle = sortedList.get((sortedList.size()-1)/2);
        sortedList.set((sortedList.size()-1)/2, sortedList.get(sortedList.size()-1));
        sortedList.set(sortedList.size()-1, middle);

        for(int i = (sortedList.size()-1)/2; i<sortedList.size()-1;i++){
            for(int j = i; j < sortedList.size()-2; j++){
                if(sortedList.get(j) < sortedList.get(j+1)){
                    int temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j+1));
                    sortedList.set(j+1, temp);
                }
            }
        }

        System.out.println(sortedList);
    }//EOF METHOD


}//EOF CLASS
