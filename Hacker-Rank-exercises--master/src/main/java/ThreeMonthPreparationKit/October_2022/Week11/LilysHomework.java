/**
 * We are given the array of integer. We need to swap the elements in such a way that the sum of the absolute difference between the elements is minimum.
 * For eg: arr of 2 5 3 1 has the difference between elements is 3 2 2 [5-2, 3-5, 1-3] & sum is 7. Now we need to arrange the numbers in such a way,
 * 1 2 3 5 that gives us the sum of difference = 1 + 1 + 2 = 4. which is minimum.
 * Also, the is true for 5 3 2 1 array. For which the difference is minimum = 2 + 1 + 1 = 4.
 * Find the minimum number of times we can swap to get the array ascending
 */

//SI
//4
//2 5 3 1

//SO
//2

//SI
//5
//3 4 2 5 1

//1 4 2 5 3
//1 2 4 5 3
//1 2 3 5 4
//1 2 3 4 5

//5 4 2 3 1
//5 4 3 2 1

//SO
//2

package ThreeMonthPreparationKit.October_2022.Week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LilysHomework {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            int n = Integer.parseInt(br.readLine());
            List<Integer> integerList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println("Result --");
            System.out.println(LilysHomeworkResult.lilysHomework(integerList));
        }catch (IOException e){
            e.printStackTrace();
        }
    }//main
}//class

class LilysHomeworkResult {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int lilysHomework(List<Integer> array) {
        //Iterate the elements and try to make the array in Asc and desc order.
        // For both asc and desc, calculate the swap and return the minimum.

        List<Integer> arr = new ArrayList<>(array);
        int ascSwap = 0;
        // 1. Find the index of the smallest element and swap at the index 0.
        // 2. Then take the sub-list and find the smallest array and swap at the index 1.
        // 3. Repeat the process until the list is asc.
        for(int i = 0; i < arr.size(); i++){
            List<Integer> tempList = arr.subList(i,arr.size());
            if(isSortedAscArray(arr))break;
            int minValue = Collections.min(tempList);
            int minIndex = tempList.indexOf(minValue);
            if(minIndex != 0){
                int temp = tempList.get(0);
                arr.set(i, minValue);
                arr.set(i+minIndex, temp);
                ascSwap++;
            }
        }

        List<Integer> arr1 = new ArrayList<>(array);
        int descSwap = 0;
        for(int i = 0; i < arr1.size(); i++){
            List<Integer> tempList = arr1.subList(i, arr1.size());
            if(isSortedDescArray(arr1))break;
            int maxVal = Collections.max(tempList);
            int maxIndex = tempList.indexOf(maxVal);

            if(maxIndex != 0){
                int temp = tempList.get(0);
                arr1.set(i,maxVal);
                arr1.set(i+maxIndex, temp);
                descSwap++;
            }

        }

        return Math.min(ascSwap, descSwap);

    }

    public static boolean isSortedAscArray(List<Integer> arr){
        if(arr.stream().sorted().collect(Collectors.toList()).equals(arr)){
            return true;
        }
        else return false;
    }

    public static boolean isSortedDescArray(List<Integer> arr){
        if(arr.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).equals(arr))return true;
        return false;
    }

}