/**
 * Comparison Sorting
 * Quicksort usually has a running time of , but is there an algorithm that can sort even faster? In general, this is not possible. Most sorting algorithms are comparison sorts, i.e. they sort a list just by comparing the elements to one another. A comparison sort algorithm cannot beat  (worst-case) running time, since  represents the minimum number of comparisons needed to know where to place each element. For more details, you can see these notes (PDF).
 *
 * Alternative Sorting
 * Another sorting method, the counting sort, does not require comparison. Instead, you create an integer array whose index range covers the entire range of values in your array to sort. Each time a value occurs in the original array, you increment the counter at that index. At the end, run through your counting array, printing the value of each non-zero valued index that number of times.
 *
 * Example
 *
 * All of the values are in the range , so create an array of zeros, . The results of each iteration follow:
 *
 * i	arr[i]	result
 * 0	1	[0, 1, 0, 0]
 * 1	1	[0, 2, 0, 0]
 * 2	3	[0, 2, 0, 1]
 * 3	2	[0, 2, 1, 1]
 * 4	1	[0, 3, 1, 1]
 * The frequency array is . These values can be used to create the sorted array as well: .
 *
 * Note
 * For this exercise, always return a frequency array with 100 elements. The example above shows only the first 4 elements, the remainder being zeros.
 *
 * Challenge
 * Given a list of integers, count and return the number of times each value appears as an array of integers.
 *
 * Function Description
 *
 * Complete the countingSort function in the editor below.
 *
 * countingSort has the following parameter(s):
 *
 * arr[n]: an array of integers
 * Returns
 *
 * int[100]: a frequency array
 * Input Format
 *
 * The first line contains an integer , the number of items in .
 * Each of the next  lines contains an integer  where .
 *
 * Constraints
 *
 *
 *
 * Sample Input
 *
 * 100
 * 63 25 73 1 98 73 56 84 86 57 16 83 8 25 81 56 9 53 98 67 99 12 83 89 80 91 39 86 76 85 74 39 25 90 59 10 94 32 44 3 89 30 27 79 46 96 27 32 18 21 92 69 81 40 40 34 68 78 24 87 42 69 23 41 78 22 6 90 99 89 50 30 20 1 43 3 70 95 33 46 44 9 69 48 33 60 65 16 82 67 61 32 21 79 75 75 13 87 70 33
 * Sample Output
 *
 * 0 2 0 2 0 0 1 0 1 2 1 0 1 1 0 0 2 0 1 0 1 2 1 1 1 3 0 2 0 0 2 0 3 3 1 0 0 0 0 2 2 1 1 1 2 0 2 0 1 0 1 0 0 1 0 0 2 1 0 1 1 1 0 1 0 1 0 2 1 3 2 0 0 2 1 2 1 0 2 2 1 2 1 2 1 1 2 2 0 3 2 1 1 0 1 1 1 0 2 2
 * Explanation
 *
 * Each of the resulting values  represents the number of times  appeared in .
 */


package ThreeMonthPreparationKit.October_2022.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX05_CountingSort {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        List<Integer> listInteger = Stream.of(bufferedReader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(ResultCountingSort.countingSort(listInteger));

    }//EOF Main

}//EOF Class


class ResultCountingSort {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {

        Map<Integer,Integer> freqMap = new HashMap<>();

        // Write your code here
        for(int i = 0; i < arr.size(); i++){

            if(freqMap.containsKey(arr.get(i))){
                freqMap.put(arr.get(i),freqMap.get(arr.get(i))+1);
            }
            else{
                freqMap.put(arr.get(i),1);
            }

            if(!freqMap.containsKey(i) && i<100){
                freqMap.put(i,0);
            }

        }//EOF FOR
        //System.out.println(freqMap);
        List<Integer> freqList = new ArrayList<>();

        for(Integer i : freqMap.values())
            freqList.add(i);

        return freqList;
    }

}
//11 4 11 8 10 12 10 10 12 10 11 8 7 8 8 9 9 15 13 14 15 9 9 11 11 11 14 9 8 15 11 5 14 10 9 9 8 18 6 7 12 7 14 7 6 18 15 13 11 8 9 8 9 17 10 10 8 12 14 4 13 6 15 12 13 6 7 12 3 11 7 7 8 10 12 13 9 6 11 9 3 12 14 6 10 7 12 7 11 7 8 8 13 8 7 10 12 12 13 9