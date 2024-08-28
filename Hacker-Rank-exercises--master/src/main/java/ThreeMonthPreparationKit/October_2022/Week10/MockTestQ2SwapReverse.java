//2
//4 2

//yes
//swap 1 2

//6
//1 5 4 3 2 6

//yes
//reverse 2 5

package ThreeMonthPreparationKit.October_2022.Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MockTestQ2SwapReverse {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());

            List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            MockTest10Result.almostSorted(list);

        }catch (IOException e){
            e.fillInStackTrace();
        }

    }//main
}//class
class MockTest10Result {
    /**
     * Approach 1 - First attempt.
     * @param arr
     */
//    public static void almostSorted(List<Integer> arr) {
//        // Write your code
//        if(isSorted(arr)) {
//            System.out.println("yes");
//            return;
//        }
//
//        List<Integer> canBeSwaped = canBeSortedBySwapping(arr);
//
//        if(canBeSwaped.size() != 0){
//            System.out.println("yes");
//            System.out.println("swap " + canBeSwaped.get(0) + " " + canBeSwaped.get(1));
//        }
//        else{
//            System.out.println("no");
//        }
//    }//almostSorted
//
//    public static boolean isSorted(List<Integer> list){
//
//        for(int i = 0; i < list.size()-1; i++){
//            if(list.get(i+1) < list.get(i))return false;
//        }
//
//        return true;
//    }//isSorted
//
//    public static List<Integer> canBeSortedBySwapping(List<Integer> list){
//        List<Integer> resulIndex = new ArrayList<>();
//
//        for(int i = 0; i < list.size()-1; i++){
//
//            if(list.get(i) > list.get(i+1)){
//                int temp = list.get(i);
//                int swap = list.get(i+1);
//
//                list.remove(i); list.remove(i);
//
//                list.add(i, swap);
//                list.add(i+1, temp);
//
//                if(isSorted(list)){
//                    resulIndex.add(i+1);
//                    resulIndex.add(i+2);
//                    break;
//                }
//                else return resulIndex;
//            }//if
//        }//for
//
//        return resulIndex;
//    }//method

    /**
     * Approach 2 from the discussion:
     */

    public static void almostSorted(List<Integer> arr){

        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);
        int swapCount = 0;
        int segmentSize = 0;
        List<Integer> indices = new ArrayList<>();

        if (arr.equals(sorted)) {
            System.out.println("yes");
        } else {
            // Swap
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) != sorted.get(i)) {
                    swapCount++;
                    indices.add(i + 1);
                    indices.add(arr.indexOf(sorted.get(i)) + 1);
                }
            }

            // Reverse
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    segmentSize++;
                } else {
                    if (segmentSize > 1) {
                        List<Integer> startArr = new ArrayList<>(arr.subList(0, i - segmentSize));
                        List<Integer> subArr = new ArrayList<>(arr.subList(i - segmentSize, i + 1));
                        List<Integer> endArr = new ArrayList<>(arr.subList(i + 1, arr.size()));

                        Collections.reverse(subArr);
                        arr.clear();
                        arr.addAll(startArr);
                        arr.addAll(subArr);
                        arr.addAll(endArr);

                        indices.add(i + 1);
                        indices.add(i - segmentSize + 1);
                        break;
                    }
                    segmentSize = 0;
                }
            }

            if (swapCount == 2) {   // Swap
                System.out.println("yes");
                System.out.println("swap " + indices.get(0) + " " + indices.get(1));
            } else if (arr.equals(sorted)) { // Reverse
                System.out.println("yes");
                System.out.println("reverse " + indices.get(indices.size() - 1) + " " + indices.get(indices.size() - 2));
            } else {
                System.out.println("no");
            }
        }
    }
}