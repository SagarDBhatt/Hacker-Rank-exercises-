/**
 * Problem:
 * Evenly spaced(1 Unit) cities. Need to provide electricity to each city.
 * Identify the minimum number of power plant needed.
 * Each plant has limit to distribute the power till < K units.
 *
 * Input:
 * n - num of cities; k = range/limit.
 * 0,1 array - 0 - City Not suitable for building the plant. 1 City can build the plant.
 *
 * O/P:
 * Print min number of power plants needed.
 *
 * If cant return -1.
 *
 * Sample IN:
 * 6 2
 * 0 1 1 1 1 0
 *
 * Sample OUT:
 * 2
 */


package ThreeMonthPreparationKit.October_2022.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EX3_GoodLandElectricity {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);

            List<Integer> arr = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            System.out.println(Result.pylons(k, arr));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}//class

class Result {

    /**
     * @param k
     * @param arr
     * @return
     * 6 2
     * 0 1 1 1 1 0
     */
    public static int pylons(int k, List<Integer> arr) {
        int plants = 0;
        int index = k - 1;
        int start = 0;
        while(index < arr.size()) {
            if(arr.get(index) == 1) {
                start = index + 1;
                plants++;
                if((index + ((k - 1) * 2) + 1 > arr.size() - 1) && index + k < arr.size()){
                    if(arr.subList(arr.size() - k, arr.size()).contains(1)){
                        plants++;
                        break;
                    }else{
                        return -1;
                    }
                }else{
                    index += ((k - 1) * 2) + 1;
                }
            }else if(index == start){
                return -1;
            }else{
                index--;
            }
        }
        return plants;
    }


    /*
     * Complete the 'pylons' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */
//    public static int pylons(int k, List<Integer> arr) {
//        // Write your code here
//        //Max available limit  = 2 * (k - 1) + 1.
//
//        /**
//         * Second approach to this algorithm.
//         * Identify the first 1 / suitable city and remove the left and right elements from it within the
//         * provided limit. Then repeat the same steps.
//         *
//         * At the end of the iteration if any of the elements left in the arr then return -1
//         * else return counter.
//         *
//         * 10 3
//         * 0 1 0 0 0 1 1 1 1 1
//         *
//         * 3
//         */
//
//        int loc = 0;
//        for(int i = 0; i < arr.size(); i++){
//            if(arr.get(i) == 0)continue;
//            else{
//                for(int j = 1; j < k; j++){
//                    if(i-j >= 0)arr.remove(i-j);
//                    if(i+j < arr.size())arr.remove(i+j);
//
//                }
//            }
//        }
//
//        int boundary = 2 * (k - 1) + 1;
//        int limit = k-1;
//        for(int i = 0; i < boundary; i++){
//            if(arr.get(i) == 1){
//
//            }
//        }
//
//        /**
//         * Below solution works fine in case of finding the best number of plants with the given
//         * limit. But in the question,we need to find an optimal solution for which each city should
//         * get the plant.
//         */
//
//        /**
//         * Optimal sub-array to set up a plant is = 2(k-1)+1.
//         * Now, optimal city in the sub-array = subArray.size() / 2 + 1.
//         * If the optimal city = 1 then count++. Else return -1.
//         *
//         * Repeat the steps to identify the next possible sub-array.
//         * If 2(k-1)+1 <= size of arr then repeat else find the sub-array with the remaining values.
//         *
//         * Check for optimal city and then find the suitability.
//         */
//        int endInd =(2*(k-1) + 1);
//        int stInd = 0;
//        int multiple = 1;
//        int minCounter = 0;
//
//        while(endInd <= arr.size()){
//            List<Integer> intermediateList = arr.subList(stInd, endInd);
//
//            /**
//             * Enhancements:
//             * If the middle elements is 1 then get the optimal sol. Remove all the elements
//             * that satisfy the condition.
//             * If middle element is 0 then iterate
//             */
//            int val = intermediateList.get(intermediateList.size()/2);
//            if(val == 1){
//                minCounter++;
//                arr.subList(stInd,endInd).clear();
//            }
//            else return -1;
//
//            multiple++;
//            stInd = endInd;
//            endInd = multiple * (2*(k-1) + 1);
//        }
//
////        while(endInd <= arr.size()){
////            List<Integer> intermediateList = arr.subList(stInd, endInd);
////
////            /**
////             * Enhancements:
////             * If the middle elements is 1 then get the optimal sol. Remove all the elements
////             * that satisfy the condition.
////             * If middle element is 0 then iterate
////             */
////            int val = intermediateList.get(intermediateList.size()/2);
////
////            if(val == 1){
////                minCounter++;
////            }
////            else return -1;
////
////            multiple++;
////            stInd = endInd;
////            endInd = multiple * (2*(k-1) + 1);
////        }
//        return minCounter;
//    }//pylons

}//class