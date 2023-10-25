/**
 * Watson gives Sherlock an array of integers. His challenge is to find an element of the array such that the sum of all elements to the left is equal to the sum of all elements to the right.
 *
 * Example
 *
 *
 *  is between two subarrays that sum to .
 * The answer is  since left and right sum to .
 *
 * You will be given arrays of integers and must determine whether there is an element that meets the criterion. If there is, return YES. Otherwise, return NO.
 *
 * Question:
 * 1) Given the array, find the sum of 2 groups of elements for which the sum is the same. Without the central element. If that is true then return yes else no.
 *
 * UPDATE: The group can be formed any way with any number of digits to the left (0 or more)
 * OR right (0 or more).
 *
 * Sample input:
 * arr = [1,2,3,3]
 *
 * Sum of index (0,1) is 3 = sum of index[3] is 3.
 *
 * Sample output: yes
 *
 * Pseudocode:
 * 1) If the size of the arrayList is 1 then return Yes.
 * 2) Else, if the arrayList is even then find the middle 2 elements. Find the sum of rest of the group and match.
 * 3) If the arrayList size is odd then find the middle element and find the sum of the 2 groups and match.
 *
 * SI:
 * 2
 * 3
 * 1 2 3
 * 4
 * 1 2 3 3
 *
 * SO:
 * NO
 * YES
 *
 * Updated Pseudocode:
 * 1) If the index is 0 then leftsum =0 and right sum = sum of all arrays element - index 0 element.
 * 2) For the index size-1 then right sum = 0 && left sum is sum of all arrays element - last array element.
 *
 * V3 of Pseudocode:
 * 1) Initiate the leftSum =0 and rightSum to sum of array.
 * 2) Iterate the index, add the sumLeft to each element and deduct the sumRight with each element.
 * 3) For any given index if the both sum are equal then print YES else No.
 *
 */

package ThreeMonthPreparationKit.October_2022.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Week06_Ex02_Sherlock_Array {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            IntStream.range(0,n).forEach(i -> {
                try {
                    int cnt = Integer.parseInt(br.readLine());
                    List<Integer> inputList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                    System.out.println(SherlockArray.balancedSums(inputList));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//EOF main
}//EOF CLASS

class SherlockArray {

    public static String balancedSums(List<Integer> arr) {
        int leftSum = 0, rightSum = arr.stream().reduce(Integer::sum).get();

        for(int i = 0; i < arr.size(); i++){
            if(i==0){
                leftSum=0;
            }
            else {
                leftSum += arr.get(i - 1);
            }
            rightSum -= arr.get(i);
            if(leftSum == rightSum)return "YES";
        }
        return "NO";
    }

//    public static String balancedSums(List<Integer> arr) {
//        int leftSum = 0, rightSum = 0;
//
//        for(int i = 0; i < arr.size(); i++){
//            if(i == 0){
//                leftSum = 0;
//                rightSum = arr.stream().reduce(0, Integer::sum) - arr.get(0);
//            }
//            else if(i == arr.size() - 1){
//                rightSum = 0;
//                leftSum = arr.stream().reduce(0, Integer::sum) - arr.get(arr.size() - 1);
//            }
//            else{
//
//            }
//            if(leftSum == rightSum)return "YES";
//            else return "NO";
//        }
//
//        // Write your code here
//        int sumLeft = 0, sumRight = 0;
//        for(int i = -1; i <= arr.size(); i++){
//            sumLeft += (i < 0) ? 0 : arr.get(i);
//            sumRight += (i == arr.size()) ? 0 : arr.get(i);
//
//            if(sumLeft == sumRight)return "YES";
//            else return "NO";
//        }
//        return "NO";
//    }


    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

//    public static String balancedSums(List<Integer> arr) {
//        // Write your code here
//
//        if(arr.size() == 1){
//            return "YES";
//        }
//        else if(arr.size() % 2 != 0){
//            int leftSum = 0, righSum = 0;
//            for(int i =0; i < arr.size()/2; i++){
//                leftSum += arr.get(i);
//            }
//            for(int i = arr.size()-1; i > arr.size()/2; i--){
//                righSum += arr.get(i);
//            }
//            if(leftSum == righSum){
//                return "YES";
//            }
//            else{
//                return "NO";
//            }
//        }
//        else {
//            int leftSum = 0, righSum = 0;
//            for(int i =0; i < arr.size()/2; i++){
//                leftSum += arr.get(i);
//            }
//            for(int i = arr.size()-1; i > arr.size()/2; i--){
//                righSum += arr.get(i);
//            }
//            if(leftSum == righSum){
//                return "YES";
//            }
//            else{
//                leftSum = 0;
//                righSum = 0;
//                for(int i =0; i < arr.size()/2-1; i++){
//                    leftSum += arr.get(i);
//                }
//                for(int i = arr.size()-1; i >= arr.size()/2; i--){
//                    righSum += arr.get(i);
//                }
//                if(leftSum == righSum){
//                    return "YES";
//                }
//                else{
//                    return "NO";
//                }
//            }
//        }
//    }

}//EOF class